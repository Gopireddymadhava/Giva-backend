package com.exception.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exception.dto.WishlistDto;
import com.exception.entities.Cart;
import com.exception.entities.Product;
import com.exception.entities.User1;
import com.exception.entities.WishList;
import com.exception.entities.WishListItem;

import com.exception.exceptions.User1NotFoundException;
import com.exception.exceptions.WishlistNotFoundException;
import com.exception.mapper.WishlistMapper;
import com.exception.repositories.User1Repo;
import com.exception.repositories.WishListRepo;

import jakarta.el.MethodNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class WishListService {
	
@Autowired
private WishListRepo wishrepo;
@Autowired
private WishlistMapper wishlistmapper;

@Autowired
private ProductService productService;

@Autowired
private User1Service userservice;

@Autowired
private User1Repo userrepo;

//Method used to get wishlist based on id
public WishlistDto getWishListById(Long id) {
	try {
    WishList wishlist=wishrepo.findById(id).orElseThrow(()-> new WishlistNotFoundException("wishlist not found"));
    return wishlistmapper.toWishListDto(wishlist);
	}catch (Exception e) {
       
        throw new WishlistNotFoundException("Error while getting wishlist by id");
    }
}

//Method used to add item to wishlist
public WishlistDto addItemToWishList(Long wishlistId, Long productId) {
    WishList wishlist = wishrepo.findById(wishlistId).orElseThrow(()-> new WishlistNotFoundException("wishlist not found") );
    Product product = productService.getProductById(productId);

    if (wishlist != null && product != null) {
        WishListItem wishItem = new WishListItem();
        wishItem.setProduct(product);
       
        wishItem.setWishlist(wishlist);

        wishlist.getWishlistItems().add(wishItem);
        wishrepo.save(wishlist);
    }

    return wishlistmapper.toWishListDto(wishlist);
}

//Method used to get wishlist by userid
public WishList getWishListByUser1Id(Long userId) throws User1NotFoundException {
    User1 user = (User1) userservice.getUser1(userId);

    if (user != null && ((User1) user).getWishList() != null) {
        return ((User1) user).getWishList();
    } else {
        return createWishlistForUser1(user);
    }
}


//Method used to create wishlist
public WishList createWishlistForUser1(User1 user) {
	try {
    WishList wishlist = new WishList();
    wishlist.setUser1(user);
    return wishrepo.save(wishlist);
	}catch (Exception e) {
       
        throw new WishlistNotFoundException("Error while creating wishlist");
    }
}

//Method used to create wishlist
public WishList createWishlistForUser1(Long userId) {
    // Retrieve the user by ID
    User1 user = userrepo.findById(userId)
                         .orElseThrow(() -> new User1NotFoundException("User not found with ID: " + userId));

    // Create a new cart for the user
    WishList wish = new WishList();
    wish.setUser1(user);

    // Save the cart
    return wishrepo.save(wish);
}


//Method used to get wishlist by user ID
public Long getWishlistIdByUserId(Long userId) {
    WishList wishlist = wishrepo.findByUser1Id(userId);
    if (wishlist != null) {
        return wishlist.getId();
    } else {
        return null; 
    }
}


}
