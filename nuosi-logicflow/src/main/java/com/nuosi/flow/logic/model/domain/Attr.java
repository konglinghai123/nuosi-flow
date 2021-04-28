package com.nuosi.flow.logic.model.domain;

import java.util.List;

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
    private List<Limit> limits;

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

    public List<Limit> getLimits() {
        return limits;
    }

    public void setLimits(List<Limit> limits) {
        this.limits = limits;
    }
}
