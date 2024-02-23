package com.exception.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class User1NotFoundException extends RuntimeException {

	public User1NotFoundException(String message) {
		super(message);
		
	}

}
