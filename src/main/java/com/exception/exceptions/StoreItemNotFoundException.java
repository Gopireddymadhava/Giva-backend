package com.exception.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class StoreItemNotFoundException extends RuntimeException{

	public StoreItemNotFoundException() {
		// TODO Auto-generated constructor stub
	}
	public StoreItemNotFoundException(String message) {
		super(message);
		
	}

}
