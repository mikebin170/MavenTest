package com.testfan.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ReadDB {
	
	private static Connection getConn() {
		try {
			return JDBCUtils.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static List<User> query() {
	    Connection conn = getConn();
	    int i = 0;
	    String sql = "SELECT * FROM t_user_testfan  limit 1,100";
	    PreparedStatement pstmt = null;
	    List<User> list = new ArrayList<User>();
	    try {
	        pstmt = (PreparedStatement) conn.prepareStatement(sql);
	        ResultSet st = pstmt.executeQuery();
	        int count=0;
	        while(st.next()) {
	        	User user =  new User();
	        	System.out.print(st.getString("uid"));
	        	user.setUid(st.getString("uid"));
	        	System.out.print(st.getString("loginname"));
	        	user.setLoginname(st.getString("loginname"));
	        	System.out.print(st.getString("loginpass"));
	        	user.setLoginpass(st.getString("loginname"));
	        	//System.out.println("------------"+count++ );
	        	list.add(user);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }finally {
	    	  try {
				 pstmt.close();
				 conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	    return list;
	}
	
	public static void main(String[] args) {
		List<User> users = query();
		for (User user : users) {
			System.out.println(user);
		}
	}

}
