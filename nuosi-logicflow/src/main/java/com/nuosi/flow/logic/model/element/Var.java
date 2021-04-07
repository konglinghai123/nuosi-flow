package com.nuosi.flow.logic.model.element;

import com.nuosi.flow.logic.model.domain.Attr;

/**
 * <p>desc: 逻辑流元素：变量定义</p>
 * <p>date: 2021/3/6 12:19</p>
 * @author nuosi fsofs@163.com
 * @version v1.0.0
 */
public class Var extends Attr {
    private String reuse;
    private String attr;
    private String buskey;
    private String validityCheck;

    public String getReuse() {
        return reuse;
    }

    public void setReuse(String reuse) {
        this.reuse = reuse;
    }

    public String getAttr() {
        return attr;
    }

    public void setAttr(String attr) {
        this.attr = attr;
    }

    public String getBuskey() {
        return buskey;
    }

    public void setBuskey(String buskey) {
        this.buskey = buskey;
    }

    public String getValidityCheck() {
        return validityCheck;
    }

    public void setValidityCheck(String validityCheck) {
        this.validityCheck = validityCheck;
    }
}
