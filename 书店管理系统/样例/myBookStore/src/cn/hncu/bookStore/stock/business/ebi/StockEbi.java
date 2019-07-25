package cn.hncu.bookStore.stock.business.ebi;

import java.util.List;

import cn.hncu.bookStore.stock.vo.StockModel;
import cn.hncu.bookStore.stock.vo.StockQueryModel;


/**
 * ����߼���Ľӿ�
 * @author �º���
 *
 * @version 1.0  2016-4-20
 */
public interface StockEbi {
	/**
	 * �õ����еĿ�����
	 * @return---���еĿ����󼯺�
	 */
	public List<StockModel> getAll();
	
	/**
	 * ���ݲ�ѯ��������ѯ���з��������Ŀ�����
	 * @param sqm---��ѯ����
	 * @return---���з��������Ŀ����󼯺�
	 */
	public List<StockModel> getByCondition(StockQueryModel sqm);
	
}
