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
 * �������TradeRecord�����ݿ��е�����
 * 
 * @author Cute Code
 *
 */
public class TradeRecordDAO {
	// ���ݿ�����
	private Connection conn = null;
	// �Ự
	private Statement stmt = null;
	// �����
	private ResultSet rs = null;
	// Ԥ��������
	private PreparedStatement pstmt = null;

	DBManager manager = new DBManager();
	
	public TradeRecordDAO() {
		
	}
	
	/**
	 * ��һ�����׼�¼������뵽���ݿ���
	 * @param tr
	 */
	public void insertRecord(TradeRecord tr) {
		// ���ݿ�������
		String sql = "insert into traderecord(userId,bookId,tradeNum,sum) values(?,?,?,?)";
		
		try {
			// ������ݿ�����
			conn = manager.getConnection();
			// ���Ԥ��������
			pstmt = conn.prepareStatement(sql);
			// ���ν����Բ������ݿ�
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
			// �ر����ݿ�����
			manager.closeAll(rs,stmt,conn);
		}
	}
	
	/**
	 * ��ѯ�������ۼ�¼
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
