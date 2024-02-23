package com.exception.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exception.entities.CartItem;
import com.exception.entities.WishList;
import com.exception.entities.WishListItem;
import com.exception.exceptions.WishlistItemNotFoundException;
import com.exception.repositories.WishListItemRepo;

import jakarta.transaction.Transactional;

@Service
public class WishListItemService {
@Autowired
	private WishListItemRepo wishrepo;


//Method used  for deleting the product 
@Transactional
    public void removeFromWishListByProductId(Long productId) {
    	try {
        wishrepo.deleteByProductId(productId);
    	}catch (Exception e) {
        
            throw new WishlistItemNotFoundException("Error while removing the product");
        }
    }
	
	//Method used for getting List of cartItems
	public List<WishListItem> getAllWishlistItems() {
		try {
		return wishrepo.findAll();
		}catch (Exception e) {
         
            throw new WishlistItemNotFoundException("Error while getting all wishlist items ");
        }
		
	}

	
	
}
