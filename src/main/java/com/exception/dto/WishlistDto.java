package com.exception.dto;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class WishlistDto {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	public WishlistDto(long id2, long id3) {
		// TODO Auto-generated constructor stub
		this.id=id2;
		this.id=id3;
	}

}
