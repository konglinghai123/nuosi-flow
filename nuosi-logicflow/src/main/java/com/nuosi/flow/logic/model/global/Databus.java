package com.nuosi.flow.logic.model.global;

import com.nuosi.flow.logic.model.element.Var;

import java.util.List;

/**
 * <p>desc: 逻辑流元素：全局定义</p>
 * <p>date: 2021/3/6 12:13</p>
 * @author nuosi fsofs@163.com
 * @version v1.0.0
 */
public class Databus {
    private List<Import> imports;
    private List<Var> vars;

    public List<Import> getImports() {
        return imports;
    }

    public void setImports(List<Import> imports) {
        this.imports = imports;
    }

    public List<Var> getVars() {
        return vars;
    }

    public void setVars(List<Var> vars) {
        this.vars = vars;
    }
}
