package com.nuosi.flow.logic.model.body;

/**
 * @author nuosi fsofs@163.com
 * @version 0.1.0
 * @name SqlNode
 * @desc TODO
 * @date 2021/3/6 12:16
 */
public class SqlNode extends Node{
    private String sql;

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }
}
