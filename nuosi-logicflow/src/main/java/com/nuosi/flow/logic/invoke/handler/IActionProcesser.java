package com.nuosi.flow.logic.invoke.handler;

import com.ai.ipu.data.JMap;
import com.nuosi.flow.logic.invoke.ExecutionContainer;
import com.nuosi.flow.logic.model.body.Action;

import java.util.Map;

/**
 * <p>desc: 节点执行处理器的抽象接口</p>
 * <p>date: 2021/3/6 12:26</p>
 * @author nuosi fsofs@163.com
 * @version v1.0.0
 */
public interface IActionProcesser {

    public Object execute(Map<String, Object> databus, Action action, JMap input, Object ... param) throws Exception;
}
