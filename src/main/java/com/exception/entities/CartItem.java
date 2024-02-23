package com.exception.entities;

import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private int quantity;
@JsonBackReference
@ManyToOne
@JoinColumn(name = "product_id")
private Product product;

@JsonIgnore
@ManyToOne
@JoinColumn(name="cart_id")
private Cart cart;

//@JsonIgnore
//@ManyToOne
//@JoinColumn(name="order_id",nullable=false)
//private Order order;

public Long getProductId() {
	return id;
}





}
