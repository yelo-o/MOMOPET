package com.momo.review.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter @Getter @NoArgsConstructor @AllArgsConstructor
public class Review {

	private String reviewNo;
	private String reviewRating;
	private String reviewContent;
	private String reviewWriter;
	private String userId;
	private String writingDate;
	
}
