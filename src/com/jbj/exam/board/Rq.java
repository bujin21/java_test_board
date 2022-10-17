package com.jbj.exam.board;

import java.util.Map;

public class Rq {
  String url;
  Map<String, String> params;
  String urlPath;

  Rq(String url) {
    this.url = url;
    params = Util.getParamsFromUrl(this.url);
    urlPath = Util.getUrlPathFromUrl(this.url);
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
}