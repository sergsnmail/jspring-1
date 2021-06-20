package com.sergsnmail.spring.context;

import com.sergsnmail.spring.context.controller.ProductController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.sergsnmail.spring.context.controller")
public class AppConfig {
    @Autowired
    private ProductController productController;
}
