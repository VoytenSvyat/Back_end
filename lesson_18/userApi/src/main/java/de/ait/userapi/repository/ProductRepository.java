package de.ait.userapi.repository;

import de.ait.userapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findAll();
    Optional<Product> findById(Long id);
    Product save(Product product);
    // ключевое слово + By + имя поля
    List<Product> findByTitleStartingWithOrderById(String titlePrefix);
    Long countAllByTitle(String title);
    void deleteByTitle(String title);
}
