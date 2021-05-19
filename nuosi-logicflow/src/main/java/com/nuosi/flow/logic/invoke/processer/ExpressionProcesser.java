package com.nuosi.flow.logic.invoke.processer;

import com.ai.ipu.basic.util.IpuUtility;
import com.ai.ipu.data.JMap;
import com.nuosi.flow.logic.inject.QuickBuild;
import com.nuosi.flow.logic.model.action.Expression;
import com.nuosi.flow.logic.model.body.Action;
import com.nuosi.flow.util.LogicFlowConstants;
import org.mvel2.MVEL;
import org.mvel2.PropertyAccessException;

import java.util.HashMap;
import java.util.List;
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
    private static final String QB = LogicFlowConstants.QB;

    @Override
    public Object execute(Map<String, Object> databus, Action action, JMap input, Object ... param) throws Exception {
        List<Expression> expressions = action.getExpressions();
        Expression expr = expressions.get(0);
        Map<String, Object> vars = new HashMap<String, Object>();
        vars.put(DATABUS, databus);
        vars.put(INPUT, input);
        vars.put(QB, QuickBuild.getInstance());

        try{
            Object result = MVEL.eval(expr.getExpression(), vars);
            return result;
        }catch (Exception e){
            if(e instanceof PropertyAccessException){
                Throwable tr = IpuUtility.getBottomException(e);
                IpuUtility.error(tr);
            }
            throw e;
        }
    }
}
