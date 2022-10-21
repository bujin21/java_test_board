package com.jbj.exam.board.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Board {
  private int id;
  private String regDate;
  private String updateDate;
  private String name;
  private String code;
}
