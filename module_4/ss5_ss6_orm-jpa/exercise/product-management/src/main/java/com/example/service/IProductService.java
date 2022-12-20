package com.example.service;

import com.example.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> productList();

    boolean delete(int id);

    void update(Product product);

    Product findById(int id);

    void create(Product product);

    List<Product> findByName(String name);
}
