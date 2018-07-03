package com.testfan.json;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import com.fasterxml.jackson.databind.SerializationFeature;

public class FastJsonTest {
	
	public static void main(String[] args) {
		    String jsonString1 = "{\"param5\":\"value5\",\"param3\":\"value3\",\"param4\":\"value4\",\"param1\":\"value1\",\"param2\":\"value2\"}";  
	        System.out.println(jsonString1);  
	        JSONObject object = (JSONObject) JSON.parse(jsonString1);
	        System.out.println(object);
	        
	        System.out.println(object.get("param5"));
	        
	        String jsonString2 = "[{\"param5\":\"value5\",\"param3\":\"value3\",\"param4\":\"value4\",\"param1\":\"value1\",\"param2\":\"value2\"},"
	        		+ "{\"p1\":\"v1\",\"p2\":\"v2\",\"p3\":\"v3\",\"p4\":\"v4\",\"p5\":\"v5\"}]";  
	        JSONArray arry=  JSON.parseArray(jsonString2);
	        for (int i = 0; i < arry.size(); i++) {
	        	JSONObject obj = (JSONObject) arry.get(i);
	        	System.out.println(obj);
			}
	         
	        //解析有规律的
	        String jsonString3 = "[{\"age\":12,\"date\":1465475917155,\"name\":\"s1\"},"
	        		+ "{\"age\":12,\"date\":1465475917175,\"name\":\"s2\"},"
	        		+ "{\"age\":12,\"date\":1465475917175,\"name\":\"s3\"},"
	        		+ "{\"age\":12,\"date\":1465475917175,\"name\":\"s4\"},"
	        		+ "{\"age\":12,\"date\":1465475917175,\"name\":\"s5\"},"
	        		+ "{\"age\":12,\"date\":1465475917175,\"name\":\"s6\"}]";
	        
	        List<Student> studentList = JSON.parseArray(jsonString3,Student.class); 
	        for (Student student : studentList) {
				System.out.println(student);
			}
	      
//	        
//	        //有时候走读开发代码时候看到，解析成对象的另一种方式  
//	        List<Student> studentList2 = JSON.parseObject(jsonString3,new TypeReference<List<Student>>(){});  
//	        for (Student student : studentList2) {  
//	            System.out.println(student);  
//	        } 
//	        
//	        //对象转json
	        long start =System.currentTimeMillis();
	        String jsonString = JSON.toJSONString(studentList);
	        System.out.println("javabean to json"+jsonString);
	        System.out.println("read it tooks "+(System.currentTimeMillis()-start));
//	        //时间格式化问题 
//	        //方案1
//	       String dateFormat =  JSON.toJSONStringWithDateFormat(studentList, "yyyy-MM-dd HH:mm:ss");
//	       System.out.println("dataformat "+ dateFormat);
//	       //方案2
//	       //@JSONField (format="yyyy-MM-dd HH:mm:ss") 
	        
	        // 修改 json 字符串名称 @JSONField(name="ID") 用法
	        // @JSONField (name="myname") 
	        Student student=new Student();
	        student.setAge(15);
	        student.setName("xiaoming");
	       // student.setDate(1465475917155);
	        SimplePropertyPreFilter filter = new SimplePropertyPreFilter();
	        filter.getExcludes().add("name");
	        System.out.println(JSON.toJSONString(student));
	        
	        Map<String,Object> map = new HashMap<String,Object>();
	    	map.put("name", "zhansan");
	    	map.put("age", 12);
	    	map.put("sex", "男");
	    	map.put("test", null);
	    	String reString=JSONObject.toJSONString(map, SerializerFeature.MapSortField,SerializerFeature.WriteNullStringAsEmpty);
	    	System.out.println(reString);
	}

}
