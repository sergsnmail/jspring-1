package com.sergsnmail.spring.context.controller.command;

public abstract class Command <T extends Parameter>{

    protected T parameter;

    public T getParameter() {
        return parameter;
    }

    public void setParameter(T parameter) {
        this.parameter = parameter;
    }

}
