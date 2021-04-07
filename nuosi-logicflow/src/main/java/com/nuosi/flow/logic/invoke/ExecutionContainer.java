package com.nuosi.flow.logic.invoke;

import com.ai.ipu.basic.util.IpuUtility;
import com.ai.ipu.data.JMap;
import com.ai.ipu.data.impl.JsonMap;
import com.ai.ipu.database.conn.SqlSessionManager;
import com.nuosi.flow.logic.invoke.handler.ActionProcesserManager;
import com.nuosi.flow.logic.invoke.handler.IActionProcesser;
import com.nuosi.flow.logic.model.LogicFlow;
import com.nuosi.flow.logic.model.action.Sql;
import com.nuosi.flow.logic.model.body.Action;
import com.nuosi.flow.logic.model.body.End;
import com.nuosi.flow.logic.model.body.Start;
import com.nuosi.flow.logic.model.element.Input;
import com.nuosi.flow.logic.model.element.Var;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>desc: 业务逻辑流执行容器 </p>
 * <p>date: 2021/3/29 20:19 </p>
 *
 * @author nuosi fsofs@163.com
 * @version v1.0.0
 */
public class ExecutionContainer {
    private Map<String, Object> databus = new HashMap<String, Object>();
    private Map<String, Action> actionMap = new HashMap<String, Action>();

    private LogicFlow logicFlow;

    public ExecutionContainer(LogicFlow logicFlow){
        this.logicFlow = logicFlow;
        init();
    }

    private void init() {
        List<Action> actions = logicFlow.getActions();
        for(Action action : actions){
            actionMap.put(action.getId(), action);
        }
    }

    public JMap execute(JMap param){
        invokeGlobal(param);

        String next = checkInput(param);

        try{
            next = executeAction(next);
            SqlSessionManager.commitAll();
        }catch (Exception e){
            SqlSessionManager.rollbackAll();
            IpuUtility.error(e);
        }finally {
            SqlSessionManager.closeAll();
        }

        JMap result = checkOutput(next);
        return result;
    }

    public void invokeGlobal(JMap param){
        String[] keys = param.getKeys();
        for(String key : keys){
            databus.put(key, param.get(key));
        }
    }

    public String checkInput(JMap param){
        Start start =  getStart(param);
        List<Var> vars = start.getVars();
        if(vars!=null){
            String key;
            for(Var var : vars){
                key = var.getId();
                if(!param.containsKey(key)){
                    continue;
                }

                // 做数据校验

                if(var.getKey()!=null){
                    databus.put(var.getKey(), param.get(key));
                }
            }
        }
        return start.getNext();
    }

    public String executeAction(String next) throws Exception {
        Action action = actionMap.get(next);
        JMap param = invokeActionInput(action);

        IActionProcesser IActionProcesser = ActionProcesserManager.getProcesser(Action.ActionType.SQL);
        if (action.getActionType() == Action.ActionType.SQL) {
            Sql sql = action.getSqls().get(0);
            IActionProcesser.execute(this, sql, param);
        }

        next = action.getNext();
        if(actionMap.containsKey(next)){
            return executeAction(next);
        }else{
            return next;
        }
    }

    private JMap invokeActionInput(Action action){
        List<Input> inputs = action.getInputs();
        if(inputs==null){
            return null;
        }
        if(inputs.size()!=1){
            IpuUtility.error("Action节点只能有一个Input");
        }
        Input input = inputs.get(0);
        List<Var> vars = input.getVars();
        if(vars==null||vars.size()==0){
            return null;
        }
        JMap param = new JsonMap();
        for(Var var : vars){
            param.put(var.getKey(), databus.get(var.getKey()));
        }
        return param;
    }

    public JMap checkOutput(String next){
        End end = getEnd();
        if(next.equals(end.getId())){
            IpuUtility.error("配置错误：结束节点没有被正确调用");
        }

        JMap result = null;
        List<Var> vars = end.getVars();
        if(vars!=null){
            result = new JsonMap();
            String key;
            for(Var var : vars){
                key = var.getId();
                if(!databus.containsKey(key)){
                    //需要做一些告警处理，记录没有回传的值
                    continue;
                }
                result.put(key, databus.get(key));
            }
        }
        return result;
    }

    public Start getStart(JMap param){
        List<Start> starts =  logicFlow.getStarts();
        if(starts==null){
            IpuUtility.error("流程需要一个开始节点");
        }else if(starts.size()!=1){
            IpuUtility.error("流程只能有一个开始节点");
        }
        return starts.get(0);
    }

    public End getEnd(){
        List<End> ends =  logicFlow.getEnds();
        if(ends==null){
            IpuUtility.error("流程需要一个结束节点");
        }else if(ends.size()!=1){
            IpuUtility.error("流程只能有一个结束节点");
        }
        return ends.get(0);
    }
}
