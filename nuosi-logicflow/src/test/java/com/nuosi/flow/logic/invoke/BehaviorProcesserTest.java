package com.nuosi.flow.logic.invoke;

import com.ai.ipu.data.JMap;
import com.ai.ipu.data.impl.JsonMap;
import com.nuosi.flow.data.BDataDefine;
import com.nuosi.flow.data.BizDataManager;
import com.nuosi.flow.logic.LogicFlowEngine;
import com.nuosi.flow.logic.LogicFlowManager;
import com.nuosi.flow.logic.parse.DtoToDataDefineParser;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

/**
 * <p>desc: 模型行为相关语法展示 </p>
 * <p>date: 2021/5/13 18:44 </p>
 *
 * @author nuosi fsofs@163.com
 * @version v1.0.0
 */
public class BehaviorProcesserTest {

    @Test
    public void testModelBehaviorSql() {
        JMap param = new JsonMap();
        param.put("staff_id","zhangs");
        Object result = LogicFlowEngine.execute("working_hours_query",param);
        System.out.println("result===" + result);
    }

    @Test
    public void testModelBehaviorFunction() {
        JMap param = new JsonMap();
        JMap data = new JsonMap();
        data.put("fill_id","202104160005");
        data.put("fill_staff","zhangs");
        data.put("fill_date","2021-04-02 00:00:00");
        data.put("project_stage_code","1BJ2106A");
        data.put("project_name","2021年数据可视化");
        data.put("project_stage","项目上线");
        data.put("fill_hours","5");

        param.put("working_hours", data);
        Object result = LogicFlowEngine.execute("working_hours_insert",param);
        System.out.println("result===" + result);
    }

    @Before
    public void setUp() {
        String flowConfig = "working_hours/flow/working_hours_query.xml";
        InputStream is = getClass().getClassLoader().getResourceAsStream(flowConfig);
        LogicFlowManager.registerLogicFlow(is);

        flowConfig = "working_hours/flow/working_hours_insert.xml";
        is = getClass().getClassLoader().getResourceAsStream(flowConfig);
        LogicFlowManager.registerLogicFlow(is);

        String modelConfig = "working_hours/model/working_hours_entity.xml";
        is = getClass().getClassLoader().getResourceAsStream(modelConfig);
        LogicFlowManager.registerDomainModel(is);

        try {
            BDataDefine dataDefine = new DtoToDataDefineParser().parse("working_hours_entity");
            BizDataManager.registerDto(dataDefine, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
