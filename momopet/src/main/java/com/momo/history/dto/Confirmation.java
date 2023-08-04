package com.momo.history.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter@Getter@NoArgsConstructor@AllArgsConstructor
public class Confirmation {
	private int historyNo;
	private String userId; //보호자 Id(logined)
	private List<SitterInfo> info; //(돌보미정보)
	private String startDate;
	private String finishDate;
	
	

}
