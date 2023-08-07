package com.momo.review.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
//@AllArgsConstructor
public class Review {
	private String reviewNo; // int
	private String reviewRating;
	private String reviewContent;
	private String reviewWriter;
	private String userId;
	private String writingDate;
	
	//LocalDate 사용을 위한 생성자
//	public Review(String reviewNo, String reviewRating, String reviewContent, String reviewWriter, String userId, String writingDate) {
//	    this.reviewNo = reviewNo;
//	    this.reviewRating = reviewRating;
//	    this.reviewContent = reviewContent;
//	    this.reviewWriter = reviewWriter;
//	    this.userId = userId;
//	    this.writingDate = writingDate;
//	}
	
//	//SYSDATE 사용을 위한 생성자
//	public Review(String reviewNo, String reviewRating, String reviewContent, String reviewWriter, String userId) {
//	    this.reviewNo = reviewNo;
//	    this.reviewRating = reviewRating;
//	    this.reviewContent = reviewContent;
//	    this.reviewWriter = reviewWriter;
//	    this.userId = userId;
//	}
	
	//SYSDATE 사용을 위한 생성자
	public Review(String reviewRating, String reviewContent, String reviewWriter, String userId) {
	    this.reviewRating = reviewRating;
	    this.reviewContent = reviewContent;
	    this.reviewWriter = reviewWriter;
	    this.userId = userId;
	}

	public Review(String reviewWriter) {
		this.reviewWriter = reviewWriter;
	}

	@Override
	public String toString() {
		return "Review{" + "reviewNo='" + reviewNo + '\'' + ", reviewRating='" + reviewRating + '\''
				+ ", reviewContent='" + reviewContent + '\'' + ", reviewWriter='" + reviewWriter + '\'' + ", userId='"
				+ userId + '\'' + ", writingDate='" + writingDate + '\'' + '}';
	}

}
