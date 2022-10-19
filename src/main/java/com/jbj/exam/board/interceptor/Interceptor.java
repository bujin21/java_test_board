package com.jbj.exam.board.interceptor;

import com.jbj.exam.board.Rq;

public interface Interceptor {
  boolean run(Rq rq);
}
