package com.sergsnmail.spring.context.controller.command.product.create;

import com.sergsnmail.spring.context.controller.command.Parameter;

public class ProductCreateParam extends Parameter {

    private long id;
    private String title;
    private float cost;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }
}
