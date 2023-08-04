package com.momo.pet.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter @NoArgsConstructor @AllArgsConstructor
public class Pet {
	private String userId;
	private int petType;
	private String petName;
	private String petSex;
	private String petBreed;
	private String petBirth;
	private String petRemarks;

}
