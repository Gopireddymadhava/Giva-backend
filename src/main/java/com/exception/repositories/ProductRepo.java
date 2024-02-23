package com.exception.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exception.entities.Product;
@Repository
public interface ProductRepo extends JpaRepository<Product, Long>{
//List<Product> findAll();
Product findById(long id);
//List<Product> getProducts();

Optional<Product> findByName(String name);
List<Product> findByNameContainingIgnoreCase(String name);

Product getProductById(Long id);
}
