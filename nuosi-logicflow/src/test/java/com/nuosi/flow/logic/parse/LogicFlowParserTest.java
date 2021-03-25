package com.nuosi.flow.logic.parse;

import com.alibaba.fastjson.JSONObject;
import com.nuosi.flow.logic.util.XmlHelper;
import org.junit.Assert;
import org.junit.Test;

import java.io.InputStream;

/**
 * @author nuosi fsofs@163.com
 * @version 0.1.0
 * @name LogicFlowParserTest
 * @desc TODO
 * @date 2021/3/7 16:37
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
