package com.nuosi.flow.logic;

import com.ai.ipu.basic.util.IpuBaseException;
import com.nuosi.flow.data.BData;

/**
 * @author nuosi fsofs@163.com
 * @version 0.1.0
 * @name LogicFlowEngine
 * @desc 逻辑流引擎入口类
 * @date 2021/3/6 11:26
 */
public class LogicFlowEngine {
    static {
        registerExceptionCode();
    }

    public static void init(){
    }

    private static void registerExceptionCode(){
        // 热部署会多次加载，因此需要捕获并忽略异常
        String exceptionMessagesConfig = "com/nuosi/flow/exception_messages";
        IpuBaseException.registerCode(exceptionMessagesConfig);
    }

    public static BData execute(String name, BData ... bData){
        // 1.获取逻辑流程的配置

        // 2.解析配置执行逻辑节点

        // 3.得到逻辑结果并返回
        return null;
    }
}
