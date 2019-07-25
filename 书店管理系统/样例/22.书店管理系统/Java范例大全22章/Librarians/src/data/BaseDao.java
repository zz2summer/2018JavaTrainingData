package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Book;
import entity.Reader;

public class BaseDao {
	protected static String driver = "com.mysql.jdbc.Driver"; // 数据库驱动

	protected static String url = "jdbc:mysql://localhost:3306/myuser"; // 连接url

	protected static String dbUser = "root"; // 数据库用户名

	protected static String dbPwd = "root"; // 数据库密码

	private static Connection conn = null;

	// 构造方法，创建数据库连接
	private BaseDao() {
		try {
			if (conn == null) {
				Class.forName(driver); // 加载数据库驱动
				conn = DriverManager.getConnection(url, dbUser, dbPwd); // 建立数据库连接
			} else
				return;
		} catch (Exception ee) {
			ee.printStackTrace();
		}
	}

	// 执行数据库查询操作
	public static ResultSet executeQuery(String sql) {
		try {
			if (conn == null)
				new BaseDao();
			return conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE).executeQuery(sql); // 执行数据库查询
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	// 执行数据库更新操作
	public static int executeUpdate(String sql) {

		try {
			if (conn == null)
				new BaseDao();
			return conn.createStatement().executeUpdate(sql); // 执行数据库更新
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return -1;
		} finally {
		}
	}

	public static void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn = null;
		}
	}

}