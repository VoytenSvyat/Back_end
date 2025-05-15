package de.ait.userapi.repository;

import de.ait.userapi.model.Product;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

public class ProductDB implements ProductRepository{
    private Long lastId = 5L;
    private static HashMap<Long, Product> map = new HashMap<>();
    static {
        map.put(1L, new Product(1L, "Orange", new BigDecimal(4.5)));
        map.put(2L, new Product(2L, "Apple",new BigDecimal(3.5)));
        map.put(3L, new Product(3L, "Pear", new BigDecimal(2.5)));
        map.put(4L, new Product(4L, "Banana", new BigDecimal(5.5)));
        map.put(5L, new Product(5L, "Strawberry", new BigDecimal(6.5)));
    }
    public  List<Product> getAllProducts(){
        return map.values().stream().toList();
    }
    public Product findById(Long id){
        return map.get(id);
    }
    public Product save(Product product){
        product.setId(++lastId);
        map.put(product.getId(),product);
        return product;
    }
}
