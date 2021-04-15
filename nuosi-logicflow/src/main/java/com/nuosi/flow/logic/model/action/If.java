package com.nuosi.flow.logic.model.action;

/**
 * <p>desc: 逻辑流元素：条件判断节点 </p>
 * <p>date: 2021/4/15 13:26 </p>
 * @author nuosi fsofs@163.com
 * @version v1.0.0
 */
public class If {
    private String test;
    private String interrupt;
    private String next;

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public String getInterrupt() {
        return interrupt;
    }

    public void setInterrupt(String interrupt) {
        this.interrupt = interrupt;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }
}
