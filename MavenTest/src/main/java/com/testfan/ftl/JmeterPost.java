package com.testfan.ftl;

import java.util.HashMap;
import java.util.Map;



public class JmeterPost {
	
	public static void main(String[] args) {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("casename", "测试");
		map.put("threads", 100);
		map.put("loops", 100);
		map.put("url", "http://59.110.139.20:8080/goods/UserServlet");
		String params= "method=loginMobile&loginname=test1&loginpass=test1";
		map.put("paramMap", MapUtils.covertStringToMp(params,"&"));
		
		FreeMarkerUtil.fprint("http_post.ftl", map,"http_post.jmx");
	}
	
	
	

}
