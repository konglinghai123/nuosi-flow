package com.nuosi.flow.logic.inject.basic;

import com.ai.ipu.basic.util.IpuUtility;
import com.nuosi.flow.mgmt.message.MessageManager;

/**
 * <p>desc: 注入表达式的异常工具 </p>
 * <p>date: 2021/4/30 20:44 </p>
 *
 * @author nuosi fsofs@163.com
 * @version v1.0.0
 */
public class ExceptionUtil {

    public static void errorCode(String msgCode, String... matcher) {
        //关键字：MEVL static
        String message = MessageManager.getMessage(msgCode, matcher);
        IpuUtility.error(message);
    }

}
