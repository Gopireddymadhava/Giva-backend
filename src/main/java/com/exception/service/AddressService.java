package com.exception.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exception.dto.AddressDto;
import com.exception.entities.Address;
import com.exception.entities.User1;
import com.exception.exceptions.AddressNotFoundException;
import com.exception.exceptions.NotFoundException;
import com.exception.exceptions.User1NotFoundException;
import com.exception.mapper.AddressMapper;
import com.exception.repositories.AddressRepository;
import com.exception.repositories.User1Repo;

import jakarta.transaction.Transactional;
@Service
public class AddressService {
	 @Autowired
	    private AddressRepository addressRepository;
	 @Autowired
	 private User1Repo usersrepo;
	 
	 @Autowired
	 private AddressMapper addressmapper;
	 
	 
	 //Method used to save address   	
	 public AddressDto saveAddress(Address address) {
		    try {
		        if (address == null) {
		            throw new IllegalArgumentException("Address must not be null");
		        }
		        return addressmapper.toAddressDto(addressRepository.save(address));
		    } catch (Exception e) {
		     
		        throw new AddressNotFoundException("Error while saving address");
		    }
		}
	 

	 //Method used to get address by addressId
		public AddressDto getAddressById(Long addressId) {
		    try {
		        return addressmapper.toAddressDto(addressRepository.findById(addressId).orElseThrow(()-> new AddressNotFoundException("Address Not found")));
		    } catch (Exception e) {
		       
		        throw new AddressNotFoundException("Error while getting address by ID");
		    }
		}
		
		
//Method used to save address based on userId
		public Address saveAddress(Long userId, Address address) {
		    
		        if (userId == null || userId < 1) {
		            throw new IllegalArgumentException("Invalid userId");
		        }
		        if (address == null) {
		            throw new IllegalArgumentException("Address must not be null");
		        }

		        User1 user = usersrepo.findById(userId)
		                .orElseThrow(()-> new User1NotFoundException("user not found"));

		        address.setUser1(user);
		        return addressRepository.save(address);
		    
		}
		
		
		//Method to get the list of addresses by userId
		public List<Address> getAddressesByUserId(Long userId) {
		    
		        List<Address> addresses= addressRepository.findByUser1Id(userId);
		        if(addresses!=null) {
		        	return addresses;
		    } else {
		        throw new AddressNotFoundException("Error while getting addresses by userId");
		    }
		}

	   

	
		
	    
}
