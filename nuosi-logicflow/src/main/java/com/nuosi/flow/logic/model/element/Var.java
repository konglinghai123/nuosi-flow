package com.nuosi.flow.logic.model.element;

/**
 * @author nuosi fsofs@163.com
 * @version 0.1.0
 * @name Var
 * @desc TODO
 * @date 2021/3/6 12:19
 */
public class Var {
    private String id;
    private String type;
    private String name;
    private String initial;

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
}
