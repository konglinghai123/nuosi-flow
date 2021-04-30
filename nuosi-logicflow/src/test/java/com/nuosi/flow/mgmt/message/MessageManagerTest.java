package com.nuosi.flow.mgmt.message;

import org.junit.Test;

/**
 * <p>desc: 描述这个类功能的注释 </p>
 * <p>date: 2021/4/30 13:00 </p>
 *
 * @author nuosi fsofs@163.com
 * @version v1.0.0
 */
public class MessageManagerTest {

    @Test
    public void messageTest(){
        MessageManager.init();
        String message = MessageManager.parse(Messages.FLOW_NODE_TAG_ARRT_EXCEPT,"ABC","start","var");
        System.out.println(message);
    }
}
