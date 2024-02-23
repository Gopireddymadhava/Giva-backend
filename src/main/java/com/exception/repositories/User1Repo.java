package com.exception.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.exception.dto.User1Dto;
import com.exception.entities.User1;

@Repository
public interface User1Repo extends JpaRepository<User1, Long> {

//@Query(value="select * from users_tbl",nativeQuery=true)
//	List<Users> getallUsers();
//
//List<Users> findById(long id);
	User1 findById(long id);
	User1 findByEmail(String email);
	
	   
	Optional<User1> findOneByEmailAndPassword(String email, String encodedPassword);
}
