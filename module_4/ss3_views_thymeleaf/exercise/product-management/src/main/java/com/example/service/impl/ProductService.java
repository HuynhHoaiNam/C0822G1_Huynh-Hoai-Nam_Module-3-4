package com.example.service.impl;

import com.example.model.Product;
import com.example.service.IProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements IProductService {

    private static List<Product> productList = new ArrayList<>();
    static {
        productList.add(new Product(1, "Car", 2.22, "Mới", "Honda"));
        productList.add(new Product(2, "Motor", 35.2, "Suýt Mới", "Yamaha"));
        productList.add(new Product(3, "Plane", 213, "Cũ", "Lamborghini"));
        productList.add(new Product(4, "Dream", 12, "Mới Cứng", "longgin"));
        productList.add(new Product(5, "Dream", 455, "Bình thường", "longgin"));
    }



    @Override
    public List<Product> productList() {
        return productList;
    }

    @Override
    public boolean delete(int id) {
        productList.remove(id);
        return true;
    }

    @Override
    public void update(Product product) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == product.getId()) {
                productList.set(i, product);
            }
        }
    }

    @Override
    public Product findById(int id) {
        for (Product p : productList) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    @Override
    public void create(Product product) {
        productList.add(product);
    }

    @Override
    public List<Product> findByName(String name) {
                List<Product> productH = new ArrayList<>();
        for (Product p : productList) {
            if (p.getName().contains(name)) {
                productH.add(p);
            }
        }
        return productH;
    }




}
