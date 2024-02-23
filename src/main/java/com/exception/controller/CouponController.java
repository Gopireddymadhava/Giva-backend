package com.exception.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exception.dto.CouponsDto;
import com.exception.entities.Coupons;
import com.exception.service.CouponService;

@RestController
@CrossOrigin(origins="*")
public class CouponController {
	@Autowired
	private CouponService couponservice;
	
	
	// Create a new coupon
	@PostMapping("/createcoupon")
	public CouponsDto createcoupon(@RequestBody Coupons coupon) {
	    // Call couponservice to create and return the created coupon
	    return couponservice.createCoupon(coupon);
	}

	// Apply a coupon by code
	@PostMapping("/applycoupon/{code}")
	public CouponsDto applycoupon(@PathVariable String code) {
	    // Call couponservice to apply the coupon by code and return the result
	    return couponservice.applyCoupon(code);
	}

}
