package com.momo.customer.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter @NoArgsConstructor @AllArgsConstructor

public class Customer {
	private String userId;
	private String name;
	private String pwd;
	private String phoneNumber;
	private String email;
	private String address;
	private Date birthDate;
	private String pay;
	private String introduce;
	private int userSex;
	private int role;
	private int userStatus;
	private String dateCreated;
	
}