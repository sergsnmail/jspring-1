package com.sergsnmail.spring.context.service;

import com.sergsnmail.spring.context.controller.command.product.create.ProductCreateParam;
import com.sergsnmail.spring.context.controller.command.product.delete.ProductDeleteParam;
import com.sergsnmail.spring.context.controller.command.product.read.ProductReadParam;
import com.sergsnmail.spring.context.controller.command.product.update.ProductUpdateParam;
import com.sergsnmail.spring.context.model.Product;
import com.sergsnmail.spring.context.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@ComponentScan("com.sergsnmail.spring.context.repository")
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public void create(ProductCreateParam parameter) {
        Product newProduct = new Product(parameter.getId(), parameter.getTitle(), parameter.getCost());
        productRepository.create(newProduct);
    }

    public void read(ProductReadParam parameter) {
        Product product = productRepository.getProduct(parameter.getId());
        printHeader();
        System.out.printf("|%10d|%30s|%10.2f|\n", product.getId(), product.getTitle(), product.getCost());
    }

    public void update(ProductUpdateParam parameter) {
        Product product = productRepository.getProduct(parameter.getId());
        product.setTitle(parameter.getTitle());
        product.setCost(parameter.getCost());
        productRepository.update(product);
    }

    public void delete(ProductDeleteParam parameter) {
        productRepository.delete(parameter.getId());
    }

    public void printAvg() {
        List<Product> products = productRepository.getProducts();
        float totalCost = 0;
        for (Product product : products) {
            totalCost +=product.getCost();
        }
        System.out.printf("Avg product cost: %f\n", totalCost/products.size());
    }

    public void printAllProducts() {
        List<Product> products = productRepository.getProducts();
        printHeader();
        for (Product product : products) {
            System.out.printf("|%10d|%30s|%10.2f|\n", product.getId(), product.getTitle(), product.getCost());
        }
    }

    private void printHeader(){
        System.out.printf("|%10s|%30s|%10s|\n", "Id", "Title", "Cost");
        System.out.printf("%10s%30s%10s\n", "|----------", "|------------------------------", "|----------|");
    }
}
