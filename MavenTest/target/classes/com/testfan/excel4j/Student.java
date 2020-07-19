package com.testfan.excel4j;

import com.github.crab2died.annotation.ExcelField;

public class Student {
	
	 /**
     * id   
     */
	@ExcelField(title = "header1")
    private String id;
    /**
     * 学号
     */
	@ExcelField(title = "header2")
    private String no;
    /**
     * 姓名
     */
	@ExcelField(title = "header3")
    private String name;
    /**
     * 学院
     */
	@ExcelField(title = "header4")
    private String age;
    /**
     * 成绩
     */
	@ExcelField(title = "header5")
    private String score;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }


	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", no=" + no + ", name=" + name + ", age=" + age + ", score=" + score + "]";
	}
}
