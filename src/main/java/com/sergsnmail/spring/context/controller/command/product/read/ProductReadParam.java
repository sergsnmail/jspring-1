package com.sergsnmail.spring.context.controller.command.product.read;

import com.sergsnmail.spring.context.controller.command.Parameter;

public class ProductReadParam extends Parameter {

    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
