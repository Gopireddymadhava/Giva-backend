package com.exception.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.exception.dto.CartDto;
import com.exception.dto.LoginDto;
import com.exception.dto.User1Dto;
import com.exception.dto.WishlistDto;
import com.exception.entities.Cart;
import com.exception.entities.User1;
import com.exception.entities.WishList;
import com.exception.exceptions.CartNotFoundException;
import com.exception.exceptions.LoginResponse;
import com.exception.exceptions.User1NotFoundException;
import com.exception.exceptions.WishlistNotFoundException;
import com.exception.repositories.User1Repo;
import com.exception.repository.UserRepository;

@Service
public class User1Service {
	@Autowired
	private User1Repo user1repo;
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	@Autowired
	private CartService cartservice; 
	
	
	@Autowired
	private WishListService wishlist;
	
	//Method used for saving the user deatils
	public User1 saveUser(User1Dto dto) {
		try {
		User1 user=User1.build(0, dto.getName(), dto.getEmail(), dto.getPassword(), null, null, null, null);
		return user1repo.save(user);
		}catch(Exception e) {
		
	        throw new User1NotFoundException("Error while saving  user");
		}
		
	}
	

//Method used to get user by id	
	 public Optional<User1> getUserById(Long userId) {
		 
	       Optional<User1> user=  user1repo.findById(userId);
	       if(user!=null) {
	    	   return user;
	       }else {
	    	   throw new User1NotFoundException("user not found");
	    	   
	       }
	    }
	 
	 
	 //Method used for logging through user details
	public LoginResponse  loginEmployee(LoginDto loginDTO) {
        String msg = "";
        User1 employee1 = user1repo.findByEmail(loginDTO.getEmail());
        if (employee1 != null) {
            String password = loginDTO.getPassword();
            String encodedPassword = employee1.getPassword();
            Boolean isPwdRight = password.equals(encodedPassword) ;
            if (isPwdRight) {
                Optional<User1> employee = user1repo.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
                if (employee.isPresent()) {
                    return new LoginResponse("Login Success", true,employee1.getId());
                } else {
                    return new LoginResponse("Login Failed", false,null);
                }
            } else {
                return new LoginResponse("password Not Match", false,null);
            }
        }else {
            return new LoginResponse("Email not exits", false,null);
        }
    }

	
	
	
	//Method used to get  list of users
	public List<User1> getAllUser1(){
		List<User1> users=user1repo.findAll();
		if(users!=null) {
			return users;
		}else {
			throw new User1NotFoundException("user not found");
		}
	}
	
	
	//Method used to get user based on id
	public User1 getUser1(long id) throws User1NotFoundException{
		User1 user=user1repo.findById(id);
		if(user!=null) {
			return user;
		}else {
			throw new User1NotFoundException("user not found with id :"+id);
		}
	}
	
	
	//Method used to cart details through the user id
	public CartDto getUserAndCartInfo(Long userId) throws User1NotFoundException {
      

		
	    User1 user = user1repo.findById(userId)
	            .orElseThrow(() -> new User1NotFoundException("User not found with id: " + userId));

	    // Used method reference and Optional to handle the case when the cart is not found
	    CartDto cart = Optional.ofNullable(cartservice.getCartById(userId))
	            .orElseThrow(() -> new CartNotFoundException("Cart not found for user with id: " + userId));

	    // Used constructor reference to create the CartDto
	    CartDto userCartDto = new CartDto(user.getId(), cart.getId());

	    return userCartDto;
    }
	
	//Method used to get wishlist details through user id
public WishlistDto getUserAndWishlistInfo(Long userId) throws User1NotFoundException {
      

		
	    User1 user = user1repo.findById(userId)
	            .orElseThrow(() -> new User1NotFoundException("User not found with id: " + userId));

	    // Used method reference and Optional to handle the case when the cart is not found
	    WishlistDto cart = Optional.ofNullable(wishlist.getWishListById(userId))
	            .orElseThrow(() -> new WishlistNotFoundException("Wishlist not found for user with id: " + userId));

	    // Used constructor reference to create the CartDto
	    WishlistDto userCartDto = new WishlistDto(user.getId(), cart.getId());

	    return userCartDto;
    }


//Method used to update the user details 
public User1 updatepassword(String email,String password) {
	
	
	User1 user=user1repo.findByEmail(email);
	
	user.setPassword(password);
	
	user1repo.save(user);
	return user;

}



}
