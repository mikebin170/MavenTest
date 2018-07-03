package com.testfan.json;

import java.io.Serializable;
import java.util.Date;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;


public class Student   implements Serializable{
	//@JSONField (name="myname") 
	//@JSONField(name="myname",serialize=false)
	//@JsonIgnore 
	private String name; 
	
	//@JsonProperty("agesss")
    private int age; 
   // @JsonFormat(pattern = "yyyy-MM-dd HH-mm-ss") 
    private Date date;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", date=" + date + "]";
	}
}
