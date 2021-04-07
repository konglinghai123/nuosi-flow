package com.nuosi.flow.logic.model.body;

import com.nuosi.flow.logic.model.element.Var;

import java.util.List;

/**
 * <p>desc: 逻辑流元素：开始节点</p>
 * <p>date: 2021/3/24 12:15</p>
 * @author nuosi fsofs@163.com
 * @version v1.0.0
 * update:[序号][日期YYYY-MM-DD] [更改人姓名][变更描述]
 */
public class Start{
    private String id;
    private String name;
    private String next;
    private List<Var> vars;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public List<Var> getVars() {
        return vars;
    }

    public void setVars(List<Var> vars) {
        this.vars = vars;
    }
}
