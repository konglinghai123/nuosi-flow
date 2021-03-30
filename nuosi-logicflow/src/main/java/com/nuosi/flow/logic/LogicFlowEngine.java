package com.nuosi.flow.logic;

import com.ai.ipu.basic.util.IpuBaseException;
import com.ai.ipu.data.JMap;
import com.nuosi.flow.logic.invoke.ExecutionContainer;
import com.nuosi.flow.logic.model.LogicFlow;

/**
 * @author nuosi fsofs@163.com
 * @version 0.1.0
 * @name LogicFlowEngine
 * @desc 逻辑流引擎入口类
 * @date 2021/3/6 11:26
 */
public class LogicFlowEngine {

    public static JMap execute(String flowName, JMap param){
        // 1.获取逻辑流程的配置
        LogicFlow logicFlow = LogicFlowManager.getLogicFlow(flowName);
        // 2.解析配置执行逻辑节点
        JMap result = new ExecutionContainer(logicFlow).execute(param);
        return result;
    }

    static {
        registerExceptionCode();
    }

    public static void init() {
    }

    private static void registerExceptionCode(){
        // 热部署会多次加载，因此需要捕获并忽略异常
        String exceptionMessagesConfig = "com/nuosi/flow/exception_messages";
        IpuBaseException.registerCode(exceptionMessagesConfig);
    }
}
