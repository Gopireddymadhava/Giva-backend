package com.exception.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exception.dto.CartDto;
import com.exception.entities.Cart;
import com.exception.entities.CartItem;
import com.exception.entities.User1;
import com.exception.exceptions.User1NotFoundException;
import com.exception.service.CartItemService;
import com.exception.service.CartService;
import com.exception.service.User1Service;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/carts")
public class CartController {

	@Autowired
	private CartService cartService;

	@Autowired
	private User1Service userservice;

	@Autowired
	private CartItemService cartservice;

	// Get all cart items
	@GetMapping("all")
	public ResponseEntity<List<CartItem>> getCartItems(){
	    // Retrieve all cart items from the service
	    List<CartItem> cartItems = cartservice.getAllCartItems();
	    return ResponseEntity.ok(cartItems);
	}

	// Remove item from cart by product ID
	@DeleteMapping("/remove/{productId}")
	public ResponseEntity<String> removeFromCart(@PathVariable Long productId) {
	    // Remove the specified item from the cart
	    cartservice.removeFromCartByProductId(productId);
	    return ResponseEntity.ok("Item removed from the cart");
	}

	// Get cart details by cart ID
	@GetMapping("/getcart/{cartId}")
	public CartDto getCart(@PathVariable Long cartId) {
	    // Retrieve cart details by cart ID
	    return cartService.getCartById(cartId);
	}

	// Add item to cart
	@PostMapping("/{cartId}/add-to-cart/{productId}/{quantity}")
	public CartDto addItemToCart(@PathVariable Long cartId, @PathVariable Long productId, @PathVariable int quantity) {
	    // Add the specified quantity of the product to the cart
	    return cartService.addItemToCart(cartId, productId, quantity);
	}



	// Get user's cart details by user ID
	 @GetMapping("/getcartbyuser/{userId}")
	    public ResponseEntity<Long> getCartIdByUserId(@PathVariable Long userId) {
	        Long cartId = cartService.getCartIdByUserId(userId);
	        if (cartId != null) {
	            return ResponseEntity.ok(cartId);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	
	 //Add cart for user
	 @PostMapping("/createcart/{userId}")
	    public ResponseEntity<CartDto> createCartForUser(@PathVariable Long userId) {
	        try {
	            Cart createdCart = cartService.createCartForUser1(userId);
	            CartDto cartDto = cartService.getCartById(createdCart.getId());
	            return new ResponseEntity<>(cartDto, HttpStatus.CREATED);
	        } catch (Exception e) {
	            // Handle exceptions here
	            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
	
	
}
