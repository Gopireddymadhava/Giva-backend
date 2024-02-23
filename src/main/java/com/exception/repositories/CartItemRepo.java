package com.exception.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.exception.entities.Cart;
import com.exception.entities.CartItem;
@Repository
public interface CartItemRepo extends JpaRepository<CartItem, Long>{
List<CartItem> findAll();

@Modifying
@Query("DELETE FROM CartItem c WHERE c.product.id = :productId")
void deleteByProductId(@Param("productId") Long productId);


List<CartItem> findByCart(Cart cart);
}
