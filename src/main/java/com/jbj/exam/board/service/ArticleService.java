package com.jbj.exam.board.service;

import com.jbj.exam.board.dto.Article;
import com.jbj.exam.board.repository.ArticleRepository;

import java.util.List;



public class ArticleService {
  private ArticleRepository articleRepository;
  public ArticleService() {
    articleRepository = new ArticleRepository();
  }
  public int write(int boardId, int memberId, String title, String body) {
    return articleRepository.write(boardId, memberId, title, body);
  }
  public void makeTestData() {
    for (int i = 0; i < 100; i++) {
      String title = "제목" + (i + 1);
      String body = "내용" + (i + 1);
      write(i % 2 + 1, i % 2 + 1, title, body);
    }
  }

  public List<Article> getArticles(int boardId, String orderBy, String searchKeyword, String searchKeywordTypeCode, int page, int pageItemCount) {
    int limitStart = (page - 1) * pageItemCount;
    int limitCount = pageItemCount;

    return articleRepository.getArticles(boardId, orderBy, searchKeyword, searchKeywordTypeCode, limitStart, limitCount);
  }


  public void deleteArticleById(int id) {
    articleRepository.deleteArticleById(id);
  }
  public Article getArticleById(int id) {
    return articleRepository.getArticleById(id);
  }
  public void modify(int id, String title, String body) {
    articleRepository.modify(id, title, body);
  }
}