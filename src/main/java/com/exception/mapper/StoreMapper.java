package com.exception.mapper;

import org.springframework.stereotype.Component;

import com.exception.dto.CartDto;
import com.exception.dto.StoreDto;
import com.exception.entities.Cart;
import com.exception.entities.Store;

@Component
public class StoreMapper {

	public StoreMapper() {
		// TODO Auto-generated constructor stub
	}
	
	public Store toStoreEntity(StoreDto dtos) {
		Store user=new Store();
		user.setId(dtos.getId());
		user.setName(dtos.getName());
		
		return user;
		
	}
	public StoreDto toStoreDto(Store users) {
		StoreDto dto=new StoreDto();
		dto.setId(users.getId());
	dto.setName(users.getName());
		return dto;
	}

}
