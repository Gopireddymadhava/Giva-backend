package com.exception.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exception.entities.StoreItems;
@Repository
public interface StoreItemsRepo extends JpaRepository<StoreItems, Long>{
	List<StoreItems> findByStoreId(Long storeId);

	List<StoreItems> findByPincode(String pincode);
}
