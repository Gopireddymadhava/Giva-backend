package com.exception.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName="build")
public class ProductDto {
	
	
	private Long id;
@NotBlank(message="please enter productname")
	
	@NotNull(message="productname should not be null ")
	private String name;

@NotNull(message="enter the value")
	private double price;

private String imageUrl;
private Long orderItemId;



	
}
