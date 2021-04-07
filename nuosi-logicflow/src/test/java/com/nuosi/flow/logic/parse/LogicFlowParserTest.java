package com.nuosi.flow.logic.parse;

import com.alibaba.fastjson.JSONObject;
import com.nuosi.flow.logic.util.XmlHelper;
import org.junit.Assert;
import org.junit.Test;

import java.io.InputStream;

/**
 * <p>desc: 逻辑流模型解析单元测试</p>
 * <p>date: 2021/3/7 16:37</p>
 * @author nuosi fsofs@163.com
 * @version v1.0.0
 */
public class LogicFlowParserTest {

    @Test
    public void parseAllTest() throws Exception {
        try{
            String flowConfig = "flow/simple_flow.xml";
            InputStream is = getClass().getClassLoader().getResourceAsStream(flowConfig);
            new LogicFlowParser().parser(is);
            Assert.assertTrue(true);
        }catch (Exception e){
            Assert.assertTrue(false);
            e.printStackTrace();
        }
    }

    @Test
    public void parseTest() throws Exception {
        try{
            String flowConfig = "flow/simple_flow.xml";
            InputStream is = getClass().getClassLoader().getResourceAsStream(flowConfig);
            XmlHelper dh = new XmlHelper(is);
            JSONObject originData = dh.getAllJson();
            System.out.println(originData.toJSONString());
            Assert.assertTrue(true);
        }catch (Exception e){
            Assert.assertTrue(false);
            e.printStackTrace();
        }
    }
}
