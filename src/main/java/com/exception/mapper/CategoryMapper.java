package com.exception.mapper;

import org.springframework.stereotype.Component;

import com.exception.dto.CartDto;
import com.exception.dto.CategoryDto;
import com.exception.entities.Cart;
import com.exception.entities.Category;

@Component
public class CategoryMapper {

	public CategoryMapper() {
		// TODO Auto-generated constructor stub
	}
	
	public Category toCategoryEntity(CategoryDto dtos) {
		Category user=new Category();
		user.setId(dtos.getId());
		user.setName(dtos.getName());
		
		return user;
		
	}
	public CategoryDto toCategoryDto(Category users) {
		CategoryDto dto=new CategoryDto();
		dto.setId(users.getId());
		dto.setName(users.getName());
	
		return dto;
	}

}
