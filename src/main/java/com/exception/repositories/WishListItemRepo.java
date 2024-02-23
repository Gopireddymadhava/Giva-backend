package com.exception.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.exception.entities.WishListItem;

@Repository
public interface WishListItemRepo extends JpaRepository<WishListItem, Long> {
	
	@Modifying
	@Query("DELETE FROM WishListItem c WHERE c.product.id = :productId")
	void deleteByProductId(@Param("productId") Long productId);
	

}
