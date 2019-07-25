package manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * ���������������ݿ�,�ر����ݿ�
 * 
 * @author Cute Code
 * 
 */
public class DBManager {
	/**
	 * �޲ι��캯��
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
	 * ������ݿ����Ӷ���
	 * 
	 * @return conn ���ݿ����Ӷ���
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
	 * �ر����ݿ�
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
