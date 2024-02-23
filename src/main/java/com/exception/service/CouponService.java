package com.exception.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exception.dto.CouponsDto;
import com.exception.entities.Coupons;
import com.exception.exceptions.CouponNotFoundException;
import com.exception.exceptions.NotFoundException;
import com.exception.mapper.Couponsmapper;
import com.exception.repositories.CouponsRepo;

@Service
public class CouponService {
	@Autowired
	private CouponsRepo couponsrepo;
	@Autowired
	private Couponsmapper couponsmapper;
	
	//Method used to create coupon
	public CouponsDto createCoupon(Coupons coupon) {
		try {
		return couponsmapper.toCouponsDto(couponsrepo.save(coupon));
		}catch(Exception e) {
			
	        throw new CouponNotFoundException("Error while creating coupon");
		}
	}
	
	//Method used for applying coupon
	public CouponsDto applyCoupon(String code) {
		try {
		Coupons coupons=couponsrepo.findByCode(code)
				.filter(coupon->isCouponValid(coupon))
				.orElseThrow(()->new CouponNotFoundException(code));
		return couponsmapper.toCouponsDto(coupons);
		}
		catch(Exception e) {
			
	        throw new CouponNotFoundException("Error while applying coupon");
		}
	}
	
	//Method used to check whether selected coupon is valid or not
	private boolean isCouponValid(Coupons code) {
		try {
		Boolean answer= !code.getExpirationdate().isBefore(LocalDate.now());
				return answer;
		}
		catch(Exception e) {
			
	        throw new CouponNotFoundException("Error while checking  coupon is valid or not");
		}
	}
	

}
