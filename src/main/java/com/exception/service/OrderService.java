package com.exception.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.exception.advice.UserNotFoundException;
import com.exception.dto.OrderDto;
import com.exception.entities.Address;
import com.exception.entities.Cart;
import com.exception.entities.CartItem;
import com.exception.entities.Order;
import com.exception.entities.Payment;
import com.exception.entities.User1;
import com.exception.exceptions.AddressNotFoundException;
import com.exception.exceptions.CartNotFoundException;
import com.exception.exceptions.NotFoundException;
import com.exception.exceptions.OrderNotFoundException;
import com.exception.exceptions.PaymentNotFoundException;
import com.exception.exceptions.User1NotFoundException;
import com.exception.mapper.CheckoutMapper;
import com.exception.repositories.AddressRepository;
import com.exception.repositories.CartItemRepo;
import com.exception.repositories.CartRepo;
import com.exception.repositories.OrderRepo;
import com.exception.repositories.PaymentRepo;
import com.exception.repositories.User1Repo;

import jakarta.transaction.Transactional;

@Service
public class OrderService {
	
	@Autowired
    private OrderRepo orderRepository;
	
	@Autowired
    private User1Repo userRepository;
	@Autowired
    private AddressRepository addressRepository;
	
	@Autowired
    private CartRepo cartRepository;
	@Autowired
    private CartItemRepo cartitemRepository;
	@Autowired
    private PaymentRepo paymentRepository;

	
	@Autowired
	private CheckoutMapper checkoutmapper;
	
	//Method used to get List of orders 
    public List<Order> getAllCheckouts() {
    	try {
        return orderRepository.findAll();
    	}
    		catch(Exception e) {
    			
    	        throw new OrderNotFoundException("Error while getting orders");
    		}
    	
    }


    
    //Method used to create order by passing arguments
    public OrderDto createOrder(User1 user, List<CartItem> orderItems, Address address) {
       
        Order order = new Order();
        order.setUser1(user);
        
        order.setAddress(address);
        order = orderRepository.save(order);

        return checkoutmapper.toChecoutDto(order);
    }


		
	
//Method used to get order Based on the orderId
	public OrderDto getOrderById(Order orderId) {
		try {
		
		return checkoutmapper.toChecoutDto(orderRepository.save(orderId));
		}catch(Exception e) {
		
	        throw new OrderNotFoundException("Error while getting order by id");
		}
	}

	//Method used to update the order
	public OrderDto updateOrder(Order order) {
		try {
        return checkoutmapper.toChecoutDto(orderRepository.save(order));
		}catch(Exception e) {
		
	        throw new OrderNotFoundException("Error while updating the order");
		}
    }

    
	
	
	 

	   
//Method used for placing order using userid,addressid,cartid,paymentid and total amount
	public Long placeOrder(Long userId, Long addressId, Long shoppingCartId,double totalAmount,Long payment_id) {
	    User1 user = userRepository.findById(userId)
	            .orElseThrow(() -> new User1NotFoundException("User not found"));

	    Address address = addressRepository.findById(addressId)
	            .orElseThrow(() -> new AddressNotFoundException("Address not found"));

	    Cart shoppingCart = cartRepository.findById(shoppingCartId)
	            .orElseThrow(() -> new CartNotFoundException("ShoppingCart not found"));
	    
	    Payment payment=paymentRepository.findById(payment_id).orElseThrow(()->new PaymentNotFoundException("payment not found"));

	    List<CartItem> cartItems = cartitemRepository.findByCart(shoppingCart);


	    Order order = new Order();
	    order.setUser1(user);
	    order.setAddress(address);
	    order.setCart(shoppingCart);
	    order.setTotalAmount(totalAmount);
        order.setPayment(payment);
	    orderRepository.save(order);

	    shoppingCart.setCartitems(new ArrayList<>());
	    cartRepository.save(shoppingCart);

	    return order.getId();
	}
	
	
	//Method used to get a list of payments
	public List<Payment> getpayments(){
		try {
		return paymentRepository.findAll();
		}catch(Exception e) {
		
	        throw new OrderNotFoundException("Error while getting all payments ");
		}
	}

	//Method used to get payment based on id
	public Optional<Payment> getpaymentsById(Long id){
		try {
		return paymentRepository.findById(id);
		}catch(Exception e) {
		
	        throw new OrderNotFoundException("Error while getting the  payments");
		}
	}


//Method used to get the order details through the order ID
	public Order findOrderById(Long orderId) {
		// TODO Auto-generated method stub
		return orderRepository.findById(orderId).orElseThrow(()-> new OrderNotFoundException("order not found"));
	}


    
}



