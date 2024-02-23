package com.exception.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "build")
@Table(name="USERS_TBL")
@Entity
public class User1 {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;
private String name;
private String email;
private String password;

@JsonIgnore
@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
private Cart cart;

@JsonIgnore
@OneToOne(mappedBy = "user1", cascade = CascadeType.ALL)
private WishList wishlist;


@JsonIgnore
@OneToMany(mappedBy = "user1", cascade = CascadeType.ALL)
private List<Order> checkout;



@JsonIgnore
@OneToMany(mappedBy="user1",cascade = CascadeType.ALL)
private List<Address> address;

public WishList getWishList() {
	
	return wishlist;
}







}
