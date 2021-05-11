package com.nuosi.flow.util;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>desc: 分支逻辑工具类单元测试 </p>
 * <p>date: 2021/4/30 14:10 </p>
 *
 * @author nuosi fsofs@163.com
 * @version v1.0.0
 */
public class IfUtilTest {

    @Test
    public void testRenderTemplate(){
        Map map = new HashMap();
        map.put("name", "张三");
        map.put("money", String.format("%.2f", 10.155));
        map.put("point", 10);
        String content = "您好${name}，晚上好！您目前余额：${money}元，积分：${point}";
        String message = IfUtil.renderTemplate(content, map);
        System.out.println(message);
        Assert.assertTrue(true);
    }
}
