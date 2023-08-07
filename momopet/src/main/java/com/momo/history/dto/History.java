package com.momo.history.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter @NoArgsConstructor @AllArgsConstructor
public class History {
	private int historyNo;
	private String sitterId;
	private String userId;
	private Date startDate;
	private Date endDate;
	private int userType;
	private int status;
}
