package com.exception.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDto {
	

	private long id;
	public CartDto(long id2, long id3) {
		this.id=id2;
		this.id=id3;
		
	}
	
}
