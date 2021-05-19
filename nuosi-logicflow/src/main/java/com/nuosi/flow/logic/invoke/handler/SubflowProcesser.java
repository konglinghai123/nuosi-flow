package com.nuosi.flow.logic.invoke.handler;

import com.ai.ipu.data.JMap;
import com.nuosi.flow.logic.LogicFlowEngine;
import com.nuosi.flow.logic.model.action.Subflow;
import com.nuosi.flow.logic.model.body.Action;

import java.util.List;
import java.util.Map;

/**
 * <p>desc: 节点执行处理器的子流程类型实现 </p>
 * <p>date: 2021/5/16 10:22 </p>
 *
 * @author nuosi fsofs@163.com
 * @version v1.0.0
 */
public class SubflowProcesser implements IActionProcesser{

    @Override
    public Object execute(Map<String, Object> databus, Action action, JMap input, Object ... param) throws Exception {
        List<Subflow> subflows = action.getSubflows();
        Subflow subflow = subflows.get(0);

        Object result = LogicFlowEngine.execute(subflow.getFlow(), input);
        return result;
    }
}
