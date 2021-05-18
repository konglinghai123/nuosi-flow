package com.nuosi.flow.mgmt.message;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * <p>desc: 描述这个类功能的注释 </p>
 * <p>date: 2021/4/30 13:00 </p>
 *
 * @author nuosi fsofs@163.com
 * @version v1.0.0
 */
public class MessageManagerTest {
    private String msgCode;

    @Test
    public void testParseMessage() {
        String message = MessageManager.parseMessage(Messages.NO_MESSAGE_CODE, "NO_MESSAGE_CODE");
        System.out.println(message);
        Assert.assertTrue(true);
    }

    @Test
    public void testGetMessage() {
        MessageManager.registerMessage(msgCode, "提示信息编码[%s]已存在，无需注册");
        String message = MessageManager.getMessage(msgCode, msgCode);
        System.out.println(message);
        Assert.assertTrue(true);
    }

    @Test
    public void testGetMessageError() {
        try {
            String message = MessageManager.getMessage("NO_CODE", "");
            Assert.assertTrue(false);
        } catch (Exception e) {
            System.out.println("异常信息：" + e.getMessage());
            Assert.assertTrue(true);
        }
    }

    @Before
    public void setUp() {
        msgCode = "NO_MESSAGE_CODE";
        MessageManager.init();
    }
}
