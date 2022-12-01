package repository.impl;

import model.Product;
import repository.IProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {
    private static List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1, "Car", 215, "Mới", "Kia"));
        productList.add(new Product(2, "Moto", 120, "Trung Bình", "Yamaha"));
        productList.add(new Product(3, "Plan", 365, "Mới Cứng", "Lamboghini"));
    }

    @Override
    public List<Product> selectAll() {
        return productList;
    }

    @Override
    public void create(Product product) {
        productList.add(product);
    }

    @Override
    public boolean update(Product product) {
        return false;
    }

    @Override
    public Product findByName(String name) {
        for (Product product : productList) {
            if (name .equals(product.getName())) {
                return product;
            }
        }
        return null;
    }


    @Override
    public Product findById(int id) {
        Product product = null;
        for (Product p : productList) {
            if (id == p.getId()) {
                product = productList.get(id);
                break;
            }
        }
        return product;
    }

    @Override
    public void remove(int id) {
        productList.remove(id);
    }
}
