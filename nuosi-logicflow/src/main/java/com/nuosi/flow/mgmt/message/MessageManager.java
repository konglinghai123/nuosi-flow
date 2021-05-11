package com.nuosi.flow.mgmt.message;

import com.ai.ipu.basic.log.ILogger;
import com.ai.ipu.basic.log.IpuLoggerFactory;
import com.ai.ipu.basic.util.IpuUtility;

import java.lang.reflect.Field;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p>desc: 应用提示消息的管理类 </p>
 * <p>date: 2021/4/30 12:18 </p>
 *
 * @author nuosi fsofs@163.com
 * @version v1.0.0
 */
public class MessageManager {
    /**自定义提示信息的二级缓存*/
    private static Map<String, String> messageCache = new ConcurrentHashMap<String, String>();

    public static String getMessage(String msgCode, String ... matcher){
        String message = parseCodeToMessage(msgCode);
        return String.format(message, matcher);
    }

    public static void registerMessage(String msgCode, String message){
        messageCache.put(msgCode, message);
    }

    public static void unregisterMessage(String msgCode){
        messageCache.remove(msgCode);
    }

    public static String parseMessage(String message, String ... matcher){
        return String.format(message, matcher);
    }

    private static String parseCodeToMessage(String msgCode){
        String message = messageCache.get(msgCode);
        if(message==null){
            message = loadMessage(msgCode);
            messageCache.put(msgCode, message);
        }
        return message;
    }

    private static String loadMessage(String code){
        /*加载提示信息的逻辑需要重新实现，从分布式缓存中去获取*/
        String message = messageCache.get(code);//需要修改
        if(message==null){
            String error = MessageManager.parseMessage(Messages.NO_MESSAGE_CODE,code);
            IpuUtility.error(error);
        }
        return message;
    }
}
