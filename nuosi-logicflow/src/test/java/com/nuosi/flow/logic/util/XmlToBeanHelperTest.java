package com.nuosi.flow.logic.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.nuosi.flow.logic.model.domain.DomainModel;
import org.junit.Assert;
import org.junit.Test;

import java.io.InputStream;

/**
 * <p>desc: XML转换JavaBean单元测试</p>
 * <p>date: 2021/3/26 0:45</p>
 * @author nuosi fsofs@163.com
 * @version v1.0.0
 */
public class XmlToBeanHelperTest {

    @Test
    public void testGetBeanJson(){
        try{
            String flowConfig = "model/goods_info.xml";
            InputStream is = getClass().getClassLoader().getResourceAsStream(flowConfig);
            JSONObject beanJson = new XmlToBeanHelper(is).getBeanJson();
            System.out.println(beanJson);
            DomainModel domainModel = JSON.toJavaObject(beanJson, DomainModel.class);
            Assert.assertTrue(true);
        }catch (Exception e){
            e.printStackTrace();
            Assert.assertTrue(false);
        }
    }
}
