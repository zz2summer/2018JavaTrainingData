package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import beans.*;
import manager.*;

import java.util.ArrayList;

/**
 * ʵ��ͼ��������
 * �汾 1.0
 * ���ߣ�CuteCode
 * 
 */

public class BookCategoryDAO {
	
	
	/**
	 * �������������ѯ��Ӧ�������󷵻�
	 * @param id
	 * @return
	 */
	
	public BookCategory querryUseName(String name) {
		String querry = "select * from bookcategory where name = \'"+name+"\';";
		DBManager dbm = null;
		Connection conn= null;
		Statement stmt = null;
		ResultSet rs = null;
		BookCategory  bc = null;
		try{
			dbm = new DBManager();
			bc = new BookCategory();
			conn = dbm.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(querry);
			
			while(rs.next()){
				bc.setId(rs.getInt(1));
				bc.setName(rs.getString(2));
			}
			return bc;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			dbm.closeAll(rs, stmt, conn);
		}
		return null;
	}
	
	/**
	 * ����ID����ѯ��Ӧ��������
	 * @param id
	 * @return ������
	 */
	public BookCategory querry(int id){
		String querry = "select * from bookcategory where id = "+id+";";
		DBManager dbm = null;
		Connection conn= null;
		Statement stmt = null;
		ResultSet rs = null;
		BookCategory  bc = null;
		try{
			dbm = new DBManager();
			bc = new BookCategory();
			conn = dbm.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(querry);
			
			while(rs.next()){
				bc.setId(rs.getInt(1));
				bc.setName(rs.getString(2));
			}
		return bc;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			dbm.closeAll(rs, stmt, conn);
		}
		return bc;
	}
	
	
	/**
	 * ��һ����������뵽���ݿ���
	 * @param bc
	 */
	public void insert(BookCategory bc){
		String insert = "insert into bookcategory(name) values(?);";
		DBManager dbm = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		System.out.println("wwwwwww");
		try{
			dbm = new DBManager();
			conn = dbm.getConnection();
			
			pstmt = conn.prepareStatement(insert);
			//System.out.println(bc.getName());
			pstmt.setString(1, bc.getName());
			
			pstmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			dbm.closeAll(null, pstmt, conn);
		}
	}
	
	/**
	 * ����ID��ɾ��һ��������
	 * @param id
	 */
	public void delete(int id){
		
		String delete = "delete from bookcategory where id = "+id+";";
		
		DBManager dbm = null;
		Connection conn = null;
		Statement stmt = null;
		
		try{
			dbm = new DBManager();
			conn = dbm.getConnection();
			stmt = conn.createStatement();
			stmt.executeUpdate(delete);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			dbm.closeAll(null, stmt, conn);
		}
	}
	
	/**
	 * ����һ��������
	 * @param bc
	 */
	public void update(BookCategory bc){
		String update = "update bookcategory set name = ?  where id = "+ bc.getId()+";";
		DBManager dbm = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			dbm = new DBManager();
			conn = dbm.getConnection();
			pstmt = conn.prepareStatement(update);
			pstmt.setString(1,bc.getName());
			pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			dbm.closeAll(null, pstmt, conn);
		}
	}
	
	/**
	 * ��ѯ����ͼ�����
	 * @return
	 */
	public ArrayList querryCategory() {
		String sql = "select * from bookcategory";
		DBManager dbm = null;
		Connection conn= null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList categoryList = null;
		try {
			dbm = new DBManager();
			conn = dbm.getConnection();
			stmt = conn.createStatement();
			categoryList = new ArrayList();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				BookCategory bc =new BookCategory();
				bc.setId(rs.getInt(1));
				bc.setName(rs.getString(2));
				categoryList.add(bc);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbm.closeAll(rs,stmt,conn);
			return categoryList;
		}
	}
	
	/**
	 * ��ѯ���е�ͼ�����
	 * @return
	 */
	public ArrayList querryAllCategory(){
		String querry = "select * from bookcategory;";
		DBManager dbm = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs= null;
		ArrayList al = null;
		BookCategory bc = null;
		
		
		try{
			dbm = new DBManager();
			conn = dbm.getConnection();
			stmt = conn.createStatement();
			rs= stmt.executeQuery(querry);
			al = new ArrayList();
			
			while(rs.next()){
				bc = new BookCategory();
				bc.setId(rs.getInt(1));
				bc.setName(rs.getString(2));
				al.add(bc);
			}
			return al;
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			dbm.closeAll(rs, stmt, conn);
		}
		return al;
	}
	
}
