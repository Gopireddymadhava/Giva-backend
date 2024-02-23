package com.exception.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exception.entities.Address;
import com.exception.entities.User1;
@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{
	List<Address> findByUser1Id(Long userId);
	List<Address> findByUser1(User1 user1);
}
