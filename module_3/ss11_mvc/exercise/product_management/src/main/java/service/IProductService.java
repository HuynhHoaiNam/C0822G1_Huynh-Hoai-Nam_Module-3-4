package service;

import model.Product;

import java.util.List;

public interface IProductService {
    List<Product> selectAll();

    void create(Product product);

    boolean update(Product product);

    Product findByName(String name);

    Product findById(int id);

    void remove(int id);
}
