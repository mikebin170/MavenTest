package com.testfan.json;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonTest {
	
public static void main(String[] args) {
		
		String json = "{\"name\":\"小民\",\"age\":20,\"date\":1465475917155}";
		
		String jsonString = "[{\"age\":12,\"date\":1465475917155,\"name\":\"s1\"},"
        		+ "{\"age\":12,\"date\":1465475917175,\"name\":\"s2\"},"
        		+ "{\"age\":12,\"date\":1465475917175,\"name\":\"s3\"},"
        		+ "{\"age\":12,\"date\":1465475917175,\"name\":\"s4\"},"
        		+ "{\"age\":12,\"date\":1465475917175,\"name\":\"s5\"},"
        		+ "{\"age\":12,\"date\":1465475917175,\"name\":\"s6\"}]";  
		
		ObjectMapper mapper = new ObjectMapper();  
		
		try {
			//单个对象
			Student student = mapper.readValue(json, Student.class);
			System.out.println(student);
			
//			//多个对象 不支持
//			List<Student> studentList = (List<Student>) mapper.readValue(jsonString, Student.class);
//			System.out.println(studentList);
			
			
			//多个对象
//			long start =System.currentTimeMillis();
//			JavaType javaType = mapper.getTypeFactory().constructParametricType(List.class, Student.class);  
//			List<Student> studentList = (List<Student>) mapper.readValue(jsonString, javaType);
//			 for (Student student2 : studentList) {
//					System.out.println(student2);
//				}
//			System.out.println("read it tooks "+(System.currentTimeMillis()-start));
//            
//			//对象转字符串
//			long start1 =System.currentTimeMillis();
//			String jsonlist = mapper.writeValueAsString(studentList);
//			System.out.println(jsonlist);
//			System.out.println(" it tooks write "+(System.currentTimeMillis()-start1));
//			
			//时间格式化 注解
			//@JsonFormat(pattern = "yyyy-MM-dd HH-mm-ss") 
			//修改属性
			//@JsonProperty(value = "test")
			Student s = new Student();
			s.setName("123");
			s.setAge(12);
			System.out.println(mapper.writeValueAsString(s));
			//属性 忽略  @JsonIgnore 
			//Fastjson Ignore
		} catch (IOException e) {
			e.printStackTrace();
		}  
	}
}
