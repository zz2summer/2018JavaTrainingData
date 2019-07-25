package manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 该类用于连接数据库,关闭数据库
 * 
 * @author Cute Code
 * 
 */
public class DBManager {
	/**
	 * 无参构造函数
	 * 
	 */
	public DBManager() {

	}

	private Connection conn = null;

	private Statement stmt = null;

	private ResultSet rs = null;

	private String url = "jdbc:mysql://localhost:3306/bookshop?autoReconnect=true&UseUnicode=true&"
			+ "characterEncoding=UTF-8";

	private String username = "root";

	private String password = "12345";

	/**
	 * 获得数据库连接对象
	 * 
	 * @return conn 数据库连接对象
	 */
	public Connection getConnection() {

		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();

			conn = DriverManager.getConnection(url, username, password);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn;
	}

	/**
	 * 关闭数据库
	 */
	public void closeAll(ResultSet rs,Statement stmt,Connection conn) {

		try {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
