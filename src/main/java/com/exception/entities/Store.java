package com.exception.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Store {

	public Store(long l, String string) {
this.id=l;
this.name=string;

	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="Location")
	private String name;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "store",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<StoreItems> storeitems;
	

}
