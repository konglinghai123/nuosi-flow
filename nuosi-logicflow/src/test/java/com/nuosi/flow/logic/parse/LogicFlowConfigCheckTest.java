package com.nuosi.flow.logic.parse;

import com.nuosi.flow.logic.util.LogicFlowUtilTest;
import org.junit.Before;
import org.junit.Test;

/**
 * <p>desc: 逻辑编排配置文件检查测试类 </p>
 * <p>date: 2021/4/28 17:42 </p>
 *
 * @author nuosi fsofs@163.com
 * @version v1.0.0
 */
public class LogicFlowConfigCheckTest {

    @Test
    public void testStartVarIdExcept(){
//        JMap param = new JsonMap();
//        param.put("content","文本参数");
//        LogicFlow logicFlow = LogicFlowManager.getLogicFlow("except_start_var_id_miss");
//        JMap result = new LogicFlowConfigCheck(logicFlow).check(param);
//        System.out.println("result===" + result);
    }

    @Test
    public void testStartExcept(){
//        JMap param = new JsonMap();
//        param.put("content","文本参数");
//        LogicFlow logicFlow = LogicFlowManager.getLogicFlow("except_start_var_id");
//        JMap result = new LogicFlowConfigCheck(logicFlow).check(param);
//        System.out.println("result===" + result);
    }

    @Before
    public void setUp(){
        String flowConfig = "except/flow/except_start_var_id_miss.xml";
        LogicFlowUtilTest.storageLogicFlow(flowConfig);
        flowConfig = "except/flow/except_start_miss.xml";
        LogicFlowUtilTest.storageLogicFlow(flowConfig);
    }
}
