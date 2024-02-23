package com.exception.mapper;

import org.springframework.stereotype.Component;

import com.exception.dto.ProductDto;
import com.exception.entities.Product;

@Component
public class ProductMapper {
	
	public Product toProductEntity(ProductDto dto) {
		Product product=new Product();
		product.setName(dto.getName());
		product.setPrice(dto.getPrice());
		
		return product;
		
	}
	
	public ProductDto toProductDto(Product dto) {
		ProductDto product=new ProductDto();
		product.setName(dto.getName());
		product.setPrice(dto.getPrice());
		
		return product;
		
	}

}
