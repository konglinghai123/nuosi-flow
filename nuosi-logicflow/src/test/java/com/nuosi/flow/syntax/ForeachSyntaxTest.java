package com.nuosi.flow.syntax;

import com.ai.ipu.data.JList;
import com.ai.ipu.data.JMap;
import com.ai.ipu.data.impl.JsonList;
import com.ai.ipu.data.impl.JsonMap;
import com.nuosi.flow.logic.LogicFlowEngine;
import com.nuosi.flow.logic.LogicFlowManager;
import com.nuosi.flow.mgmt.message.Messages;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

/**
 * <p>desc: 循环逻辑相关语法展示 </p>
 * <p>date: 2021/5/11 18:28 </p>
 *
 * @author nuosi fsofs@163.com
 * @version v1.0.0
 */
public class ForeachSyntaxTest {

    @Test
    public void testForeachExcept() {
        try {
            JList paramList = new JsonList();
            for (int i = 0; i < 10; i++) {
                paramList.add(i);
            }
            JMap param = new JsonMap();
            param.put("input_list", paramList);

            LogicFlowEngine.execute("foreach_except", param);
            Assert.assertTrue(false);
        } catch (Exception e) {
            System.out.println("抛出信息：" + e.getMessage());
            Assert.assertTrue(e.getMessage(), true);
        }
    }

    @Before
    public void setUp() {
        System.out.println(Messages.FOREACH_DEFINE_HINT);
        String flowConfig = "syntax/foreach_except.xml";
        InputStream is = getClass().getClassLoader().getResourceAsStream(flowConfig);
        LogicFlowManager.registerLogicFlow(is);
    }
}
