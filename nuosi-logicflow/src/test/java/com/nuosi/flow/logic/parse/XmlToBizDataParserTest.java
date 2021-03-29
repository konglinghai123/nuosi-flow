package com.nuosi.flow.logic.parse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.nuosi.flow.logic.model.domain.DomainModel;
import com.nuosi.flow.logic.parse.BizDataParser;
import com.nuosi.flow.logic.parse.XmlToBizDataParser;
import org.junit.Assert;
import org.junit.Test;

import java.io.InputStream;

/**
 * <p>desc: 描述这个类功能的注释 </p>
 * <p>date: 2021/3/27 13:32 </p>
 *
 * @author nuosi fsofs@163.com
 * @version v1.0.0
 * update:[序号][日期YYYY-MM-DD] [更改人姓名][变更描述]
 */
public class XmlToBizDataParserTest {

    @Test
    public void testGetBeanJson(){
        try{
            String flowConfig = "dto/goods_info_dto.xml";
            InputStream is = getClass().getClassLoader().getResourceAsStream(flowConfig);
            JSONObject beanJson = new XmlToBizDataParser(is).getBeanJson();
            System.out.println("beanJson==="+beanJson);
            DomainModel domainModel = JSON.toJavaObject(beanJson, DomainModel.class);
            System.out.println("domainModel==="+JSON.toJSONString(domainModel));
            Assert.assertTrue(true);
        }catch (Exception e){
            e.printStackTrace();
            Assert.assertTrue(false);
        }
    }

    @Test
    public void testDomainModelIsEquals(){
        try{
            String flowConfig = "dto/goods_info_dto.xml";
            InputStream is1 = getClass().getClassLoader().getResourceAsStream(flowConfig);
            JSONObject beanJson = new XmlToBizDataParser(is1).getBeanJson();
            DomainModel domainModel1 = JSON.toJavaObject(beanJson, DomainModel.class);
            System.out.println("domainModel1==="+JSON.toJSONString(domainModel1));

            InputStream is2 = getClass().getClassLoader().getResourceAsStream(flowConfig);
            DomainModel domainModel2 = new BizDataParser().parser(is2);
            System.out.println("domainModel2==="+JSON.toJSONString(domainModel2));

            Assert.assertEquals("两个DomainModel转换格式不一致",
                    JSON.toJSONString(domainModel1), JSON.toJSONString(domainModel2));
        }catch (Exception e){
            e.printStackTrace();
            Assert.assertTrue(false);
        }
    }
}
