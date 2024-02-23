package com.exception.mapper;

import org.apache.catalina.User;
import org.springframework.stereotype.Component;

import com.exception.dto.User1Dto;
import com.exception.entities.User1;


@Component
public class UserMapper {
public User1 toUsersEntity(User1Dto dtos) {
	User1 user=new User1();
	user.setEmail(dtos.getEmail());
	user.setName(dtos.getName());
	user.setPassword(dtos.getPassword());
	return user;
	
}
public User1Dto toUsersDto(User1 users) {
	User1Dto dto=new User1Dto();
	dto.setEmail(users.getEmail());
	dto.setName(users.getName());
	dto.setPassword(users.getPassword());
	return dto;
}


}
