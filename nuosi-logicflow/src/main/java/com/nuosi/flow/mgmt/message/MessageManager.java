package com.nuosi.flow.mgmt.message;

import com.ai.ipu.basic.log.ILogger;
import com.ai.ipu.basic.log.IpuLoggerFactory;
import com.ai.ipu.basic.util.IpuUtility;
import com.nuosi.flow.util.LogicFlowConstants;

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
    private static final ILogger LOG = IpuLoggerFactory.createLogger(MessageManager.class);
    private static final String FROM_ENCODE = "ISO-8859-1";
    private static final String TO_ENCODE = "UTF-8";
    /**自定义提示信息的二级缓存*/
    private static Map<String, String> messageCache = new ConcurrentHashMap<String, String>();

    public static String parseMessage(String message, String ... matcher){
        return String.format(message, matcher);
    }

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

    private static String parseCodeToMessage(String msgCode){
        String message = messageCache.get(msgCode);
        if(message==null){
            message = loadMessage(msgCode);
            messageCache.put(msgCode, message);
        }
        return message;
    }

    private static String loadMessage(String code){
        String message = messageCache.get(code);
        if(message==null){
            String error = MessageManager.parseMessage(Messages.NO_MESSAGE_CODE,code);
            IpuUtility.error(error);
        }
        return message;
    }

    public static void initializeMessages(String bundleName, String className) {
        ResourceBundle messages = ResourceBundle.getBundle(bundleName, Locale.getDefault());

        try {
            Class<?> cls = Class.forName(className);
            Field[] fields = cls.getFields();
            int i = 0;

            for(int len = fields.length; i < len; ++i) {
                String value;
                try {
                    byte[] bytes = messages.getString(fields[i].getName()).getBytes(FROM_ENCODE);
                    value = new String(bytes, TO_ENCODE);
                } catch (MissingResourceException ex) {
                    value = null;
                }

                fields[i].set(cls, value);
            }
        } catch (Exception e) {
            LOG.error("Exception:", e);
        }
    }
}
