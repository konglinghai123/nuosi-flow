package com.nuosi.flow.logic.model.body;

import com.nuosi.flow.logic.model.element.Input;
import com.nuosi.flow.logic.model.element.Output;

import java.util.List;

/**
 * @author nuosi fsofs@163.com
 * @version 0.1.0
 * @name Node
 * @desc TODO
 * @date 2021/3/6 12:16
 */
public class Action {
    protected String id;
    protected String name;
    protected String next;
    protected Input input;
    protected Output output;

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

    public Input getInput() {
        return input;
    }

    public Action setInput(Input input) {
        this.input = input;
        return this;
    }

    public Output getOutput() {
        return output;
    }

    public Action setOutput(Output output) {
        this.output = output;
        return this;
    }
}
