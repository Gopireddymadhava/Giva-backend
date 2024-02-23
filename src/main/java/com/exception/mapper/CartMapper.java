package com.exception.mapper;

import org.springframework.stereotype.Component;

import com.exception.dto.CartDto;
import com.exception.dto.User1Dto;
import com.exception.entities.Cart;
import com.exception.entities.User1;

@Component
public class CartMapper {
	
	public Cart toCartEntity(CartDto dtos) {
		Cart user=new Cart();
		user.setId(dtos.getId());
		
		return user;
		
	}
	public CartDto toCartDto(Cart users) {
		CartDto dto=new CartDto();
		dto.setId(users.getId());
	
		return dto;
	}

}
