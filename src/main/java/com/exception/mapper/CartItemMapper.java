package com.exception.mapper;

import org.springframework.stereotype.Component;

import com.exception.dto.CartDto;
import com.exception.dto.CartItemDto;
import com.exception.entities.Cart;
import com.exception.entities.CartItem;
@Component
public class CartItemMapper {

	
	
	public CartItem toCartItemEntity(CartItemDto dtos) {
		CartItem user=new CartItem();
		
		user.setQuantity(dtos.getQuantity());
		
		return user;
		
	}
	public CartItemDto toCartItemDto(CartItem users) {
		CartItemDto dto=new CartItemDto();
		
		dto.setQuantity(users.getQuantity());
	
		return dto;
	}

}
