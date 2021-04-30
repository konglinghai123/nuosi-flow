package com.nuosi.flow.logic;

import com.ai.ipu.data.JMap;
import com.ai.ipu.data.impl.JsonMap;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.nuosi.flow.data.BDataDefine;
import com.nuosi.flow.data.BizDataManager;
import com.nuosi.flow.logic.model.LogicFlow;
import com.nuosi.flow.logic.model.domain.DomainModel;
import com.nuosi.flow.logic.parse.DtoToDataDefineParser;
import com.nuosi.flow.logic.parse.XmlToBizDataParser;
import com.nuosi.flow.logic.parse.XmlToLogicFlowParser;
import com.nuosi.flow.logic.parse.XmlToLogicFlowParserTest;
import com.nuosi.flow.mgmt.message.MessageManager;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * <p>desc: 逻辑流引擎单元测试</p>
 * <p>date: 2021/3/29 21:17</p>
 * @author nuosi fsofs@163.com
 * @version v1.0.0
 */
public class LogicFlowEngineTest {

    @Test
    public void testExecute(){
        MessageManager.registerMessage("NO_MESSAGE_CODE", "提示信息编码[%s]已存在，无需注册");
        JMap param = new JsonMap();
        param.put("goods_name","橙汁");
        param.put("goods_type",1);
        Object result = LogicFlowEngine.execute("simple_logic_flow_example",param);
        System.out.println("result===" + result);
    }

    @Before
    public void setUp(){
        String dtoConfig = "model/goods_model.xml";
        InputStream is1 = XmlToLogicFlowParserTest.class.getClassLoader().getResourceAsStream(dtoConfig);
        String flowConfig = "flow/simple_flow.xml";
        InputStream is2 = getClass().getClassLoader().getResourceAsStream(flowConfig);
        try {
            JSONObject beanJson = new XmlToBizDataParser(is1).getBeanJson();
            DomainModel domainModel = JSON.toJavaObject(beanJson, DomainModel.class);
            LogicFlowManager.storageDomainModel(domainModel);
            BDataDefine dataDefine = new DtoToDataDefineParser().parse(domainModel);

            BizDataManager.registerDto(dataDefine, true);


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
}
