package com.nuosi.flow.logic.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.nuosi.flow.logic.LogicFlowEngine;
import com.nuosi.flow.logic.LogicFlowManager;
import com.nuosi.flow.logic.model.LogicFlow;
import com.nuosi.flow.logic.parse.XmlToLogicFlowParser;

import java.io.IOException;
import java.io.InputStream;

/**
 * <p>desc: 描述这个类功能的注释 </p>
 * <p>date: 2021/4/28 23:16 </p>
 *
 * @author nuosi fsofs@163.com
 * @version v1.0.0
 */
public class LogicFlowUtilTest {

    public static void storageLogicFlow(String flowConfig){
        InputStream is = LogicFlowEngine.class.getClassLoader().getResourceAsStream(flowConfig);
        try {
            JSONObject flowJson = new XmlToLogicFlowParser(is).getBeanJson();
            LogicFlow logicFlow = JSON.toJavaObject(flowJson, LogicFlow.class);
            LogicFlowManager.storageLogicFlow(logicFlow);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(is!=null)
                    is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
