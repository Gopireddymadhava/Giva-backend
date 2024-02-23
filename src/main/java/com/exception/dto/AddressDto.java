package com.exception.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName="build")
@NoArgsConstructor
public class AddressDto {
	private long id;
	@NotNull
	@Column(name="street",nullable=false )
	private String street;
	@NotNull
	@Column(name="state")
	private String state;
	@NotNull
	private String city;
	@NotNull
	private String zipcode;
	@NotNull
	private String country;
	
	@NotNull
	private String phnumber;
	@NotNull
	private String firstname;
	@NotNull
	private String lastname;
	

}
