package com.nuosi.flow.mgmt.message;

import com.ai.ipu.basic.log.ILogger;
import com.ai.ipu.basic.log.IpuLoggerFactory;
import com.nuosi.flow.util.LogicFlowConstants;

import java.lang.reflect.Field;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * <p>desc: 提示信息内置常量 </p>
 * <p>date: 2021/4/30 12:54 </p>
 *
 * @author nuosi fsofs@163.com
 * @version v1.0.0
 */
public class Messages {
    private static final ILogger LOG = IpuLoggerFactory.createLogger(Messages.class);
    private static final String FROM_ENCODE = "ISO-8859-1";
    private static final String TO_ENCODE = "UTF-8";
    static {
        // 加载默认提供的信息
        initializeMessages(LogicFlowConstants.PACKAGE_PATH + "messages",
                "com.nuosi.flow.mgmt.message.Messages");
    }

    /*提示信息编码*/
    public static String NO_MESSAGE_CODE;
    public static String EXPRESSION_DEFINE_HINT;
    public static String FOREACH_DEFINE_HINT;

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
                MessageManager.registerMessage(fields[i].getName(), value); //将Messages中的消息变量注册并提供给脚本使用
            }
        } catch (Exception e) {
            LOG.error("Exception:", e);
        }
    }

}
