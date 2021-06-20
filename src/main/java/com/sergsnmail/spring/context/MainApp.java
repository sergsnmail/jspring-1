package com.sergsnmail.spring.context;

import com.sergsnmail.spring.context.controller.ProductController;
import com.sergsnmail.spring.context.controller.command.CommandFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ProductController productController = context.getBean("productController", ProductController.class);

        System.out.print("\\>");
        Scanner sc = new Scanner(System.in);
        String cmd;
        while(!((cmd = sc.nextLine()).equals("/quit"))){
            productController.doCommand(CommandFactory.create(cmd));
            System.out.print("\\>");
        }
        context.close();
    }
}
