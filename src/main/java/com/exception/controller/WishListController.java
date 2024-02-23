package com.exception.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RestController;

import com.exception.dto.CartDto;
import com.exception.dto.WishlistDto;
import com.exception.entities.Cart;
import com.exception.entities.WishList;
import com.exception.exceptions.User1NotFoundException;

import com.exception.service.User1Service;
import com.exception.service.WishListItemService;
import com.exception.service.WishListService;

@RestController
@CrossOrigin(origins="*")
public class WishListController {
	@Autowired
	private  WishListItemService wishlistService;


	@Autowired
	private WishListService wishlistservice;
	
	@Autowired
	private User1Service userservice;

	
	// Remove a product from the wishlist by product ID
	@DeleteMapping("/wish/remove/{productId}")
	public ResponseEntity<String> removeFromWishList(@PathVariable Long productId) {
	    // Remove the specified item from the wishlist
	    wishlistService.removeFromWishListByProductId(productId);
	    return ResponseEntity.ok("Item removed from the wishlist");
	}

	// Get wishlist details by wishlist ID
	@GetMapping("/wishlist/{wishlistId}")
	public WishlistDto getWishList(@PathVariable Long wishlistId) {
	    // Retrieve and return wishlist details by wishlist ID
	    return wishlistservice.getWishListById(wishlistId);
	}

	// Add item to wishlist
	@PostMapping("/{wishlistId}/add-to-wishlist/{productId}")
	public WishlistDto addItemToCart(@PathVariable Long wishlistId, @PathVariable Long productId) {
	    // Add the specified product to the wishlist
	    return wishlistservice.addItemToWishList(wishlistId, productId);
	}

	// Get wishlist details by user ID
	@GetMapping("/user/{userId}")
	public ResponseEntity<WishlistDto> getWishListByUserId(@PathVariable Long userId) throws User1NotFoundException {
	    // Retrieve user and wishlist information based on userId
	    WishlistDto userWishList = userservice.getUserAndWishlistInfo(userId);
	    return ResponseEntity.ok(userWishList);
	}

	//Method for creating wishlist for particular user 
	 @PostMapping("/createwish/{userId}")
	    public ResponseEntity<WishlistDto> createWishlistForUser(@PathVariable Long userId) {
	        try {
	            WishList createdwish = wishlistservice.createWishlistForUser1(userId);
	            WishlistDto cartDto = wishlistservice.getWishListById(createdwish.getId());
	            return new ResponseEntity<>(cartDto, HttpStatus.CREATED);
	        } catch (Exception e) {
	            // Handle exceptions here
	            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
	 
	 //Method used to get wishlist by userid
	 @GetMapping("/getwishlistbyuser/{userId}")
	    public ResponseEntity<Long> getWishlistIdByUserId(@PathVariable Long userId) {
	        Long wishlistId = wishlistservice.getWishlistIdByUserId(userId);
	        if (wishlistId != null) {
	            return ResponseEntity.ok(wishlistId);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	}


