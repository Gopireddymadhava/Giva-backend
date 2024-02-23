package com.exception.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemDto {
	private Long id;
	private Long orderId;
    private Long productId;
    private Integer quantity;
   
    private String name;
    private String imageUrl;
    
    private Long paymentId;
    private BigDecimal paymentAmount;
    private String paymentStatus;
   private double productprice;
    
	public void setProduct(ProductDto productDTO) {
		// TODO Auto-generated method stub
		
	}


	public BigDecimal gettotalPrice() {
		// TODO Auto-generated method stub
		return paymentAmount;
	}


	


	


}
