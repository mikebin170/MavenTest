package com.testfan.excel4j;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.github.crab2died.ExcelUtils;
import com.github.crab2died.sheet.wrapper.NoTemplateSheetWrapper;

public class ExcelUtils4JTest {
	
	public static void main(String[] args) {
		String path =System.getProperty("user.dir")+File.separator+"data"+File.separator+"test.xlsx";
		
		try {
			List<Student> list = ExcelUtils.getInstance().readExcel2Objects(path, Student.class);
			for (Student student : list) {
				System.out.println(student);
			}
//			
//	       ExcelUtils.getInstance().exportObjects2Excel(list, Student.class, "e:/result.xlsx");
	       
		   //多sheet 操作
//	       List<NoTemplateSheetWrapper> sheets = new ArrayList<NoTemplateSheetWrapper>();
//
//	        for (int s = 0; s < 3; s++) {
//	            List<Student> list = new ArrayList<>();
//	            for (int i = 0; i < 1000; i++) {
//	                list.add(new Student(""+i, "学生" + i, "20", "90", 99l));
//	            }
//	            sheets.add(new NoTemplateSheetWrapper(list, Student.class, true, "sheet_" + s));
//	        }
//	        ExcelUtils.getInstance().noTemplateSheet2Excel(sheets, "e:/EE.xlsx");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

