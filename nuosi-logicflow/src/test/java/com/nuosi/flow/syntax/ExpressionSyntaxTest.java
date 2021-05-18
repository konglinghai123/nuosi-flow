package com.nuosi.flow.syntax;

import com.nuosi.flow.logic.LogicFlowEngine;
import com.nuosi.flow.logic.LogicFlowManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

/**
 * <p>desc: 表达式逻辑相关语法展示 </p>
 * <p>date: 2021/5/11 12:20 </p>
 *
 * @author nuosi fsofs@163.com
 * @version v1.0.0
 */
public class ExpressionSyntaxTest {

    @Test
    public void testExpressionExcept(){
        try{
            LogicFlowEngine.execute("expression_except",null);
            Assert.assertTrue(false);
        }catch (Exception e){
            System.out.println("抛出信息：" + e.getMessage());
            Assert.assertTrue(e.getMessage(), true);
        }
    }

    @Before
    public void setUp(){
        String flowConfig = "syntax/expression_except.xml";
        InputStream is = getClass().getClassLoader().getResourceAsStream(flowConfig);
        LogicFlowManager.registerLogicFlow(is);
    }
}
