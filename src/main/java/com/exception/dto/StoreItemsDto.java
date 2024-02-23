package com.exception.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StoreItemsDto {

	private String name;
	private String address;
	private String distance;
	private String location;

}
