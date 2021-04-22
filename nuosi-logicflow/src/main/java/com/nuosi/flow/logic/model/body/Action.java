package com.nuosi.flow.logic.model.body;

import com.nuosi.flow.logic.model.action.Expression;
import com.nuosi.flow.logic.model.action.Foreach;
import com.nuosi.flow.logic.model.action.If;
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
        SQL,EXPRESSION,IF,FOREACH,SERVICE,RULE,MAPPING,EVENT
    }

    private String id;
    private String name;
    private String next;
    private List<Input> inputs;
    private List<Output> outputs;
    private ActionType actionType;
    private List<Sql> sqls;
    private List<Expression> expressions;
    private List<If> ifs;
    private List<Foreach> foreachs;

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

    public List<Expression> getExpressions() {
        return expressions;
    }

    public Action setExpressions(List<Expression> expressions) {
        this.expressions = expressions;
        actionType = ActionType.EXPRESSION;
        return this;
    }

    public List<If> getIfs() {
        return ifs;
    }

    public Action setIfs(List<If> ifs) {
        this.ifs = ifs;
        actionType = ActionType.IF;
        return this;
    }

    public List<Foreach> getForeachs() {
        return foreachs;
    }

    public Action setForeachs(List<Foreach> foreachs) {
        this.foreachs = foreachs;
        actionType = ActionType.FOREACH;
        return this;
    }
}
