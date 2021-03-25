package com.nuosi.flow.data.parse;

import com.alibaba.fastjson.JSON;
import com.nuosi.flow.logic.model.domain.DomainModel;
import org.junit.Assert;
import org.junit.Test;

import java.io.InputStream;

/**
 * <p>desc: 描述这个类功能的注释 </p>
 * <p>date: 2021/3/25 13:53 </p>
 *
 * @author nuosi fsofs@163.com
 * @version v1.0.0
 * update:[序号][日期YYYY-MM-DD] [更改人姓名][变更描述]
 */
public class BDataParserTest {

    @Test
    public void parseAllTest() throws Exception {
        try{
            String flowConfig = "dto/goods_info_dto.xml";
            InputStream is = getClass().getClassLoader().getResourceAsStream(flowConfig);
            DomainModel domainModel = new BizDataParser().parser(is);
            String strDomainModel = JSON.toJSONString(domainModel);
            System.out.println("domainModel==="+ strDomainModel);
            DomainModel domainModel1 = JSON.toJavaObject(JSON.parseObject(strDomainModel), DomainModel.class);
            Assert.assertEquals(strDomainModel, JSON.toJSONString(domainModel1));
        }catch (Exception e){
            e.printStackTrace();
            Assert.assertTrue(false);
        }
    }
}
