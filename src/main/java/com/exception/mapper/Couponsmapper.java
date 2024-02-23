package com.exception.mapper;

import org.springframework.stereotype.Component;

import com.exception.dto.CouponsDto;
import com.exception.dto.User1Dto;
import com.exception.entities.Coupons;
import com.exception.entities.User1;

@Component
public class Couponsmapper {
	public Coupons toCouponsEntity(CouponsDto dtos) {
		Coupons user=new Coupons();
		user.setCode(dtos.getCode());
		user.setDiscount(dtos.getDiscount());
		user.setExpirationdate(dtos.getExpirationdate());
		return user;
		
	}
	public CouponsDto toCouponsDto(Coupons users) {
		CouponsDto dto=new CouponsDto();
		dto.setCode(users.getCode());
		dto.setDiscount(users.getDiscount());
		dto.setExpirationdate(users.getExpirationdate());
		return dto;
	}

}
