package com.nuosi.flow.logic.model.domain;

import com.nuosi.flow.logic.model.element.Var;

/**
 * <p>desc: 描述这个类功能的注释 </p>
 * <p>date: 2021/3/25 18:08 </p>
 *
 * @author nuosi fsofs@163.com
 * @version v1.0.0
 * update:[序号][日期YYYY-MM-DD] [更改人姓名][变更描述]
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
