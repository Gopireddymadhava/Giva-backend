package com.exception.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exception.dto.AddressDto;
import com.exception.entities.Address;
import com.exception.repositories.AddressRepository;
import com.exception.service.AddressService;

@RestController
@CrossOrigin(origins = "*")
public class AddressController {

	@Autowired
	private AddressService addressService;

	
	// Save an address for a specific user
	@PostMapping("/saveaddress/{userId}")
	public ResponseEntity<Address> saveAddress(@PathVariable Long userId, @RequestBody Address address) {
	    // Call addressService to save the address for the given user ID.
	    Address savedAddress = addressService.saveAddress(userId, address);
	    // Return a ResponseEntity with the saved address and HTTP status code 200 (OK).
	    return new ResponseEntity<>(savedAddress, HttpStatus.OK);
	}

	// Get all addresses for a specific user
	@GetMapping("/getaddresses/{userId}")
	public ResponseEntity<List<Address>> getAddressesByUserId(@PathVariable Long userId) {
	    // Call addressService to get a list of addresses for the given user ID.
	    List<Address> addresses = addressService.getAddressesByUserId(userId);
	    // Return a ResponseEntity with the list of addresses and HTTP status code 200 (OK).
	    return new ResponseEntity<>(addresses, HttpStatus.OK);
	}

	// Get a specific address by its ID
	@GetMapping("/getaddress/{addressId}")
	public ResponseEntity<AddressDto> getAddressesById(@PathVariable Long addressId) {
	    // Call addressService to get the address details by the given address ID.
	    AddressDto address = addressService.getAddressById(addressId);
	    // Return a ResponseEntity with the address details and HTTP status code 200 (OK).
	    return new ResponseEntity<>(address, HttpStatus.OK);
	}

}
