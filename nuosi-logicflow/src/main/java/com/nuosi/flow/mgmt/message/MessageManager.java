package com.nuosi.flow.mgmt.message;

import com.ai.ipu.basic.log.ILogger;
import com.ai.ipu.basic.log.IpuLoggerFactory;
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
    private static Map<String, String> messageCache = new ConcurrentHashMap<String, String>();

    static {
        // 加载默认提供的信息
        initializeMessages(LogicFlowConstants.PACKAGE_PATH + "messages",
                "com.nuosi.flow.mgmt.message.Messages");
    }

    public static void init(){}

    public static String get(String code, String ... matcher){
        String message = parseCodeToMessage(code);
        return String.format(message, matcher);
    }

    public static String parse(String message, String ... matcher){
        return String.format(message, matcher);
    }

    private static String parseCodeToMessage(String code){
        String message = messageCache.get(code);
        if(message==null){
            message = loadMessage(code);
            messageCache.put(code, message);
        }
        return message;
    }

    private static String loadMessage(String code){
        String message = messageCache.get(code);
        if(message==null){
            message = "";
            messageCache.put(code, message);
        }
        return message;
    }

    private static void initializeMessages(String bundleName, String className) {
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
