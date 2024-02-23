package com.exception.mapper;

import org.springframework.stereotype.Component;

import com.exception.dto.CartDto;
import com.exception.dto.WishlistDto;
import com.exception.entities.Cart;
import com.exception.entities.WishList;
@Component
public class WishlistMapper {
	public WishList toWishlistEntity(WishlistDto dtos) {
		WishList user=new WishList();
		user.setId(dtos.getId());
		
		return user;
		
	}
	public WishlistDto toWishListDto(WishList users) {
		WishlistDto dto=new WishlistDto();
		dto.setId(users.getId());
	
		return dto;
	}

}
