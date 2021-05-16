package com.nuosi.flow.logic.model.domain;

import com.nuosi.flow.logic.model.action.Expression;
import com.nuosi.flow.logic.model.action.Foreach;
import com.nuosi.flow.logic.model.action.Sql;
import com.nuosi.flow.logic.model.body.Action;

import java.util.List;

/**
 * <p>desc: 逻辑流元素：领域模型行为 </p>
 * <p>date: 2021/5/13 15:52 </p>
 *
 * @author nuosi fsofs@163.com
 * @version v1.0.0
 */
public class Behavior {
    private Action.ActionType actionType;
    private String model;
    private String id;
    private String name;
    private List<Sql> sqls;
    private List<Expression> expressions;
    private List<Foreach> foreachs;

    public Action.ActionType getActionType() {
        return actionType;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

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

    public List<Sql> getSqls() {
        return sqls;
    }

    public Behavior setSqls(List<Sql> sqls) {
        this.sqls = sqls;
        actionType = Action.ActionType.SQL;
        return this;
    }

    public List<Expression> getExpressions() {
        return expressions;
    }

    public Behavior setExpressions(List<Expression> expressions) {
        this.expressions = expressions;
        actionType = Action.ActionType.EXPRESSION;
        return this;
    }

    public List<Foreach> getForeachs() {
        return foreachs;
    }

    public Behavior setForeachs(List<Foreach> foreachs) {
        this.foreachs = foreachs;
        actionType = Action.ActionType.FOREACH;
        return this;
    }
}
