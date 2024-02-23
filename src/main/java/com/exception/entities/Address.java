package com.exception.entities;

import org.springframework.boot.autoconfigure.web.WebProperties.Resources.Chain.Strategy;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Address_tbl")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name="street",nullable=false )
	private String street;
	@Column(name="state")
	private String state;
	private String city;
	private String zipcode;
	private String country;
	
	
	private String phnumber;
	private String firstname;
	private String lastname;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="user_id")
private User1 user1;

	public void setUser1(User1 user2) {
		// TODO Auto-generated method stub
		this.user1=user2;
	}
	
	
}
