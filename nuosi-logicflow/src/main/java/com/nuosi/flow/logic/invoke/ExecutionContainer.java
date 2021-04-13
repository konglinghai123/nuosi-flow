package com.nuosi.flow.logic.invoke;

import com.ai.ipu.basic.util.IpuUtility;
import com.ai.ipu.data.JMap;
import com.ai.ipu.data.impl.JsonMap;
import com.ai.ipu.database.conn.SqlSessionManager;
import com.nuosi.flow.data.BDataDefine;
import com.nuosi.flow.data.BizDataManager;
import com.nuosi.flow.logic.invoke.handler.ActionProcesserManager;
import com.nuosi.flow.logic.invoke.handler.IActionProcesser;
import com.nuosi.flow.logic.model.LogicFlow;
import com.nuosi.flow.logic.model.action.Sql;
import com.nuosi.flow.logic.model.body.Action;
import com.nuosi.flow.logic.model.body.End;
import com.nuosi.flow.logic.model.body.Start;
import com.nuosi.flow.logic.model.element.Input;
import com.nuosi.flow.logic.model.element.Var;
import com.nuosi.flow.logic.model.global.Define;
import com.nuosi.flow.logic.model.global.Import;
import com.nuosi.flow.logic.parse.DtoToDataDefineParser;

import java.util.*;

/**
 * <p>desc: 业务逻辑流执行容器 </p>
 * <p>date: 2021/3/29 20:19 </p>
 *
 * @author nuosi fsofs@163.com
 * @version v1.0.0
 */
public class ExecutionContainer {
    private Map<String, Object> databus = new HashMap<String, Object>();
    private Set<String> importSet = new HashSet<String>();
    private BDataDefine bDataDefine;
    private Map<String, Action> actionMap = new HashMap<String, Action>();

    private LogicFlow logicFlow;

    public ExecutionContainer(LogicFlow logicFlow) {
        this.logicFlow = logicFlow;
        init();
    }

    private void init() {
        initGlobalDefine();
        initGlobalAction();
    }

    private void initGlobalDefine() {
        List<Define> defines = logicFlow.getDefines();
        for (Define define : defines) {
            List<Import> imports = define.getImports();
            if (imports != null) {
                initGlobalImport(imports);
            }
            List<Var> vars = define.getVars();
            if (vars != null) {
                initGlobalVar(vars);
            }
        }
    }

    private void initGlobalImport(List<Import> imports) {
        for (Import imp : imports) {
            importSet.add(imp.getModel());
        }
    }

    private void initGlobalVar(List<Var> vars) {
        this.bDataDefine = new DtoToDataDefineParser().parse(logicFlow.getId(), vars);
        if(!BizDataManager.contains(logicFlow.getId())){
            BizDataManager.registerDto(bDataDefine);
        }
    }

    private void initGlobalAction() {
        List<Action> actions = logicFlow.getActions();
        for (Action action : actions) {
            actionMap.put(action.getId(), action);
        }
    }

    public JMap execute(JMap param) {
        JMap result = null;
        try {
            storeDatabus(param);
            String next = checkStart();

            next = executeAction(next);

            result = checkEnd(next);
            SqlSessionManager.commitAll();
        } catch (Exception e) {
            SqlSessionManager.rollbackAll();
            IpuUtility.error(e);
        } finally {
            SqlSessionManager.closeAll();
        }
        return result;
    }

    private void storeDatabus(JMap param) {
        String[] keys = param.getKeys();
        for (String key : keys) {
            //存在则进行业务对象校验
            if (bDataDefine.getDataTypes().containsKey(key)) {
                bDataDefine.checkData(key, param.get(key));
            }
            databus.put(key, param.get(key));
        }
    }

    public String checkStart() {
        Start start = getStart();
        List<Var> vars = start.getVars();
        if (vars != null) {
            String key;
            for (Var var : vars) {
                key = var.getId();
                if (key != null) {
                    if (!databus.containsKey(key)) {
                        IpuUtility.error("执行XX节点的参数key不存在");
                    } else {
                        // 做数据校验
                        bDataDefine.checkData(key, databus.get(key));
                    }
                } else if (var.getModel() != null && var.getAttr() != null && var.getKey() != null) {
                    BDataDefine bDataDefine = BizDataManager.getDataDefine(var.getModel());
                    bDataDefine.checkData(var.getAttr(), databus.get(var.getKey()));
                } else {
                    IpuUtility.error("属性不正确");
                }
            }
        }
        return start.getNext();
    }

    public String executeAction(String next) throws Exception {
        Action action = actionMap.get(next);
        JMap param = prepareActionParam(action);

        IActionProcesser IActionProcesser = ActionProcesserManager.getProcesser(Action.ActionType.SQL);
        if (action.getActionType() == Action.ActionType.SQL) {
            Sql sql = action.getSqls().get(0);
            IActionProcesser.execute(this, sql, param);
        }

        next = action.getNext();
        if (actionMap.containsKey(next)) {
            return executeAction(next);
        } else {
            return next;
        }
    }

    private JMap prepareActionParam(Action action) {
        List<Input> inputs = action.getInputs();
        if (inputs == null) {
            return null;
        }
        if (inputs.size() != 1) {
            IpuUtility.error("Action节点只能有一个Input");
        }
        Input input = inputs.get(0);
        List<Var> vars = input.getVars();
        if (vars == null || vars.size() == 0) {
            return null;
        }
        JMap param = new JsonMap();
        for (Var var : vars) {
            param.put(var.getKey(), databus.get(var.getKey()));
        }
        return param;
    }

    public JMap checkEnd(String next) {
        End end = getEnd();
        if (next.equals(end.getId())) {
            IpuUtility.error("配置错误：结束节点没有被正确调用");
        }

        JMap result = null;
        List<Var> vars = end.getVars();
        if (vars != null) {
            result = new JsonMap();
            String key;
            for (Var var : vars) {
                key = var.getId();
                if (!bDataDefine.getDataTypes().containsKey(key)) {
                    //需要做一些告警处理，记录没有回传的值
                    continue;
                } else {
                    result.put(key, databus.get(key));
                }
            }
        }
        return result;
    }

    public Start getStart() {
        List<Start> starts = logicFlow.getStarts();
        if (starts == null) {
            IpuUtility.error("流程需要一个开始节点");
        } else if (starts.size() != 1) {
            IpuUtility.error("流程只能有一个开始节点");
        }
        return starts.get(0);
    }

    public End getEnd() {
        List<End> ends = logicFlow.getEnds();
        if (ends == null) {
            IpuUtility.error("流程需要一个结束节点");
        } else if (ends.size() != 1) {
            IpuUtility.error("流程只能有一个结束节点");
        }
        return ends.get(0);
    }
}
