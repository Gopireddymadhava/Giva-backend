package com.exception.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.exception.entities.Product;
import com.exception.entities.WishList;
@Repository
public interface WishListRepo extends JpaRepository<WishList, Long> {

	void save(Product pro);

	WishList findByUser1Id(Long userId);

//	void save(Optional<Product> pro);

//	void save(Product pro);


}
