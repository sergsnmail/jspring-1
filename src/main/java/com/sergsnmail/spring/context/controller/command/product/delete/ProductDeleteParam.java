package com.sergsnmail.spring.context.controller.command.product.delete;

import com.sergsnmail.spring.context.controller.command.Parameter;

public class ProductDeleteParam extends Parameter {

    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
