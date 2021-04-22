package com.nuosi.flow.logic.model.action;

/**
 * <p>desc: 逻辑流元素：循环节点
 * 循环List结构的数据结果集，其他更灵活的循环使用脚本实现</p>
 * <p>date: 2021/4/16 9:44 </p>
 *
 * @author nuosi fsofs@163.com
 * @version v1.0.0
 */
public class Foreach {
    private String iterable;
    private String foreach;

    public String getIterable() {
        return iterable;
    }

    public void setIterable(String iterable) {
        this.iterable = iterable;
    }

    public String getForeach() {
        return foreach;
    }

    public void setForeach(String foreach) {
        this.foreach = foreach;
    }
}
