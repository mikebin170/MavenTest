package com.testfan.file;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.io.FileUtils;

import com.testfan.db.JDBCUtils;
import com.testfan.db.User;

public class CsvFromDb {
	
	public static void main(String[] args) throws Exception {
		    QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
	        String sql = "select * from t_user limit 100";
	        List<User> list = (List) runner.query(sql, new BeanListHandler(User.class));
	        File file= new File("D:/fileUtis/targetFile/aa.csv");
	        if(file.exists()) {
	        	FileUtils.forceDelete(file);
	        }
	        for (User user : list) {
	        	System.out.println(user);
	        	FileUtils.write(file, user.toString(),"utf-8",true);
			}
	}

}
