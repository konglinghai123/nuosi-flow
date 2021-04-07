package com.nuosi.flow.logic.invoke.handler;

import com.nuosi.flow.logic.invoke.ExecutionContainer;
import com.nuosi.flow.logic.model.action.Sql;

/**
 * <p>desc: 节点执行处理器的SQL类型实现 </p>
 * <p>date: 2021/3/29 21:33 </p>
 *
 * @author nuosi fsofs@163.com
 * @version v1.0.0
 */
public class SqlProcesser implements IActionProcesser {

    @Override
    public void execute(ExecutionContainer container, Object ... param) {
        Sql sql = (Sql) param[0];
        System.out.println("执行SQL：" + sql.getSql());
    }
}
