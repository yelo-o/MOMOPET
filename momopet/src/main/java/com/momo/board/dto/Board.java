package com.momo.board.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter @NoArgsConstructor @AllArgsConstructor
public class Board {

	private int rn;
	private String boardNo;
	private String boardId;
	private int views;
	private String boardTitle;
	private String boardContent;
	private Date postingDate;
}

