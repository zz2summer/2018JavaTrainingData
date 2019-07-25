package dao;

import beans.*;
import manager.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

/**
 * �������User�������ݿ��е�����
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
	 * �޲ι��캯��
	 * 
	 */
	public UserDAO() {
	}

	/**
	 * ��֤�û�Ȩ��
	 */
	public boolean userTest(User u) {
		// ��ѯ���ݿ��SQL���
		String sql = "select * from user where name=\'" + u.getName()
				+ " \'and pass =\'" + u.getPass() + "\'";
		
		conn = manager.getConnection();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			// �ж��û��Ƿ������ݿ���
			if (rs.next()) {
				return true;	// �ڣ�������
			} else {
				return false;	// ���ڣ����ؼ�
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			// �ر����ݿ�����
			manager.closeAll(rs,stmt,conn);
		}
		return false;
	}
	
	/**
	 * ����һ���û�����USER��
	 * @param user
	 */
	public void insertUser(User user) {
		String sql = "insert into user(name,pass,role,realName,phone,email,address,age,sex,registerDate) values(?,?,?,?,?,?,?,?,?,?)";
		
		try {
			
			// ������ݿ�����
			conn = manager.getConnection();
			// ���Ԥ��������
			pstmt = conn.prepareStatement(sql);
			// ���ν����Բ������ݿ�
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
			// �ر����ݿ�����
			manager.closeAll(rs,stmt,conn);
		}
	}
	
	/**
	 * ����������ѯһ��USER����
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
	 * �ж��Ƿ��ǹ���Ա
	 * @param u
	 * 			
	 * @return
	 * 		����ǹ���Ա��������
	 * 		���Ƿ��ؼ�
	 */
	public boolean adminTest(String name,String password){
		if("admin".equals(name)&"admin".equals(password)){
			return true;
		}else
			return false;
		//��ѯ���ݿ��SQL���
		//String sql = "select * from user where name=\'" + name
		//		+ " \'and pass=\'" + password+"\'and role=0";
		//conn = manager.getConnection();
		//try {
		//	stmt = conn.createStatement();
		//	rs = stmt.executeQuery(sql);
			// �ж��û��Ƿ������ݿ���
		//	if (rs.next()) {
				//return true;	// �ڣ�������
		//	} else {
				//return false;	// ���ڣ����ؼ�
		//	}

	//	} catch (SQLException e) {
			//e.printStackTrace();

	//	} catch (Exception e) {
		//	e.printStackTrace();
	//	}

	//	finally {
			// �ر����ݿ�����
		//	manager.closeAll(rs,stmt,conn);
		//}
	//	return false;
	}
	
	
	
}
