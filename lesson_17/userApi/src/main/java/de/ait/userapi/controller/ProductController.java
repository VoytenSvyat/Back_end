package de.ait.userapi.controller;


import de.ait.userapi.model.Product;
import de.ait.userapi.repository.ProductDB;
import de.ait.userapi.repository.ProductRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    ProductRepository repository = new ProductDB();

    @GetMapping("/products")
    public List<Product> getProducts(){
       return repository.getAllProducts();
    }
    @GetMapping("/products/{id}")
    public Product getById(@PathVariable(name = "id") Long id){
        return repository.findById(id);
    }
    public Product addProduct(@RequestBody Product product){
        return repository.save(product);
    }
}
