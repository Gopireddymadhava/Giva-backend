package com.exception.controller;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exception.dto.LoginDto;
import com.exception.dto.User1Dto;
import com.exception.entities.User1;
import com.exception.exceptions.LoginResponse;
import com.exception.exceptions.User1NotFoundException;
import com.exception.service.User1Service;

import jakarta.validation.Valid;
@CrossOrigin(origins="*")
@RestController
@RequestMapping("/users")
public class UsersController {
	
@Autowired
private User1Service userservice;

//Save a new user (signup)
@PostMapping("/signup")
public ResponseEntity<User1> saveuser(@RequestBody @Valid User1Dto dto){
 // Call userservice to save a new user and return the created user
 return new ResponseEntity<>(userservice.saveUser(dto), HttpStatus.CREATED);
}

//Get all users
@GetMapping("/all")
public ResponseEntity<List<User1>> getallUsers(){
 // Retrieve and return all users
 return ResponseEntity.ok(userservice.getAllUser1());
}

//Get user by ID
@GetMapping("/all/{id}")
public ResponseEntity<User1> getUser(@PathVariable long id) throws User1NotFoundException{
 // Retrieve and return user by ID
 return ResponseEntity.ok(userservice.getUser1(id));
}

//Login user
@PostMapping("/login")
public ResponseEntity<LoginResponse> loginEmployee(@RequestBody LoginDto loginDTO)
{
 // Call userservice to authenticate and login the user
 LoginResponse loginResponse = userservice.loginEmployee(loginDTO);
 return ResponseEntity.ok(loginResponse);
}

//Updating user details with password
@PutMapping("/updatepassword/{email}/{password}")
public ResponseEntity<User1> updatepassword(@PathVariable String email,@PathVariable String password){
	User1 user=userservice.updatepassword(email, password);
	return ResponseEntity.ok(user);
}

	
}
