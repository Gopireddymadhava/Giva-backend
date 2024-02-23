package com.exception.mapper;

import org.springframework.stereotype.Component;

import com.exception.dto.AddressDto;
import com.exception.dto.CartDto;
import com.exception.entities.Address;
import com.exception.entities.Cart;

@Component
public class AddressMapper {

	public AddressMapper() {
		// TODO Auto-generated constructor stub
	}
	
	public Address toAddressEntity(AddressDto dtos) {
		Address user=new Address();
		user.setId(dtos.getId());
		user.setCity(dtos.getCity());
		user.setCountry(dtos.getCountry());
		user.setFirstname(dtos.getFirstname());
		user.setLastname(dtos.getLastname());
		user.setPhnumber(dtos.getPhnumber());
		user.setState(dtos.getState());
		user.setStreet(dtos.getStreet());
		user.setZipcode(dtos.getZipcode());
		
		return user;
		
	}
	public AddressDto toAddressDto(Address dtos) {
		AddressDto user=new AddressDto();
user.setId(dtos.getId());
		user.setCity(dtos.getCity());
		user.setCountry(dtos.getCountry());
		user.setFirstname(dtos.getFirstname());
		user.setLastname(dtos.getLastname());
		user.setPhnumber(dtos.getPhnumber());
		user.setState(dtos.getState());
		user.setStreet(dtos.getStreet());
		user.setZipcode(dtos.getZipcode());
		
	
		return user;
	}

}
