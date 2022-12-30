package com.codegym.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private int id;

    Map<Product, Integer> productMap = new HashMap<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Map<Product, Integer> getProductMap() {
        return productMap;
    }

    public void setProductMap(Map<Product, Integer> productMap) {
        this.productMap = productMap;
    }

    public void addProduct(Product product) {
        if (productMap.containsKey(product)) {
            int value = productMap.get(product);
            productMap.put(product, value + 1);
        } else {
            productMap.put(product, 1);
        }
    }
}
