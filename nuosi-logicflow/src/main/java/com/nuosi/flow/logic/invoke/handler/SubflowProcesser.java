package com.nuosi.flow.logic.invoke.handler;

import com.ai.ipu.data.JMap;
import com.nuosi.flow.logic.LogicFlowEngine;
import com.nuosi.flow.logic.model.action.Subflow;

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
    public Object execute(Map<String, Object> databus, Object... param) throws Exception {
        Subflow subflow = (Subflow) param[0];
        JMap params = (JMap) param[1];
        Object result = LogicFlowEngine.execute(subflow.getFlow(), params);
        return result;
    }
}
