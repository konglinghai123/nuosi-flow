package com.nuosi.flow.logic.model.body;

import com.nuosi.flow.logic.model.action.Rule;
import com.nuosi.flow.logic.model.action.Sql;
import com.nuosi.flow.logic.model.element.Input;
import com.nuosi.flow.logic.model.element.Output;

import java.util.List;

/**
 * <p>desc: 逻辑流元素：行为节点</p>
 * <p>date: 2021/3/6 12:16</p>
 * @author nuosi fsofs@163.com
 * @version v1.0.0
 */
public class Action {

    public static enum ActionType{
        SQL,SERVICE,RULE,MAPPING,EXPRESSION,EVENT
    }

    private String id;
    private String name;
    private String next;
    private List<Input> inputs;
    private List<Output> outputs;
    private ActionType actionType;
    private List<Sql> sqls;
    private List<Rule> rules;

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

    public List<Input> getInputs() {
        return inputs;
    }

    public Action setInputs(List<Input> inputs) {
        this.inputs = inputs;
        return this;
    }

    public List<Output> getOutputs() {
        return outputs;
    }

    public Action setOutputs(List<Output> outputs) {
        this.outputs = outputs;
        return this;
    }

    public ActionType getActionType() {
        return actionType;
    }

    public List<Sql> getSqls() {
        return sqls;
    }

    public Action setSqls(List<Sql> sqls) {
        this.sqls = sqls;
        actionType = ActionType.SQL;
        return this;
    }

    public List<Rule> getRules() {
        return rules;
    }

    public Action setRules(List<Rule> rules) {
        this.rules = rules;
        actionType = ActionType.RULE;
        return this;
    }
}
