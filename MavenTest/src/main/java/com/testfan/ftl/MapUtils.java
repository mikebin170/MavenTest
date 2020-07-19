package com.testfan.ftl;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class MapUtils {
	
	public static Map<String, Object> covertBeanToMp(Object obj){
		Map<String, Object> map = new HashMap<String, Object>();    
        Field[] declaredFields = obj.getClass().getDeclaredFields();    
        for (Field field : declaredFields) {    
            field.setAccessible(true);  
            try {
            	if(field.get(obj)!=null) {
				  map.put(field.getName(), field.get(obj));
            	}
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}  
        }
		return map;
	}
	
	public static Map<String, Object> covertStringToMp(String params, String regx) {
	    if(params==null)  return null;
		String [] params_array =params.split(regx);
		Map<String, Object> paramsmp = new HashMap<String, Object>();
		if(params!=null&&!"".equals(params)) {
		for (String header : params_array) {
			String[] keys = header.split("=");
			if(keys.length>1) {
				paramsmp.put(keys[0], keys[1]);
			}
		}
		}
		return paramsmp;
	}
	
	public static Map<String, Object> covertStringToMp(String params) {
		return covertStringToMp(params, ";");
	}
	
	public static void main(String[] args) {
		String teString="method=loginMobile&loginname=test1&loginpass=test1";
		Map<String, Object> mp1 = covertStringToMp(teString, "&");
		System.out.println(mp1);
		String test1="token=11;user=123;";
		Map<String, Object> mp2 = covertStringToMp(test1);
		System.out.println(mp2);
	}

}
