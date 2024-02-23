package com.exception.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class WishList {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@JsonIgnore
	@OneToMany(mappedBy = "wishlist", cascade = CascadeType.ALL)
    private List<WishListItem> wishlistItems = new ArrayList<>();

	
	@JsonIgnore
	 @OneToOne
	    @JoinColumn(name = "user_id")
	    private User1 user1;

	public void setUser1(User1 user2) {
		
		this.user1=user2;
	}

	public List<WishListItem> getWishlistItems() {
		
		return wishlistItems;
	}
	
	

}
