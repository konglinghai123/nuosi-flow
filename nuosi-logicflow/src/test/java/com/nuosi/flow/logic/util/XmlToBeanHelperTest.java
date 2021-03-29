package com.nuosi.flow.logic.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.nuosi.flow.logic.model.domain.DomainModel;
import org.junit.Assert;
import org.junit.Test;

import java.io.InputStream;

/**
 * <p>desc: 描述这个类功能的注释 </p>
 * <p>date: 2021/3/26 0:45 </p>
 *
 * @author nuosi fsofs@163.com
 * @version v1.0.0
 * update:[序号][日期YYYY-MM-DD] [更改人姓名][变更描述]
 */
public class XmlToBeanHelperTest {

    @Test
    public void testGetBeanJson(){
        try{
            String flowConfig = "dto/goods_info_dto.xml";
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
