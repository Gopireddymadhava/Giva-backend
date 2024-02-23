package com.exception.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.exception.entities.OrderItem;
@Repository
public interface OrderItemRepo extends JpaRepository<OrderItem, Long>{
//	List<OrderItem> findByOrder_User1_Id(Long userId);

//	List<OrderItem> findByOrder_User1_Id(Long userId);

//	List<OrderItem> findByUser1Id(Long userId);
	@Query(value="select * from order_item where order_id=?",nativeQuery=true)
	public List<OrderItem> getOrderItemd(@PathVariable Long order_id);

}
