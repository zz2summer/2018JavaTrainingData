package dao;

import beans.*;
import manager.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

/**
 * 该类操作User类在数据库中的数据
 * 
 * @author Cute Code
 * 
 */
public class UserDAO {

	private Connection conn = null;

	private Statement stmt = null;

	private ResultSet rs = null;
	
	private PreparedStatement pstmt = null;

	DBManager manager = new DBManager();

	/**
	 * 无参构造函数
	 * 
	 */
	public UserDAO() {
	}

	/**
	 * 验证用户权限
	 */
	public boolean userTest(User u) {
		// 查询数据库的SQL语句
		String sql = "select * from user where name=\'" + u.getName()
				+ " \'and pass =\'" + u.getPass() + "\'";
		
		conn = manager.getConnection();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			// 判断用户是否在数据库中
			if (rs.next()) {
				return true;	// 在，返回真
			} else {
				return false;	// 不在，返回假
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			// 关闭数据库连接
			manager.closeAll(rs,stmt,conn);
		}
		return false;
	}
	
	/**
	 * 插入一个用户对象到USER表
	 * @param user
	 */
	public void insertUser(User user) {
		String sql = "insert into user(name,pass,role,realName,phone,email,address,age,sex,registerDate) values(?,?,?,?,?,?,?,?,?,?)";
		
		try {
			
			// 获得数据库连接
			conn = manager.getConnection();
			// 获得预处理结果集
			pstmt = conn.prepareStatement(sql);
			// 依次将属性插入数据库
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getPass());
			pstmt.setString(3, String.valueOf(user.getRole()));
			pstmt.setString(4, user.getRealName());
			pstmt.setString(5, user.getPhone());
			pstmt.setString(6, user.getEmail());
			pstmt.setString(7, user.getAddress());
			pstmt.setString(8, String.valueOf(user.getAge()));
			pstmt.setString(9, user.getSex());
			pstmt.setString(10, String.valueOf(user.getRegisterDate()));
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();

		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			// 关闭数据库连接
			manager.closeAll(rs,stmt,conn);
		}
	}
	
	/**
	 * 根据姓名查询一个USER对象
	 * @param name
	 * @return
	 */
	public User querryUseName(String name){
		String querry = "select * from user where name = \'"+ name+"\';";
		User u = null;
		DBManager dbm = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs= null;
		
		try{
			dbm = new DBManager();
			conn = dbm.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(querry);
			
			while(rs.next()){
				u = new User();
				u.setId(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setPass(rs.getString(3));
				u.setRole(rs.getInt(4));
				u.setRealName(rs.getString(5));
				u.setPhone(rs.getString(6));
				u.setEmail(rs.getString(7));
				u.setAddress(rs.getString(8));
				u.setAge(rs.getInt(9));
				u.setSex(rs.getString(10));
				u.setRegisterDate(rs.getDate(11));
				
			}
			
			return u;
		}catch(Exception e){
			e.printStackTrace();
		}finally{}
		return u;
	}
	
	/**
	 * 判断是否是管理员
	 * @param u
	 * 			
	 * @return
	 * 		如果是管理员，返回真
	 * 		不是返回假
	 */
	public boolean adminTest(String name,String password){
		if("admin".equals(name)&"admin".equals(password)){
			return true;
		}else
			return false;
		//查询数据库的SQL语句
		//String sql = "select * from user where name=\'" + name
		//		+ " \'and pass=\'" + password+"\'and role=0";
		//conn = manager.getConnection();
		//try {
		//	stmt = conn.createStatement();
		//	rs = stmt.executeQuery(sql);
			// 判断用户是否在数据库中
		//	if (rs.next()) {
				//return true;	// 在，返回真
		//	} else {
				//return false;	// 不在，返回假
		//	}

	//	} catch (SQLException e) {
			//e.printStackTrace();

	//	} catch (Exception e) {
		//	e.printStackTrace();
	//	}

	//	finally {
			// 关闭数据库连接
		//	manager.closeAll(rs,stmt,conn);
		//}
	//	return false;
	}
	
	
	
}
