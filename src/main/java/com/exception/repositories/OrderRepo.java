package com.exception.repositories;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.exception.dto.OrderDto;
import com.exception.entities.Order;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long>{

//	List<Checkout> findByUser1Id(Long userId);

//	 List<Checkout> findByUser1Id(Long userId);
	@Query(value="select * from [customer_order] where user_id=?",nativeQuery=true)
	public List<Order> getOrder(@PathVariable Long user_id);
	
	
}
