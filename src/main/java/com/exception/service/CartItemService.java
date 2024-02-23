package com.exception.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exception.entities.CartItem;
import com.exception.entities.Product;
import com.exception.exceptions.CartItemNotFoundException;
import com.exception.exceptions.CartNotFoundException;
import com.exception.exceptions.NotFoundException;
import com.exception.repositories.CartItemRepo;
import com.exception.repositories.ProductRepo;

import jakarta.transaction.Transactional;

import com.exception.repositories.ProductRepo;

@Service
public class CartItemService {
	@Autowired
	private CartItemRepo cartItemRepository;

	//Method used to remove product from cart
	@Transactional
	public void removeFromCartByProductId(Long productId) {
	    try {
	        cartItemRepository.deleteByProductId(productId);
	    } catch (Exception e) {
	      
	        throw new CartItemNotFoundException("Error while removing item from cart by productId");
	    }
	}
	
//Method used to get list of cartitems
	public List<CartItem> getAllCartItems() {
	    try {
	        return cartItemRepository.findAll();
	    } catch (Exception e) {
	        
	        throw new CartItemNotFoundException("Error while retrieving all cart items");
	    }
	}
	

	//Method used to create cartitem
	public CartItem createCartItem(CartItem cartItem) {
	    try {
	        return cartItemRepository.save(cartItem);
	    } catch (Exception e) {
	      
	        throw new CartItemNotFoundException("Error while creating cart item");
	    }
	}
	
	
//Method used to get list of cartItems based on cartId
	public List<CartItem> getCartItems(Long cartId) {
	    try {
	        return cartItemRepository.findAll();
	    } catch (Exception e) {
	      
	        throw new CartItemNotFoundException("Error while retrieving cart items by cartId");
	    }
	}
}
