package com.exception.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName="build")
@NoArgsConstructor
public class User1Dto {
	
	@NotBlank(message="please enter username")
	
	@NotNull(message="username should not be null ")
	private String name;
	@Email(message="invalid email")
	private String email;
	
			@NotNull(message="password is required")
	@NotBlank(message="password is required")
	private String password;
	
	
	

}
