package book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * javabean文件
 * 
 * @author acer
 * 
 */
public class bk {

	String sDBDriver = "com.mysql.jdbc.Driver";
	// 数据库的用户名和密码
	final String db_user = "root";
	final String db_password = "123456";
	Connection conn = null;
	ResultSet rs = null;

	public ResultSet executeQuery(String sql) {
		rs = null;
		try {
			Class.forName(sDBDriver);
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/test", db_user,
					db_password);
			Statement stmt = conn.createStatement();
			// stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
			// ResultSet.CONCUR_READ_ONLY);
			rs = stmt.executeQuery(sql);
			System.out.println("执行到了这里!!!");
		} catch (Exception e) {
			System.err.println("aq.executeQuery:" +sql);
		}
		return rs;
	}
	
	public void executeUpdate(String sql) {
		try {
			Class.forName(sDBDriver);
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/webstore", db_user,
					db_password);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			System.out.println("执行到了这里!!!");
		} catch (Exception e) {
			System.err.println("aq.executeQuery:" +sql);
		}
		 
	}
	
	
	
	
}
