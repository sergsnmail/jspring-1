package com.sergsnmail.spring.context.repository;

import com.sergsnmail.spring.context.model.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> getProducts();
    Product getProduct(long id);
    void create (Product product);
    void update (Product product);
    void delete(long id);
}
