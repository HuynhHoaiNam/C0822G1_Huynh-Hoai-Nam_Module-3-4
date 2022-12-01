package repository;

import model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> selectAll();

    void create(Product product);

    boolean update(Product product);

    Product findByName(String name);

    Product findById(int id);

    void remove(int id);
}
