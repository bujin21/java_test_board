package com.jbj.exam.board.repository;

import com.jbj.exam.board.dto.Board;

import java.util.ArrayList;
import java.util.List;

public class BoardRepository {
  private List<Board> boards;
  private int lastId;

  public BoardRepository(){
    boards = new ArrayList<>();
    lastId = 0;
  }
  public Board getBoardById(int id) {
    for(Board board : boards) {
      if(board.getId() == id){
        return board;
      }
    }
    return null;
  }
}
