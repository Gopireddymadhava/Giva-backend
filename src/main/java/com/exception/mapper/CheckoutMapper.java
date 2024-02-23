package com.exception.mapper;

import org.springframework.stereotype.Component;

import com.exception.dto.CartDto;
import com.exception.dto.OrderDto;
import com.exception.entities.Cart;
import com.exception.entities.Order;

@Component
public class CheckoutMapper {

	public Order toCheckoutEntity(OrderDto dtos) {
		Order user=new Order();
		user.setId(dtos.getId());
		
		return user;
		
	}
	public OrderDto toChecoutDto(Order users) {
		OrderDto dto=new OrderDto();
		dto.setId(users.getId());
	
		return dto;
	}

}
