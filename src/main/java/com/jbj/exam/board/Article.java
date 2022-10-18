package com.jbj.exam.board;

import lombok.Data;

@Data
public class Article {
	int id;
	String title;
	String body;

	Article(int id_, String title_, String body_) {
		this.id = id_;
		this.title = title_;
		this.body = body_;
	}

	@Override
	public String toString() {
		return String.format("{id : %d, title : \"%s\", body : \"%s\"}", id, title, body);
	}
}
