package com.testfan.file;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class FileUtilsTest {
	
	public static void main(String[] args) throws IOException {
		String path =System.getProperty("user.dir") + File.separator + "data" + File.separator;
		String source = path+ "person.xml";
		String dest =path + "person2.xml";
//        try {
//			FileUtils.copyFile(new File(source), new File(dest));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
        
//        List<String> lines=FileUtils.readLines(new File(source),"utf-8");  
//        for (String line : lines) {
//			System.out.println(line);
//		}
        
        String str = FileUtils.readFileToString(new File(source), "utf-8"); 
        System.out.println(str);
	}

}
