package com.nuosi.flow.logic.inject;

import com.ai.ipu.basic.util.IpuUtility;
import com.nuosi.flow.logic.inject.basic.ExceptionUtil;
import com.nuosi.flow.logic.inject.function.impl.DbDomainFunction;

/**
 * <p>desc: 表达式全局变量 </p>
 * <p>date: 2021/5/1 0:46 </p>
 *
 * @author nuosi fsofs@163.com
 * @version v1.0.0
 */
public class QuickBuild {
    private static volatile QuickBuild instance = null;

    private QuickBuild() {}

    public static QuickBuild getInstance() {
        if (instance == null) {
            synchronized (QuickBuild.class) {
                if (instance == null) {
                    instance = new QuickBuild();
                }
            }
        }
        return instance;
    }

    public void errorCode(String msgCode, String ... matcher){
        ExceptionUtil.errorCode(msgCode, matcher);
    }

    public void print(String msg){
        System.out.println(msg);
    }

    public void printf(String format, Object ... args){
        System.out.printf(format + "%n", args);
    }

    public DbDomainFunction getDataModelPersistence(String connName) {
        try {
            return new DbDomainFunction();
        } catch (Exception e) {
            IpuUtility.error(e);
        }
        return null;
    }
}
