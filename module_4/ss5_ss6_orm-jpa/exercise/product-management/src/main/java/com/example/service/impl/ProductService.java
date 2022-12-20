package com.example.service.impl;

import com.example.model.Product;
import com.example.repository.IProductRepository;
import com.example.service.IProductService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;


    @Override
    public List<Product> productList() {
        return productRepository.productList();
    }

    @Override
    public boolean delete(int id) {
        return productRepository.delete(id);
    }

    @Override
    public void update(Product product) {
        productRepository.update(product);
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public void create(Product product) {
        productRepository.update(product);
    }

    @Override
    public List<Product> findByName(String name) {
        return null;
    }

}
