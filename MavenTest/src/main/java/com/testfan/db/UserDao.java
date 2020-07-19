package com.testfan.db;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;

public class UserDao {
	
	public static List<User> getAll() throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "select * from t_user_testfan limit 100";
        List<User> list = (List) runner.query(sql, new BeanListHandler(User.class));
        return list;
    }
	
	public static User getById(String id) throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "select * from t_user_testfan where uid=?";
        User user=  (User) runner.query(sql, new BeanHandler(User.class),id);
        return user;
    }
	
	public static List getallObject() throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "select * from t_user_testfan";
        List list = runner.query(sql, new ArrayListHandler());
        return list;
    }
	
	public static void delete(String  uid) throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "delete from t_user_testfan where uid =? ";
        runner.update(sql,uid);
    }
	
	 public static void batch() throws SQLException {
	        QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
	        String sql = "insert into t_user_testfan(uid,loginname,loginpass) values(?,?,?)";
	        Object[][] params = new Object[10][3];
	        for (int i = 0; i < params.length; i++) {
	            params[i] = new Object[]{UUID.randomUUID().toString(), "loginname"+UUID.randomUUID().toString(), "loginpass"+i};
	        }
	        runner.batch(sql, params);
	    }
	
	public static void main(String[] args) {
		try {
//			List<User> list = UserDao.getAll();
//			for (User user : list) {
//				System.out.println(user);
//			}
//			User user = getById("0003bc7f-0af7-48f8-b406-5adc7f391bf3");
//			System.out.println(user);
//			List<Object[]> list= getallObject();
//			for (Object[] object : list) {
//				System.out.println(object[1]);
//			}
			delete("04d5486c-fdd5-4af6-9704-2e69ea50ed33");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
