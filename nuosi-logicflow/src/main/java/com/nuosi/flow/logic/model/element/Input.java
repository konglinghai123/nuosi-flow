package com.nuosi.flow.logic.model.element;

import java.util.List;

/**
 * <p>desc: 逻辑流元素：输入</p>
 * <p>date: 2021/3/6 12:19</p>
 * @author nuosi fsofs@163.com
 * @version v1.0.0
 */
public class Input {

    private List<Var> vars;

    public List<Var> getVars() {
        return vars;
    }

    public Input setVars(List<Var> vars) {
        this.vars = vars;
        return this;
    }
}
