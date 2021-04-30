package com.nuosi.flow.mgmt.message;

import com.ai.ipu.basic.string.NLS;
import com.nuosi.flow.util.LogicFlowConstants;

/**
 * <p>desc: 提示信息内置常量 </p>
 * <p>date: 2021/4/30 12:54 </p>
 *
 * @author nuosi fsofs@163.com
 * @version v1.0.0
 */
public class Messages {
    static {
        // 加载默认提供的信息
        MessageManager.initializeMessages(LogicFlowConstants.PACKAGE_PATH + "messages",
                "com.nuosi.flow.mgmt.message.Messages");
    }

    /*提示信息编码*/
    public static String NO_MESSAGE_CODE;

}
