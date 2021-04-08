package com.nuosi.flow.logic.parse;

import com.ai.ipu.basic.util.IpuBaseException;
import com.nuosi.flow.data.BData;
import com.nuosi.flow.data.BDataDefine;
import com.nuosi.flow.data.BizDataManager;
import com.nuosi.flow.data.impl.BizData;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * <p>desc: 描述这个类功能的注释 </p>
 * <p>date: 2021/4/8 19:13 </p>
 *
 * @author nuosi fsofs@163.com
 * @version v1.0.0
 */
public class DtoToDataDefineParserTest {

    @Test
    public void testParseDataDefine() throws Exception {
        String flowConfig = "dto/goods_info_dto.xml";
        DtoToDataDefineParser parser = new DtoToDataDefineParser(flowConfig);
        BDataDefine dataDefine = parser.parse();

        BizDataManager.registerDto(dataDefine, true);
        BData bData = new BizData(dataDefine.getBizName());
        try{
            bData.put("price", 99.999999999);
            Assert.assertTrue(false);
        }catch (Exception e){
            Assert.assertTrue(true);
        }
    }

    @Test
    public void testImportBData() throws Exception {

    }

    @Before
    public void before(){
        String exceptionMessagesConfig = "com/nuosi/flow/exception_messages";
        IpuBaseException.registerCode(exceptionMessagesConfig);
    }
}
