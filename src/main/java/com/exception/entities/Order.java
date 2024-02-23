package com.exception.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customer_order")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	

    private double totalAmount;
   
    
   
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;
    
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;
    
    

    @JsonIgnore
	@ManyToOne
	@JoinColumn(name = "user_id",nullable=false)
	private User1 user1;

    
    @JsonIgnore
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> orderItems = new ArrayList<>();

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="payment_id",unique = false)
    private Payment payment; 
    

    
	public void setUser1(User1 user) {
		
		this.user1=user;
	}


	public Long getOrder_id() {
		// TODO Auto-generated method stub
		return id;
	}
	

	



	




	

   


	

	
}
