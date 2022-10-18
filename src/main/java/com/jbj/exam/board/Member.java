package com.jbj.exam.board;

public class Member {
	int id;
	String loginId;
	String loginPw;
	
	Member(int id, String loginId, String loginPw){
		this.id = id;
		this.loginId = loginId;
		this.loginPw = loginPw;
	}
	
	@Override
	public String toString() {
		return String.format("{id : %d, 로그인 아이디 : \"%s\", 로그인 비번 : \"%s\"}", id, loginId, loginPw);
	}
}
