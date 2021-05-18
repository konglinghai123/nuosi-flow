package com.nuosi.flow.scene;

import com.nuosi.flow.mgmt.message.MessageManager;
import org.junit.Test;

/**
 * <p>desc: 描述这个类功能的注释 </p>
 * <p>date: 2021/5/18 17:04 </p>
 *
 * @author nuosi fsofs@163.com
 * @version v1.0.0
 */
public class WorkingHoursSceneTest {

    @Test
    public void testWorkingHoursRecord(){

    }

    private void init(){
        MessageManager.registerMessage("PROJECT_STAGE_CODE_NULL",
                "项目编号为空，[%s]员工无法录入工时");
        MessageManager.registerMessage("FILL_HOURS_RANGE",
                "[%s]员工填报工时数需要在0-24小时范围内");
    }
}
