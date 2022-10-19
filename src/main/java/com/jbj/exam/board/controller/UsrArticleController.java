package com.jbj.exam.board.controller;

import com.jbj.exam.board.dto.Article;
import com.jbj.exam.board.Rq;
import com.jbj.exam.board.util.Util;
import com.jbj.exam.board.container.Container;

import java.util.ArrayList;
import java.util.List;

public class UsrArticleController {
		private int articleLastId;
	  private List<Article> articles;

	 public UsrArticleController() {
	    articleLastId = 0;
	    articles = new ArrayList<>();
	    
	    makeTestData();

	    if (articles.size() > 0) {
	      articleLastId = articles.get(articles.size() - 1).getId();
	    }
	  }

	 public void makeTestData() {
	    for (int i = 0; i < 100; i++) {
	      int id = i + 1;
	      articles.add(new Article(id, "제목" + id, "내용" + id));
	    }
	  }
	  public void actionDelete(Rq rq) {
		    int id = rq.getIntParam("id", 0);
		    
		    if (id == 0) {
		        System.out.println("id를 올바르게 입력해주세요.");
		      return;
		    }

		    Article article = articles.get(id - 1);

		    if (id > articles.size()) {
		      System.out.println("게시물이 존재하지 않습니다.");
		      return;
		    }

		    articles.remove(article);

		    System.out.printf("%d번 게시물이 삭제되었습니다.\n", article.getId());
		  }

	  public void actionModify(Rq rq) {

		    int id = rq.getIntParam("id", 0);
		    
		    if (id == 0) {
		        System.out.println("id를 올바르게 입력해주세요.");
		      return;
		    }

		    if (articles.isEmpty()) {
		      System.out.println("게시물이 존재하지 않습니다.");
		      return;
		    }

		    Article article = articles.get(id - 1);

		    if (id > articles.size()) {
		      System.out.println("게시물이 존재하지 않습니다.");
		      return;
		    }

		    System.out.printf("새 제목 : ");
		    article.setTitle(Container.getSc().nextLine());
		    System.out.printf("새 내용 : ");
		    article.setBody(Container.getSc().nextLine());

		    System.out.printf("%d번 게시물이 수정되었습니다.\n", id);
		  }

		  public void actionDetail(Rq rq) {
		    int id = rq.getIntParam("id", 0);
			  
		    if (id == 0) {
		      System.out.println("id를 올바르게 입력해주세요.");
		      return;
		    }

		    if (articles.isEmpty()) {
		        System.out.println("게시물이 존재하지 않습니다.");
		      return;
		    }

		    Article article = articles.get(id - 1);

		    if (id > articles.size()) {
		      System.out.println("게시물이 존재하지 않습니다.");
		      return;
		    }

		    System.out.println("- 게시물 상세 내용 -");
		    System.out.printf("번호 : %d\n", article.getId());
		    System.out.printf("제목 : %s\n", article.getTitle());
		    System.out.printf("내용 : %s\n", article.getBody());
		  }

		  public void actionList(Rq rq) {
		    System.out.println("- 게시물 리스트 -");
		    System.out.printf("------------------\n");
		    System.out.printf("번호 / 제목\n");
		    System.out.printf("------------------\n");

		    String searchKeyword = rq.getParam("searchKeyword", "");

		    // 검색 시작
		    List<Article> filteredArticles = articles;

		    if (searchKeyword.length() > 0) {
		      filteredArticles = new ArrayList<>();

		      for (Article article : articles) {
		        boolean matched = article.getTitle().contains(searchKeyword) || article.getBody().contains(searchKeyword);

		        if (matched) {
		          filteredArticles.add(article);
		        }
		      }
		    }

		    List<Article> sortedArticles = filteredArticles;
		    
		    String orderBy = rq.getParam("orderBy", "idDesc");
		    
		    boolean orderByIdDesc = orderBy.equals("idDesc");		   

		    if (orderByIdDesc) {
		      sortedArticles = Util.reverseList(sortedArticles);
		    }

		    for (Article article : sortedArticles) {
		      System.out.printf("%d / %s\n", article.getId(), article.getTitle());
		    }

		  }

		  public void actionWrite(Rq rq) {
			  
		    System.out.println("- 게시물 등록 -");
		    System.out.printf("제목 : ");
		    String title = Container.getSc().nextLine();
		    System.out.printf("내용 : ");
		    String body = Container.getSc().nextLine();

		    int id = ++articleLastId;

		    Article article = new Article(id, title, body);

		    articles.add(article);

		    System.out.println("생성된 게시물 객체 : " + article);
		    System.out.printf("%d번 게시물이 입력되었습니다.\n", article.getId());
		    
		  }
}
