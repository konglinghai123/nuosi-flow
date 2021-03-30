package com.nuosi.flow.logic.invoke.handler;

import com.nuosi.flow.logic.invoke.ExecutionContainer;

/**
 * @author nuosi fsofs@163.com
 * @version 0.1.0
 * @name NodeHandler
 * @desc TODO
 * @date 2021/3/6 12:26
 */
public interface IActionProcesser {

    public void execute(ExecutionContainer container, Object ... param);
}
