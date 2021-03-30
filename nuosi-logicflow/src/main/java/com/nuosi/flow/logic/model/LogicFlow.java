package com.nuosi.flow.logic.model;

import com.nuosi.flow.logic.model.body.Action;
import com.nuosi.flow.logic.model.body.End;
import com.nuosi.flow.logic.model.body.Start;
import com.nuosi.flow.logic.model.header.Global;

import java.util.List;

/**
 * @author nuosi fsofs@163.com
 * @version 0.1.0
 * @name Flow
 * @desc TODO
 * @date 2021/3/6 12:12
 */
public class LogicFlow {
    private String id;
    private String name;
    private String desc;
    private List<Global> globals;
    private List<Start> starts;
    private List<End> ends;
    private List<Action> actions;

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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<Global> getGlobals() {
        return globals;
    }

    public void setGlobals(List<Global> globals) {
        this.globals = globals;
    }

    public List<Start> getStarts() {
        return starts;
    }

    public void setStarts(List<Start> starts) {
        this.starts = starts;
    }

    public List<End> getEnds() {
        return ends;
    }

    public void setEnds(List<End> ends) {
        this.ends = ends;
    }

    public List<Action> getActions() {
        return actions;
    }

    public void setActions(List<Action> actions) {
        this.actions = actions;
    }
}
