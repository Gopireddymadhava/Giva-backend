package com.exception.service;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exception.dto.CartDto;
import com.exception.entities.Cart;
import com.exception.entities.CartItem;
import com.exception.entities.Product;
import com.exception.entities.User1;
import com.exception.exceptions.CartNotFoundException;
import com.exception.exceptions.NotFoundException;
import com.exception.exceptions.User1NotFoundException;
import com.exception.mapper.CartMapper;
import com.exception.repositories.CartRepo;
import com.exception.repositories.User1Repo;

@Service
public class CartService {
	
	@Autowired
	private User1Repo userrepo;
	
	@Autowired
    private CartRepo cartRepository;

    @Autowired
    private ProductService productService;

    @Autowired
    private CartMapper cartmapper;
    
    @Autowired
    private User1Service userservice;
    
    //Method used to get cart by Entering Id
    public CartDto getCartById(Long id) {
       
            Cart cart = cartRepository.findById(id).orElseThrow(()-> new CartNotFoundException("Cart Not Found"));
    if(cart!=null) {
            return cartmapper.toCartDto(cart);
    } else{
            throw new CartNotFoundException("Error while getting cart by ID");
        }
    }
    
//Method used to add an item to cart
    public CartDto addItemToCart(Long cartId, Long productId, int quantity) {
        Cart cart = cartRepository.findById(cartId).orElseThrow(()-> new CartNotFoundException("Cart Not Found"));
        Product product = productService.getProductById(productId);

        if (cart != null && product != null) {
            CartItem cartItem = new CartItem();
            cartItem.setProduct(product);
            cartItem.setQuantity(quantity);
            cartItem.setCart(cart);

            cart.getCartitems().add(cartItem);
            cartRepository.save(cart);
        }

        return cartmapper.toCartDto(cart);
    }
    
    //Method used to get cart by userId
    public Cart getCartByUser1Id(Long userId) throws User1NotFoundException {
        User1 user =  userservice.getUser1(userId);

        if (user != null &&  user.getCart() != null) {
            return  user.getCart();
        } else {
            return createCartForUser1(user);
        }
    }
    
//Method used to create cart for user
    public Cart createCartForUser1(User1 user) {
        try {
            Cart cart = new Cart();
            cart.setUser1(user);
            return cartRepository.save(cart);
        } catch (Exception e) {
           
            throw new CartNotFoundException("Error while creating cart for user");
        }
    }

    
    //create cart for user through user id
    public Cart createCartForUser1(Long userId) {
        // Retrieve the user by ID
        User1 user = userrepo.findById(userId)
                             .orElseThrow(() -> new User1NotFoundException("User not found with ID: " + userId));

        // Create a new cart for the user
        Cart cart = new Cart();
        cart.setUser1(user);

        // Save the cart
        return cartRepository.save(cart);
    }
    
    
    // Assuming you have a CartRepository to interact with the database

    //get cart by user ID
    public Long getCartIdByUserId(Long userId) {
        Cart cart = cartRepository.findByUserId(userId);
        if (cart != null) {
            return cart.getId();
        } else {
            return null; 
        }
    }

}
