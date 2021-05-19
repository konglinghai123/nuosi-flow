package com.nuosi.flow.mgmt.except;

import com.ai.ipu.basic.util.IpuUtility;
import com.nuosi.flow.logic.LogicFlowEngine;
import com.nuosi.flow.util.LogicFlowConstants;
import org.junit.Before;
import org.junit.Test;

/**
 * <p>desc: 异常信息管理测试类 </p>
 * <p>date: 2021/5/19 17:38 </p>
 *
 * @author nuosi fsofs@163.com
 * @version v1.0.0
 */
public class ExceptionMessageTest {

    @Test
    public void testExceptionMessage(){
        try{
            IpuUtility.errorCode(LogicFlowConstants.FLOW_ACTION_ERROR,
                    "flowId", "actionId", "异常信息");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Before
    public void setUp(){
        LogicFlowEngine.init();
    }
}
