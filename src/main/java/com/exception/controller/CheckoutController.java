package com.exception.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


//import com.exception.dto.CheckoutRequest;
import com.exception.dto.OrderItemDto;

import com.exception.entities.Payment;
import com.exception.service.EmailService;
import com.exception.service.OrderItemService;
import com.exception.service.OrderService;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;


@RestController
@CrossOrigin(origins = "*")
public class CheckoutController {

	@Autowired
	private OrderService checkoutService;

@Autowired
	    private JavaMailSender javaMailSender;

@Autowired
private EmailService emailService;
	
	
	@Autowired
	private OrderItemService orderItemService;

	

	
	@Autowired
	private OrderService orderService;

	// Place an order with the specified details
	@PostMapping("/placeOrder/{userId}/{addressId}/{shoppingCartId}/{totalAmount}/{payment_id}")
	public ResponseEntity<Long> placeOrder(@PathVariable Long userId, @PathVariable Long addressId,
			@PathVariable Long shoppingCartId, @PathVariable Double totalAmount, @PathVariable Long payment_id,
			@RequestBody List<OrderItemDto> orderItems
			) {

		// Call checkoutService to place an order and retrieve the order ID
		Long orderId = checkoutService.placeOrder(userId, addressId, shoppingCartId, totalAmount, payment_id);
		orderItemService.saveOrderItems(orderId, orderItems);
		
		
		// Return the order ID in the response
		return new ResponseEntity<>(orderId, HttpStatus.OK);

	}

	// Get order items by order ID
	@GetMapping("/getItems/{order_id}")
	public ResponseEntity<List<OrderItemDto>> getByOrderId(@PathVariable Long order_id) {
		// Retrieve and return order items by order ID
		List<OrderItemDto> response = orderItemService.getOrdersByOrderId(order_id);
		return ResponseEntity.ok(response);
	}

	// Get order items by user ID
	@GetMapping("/getOrders/{user_id}")
	public ResponseEntity<List<OrderItemDto>> getByUserId(@PathVariable Long user_id) {
		// Retrieve and return order items by user ID
		List<OrderItemDto> response = orderItemService.getOrders(user_id);
		return ResponseEntity.ok(response);
	}

	// Get all payment details
	@GetMapping("/getpayments")
	public ResponseEntity<List<Payment>> getpaymentdetails() {
		// Retrieve and return all payment details
		List<Payment> response = orderService.getpayments();
		return ResponseEntity.ok(response);
	}

	// Get payment details by ID
	@GetMapping("/getpayment/{Id}")
	public ResponseEntity<Optional<Payment>> getpaymentById(@PathVariable Long Id) {
		// Retrieve and return payment details by ID
		Optional<Payment> response = orderService.getpaymentsById(Id);
		return ResponseEntity.ok(response);
	}
	
	

//Method created for sending order details through email
    @PostMapping("/send-email/{userEmail}/{totalAmount}")
    public ResponseEntity<String> sendOrderConfirmationEmail(@PathVariable String userEmail, @RequestBody List<OrderItemDto> orderDetails, @PathVariable BigDecimal totalAmount) {
        emailService.sendOrderConfirmationEmail(userEmail, orderDetails, totalAmount);
        return ResponseEntity.ok("Email sent successfully.");
    }
	
    
    //Method created for resetting the password through the email
    @PostMapping("/api/reset-password/{email}")
    public void resetPassword(@PathVariable String email) {
        
    	
    	String resetLink = "http://localhost:3000/passwordreset";
        String emailMessage = "Your password reset link: " + resetLink;

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Password Reset Request");
        message.setText(emailMessage);
        javaMailSender.send(message);
    }

   

}
