package de.ait.userapi.repository;

import de.ait.userapi.model.Product;

import java.util.List;

public interface ProductRepository {
    public List<Product> getAllProducts();
    public Product findById(Long id);
    public Product save(Product product);

}
