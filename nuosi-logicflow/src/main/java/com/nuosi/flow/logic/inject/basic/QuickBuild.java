package com.nuosi.flow.logic.inject.basic;

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

    public static void errorCode(String msgCode, String ... matcher){
        ExceptionUtil.errorCode(msgCode, matcher);
    }
}
