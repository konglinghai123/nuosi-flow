package com.nuosi.flow.logic.invoke.handler;

import com.ai.ipu.data.JMap;
import com.nuosi.flow.logic.inject.basic.ExceptionUtil;
import com.nuosi.flow.logic.inject.basic.QuickBuild;
import com.nuosi.flow.logic.model.action.Expression;
import com.nuosi.flow.util.LogicFlowConstants;
import org.mvel2.MVEL;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>desc: 节点执行处理器的表达式类型实现 </p>
 * <p>date: 2021/4/15 10:23 </p>
 *
 * @author nuosi fsofs@163.com
 * @version v1.0.0
 */
public class ExpressionProcesser implements IActionProcesser{
    private static final String DATABUS = LogicFlowConstants.DATABUS;
    private static final String INPUT = LogicFlowConstants.INPUT;
    private static final String QB = "QB";

    @Override
    public Object execute(Map<String, Object> databus, Object... param) throws Exception {
        Expression expr = (Expression) param[0];
        JMap params = (JMap) param[1];
        Map<String, Object> vars = new HashMap<String, Object>();
        vars.put(DATABUS, databus);
        vars.put(INPUT, params);
        vars.put(QB, QuickBuild.getInstance());
        Object result = MVEL.eval(expr.getExpression(), vars);
        return result;
    }
}
