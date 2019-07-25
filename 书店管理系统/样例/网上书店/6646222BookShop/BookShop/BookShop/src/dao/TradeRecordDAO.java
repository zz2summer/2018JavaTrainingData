package dao;

import beans.*;
import manager.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
/**
 * 该类操作TradeRecord在数据库中的数据
 * 
 * @author Cute Code
 *
 */
public class TradeRecordDAO {
	// 数据库连接
	private Connection conn = null;
	// 会话
	private Statement stmt = null;
	// 结果集
	private ResultSet rs = null;
	// 预处理结果集
	private PreparedStatement pstmt = null;

	DBManager manager = new DBManager();
	
	public TradeRecordDAO() {
		
	}
	
	/**
	 * 将一个交易记录对象插入到数据库中
	 * @param tr
	 */
	public void insertRecord(TradeRecord tr) {
		// 数据库插入语句
		String sql = "insert into traderecord(userId,bookId,tradeNum,sum) values(?,?,?,?)";
		
		try {
			// 获得数据库连接
			conn = manager.getConnection();
			// 获得预处理结果集
			pstmt = conn.prepareStatement(sql);
			// 依次将属性插入数据库
			pstmt.setString(1, String.valueOf(tr.getUserId()));
			pstmt.setString(2, String.valueOf(tr.getBookId()));
			pstmt.setString(3, String.valueOf(tr.getTradeNum()));
			pstmt.setString(4, String.valueOf(tr.getSum()));
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
	 * 查询所有销售记录
	 */
	public ArrayList querryRecord() {
		String sql = "select * from traderecord";
		ArrayList recordList = null;
		conn = manager.getConnection();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			recordList = new ArrayList();
			
			while(rs.next()) {
				TradeRecord tr = new TradeRecord();
				tr.setId(rs.getInt(1));
				tr.setUserId(rs.getInt(2));
				tr.setBookId(rs.getInt(3));
				tr.setTradeNum(rs.getInt(4));
				tr.setSum(rs.getDouble(5));
				recordList.add(tr);
			}
			return recordList;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			manager.closeAll(rs,stmt,conn);
			return recordList;
		}
	}
}
