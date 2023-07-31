package com.momo.customer.dto;

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
	private String phone_number;
	private String address;

}
