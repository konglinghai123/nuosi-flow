package com.nuosi.flow.logic.invoke.handler;

import com.ai.ipu.data.JMap;
import com.ai.ipu.database.dao.ISqlDao;
import com.ai.ipu.database.dao.impl.SqlDao;
import com.nuosi.flow.logic.inject.function.FunctionManager;
import com.nuosi.flow.logic.inject.function.IDomainFunction;
import com.nuosi.flow.logic.model.action.Function;
import com.nuosi.flow.logic.model.action.Sql;
import com.nuosi.flow.logic.model.domain.Behavior;
import com.nuosi.flow.logic.model.domain.BehaviorManager;

import java.util.List;
import java.util.Map;

/**
 * <p>desc: 节点执行处理器的模型行为类型实现 </p>
 * <p>date: 2021/5/13 18:41 </p>
 *
 * @author nuosi fsofs@163.com
 * @version v1.0.0
 */
public class BehaviorProcesser implements IActionProcesser {

    @Override
    public Object execute(Map<String, Object> databus, Object... param) throws Exception {
        Behavior flowBehavior = (Behavior) param[0];
        JMap params = (JMap) param[1];

        Behavior modelBehavior = getModelBehavior(flowBehavior.getModel(), flowBehavior.getId());
        Object result = null;
        switch (modelBehavior.getActionType()) {
            case SQL:
                Sql sql = modelBehavior.getSqls().get(0);
                result = executeSql(databus, sql, params);
            case EXPRESSION:
                break;
            case FUNCTION:
                List<Function> functions = modelBehavior.getFunctions();
                result = executeFunction(databus, functions, params);
            case FOREACH:
                break;
            default:
                break;
        }
        return result;
    }

    private Behavior getModelBehavior(String model, String id){
        Behavior behavior = BehaviorManager.getBehavior(model, id);
        return behavior;
    }

    private Object executeSql(Map<String, Object> databus, Sql sql, JMap params) throws Exception {
        System.out.println("执行SQL语句：" + sql.getSql());
        System.out.println("执行SQL参数：" + params);
        ISqlDao dao = new SqlDao(sql.getConn());
        List<Map<String, Object>> result = dao.executeSelect(sql.getSql(), params);
        return result;
    }

    private Object executeFunction(Map<String, Object> databus, List<Function> functions, JMap params) throws Exception {
        IDomainFunction domainFunction;
        Object result = null;
        for(Function function : functions){
            domainFunction = FunctionManager.getDomainFunction(function.getDomain());
            result = domainFunction.invoke(databus, function);
            if(function.getOutkey()!=null){
                databus.put(function.getOutkey(), result);
            }
        }
        return result;
    }
}
