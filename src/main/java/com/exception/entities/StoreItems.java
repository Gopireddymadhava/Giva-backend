package com.exception.entities;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StoreItems {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
private String name;
private String address;
private String distance;
private String location;
private String pincode;

@JsonIgnore
@ManyToOne
@JoinColumn(name="store_id")
private Store store;

public void setStore(Store store2) {
	this.store=store2;
	
}

public StoreItems(String string, String string2, String string3, String string4, Long i) {
	this.name=string;
	this.address=string2;
	this.distance=string3;
	this.location=string4;
	this.id=i;
	
}

}
