package com.exception.advice;
import java.util.HashMap;
import java.util.Map;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.exception.exceptions.AddressNotFoundException;
import com.exception.exceptions.CartItemNotFoundException;
import com.exception.exceptions.CartNotFoundException;
import com.exception.exceptions.CategoryNotFoundException;
import com.exception.exceptions.CouponNotFoundException;
import com.exception.exceptions.OrderNotFoundException;
import com.exception.exceptions.PaymentNotFoundException;
import com.exception.exceptions.ProductNotFoundException;
import com.exception.exceptions.StoreItemNotFoundException;
import com.exception.exceptions.StoreNotFoundException;
import com.exception.exceptions.AddressNotFoundException;
import com.exception.exceptions.User1NotFoundException;
import com.exception.exceptions.WishlistItemNotFoundException;
import com.exception.exceptions.WishlistNotFoundException;

@RestControllerAdvice
public class ExceptionHandler1 {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleInvalidArgument(MethodArgumentNotValidException ex){
		Map<String,String> errorMap=new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(error->{
			errorMap.put(error.getField(),error.getDefaultMessage() );
			
		});
		return errorMap;
	}
	
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(User1NotFoundException.class)
	
	public Map<String,String> handleBusinessException(User1NotFoundException ex) {
		Map<String,String> errorMap=new HashMap<>();
		errorMap.put("error message", ex.getMessage());
	     return errorMap;
}
	
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(AddressNotFoundException.class)
	
	public Map<String,String> handleaddressException(AddressNotFoundException ex) {
		Map<String,String> errorMap=new HashMap<>();
		errorMap.put("error message", ex.getMessage());
	     return errorMap;
}
	
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(CartNotFoundException.class)
	
	public Map<String,String> handlecartException(CartNotFoundException ex) {
		Map<String,String> errorMap=new HashMap<>();
		errorMap.put("error message", ex.getMessage());
	     return errorMap;
}
	
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(CategoryNotFoundException.class)
	
	public Map<String,String> handlecategoryException(CategoryNotFoundException ex) {
		Map<String,String> errorMap=new HashMap<>();
		errorMap.put("error message", ex.getMessage());
	     return errorMap;
}
	
	
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(CouponNotFoundException.class)
	
	public Map<String,String> handlecouponException(CouponNotFoundException ex) {
		Map<String,String> errorMap=new HashMap<>();
		errorMap.put("error message", ex.getMessage());
	     return errorMap;
}
	
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(PaymentNotFoundException.class)
	
	public Map<String,String> handlePaymentException(PaymentNotFoundException ex) {
		Map<String,String> errorMap=new HashMap<>();
		errorMap.put("error message", ex.getMessage());
	     return errorMap;
}
	
	
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(ProductNotFoundException.class)
	
	public Map<String,String> handleProductException(ProductNotFoundException ex) {
		Map<String,String> errorMap=new HashMap<>();
		errorMap.put("error message", ex.getMessage());
	     return errorMap;
}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(WishlistNotFoundException.class)
	
	public Map<String,String> handleWishlistException(WishlistNotFoundException ex) {
		Map<String,String> errorMap=new HashMap<>();
		errorMap.put("error message", ex.getMessage());
	     return errorMap;
}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(CartItemNotFoundException.class)
	
	public Map<String,String> handleException(CartItemNotFoundException ex) {
		Map<String,String> errorMap=new HashMap<>();
		errorMap.put("error message", ex.getMessage());
	     return errorMap;
}
	
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(OrderNotFoundException.class)
	
	public Map<String,String> handleOrderException(OrderNotFoundException ex) {
		Map<String,String> errorMap=new HashMap<>();
		errorMap.put("error message", ex.getMessage());
	     return errorMap;
}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(StoreNotFoundException.class)
	
	public Map<String,String> handleStoreException(StoreNotFoundException ex) {
		Map<String,String> errorMap=new HashMap<>();
		errorMap.put("error message", ex.getMessage());
	     return errorMap;
}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(StoreItemNotFoundException.class)
	public Map<String,String> handleStoreItemException(StoreItemNotFoundException ex) {
		Map<String,String> errorMap=new HashMap<>();
		errorMap.put("error message", ex.getMessage());
	     return errorMap;
}
	
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(WishlistItemNotFoundException.class)
	public Map<String,String> handleWishlistItemException(WishlistItemNotFoundException ex) {
		Map<String,String> errorMap=new HashMap<>();
		errorMap.put("error message", ex.getMessage());
	     return errorMap;
}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handleNotFoundException(NotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}


