package data;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.Reader;

public class ReaderDao {
	//���ݶ��߱�ţ���õ�������ʵ��
	public static Reader selectReader(String id) {
		String sql = "select *  from reader where id='" + id +"'";
		ResultSet rs = BaseDao.executeQuery(sql);
		Reader reader = null;
		try {
			if (rs.next()) {
				reader = new Reader();
				reader.setId(rs.getString("id"));
				reader.setType(rs.getString("type"));
				reader.setName(rs.getString("name"));
				reader.setSex(rs.getString("sex"));
				reader.setMax_num(rs.getString("max_num"));
				reader.setDays_num(rs.getInt("days_num"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		BaseDao.close();
		return reader;
	}
	
	//�������sql���Ķ���ʵ���б�
	public static List selectReaderList(String sql) {
		List list = new ArrayList();
		ResultSet rs = BaseDao.executeQuery(sql);
		Reader reader = null;
		try {
			while (rs.next()) {
				reader = new Reader();
				reader.setId(rs.getString("id"));
				reader.setType(rs.getString("type"));
				reader.setName(rs.getString("name"));
				reader.setSex(rs.getString("sex"));
				reader.setMax_num(rs.getString("max_num"));
				reader.setDays_num(rs.getInt("days_num"));
				list.add(reader);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		BaseDao.close();
		return list;
	}
}
