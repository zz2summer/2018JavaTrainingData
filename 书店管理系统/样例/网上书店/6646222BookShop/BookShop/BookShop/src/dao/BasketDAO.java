package dao;

import java.sql.*;
import beans.*;
import java.util.ArrayList;
import manager.DBManager;
import beans.BookCategory;

/**
 * 实现对购物车的管理
 * @author CuteCode
 *
 */
public class BasketDAO {
	
	
	/**
	 * 删除购物车中的一条记录
	 * @param id
	 */
	public void deleteBasket(String id){
		
		String delete;
		if(!id.equals("")){
			delete = "delete from basket where id="+id+";";
		}else{
			
			delete = "delete from basket;";
		}
		
		DBManager dbm = null;
		Connection conn= null;
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
	 * 向购物车中插入一条记录
	 * @param basket
	 */
	public void insertBasket(Basket basket){
		
		
		String name=basket.getName();
		float unitPrice = basket.getUnitPrice();
		float totalPrice = basket.getTotalPrice();
		int number = basket.getNumber();
		Date date = basket.getAddDate();
		int bookId = basket.getBookId();
		String userName = basket.getUserName();
		DBManager manager = new DBManager();
		String insert = "insert into basket(userName,name,unitPrice,number,totalPrice,addDate,bookId)" +
						"values(?,?,?,?,?,?,?);";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = manager.getConnection();
			pstmt = conn.prepareStatement(insert);
			pstmt.setString(1, userName);
			pstmt.setString(2,name);
			pstmt.setFloat(3, unitPrice);
			pstmt.setInt(4,number);
			pstmt.setFloat(5,totalPrice);
			pstmt.setDate(6,date);
			pstmt.setInt(7,bookId);
			pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			manager.closeAll(rs, pstmt, conn);
		}
		
	}
	/**
	 * 按照用户名来查询对应的购物车记录
	 * @param userName
	 * @return
	 */
	public ArrayList querryBasket(String userName){
		
		String querry = "select * from basket where userName=\'"+userName+"\';";
		DBManager dbm = null;
		Connection conn= null;
		Statement stmt = null;
		ResultSet rs = null;
		Basket  bt = null;
		ArrayList allBasket = new ArrayList();
		try{
			dbm = new DBManager();
			
			conn = dbm.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(querry);
			
			while(rs.next()){
				bt = new Basket();
				bt.setId(rs.getInt(1));
				bt.setUserName(rs.getString(2));
				bt.setName(rs.getString(3));
				bt.setUnitPrice(rs.getFloat(4));
				bt.setNumber(rs.getInt(5));
				bt.setTotalPrice(rs.getFloat(6));
				bt.setAddDate(rs.getDate(7));
				bt.setBookId(rs.getInt(8));
				allBasket.add(bt);
				bt=null;
			}
			return allBasket;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			dbm.closeAll(rs, stmt, conn);
		}
		return allBasket;
		
		
	}
}
