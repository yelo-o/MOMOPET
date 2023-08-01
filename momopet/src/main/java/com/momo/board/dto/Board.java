package com.momo.board.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter @NoArgsConstructor @AllArgsConstructor
public class Board {
	private String boardNo;
	private String boardId;
	private int userType;
	private String boardTitle;
	private String boardContent;
	private Date postingDate;
}
