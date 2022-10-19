package com.jbj.exam.board.container;

import com.jbj.exam.board.Session;
import com.jbj.exam.board.controller.UsrArticleController;
import com.jbj.exam.board.controller.UsrMemberController;
import com.jbj.exam.board.repository.ArticleRepository;
import com.jbj.exam.board.repository.MemberRepository;
import com.jbj.exam.board.service.ArticleService;
import com.jbj.exam.board.service.MemberService;
import lombok.Getter;

import java.util.Scanner;

public class Container {
	@Getter
	private static Scanner sc;
	@Getter
	private static Session session;
	@Getter
	private  static MemberService memberService;
	@Getter
	private  static ArticleService articleService;
	@Getter
	private  static  MemberRepository memberRepository;
	@Getter
	private  static  ArticleRepository articleRepository;
	@Getter
	private static UsrArticleController usrArticleController;
	@Getter
	private static UsrMemberController usrMemberController ;
	
	static {
		sc = new Scanner(System.in);
		session = new Session();
		memberRepository = new MemberRepository();
		articleRepository = new ArticleRepository();

		memberService = new MemberService();
		articleService = new ArticleService();

		usrArticleController = new UsrArticleController();
		usrMemberController = new UsrMemberController();
	}

	public static Session getSession() {
		return session;
	}
}
