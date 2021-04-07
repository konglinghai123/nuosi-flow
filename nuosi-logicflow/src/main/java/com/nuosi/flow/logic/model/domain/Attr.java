package com.nuosi.flow.logic.model.domain;

/**
 * <p>desc: 逻辑流元素：领域模型属性 </p>
 * <p>date: 2021/3/25 18:08 </p>
 *
 * @author nuosi fsofs@163.com
 * @version v1.0.0
 */
public class Attr {
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
