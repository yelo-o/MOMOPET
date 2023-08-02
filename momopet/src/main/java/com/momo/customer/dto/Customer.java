package com.momo.customer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter @NoArgsConstructor @AllArgsConstructor

public class Customer {
	private String userId;
	private String name;
	private String pwd;
	private String email;
	private String phoneNumber;
	private String address;
	private String birthDate;
	private String introduce;
	private String pay;
	
}