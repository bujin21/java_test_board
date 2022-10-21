package com.jbj.exam.board.container;

import com.jbj.exam.board.Session;
import com.jbj.exam.board.controller.UsrArticleController;
import com.jbj.exam.board.controller.UsrMemberController;
import com.jbj.exam.board.interceptor.NeedLoginInterceptor;
import com.jbj.exam.board.interceptor.NeedLogoutInterceptor;
import com.jbj.exam.board.repository.ArticleRepository;
import com.jbj.exam.board.repository.BoardRepository;
import com.jbj.exam.board.repository.MemberRepository;
import com.jbj.exam.board.service.ArticleService;
import com.jbj.exam.board.service.BoardService;
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
	private static BoardService boardService;
	@Getter
	private  static ArticleService articleService;
	@Getter
	private  static  MemberRepository memberRepository;
	@Getter
	private static BoardRepository boardRepository;
	@Getter
	private  static  ArticleRepository articleRepository;
	@Getter
	private static NeedLoginInterceptor needLoginInterceptor;
	@Getter
	private static NeedLogoutInterceptor needLogoutInterceptor;
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
		boardService = new BoardService();
		articleService = new ArticleService();

		needLoginInterceptor =new NeedLoginInterceptor();
		needLogoutInterceptor = new NeedLogoutInterceptor();

		usrArticleController = new UsrArticleController();
		boardRepository = new BoardRepository();
		usrMemberController = new UsrMemberController();
	}

	public static Session getSession() {
		return session;
	}
}
