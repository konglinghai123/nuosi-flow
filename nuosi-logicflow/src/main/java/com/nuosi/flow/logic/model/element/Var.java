package com.nuosi.flow.logic.model.element;

import com.nuosi.flow.logic.model.domain.Attr;
import com.nuosi.flow.logic.model.domain.Limit;

import java.util.List;

/**
 * <p>desc: 逻辑流元素：变量定义</p>
 * <p>date: 2021/3/6 12:19</p>
 * @author nuosi fsofs@163.com
 * @version v1.0.0
 */
public class Var extends Attr{
    private String model;
    private String attr;
    private String key;
    private String validityCheck;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getAttr() {
        return attr;
    }

    public void setAttr(String attr) {
        this.attr = attr;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValidityCheck() {
        return validityCheck;
    }

    public void setValidityCheck(String validityCheck) {
        this.validityCheck = validityCheck;
    }
}
