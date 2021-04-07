package com.nuosi.flow.logic.util;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>desc: 遵循XML Schema规范校验XML格式</p>
 * <p>date: 2021/3/6 16:21</p>
 * @author nuosi fsofs@163.com
 * @version v1.0.0
 */
public class FlowXmlSchema {
    static Map<String, String[]> flowXmlSchema = new HashMap<String, String[]>();
    static {
        String[] var = new String[]{"id","type","name","final","default","initial"};
        flowXmlSchema.put("var", var);
    }

    public static boolean validate(String tag){
        return flowXmlSchema.containsKey(tag);
    }
}
