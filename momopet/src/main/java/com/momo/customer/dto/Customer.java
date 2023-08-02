package com.momo.customer.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter @NoArgsConstructor @AllArgsConstructor
public class Customer {
	private String id;
	private String pwd;
	private String name;
	private String email;
	private String phoneNumber;
	private String address;	
	private int gender;
	private int role;
	private String birthdate;
	private String dateCreated;
	private int userStatus;
}
