package com.jbj.exam.board;

import com.jbj.exam.board.container.Container;
import com.jbj.exam.board.dto.Member;

import java.util.Scanner;

public class App {
	  void run() {

	    Scanner sc = Container.getSc();

	    System.out.println("== 게시판 v 0.1 ==");
	    System.out.println("== 프로그램 시작 ==");

	    

	    while (true) {
	    	Rq rq = new Rq();

	    	String promptName = "명령";
	    	
	    	if( rq.isLogined()) {
					Member loginedMember = rq.getLoginedMember();
	    		promptName = loginedMember.getLoginId();
	    	}
	    	
	    	System.out.printf("%s) ", promptName);
	    	String cmd = sc.nextLine();

				rq.setCommand(cmd);

	      if (rq.getUrlPath().equals("exit")) {
	        break;
	      } else if (rq.getUrlPath().equals("/usr/article/list")) {
	    	 Container.getUsrArticleController().actionList(rq);
	      } else if (rq.getUrlPath().equals("/usr/article/detail")) {
	    	  Container.getUsrArticleController().actionDetail(rq);
	      } else if (rq.getUrlPath().equals("/usr/article/write")) {
	    	  Container.getUsrArticleController().actionWrite(rq);
	      } else if (rq.getUrlPath().equals("/usr/article/modify")) {
	    	  Container.getUsrArticleController().actionModify(rq);
	      } else if (rq.getUrlPath().equals("/usr/article/delete")) {
	    	  Container.getUsrArticleController().actionDelete(rq);
	      } else if (rq.getUrlPath().equals("/usr/member/join")) {
	          Container.getUsrMemberController().actionJoin(rq);
	      } else if (rq.getUrlPath().equals("/usr/member/login")) {
	          Container.getUsrMemberController().actionLogin(rq);
	      } else if (rq.getUrlPath().equals("/usr/member/logout")) {
	          Container.getUsrMemberController().actionLogout(rq);
	      } else {
	        System.out.printf("입력 된 명령어 : %s\n", cmd);
	      }
	    }

	    System.out.println("== 프로그램 끝 ==");

	    sc.close();
	  }

	 
}
