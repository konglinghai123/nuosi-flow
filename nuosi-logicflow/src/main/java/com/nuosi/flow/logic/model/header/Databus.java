package com.nuosi.flow.logic.model.header;

import com.nuosi.flow.logic.model.element.Var;

import java.util.List;

/**
 * <p>desc: 逻辑流元素：数据总线</p>
 * <p>date: 2021/3/6 12:15</p>
 * @author nuosi fsofs@163.com
 * @version v1.0.0
 */
public class Databus {
    private List<Var> vars;

    public List<Var> getVars() {
        return vars;
    }

    public void setVars(List<Var> vars) {
        this.vars = vars;
    }
}
