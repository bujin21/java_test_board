package com.jbj.exam.board.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Article {
	private int id;
	private int boardId;
	private String title;
	private String body;

}

