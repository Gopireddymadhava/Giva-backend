package com.exception.dto;

import com.exception.entities.CartItem;
import com.exception.entities.Product;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItemDto {
	

	@NotNull(message="enter the value")
	private int quantity;
}
