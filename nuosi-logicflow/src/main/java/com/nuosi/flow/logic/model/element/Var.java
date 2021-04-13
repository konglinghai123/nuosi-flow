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
public class Var {
    private String id;
    private String type;
    private String name;
    private String initial;
    private List<Limit> limits;
    private String model;
    private String attr;
    private String key;
    private String validityCheck;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInitial() {
        return initial;
    }

    public void setInitial(String initial) {
        this.initial = initial;
    }

    public List<Limit> getLimits() {
        return limits;
    }

    public void setLimits(List<Limit> limits) {
        this.limits = limits;
    }

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
