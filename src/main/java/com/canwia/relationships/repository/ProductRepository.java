package com.canwia.relationships.repository;

import com.canwia.relationships.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    @Query(value = "SELECT * FROM products where account_id='1'",nativeQuery = true)
    Optional<List<Product>> findAllProductByAccountId(Long id);
}
