package com.jbj.exam.board;

import com.jbj.exam.board.container.Container;
import com.jbj.exam.board.dto.Member;
import com.jbj.exam.board.util.Util;

import java.util.Map;

public class Rq {
  private String url;
  private Map<String, String> params;
  private String urlPath;

  Rq() {

  }
	public void setCommand(String url){
		params = Util.getParamsFromUrl(url);
		urlPath = Util.getUrlPathFromUrl(url);
	}

  public Map<String, String> getParams() {
    return params;
  }

  public String getUrlPath() {
    return urlPath;
  }

public int getIntParam(String paramsName, int defaultValue) {
	
	if( params.containsKey(paramsName) == false) {
		return defaultValue;
	}
	
	try {		
		return Integer.parseInt(params.get(paramsName));
	} catch (NumberFormatException e) {
		return defaultValue;
	}
	
}
	public String getParam(String paramsName, String defaultValue) {
		
		if(params.containsKey(paramsName) == false) {
			return defaultValue;
		}
		return params.get(paramsName);
	}

	public void setSessionAttr(String key, Object value) {
		Session session = Container.getSession();
		
		session.setAttribute(key, value);
	}

	public void removeSessionAttr(String key) {
		Session session = Container.getSession();
		
		session.removeAttribute(key);
		
	}

	public boolean isLogined() {
		return hasSessionAttr("loginedMember");
	}

	private boolean hasSessionAttr(String key) {
		Session session = Container.getSession();

		return session.hasAttribute(key);
	}

	public Member getLoginedMember() {
		return (Member) getSessionAttr("loginedMember");
	}

	private Object getSessionAttr(String key) {
		Session session = Container.getSession();

		return session.getAttribute(key);
	}

	public void login(Member member) {
		setSessionAttr("loginedMember", member);
	}

	public void logout() {
		removeSessionAttr("loginedMember");
	}
}