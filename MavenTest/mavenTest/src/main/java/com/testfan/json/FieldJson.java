package com.testfan.json;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class FieldJson {
	public static void main(String[] args) {
		Map<String,Object> map = new HashMap<String,Object>();
	  	map.put("name", "zhansan");
	  	map.put("age", 12);
	  	map.put("sex", "男");
	  	map.put("test", null);
    	String reString=JSONObject.toJSONString(map, SerializerFeature.MapSortField,SerializerFeature.WriteNullStringAsEmpty);
        System.out.println(reString);
        
//        Student student=new Student();
//        student.setAge(15);
//        student.setName("xiaoming");
//        System.out.println(JSON.toJSONString(student));
		
	}
	
	
   
	
  
}
