package com.testfan.reflect;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConstructorUtils;
import org.apache.commons.beanutils.MethodUtils;

public class TestCopy {
	
	public static void main(String[] args) {
		Person p1  = new Person("zhangsan", 20);
		com.testfan.Person p2 = new com.testfan.Person();
		
//		Map<String,Object> map = new HashMap<String,Object>();
//		map.put("name", "test1");
//		map.put("age", "20");
		try {
			 BeanUtils.copyProperties(p2, p1);
			 System.out.println(p2);
			 BeanUtils.setProperty(p2, "name", "1111");
			 System.out.println(p2);
			//copy(p1, p2);
			 MethodUtils.invokeMethod(p2, "setName", "test");
			 System.out.println(p2);
			 
			 com.testfan.Person person1 = ConstructorUtils.invokeConstructor(com.testfan.Person.class,
	            new Object[] { "zhansantest", 20});
			 
			System.out.println(person1);
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void copy(Object from, Object to) throws Exception {
		Class clz1= from.getClass();
		Class clz2 = to.getClass();
		Field[] clzflist = clz1.getDeclaredFields();
		for (Field f : clzflist) {
			f.setAccessible(true);
			String name = f.getName();
			Object fvalue  = f.get(from);
			System.out.println(name+ " "+fvalue);
			//赋值
			Field f2 = clz2.getDeclaredField(f.getName());
			f2.setAccessible(true);
			f2.set(to, fvalue);
		}
	}

}
