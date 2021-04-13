package com.nuosi.flow.logic.parse.backup;

import com.alibaba.fastjson.JSON;
import com.nuosi.flow.logic.model.domain.DomainModel;
import com.nuosi.flow.logic.parse.backup.BizDataParser;
import org.junit.Assert;
import org.junit.Test;

import java.io.InputStream;

/**
 * <p>desc: 业务传输对象解析单元测试</p>
 * <p>date: 2021/3/25 13:53</p>
 * @author nuosi fsofs@163.com
 * @version v1.0.0
 */
public class BizDataParserTest {

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
