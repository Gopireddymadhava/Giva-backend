package com.exception.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private double price;
	
	private String imageUrl;
	@JsonManagedReference
	@OneToMany(mappedBy="product",cascade=CascadeType.ALL)
	private List<CartItem> cartitem;
	
@JsonIgnore
	 @ManyToOne
	    @JoinColumn(name = "category_id")
	    private Category category;


@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
private List<OrderItem> orderItems = new ArrayList<>();

	
//	@JsonManagedReference
//	@OneToMany(mappedBy="product",cascade=CascadeType.ALL)
//	private List<WishList> wishlist;
	
	
	
	

	
	

	 
	
	
	

}
