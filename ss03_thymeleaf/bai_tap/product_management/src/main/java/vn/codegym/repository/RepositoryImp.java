package vn.codegym.repository;

import org.springframework.stereotype.Repository;
import vn.codegym.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class RepositoryImp implements IRepository{
    private static final Map<Integer, Product> products;

    static {

        products = new HashMap<>();
        products.put(1, new Product(1, "iPhone 13", "799", "phone","Apple"));
        products.put(2, new Product(2, "iPhone 13 mini", "699", "phone","Apple"));
        products.put(3, new Product(3, "iPhone 13 pro", "899", "phone","Apple"));
        products.put(4, new Product(4, "iPhone 13 pro max", "999", "phone","Apple"));
        products.put(5, new Product(5, "iPad M1", "1099", "tablet","Apple"));
        products.put(6, new Product(6, "Air Pod",  "299", "headphone","Apple"));

    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);

    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }
}
