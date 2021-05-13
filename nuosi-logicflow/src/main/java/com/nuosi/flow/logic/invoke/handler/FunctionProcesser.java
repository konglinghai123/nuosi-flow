package com.nuosi.flow.logic.invoke.handler;

import com.ai.ipu.data.JMap;
import com.ai.ipu.database.dao.ISqlDao;
import com.ai.ipu.database.dao.impl.SqlDao;
import com.nuosi.flow.logic.LogicFlowManager;
import com.nuosi.flow.logic.model.action.Sql;
import com.nuosi.flow.logic.model.domain.DomainModel;
import com.nuosi.flow.logic.model.domain.Function;

import java.util.List;
import java.util.Map;

/**
 * <p>desc: 节点执行处理器的模型函数类型实现 </p>
 * <p>date: 2021/5/13 18:41 </p>
 *
 * @author nuosi fsofs@163.com
 * @version v1.0.0
 */
public class FunctionProcesser implements IActionProcesser {

    @Override
    public Object execute(Map<String, Object> databus, Object... param) throws Exception {
        Function flowFunction = (Function) param[0];
        JMap params = (JMap) param[1];

        Function modelFunction = getModelFunction(flowFunction.getModel(), flowFunction.getId());
        Object result = null;
        switch (modelFunction.getActionType()) {
            case SQL:
                Sql sql = modelFunction.getSqls().get(0);
                result = executeSql(databus, sql, params);
            case EXPRESSION:
                break;
            case FOREACH:
                break;
            default:
                break;
        }
        return result;
    }

    private Function getModelFunction(String model, String id){
        DomainModel domainModel = LogicFlowManager.getDomainModel(model);
        Function function = domainModel.getFunctionMap().get(id);
        return function;
    }

    private Object executeSql(Map<String, Object> databus, Sql sql, JMap params) throws Exception {
        System.out.println("执行SQL语句：" + sql.getSql());
        System.out.println("执行SQL参数：" + params);
        ISqlDao dao = new SqlDao(sql.getConn());
        List<Map<String, Object>> result = dao.executeSelect(sql.getSql(), params);
        return result;
    }
}
