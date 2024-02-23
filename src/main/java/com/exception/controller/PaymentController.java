package com.exception.controller;

import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exception.dto.OrderDto;

import com.exception.repositories.OrderRepo;
import com.exception.service.OrderService;
import com.exception.service.User1Service;
import com.razorpay.Order;
import com.razorpay.Payment;
import com.razorpay.PaymentLink;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

@RestController
public class PaymentController {

	@Value("{razorpay.api.key}")
	String apiKey;
	
	@Value("{razorpay.api.secret}")
	String apiSecret;
	
	@Autowired
	private OrderService orderservice;
	
	@Autowired
	private User1Service userservice;
	
	 @Autowired 
	 private OrderRepo ordererepo;
	 
//	 @PostMapping("/payments/{orderId}")
//	 public ResponseEntity<PaymentLinkResponse> createPaymentLink(@PathVariable Long orderId,
//			 @RequestHeader("Authorization") String jwt) throws RazorpayException{
//		 Order order=orderservice.findOrderById(orderId);
//		 
//		 try {
//			 RazorpayClient razorpay=new RazorpayClient(apiKey,apiSecret);
//			 JSONObject paymentLinkRequest=new JSONObject();
//			 paymentLinkRequest.put("amount", order.getTotalAmount()*100);
//			 paymentLinkRequest.put("currency", "INR");
//			 
//			 JSONObject customer=new JSONObject();
//			 customer.put("name", order.getUser1().getName());
//			 customer.put("email",order.getUser1().getEmail());
//			 paymentLinkRequest.put("customer", customer);
//			 
//			 JSONObject notify=new JSONObject();
//			 notify.put("sms", true);
//			 notify.put("email", true);
//			 paymentLinkRequest.put("notify", notify);
//			 
//			 paymentLinkRequest.put("callback_url", "http://localhost:3000/payment/"+orderId);
//			 paymentLinkRequest.put("callback_method","get");
//			 
//			 PaymentLink payment=razorpay.paymentLink.create(paymentLinkRequest);
//			 String paymentLinkId=payment.get("id");
//			 String paymentLinkUrl=payment.get("short_url");
//			 
//			 PaymentLinkResponse res=new PaymentLinkResponse();
//			 res.setPayment_link_id(paymentLinkId);
//			 res.setPayment_link_url(paymentLinkUrl);
//			 return new ResponseEntity<PaymentLinkResponse>(res,HttpStatus.CREATED);
//			 
//		 }catch(Exception e) {
//			 throw new RazorpayException(e.getMessage());
//		 }
//		 
//		 
//	 }
//	 
//	 @GetMapping("/payments")
//	 public ResponseEntity<ApiResponse> redirect(@RequestParam(name="payment_id") String payment_id,@RequestParam(name="order_id") Long orderId) throws RazorpayException{
//	 
//	 Order order=orderservice.findOrderById(orderId);
//	 RazorpayClient razorpay=new RazorpayClient(apiKey, apiSecret);
//	 try {
//		 Payment payment=razorpay.payments.fetch(payment_id);
//		 Long paymentIdLong = Long.parseLong(payment_id);
//
//		 if(payment.get("status").equals("captured")) {
//			 order.getPayment().setId(paymentIdLong);
//			 			 ordererepo.save(order);
//		 }
//		 ApiResponse res=new ApiResponse();
//		 res.setMessage("your order get placed");
//		 res.setStatus(true);
//		 return new ResponseEntity<ApiResponse>(res,HttpStatus.ACCEPTED);
//	 }catch(Exception e) {
//		 throw new RazorpayException(e.getMessage());
//	 }
//
//}
//	 
	 
	 @PostMapping("/create_order/{totalamount}")
	 public String createOrder(@PathVariable Double totalamount) throws RazorpayException {
		 RazorpayClient client=new RazorpayClient("rzp_test_4Gezio5U8ANmRO", "LL6jFp3H03s9nhStttABNR58");
		 JSONObject ob=new JSONObject();
		 ob.put("amount", totalamount*100);
		 ob.put("currency", "INR");
		 ob.put("receipt", "txn_235425");
		 
		 Order order=client.orders.create(ob);
		 System.out.println(order);
		 return order.toString();
	 }
}