package com.nuosi.flow.data;

import com.nuosi.flow.data.impl.BizDataDefine;
import com.nuosi.flow.logic.LogicFlowEngine;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author nuosi fsofs@163.com
 * @version 0.1.0
 * @name BizDataManagerTest
 * @desc TODO
 * @date 2021/3/16 17:27
 */
public class BizDataManagerTest {
    private String bizName;
    @Before
    public void before(){
        LogicFlowEngine.init();
        bizName = "User";
        // 注册User结构的业务对象
        BDataDefine dataDefine = new BizDataDefine(bizName);
        dataDefine.defineType("name", BDataDefine.DataType.STRING);
        BizDataManager.registerDto(dataDefine, true);
    }

    @Test
    public void testNewInstanceWithRegister(){
        try{
            BData user = BizDataManager.newInstance(bizName);
            user.put("name","zhangsan");
            System.out.println(bizName + ":" + user);
            Assert.assertTrue(true);
        }catch (Exception e){
            e.printStackTrace();
            Assert.assertTrue(false);
        }
    }

    @Test
    public void testNewInstanceWithNoRegister(){
        try{
            BizDataManager.removeBizDataDefine(bizName); //全量测试的时候提前删除
            BData user = BizDataManager.newInstance(bizName);
            user.put("name","zhangsan");
            System.out.println(bizName+ ":" + user);
            Assert.assertTrue(false);
        }catch (Exception e){
            Assert.assertTrue(true);
            System.out.println("Ex:" + e.getMessage());
        }
    }

    @Test
    public void testErrorDataType(){
        try{
            BData user = BizDataManager.newInstance(bizName);
            user.put("name", 123456);
            System.out.println(bizName + ":" + user);
            Assert.assertTrue(true);
        }catch (Exception e){
            e.printStackTrace();
            Assert.assertTrue(false);
        }
    }
}
