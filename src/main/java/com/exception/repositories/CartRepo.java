package com.exception.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exception.entities.Cart;

@Repository
public interface CartRepo extends JpaRepository<Cart, Long> {

	Cart findByUserId(Long userId);

}
