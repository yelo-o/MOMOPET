package com.momo.pet.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter @NoArgsConstructor @AllArgsConstructor
public class Pet {
	private String userId;
	private String petId;
	private String petType;
	private String petName;
	private String petBreed;
	private String petBirth;
	private String petSex;
	private String petRemarks;

}
