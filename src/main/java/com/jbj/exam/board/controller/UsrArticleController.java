package com.jbj.exam.board.controller;

import com.jbj.exam.board.dto.Article;
import com.jbj.exam.board.Rq;
import com.jbj.exam.board.dto.Board;
import com.jbj.exam.board.service.ArticleService;
import com.jbj.exam.board.service.BoardService;
import com.jbj.exam.board.service.MemberService;
import com.jbj.exam.board.util.Util;
import com.jbj.exam.board.container.Container;

import java.util.ArrayList;
import java.util.List;

public class UsrArticleController {
	private ArticleService articleService;
	private BoardService boardService;
	private MemberService memberService;
	public UsrArticleController() {
		articleService = Container.getArticleService();
		memberService = Container.getMemberService();
		boardService = Container.getBoardService();
		makeTestData();
	}

	public void makeTestData() {
		boardService.makeTestData();
		articleService.makeTestData();
	}
	public void actionDelete(Rq rq) {
		int id = rq.getIntParam("id", 0);

		if (id == 0) {
			System.out.println("id를 올바르게 입력해주세요.");
			return;
		}

		Article article = articleService.getArticleById(id);

		if (article == null) {
			System.out.println("게시물이 존재하지 않습니다.");
			return;
		}

		articleService.deleteArticleById(article.getId());
		System.out.printf("%d번 게시물이 삭제되었습니다.\n", article.getId());
	}
	public void actionModify(Rq rq) {
		int id = rq.getIntParam("id", 0);

		if (id == 0) {
			System.out.println("id를 올바르게 입력해주세요.");
			return;
		}

		Article article = articleService.getArticleById(id);

		if (article == null) {
			System.out.println("게시물이 존재하지 않습니다.");
			return;
		}

		System.out.printf("새 제목 : ");
		String title = Container.getSc().nextLine().trim();
		System.out.printf("새 내용 : ");
		String body = Container.getSc().nextLine().trim();
		article.setUpdateDate(Util.getNowDateStr());
		articleService.modify(article.getId(), title, body);
		System.out.printf("%d번 게시물이 수정되었습니다.\n", id);
	}
	public void actionDetail(Rq rq) {
		int id = rq.getIntParam("id", 0);

		if (id == 0) {
			System.out.println("id를 올바르게 입력해주세요.");
			return;
		}
		Article article = articleService.getArticleById(id);
		if (article == null) {
			System.out.println("게시물이 존재하지 않습니다.");
			return;
		}
		System.out.println("- 게시물 상세 내용 -");
		System.out.printf("번호 : %d\n", article.getId());
		System.out.printf("작성날짜 : %s\n", article.getRegDate());
		System.out.printf("수정날짜 : %s\n", article.getUpdateDate());
		System.out.printf("제목 : %s\n", article.getTitle());
		System.out.printf("내용 : %s\n", article.getBody());
	}

	public void actionList(Rq rq) {
		//게시물리스팅에 제목검색, 본문검색 기능 구현
	// -/usr/article/list?searchKeyword=내용1&searchKeywordTypeCode=title,body
	// -/usr/article/list?searchKeyword=제목1&searchKeywordTypeCode=title
	// -/usr/article/list?searchKeyword=내용1&searchKeywordTypeCode=body

	// -searchKeyWordTypeCode에 title,body 가 없으면 그냥 게시물이 출력 되도록
		int boardId = rq.getIntParam("boardId", 0);
		String searchKeyword = rq.getParam("searchKeyword", "");
		String searchKeywordTypeCode = rq.getParam("searchKeywordTypeCode", "");
		String orderBy = rq.getParam("orderBy", "idDesc");
		Board board = null;

		if (boardId != 0) {
			board = boardService.getBoardById(boardId);
		}
		if (board == null && boardId > 0) {
			System.out.println("해당 게시판 번호는 존재하지 않습니다.");
			return;
		}

		List<Article> articles = articleService.getArticles(boardId, orderBy, searchKeyword, searchKeywordTypeCode);

		String boardName = board == null ? "전체" : board.getName();

		System.out.printf("- %s 게시물 리스트 -\n", boardName);
		System.out.printf("------------------\n");
		System.out.printf("번호 / 게시판 / 작성자 / 현재날짜 / 제목 \n");

		List<Article> sortedArticles = articles;

		boolean orderByIdDesc = orderBy.equals("idDesc");

		if (orderByIdDesc) {
			sortedArticles = Util.reverseList(sortedArticles);
		}

		for (Article article : sortedArticles) {
			String articleBoardName = getBoardNameByBoardId(article.getBoardId());
			String writeName = getWriteNameByBoardId(article.getMemberId());

			System.out.printf("%d / %s / %s / %s / %s\n", article.getId(), articleBoardName, writeName,  article.getRegDate(), article.getTitle());
		}
		System.out.printf("------------------\n");

	}

	private String getWriteNameByBoardId(int memberId) {
		return memberService.getMemberById(memberId).getLoginId();
	}

	private String getBoardNameByBoardId(int boardId) {
		return boardService.getBoardById(boardId).getName();
	}

	public void actionWrite(Rq rq) {

		int boardId = rq.getIntParam("boardId", 0);

		if (boardId == 0) {
			System.out.println("boardId 입력해주세요.");
			return;
		}

		Board board = boardService.getBoardById(boardId);

		if (board == null) {
			System.out.println("존재하지 않는 게시판 번호입니다.");
			return;
		}

		System.out.printf("== %s 게시판 글작성 ==\n", board.getName());
		System.out.printf("제목 : ");
		String title = Container.getSc().nextLine();
		System.out.printf("내용 : ");
		String body = Container.getSc().nextLine();
		int loginedMemberId = rq.getLoginedMemberId();
		int id = articleService.write(1, loginedMemberId, title, body);
		System.out.printf("%d번 게시물이 입력되었습니다.\n", id);
	}
}