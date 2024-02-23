package com.exception.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@JsonIgnore
	 @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
	    private List<CartItem> cartitems;
	 @JsonIgnore
	 @OneToOne
	    @JoinColumn(name = "user_id")
	    private User1 user;
	
	 
	 @OneToMany(mappedBy = "cart",cascade=CascadeType.ALL)
	 private List<Order> order;

	 public User1 getUser1() {
	        return user;
	    }

	    public void setUser1(User1 user1) {
	        this.user = user1;
	    }

		public void setUser1Id(Long userId) {
			// TODO Auto-generated method stub
			this.id=userId;
		}

	   
	

}
