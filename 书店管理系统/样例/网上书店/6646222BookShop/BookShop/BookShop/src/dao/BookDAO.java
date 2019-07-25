package dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import manager.*;
import beans.*;

/**
 * 实现对BOOK的管理
 * 版本1.0
 * 作者：CuteCode
 *
 */
public class BookDAO {
	
	/**
	 * 根据编号来查询BOOK
	 * @param id
	 * @return BOOK对象
	 */
	public Book querryUseId(int bookId){
		DBManager manager = null;
		String querry = "select * from book where id = "+ bookId +";";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Book book = null;
		try{
			book = new Book();
			manager = new DBManager();
			conn = manager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(querry);
			
			while(rs.next()){
				book.setId(rs.getInt(1));
				book.setName(rs.getString(2));
				book.setAuthor(rs.getString(3));
				book.setBookman(rs.getString(4));
				book.setPrice(rs.getFloat(5));
				book.setCategoryId(rs.getInt(6));
				book.setIntroduction(rs.getString(7));
				book.setOnSaleDate(rs.getDate(8));
				book.setOnSaleNum(rs.getInt(9));
				book.setRemainNum(rs.getInt(10));
			
				return book;
			}
			
			return book;
		}catch(Exception e ){
			e.printStackTrace();
		}finally{
			manager.closeAll(rs, stmt, conn);
		}
		return book;
	}
	
	/**
	 * 查询所有的图书
	 * @return ARRAYLIST 查询结果
	 */
	public ArrayList querryAllBooks(){
		String querry = "select * from book;";
		
		ArrayList al = null;
		DBManager dbm = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs= null;
		
		try{
			dbm = new DBManager();
			conn = dbm.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(querry);
			al = new ArrayList();
			
			while(rs.next()){
				Book bk = new Book();
				bk.setId(rs.getInt(1));
				bk.setName(rs.getString(2));
				bk.setAuthor(rs.getString(3));
				bk.setBookman(rs.getString(4));
				bk.setPrice(rs.getFloat(5));
				bk.setCategoryId(rs.getInt(6));
				bk.setIntroduction(rs.getString(7));
				bk.setOnSaleDate(rs.getDate(8));
				bk.setOnSaleNum(rs.getInt(9));
				bk.setRemainNum(rs.getInt(10));		
				
				al.add(bk);
			}
			
			return al;
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			dbm.closeAll(rs, stmt, conn);
		}
		
		return al;
	}
	
		
	
	
	/**
	 * 插入一本书到数据库
	 * @param book
	 */
	public void insert(Book book){
		DBManager manager = null;
		String insert = "insert into book(name,author,bookman,price,categoryId,introduction,onSaleDate,onSaleNum,remainNum)" +
						"values(?,?,?,?,?,?,?,?,?);";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			manager = new DBManager();
			conn = manager.getConnection();
			pstmt = conn.prepareStatement(insert);
			pstmt.setString(1, book.getName());
			pstmt.setString(2, book.getAuthor());
			pstmt.setString(3,book.getBookman());
			pstmt.setDouble(4,book.getPrice());
			pstmt.setInt(5,book.getCategoryId());
			pstmt.setString(6,book.getIntroduction());
			pstmt.setDate(7,book.getOnSaleDate());
			pstmt.setInt(8,book.getOnSaleNum());
			pstmt.setInt(9,book.getRemainNum());
			
			pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			manager.closeAll(rs, pstmt, conn);
		}
	}
	
	/**
	 * 根据ID删除一本书
	 * @param bookId
	 */
	public void delete(int bookId){
		String delete = "delete from book where id = "+ bookId+ ";";
		
		DBManager dbm = null;
		Connection conn = null;
		Statement stmt = null;
		try{
			dbm = new DBManager();
			conn = dbm.getConnection();
			stmt = conn.createStatement();
			stmt.executeUpdate(delete);
		}catch(Exception e){
			e.printStackTrace()
			;
		}finally{
			dbm.closeAll(null, stmt, conn);
		}
	}
	
	/**
	 * 更新一本书的信息
	 * @param book
	 */
	public void update(Book book){
		String update = "update book set name = ?,author =?, bookman =?,price=?," +
				"categoryId=?,introduction=?,onSaleDate=?,onSaleNum =?,remainNum=? where id = "+ book.getId();
		
		DBManager dbm = null;
		Connection conn= null;
		PreparedStatement pstmt = null;
		
		try{
			dbm = new DBManager();
			conn= dbm.getConnection();
			pstmt = conn.prepareStatement(update);
			
			pstmt.setString(1,book.getName());
			pstmt.setString(2,book.getAuthor());
			pstmt.setString(3,book.getBookman());
			pstmt.setFloat(4,book.getPrice());
			pstmt.setInt(5, book.getCategoryId());
			pstmt.setString(6,book.getIntroduction());
			pstmt.setDate(7,book.getOnSaleDate());
			pstmt.setInt(8, book.getOnSaleNum());
			pstmt.setInt(9,book.getRemainNum());
			
			pstmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			dbm.closeAll(null, pstmt, conn);
		}
	}
	
	/**
	 * 更新书的数量
	 * @param bookId
	 * @param saleNum
	 */
	public void updateNum(int bookId,int saleNum){
		
		String querry = "select * from book where id="+bookId;
		String sql;
		
		DBManager dbm = null;
		Connection conn = null;
		Statement stmt = null;	
		try{
			ResultSet rs = null;
			dbm = new DBManager();
			conn = dbm.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(querry);
			int num=0;
			if(rs.next()){
				
			 num = rs.getInt(10);
			
			}
			sql= "update book set remainNum ="+(num-saleNum)+" where id="+ bookId+ ";";
			stmt.executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace()
			;
		}finally{
			dbm.closeAll(null, stmt, conn);
		}
		
	}
	
	
}
