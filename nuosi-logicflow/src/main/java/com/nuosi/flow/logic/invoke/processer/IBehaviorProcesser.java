package com.nuosi.flow.logic.invoke.processer;

import com.ai.ipu.data.JMap;
import com.nuosi.flow.logic.model.domain.Behavior;

import java.util.Map;

/**
 * <p>desc: 业务模型行为处理器的抽象接口 </p>
 * <p>date: 2021/5/19 20:06 </p>
 *
 * @author nuosi fsofs@163.com
 * @version v1.0.0
 */
public interface IBehaviorProcesser {

    public Object execute(Map<String, Object> databus, Behavior behavior, JMap input, Object ... param) throws Exception;
}
