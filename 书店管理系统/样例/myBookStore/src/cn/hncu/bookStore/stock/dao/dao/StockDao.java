package cn.hncu.bookStore.stock.dao.dao;

import java.util.List;

import cn.hncu.bookStore.stock.vo.StockModel;
import cn.hncu.bookStore.stock.vo.StockQueryModel;

/**
 * ���ģ������ݲ�ӿ�
 * @author �º���
 *
 * @version 1.0  2016-4-20
 */
public interface StockDao {
	/**
	 * ����һ��������
	 * @param stock
	 * @return
	 */
	public boolean create(StockModel stock);
	
	/**
	 * 
	 * @return �������еĿ���������
	 */
	public List<StockModel> getAl();
	
	/**
	 * ����uuid  -- �޸�Ϊ����Ŀ�����
	 * @param stock
	 * @return
	 */
	public boolean update(StockModel stock);
	
	/**
	 * ��ѯ �������� �� �����󼯺�
	 * @param sqm---��ѯ����
	 * @return---���������Ŀ����󼯺�
	 */
	public List<StockModel> getByCondition(StockQueryModel sqm);
	
	/**
	 * ����uuid���ҵ�ǰ��uuid��Ӧ�Ŀ�����
	 * @param uuid
	 * @return
	 */
	public StockModel getSingle(String uuid);
	
}
