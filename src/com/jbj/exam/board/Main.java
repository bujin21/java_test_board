package com.jbj.exam.board;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

	    System.out.println("== 게시판 v 0.1 ==");
	    System.out.println("== 프로그램 시작 ==");
	    
	    int articleLastId = 0;
	    
	    while (true) {
	        System.out.printf("명령) ");
	        String cmd = sc.nextLine();

	        if ( cmd.equals("exit")) {
	          break;
	        }

	        else if( cmd.equals("/usr/article/write")) {
	            System.out.println("- 게시물 등록 -");
	            System.out.printf("제목 : ");
	            String title = sc.nextLine();
	            System.out.printf("내용 : ");
	            String body = sc.nextLine();
	            
	            int id = articleLastId + 1;
	            articleLastId++;
	            
	            Article article = new Article();
	            article.id = id;
	            article.title = title;
	            article.body = body;
	            System.out.println("생성된 개시물 객체 : " + article);
	            System.out.printf("%d번 게시물이 입력되었습니다.\n", id);
	          }
	          else {
	            System.out.printf("입력 된 명령어 : %s\n", cmd);
	          }
	      }

	      System.out.println("== 프로그램 끝 ==");

	      sc.close();
	}
}

class Article{
	int id;
	String title;
	String body;
	
	@Override
	  public String toString() {
	    return String.format("{id : %d, title : \"%s\", body : \"%s\"}", id, title, body);
	  }
}