package com.nuosi.flow.logic.invoke.handler;

import com.ai.ipu.data.JMap;
import com.nuosi.flow.logic.model.action.Foreach;
import com.nuosi.flow.util.LogicFlowConstants;
import org.mvel2.MVEL;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>desc: 节点执行处理器的循环类型实现
 * foreach提供index、iterable、result三个常量，简化循环的使用</p>
 * <p>date: 2021/4/16 9:47 </p>
 *
 * @author nuosi fsofs@163.com
 * @version v1.0.0
 */
public class ForeachProcesser implements IActionProcesser{
    private static final String DATABUS = LogicFlowConstants.DATABUS;
    private static final String ITERATORS = "ITERATORS";
    private static final String ITERATOR = "ITERATOR";
    private static final String INDEX = "INDEX";
    private static final String RESULT = "RESULT";

    public enum ResultType {
        INT, STRING, MAP, LIST;
    }


    @Override
    public Object execute(Map<String, Object> databus, Object... param) throws Exception {
        List< Foreach> foreachs = (List< Foreach>) param[0];
        Foreach foreach = foreachs.get(0);
        JMap params = (JMap) param[1];

        Object iterator = databus.get(foreach.getIterable());
        if(iterator==null){
            return null;
        }

        Object result = null;
        if(iterator instanceof Iterable){
            Map<String, Object> vars = new HashMap<String, Object>();
            vars.put(DATABUS, databus);
            vars.put(ITERATORS, databus.get(foreach.getIterable()));

            StringBuilder expr = new StringBuilder();
            expr.append("int INDEX = 0; \n");
            appendResult(foreach, expr);
            expr.append("foreach(ITERATOR : ITERATORS){ \r");
            expr.append("INDEX++; \r");
            expr.append(foreach.getForeach()==null?"":foreach.getForeach()).append("\r");
            expr.append("} \r");
            expr.append("return RESULT; \r");
            result = MVEL.eval(expr.toString(), vars);
        }

        return result;
    }

    private void appendResult(Foreach foreach, StringBuilder expr){
        ResultType resultType = ResultType.valueOf(foreach.getResultType().toUpperCase());

        switch (resultType) {
            case INT:
                expr.append("var RESULT = 0; \r");
                break;
            case STRING:
                expr.append("var RESULT = \"\"; \r");
                break;
            case MAP:
                expr.append("var RESULT = new java.util.HashMap(); \r");
                break;
            case LIST:
                expr.append("var RESULT = new java.util.ArrayList(); \r");
                break;
            default:
                break;
        }
    }
}
