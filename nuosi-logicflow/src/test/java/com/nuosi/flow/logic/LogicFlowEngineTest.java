package com.nuosi.flow.logic;

import com.ai.ipu.data.JMap;
import com.ai.ipu.data.impl.JsonMap;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.nuosi.flow.logic.model.LogicFlow;
import com.nuosi.flow.logic.model.domain.DomainModel;
import com.nuosi.flow.logic.parse.XmlToBizDataParser;
import com.nuosi.flow.logic.parse.XmlToLogicFlowParser;
import com.nuosi.flow.logic.parse.XmlToLogicFlowParserTest;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * <p>desc: 描述这个类功能的注释 </p>
 * <p>date: 2021/3/29 21:17 </p>
 *
 * @author nuosi fsofs@163.com
 * @version v1.0.0
 * update:[序号][日期YYYY-MM-DD] [更改人姓名][变更描述]
 */
public class LogicFlowEngineTest {

    @Before
    public void setUp(){
        String dtoConfig = "dto/goods_info_dto.xml";
        InputStream is1 = XmlToLogicFlowParserTest.class.getClassLoader().getResourceAsStream(dtoConfig);
        String flowConfig = "flow/simple_flow.xml";
        InputStream is2 = getClass().getClassLoader().getResourceAsStream(flowConfig);
        try {
            JSONObject beanJson = new XmlToBizDataParser(is1).getBeanJson();
            DomainModel domainModel = JSON.toJavaObject(beanJson, DomainModel.class);
            LogicFlowManager.storageDomainModel(domainModel);

            JSONObject flowJson = new XmlToLogicFlowParser(is2).getBeanJson();
            LogicFlow logicFlow = JSON.toJavaObject(flowJson, LogicFlow.class);
            LogicFlowManager.storageLogicFlow(logicFlow);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(is1!=null)
                    is1.close();
                if(is2!=null)
                    is2.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testExecute(){
        JMap param = new JsonMap();
        param.put("id","abc");
        LogicFlowEngine.execute("simple_logic_flow_example",param);
    }
}
