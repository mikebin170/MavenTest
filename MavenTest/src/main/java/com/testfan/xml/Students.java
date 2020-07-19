package com.testfan.xml;

import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="students")
public class Students {

    private List<Student> students;
    
    private String country;
    
    private String txt;
    

    public String getTxt() {
		return txt;
	}

	public void setTxt(String txt) {
		this.txt = txt;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@XmlElement(name="student")
    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
    
    public static void main(String[] args) {
    	JAXBContext jc;
		try {
			jc = JAXBContext.newInstance(Students.class);
			Marshaller ms = jc.createMarshaller();  
	        Students st = new Students(); 
	        st.setCountry("中国");
	        ms.marshal(st, System.out);  
		} catch (JAXBException e) {
			e.printStackTrace();
		}  
        
	}
}
