package com.nuosi.flow.util;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>desc: 表达式工具类 </p>
 * <p>date: 2021/4/30 13:56 </p>
 *
 * @author nuosi fsofs@163.com
 * @version v1.0.0
 */
public class ExpressionUtil {
    static String PATTERN = "\\$\\{\\w+\\}";

    public static String renderTemplate(String template, Map<String, Object> params) {
        Matcher m = Pattern.compile(PATTERN).matcher(template);
        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            String param = m.group();
            Object value = params.get(param.substring(2, param.length() - 1));
            m.appendReplacement(sb, value == null ? "" : value.toString());
        }
        m.appendTail(sb);
        return sb.toString();
    }

}
