package com.momo.customer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter @NoArgsConstructor @AllArgsConstructor
public class PetOwner {
	private String pet_id;
	private String pet_type;
	private String pet_name;
	private String pet_sex;
	private String pet_breed;
	private String pet_remarks;

}
