package com.sergsnmail.spring.context.controller;

import com.sergsnmail.spring.context.controller.command.product.avg.ProductAvg;
import com.sergsnmail.spring.context.controller.command.product.create.ProductCreate;
import com.sergsnmail.spring.context.controller.command.product.delete.ProductDelete;
import com.sergsnmail.spring.context.controller.command.product.list.ProductList;
import com.sergsnmail.spring.context.controller.command.product.read.ProductRead;
import com.sergsnmail.spring.context.controller.command.product.update.ProductUpdate;
import com.sergsnmail.spring.context.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@ComponentScan("com.sergsnmail.spring.context.service")
public class ProductController{

    @Autowired
    private ProductService productService;

    public <T> void doCommand(T command){
        if (command instanceof ProductCreate){
            create((ProductCreate) command);
        } else if (command instanceof ProductRead){
            read((ProductRead) command);
        } else if (command instanceof ProductUpdate){
            update((ProductUpdate) command);
        } else if (command instanceof ProductDelete){
            delete((ProductDelete) command);
        } else if (command instanceof ProductAvg){
            printAvg();
        } else if (command instanceof ProductList){
            printProducts();
        } else {
            System.err.println("Unknown command");
        }
    }

    private void create(ProductCreate command) {
        productService.create(command.getParameter());
    }

    private void read(ProductRead command) {
        productService.read(command.getParameter());
    }

    private void update(ProductUpdate command) {
        productService.update(command.getParameter());
    }

    private void delete(ProductDelete command) {
        productService.delete(command.getParameter());
    }

    private void printAvg() {
        productService.printAvg();
    }

    private void printProducts() {
        productService.printAllProducts();
    }
}
