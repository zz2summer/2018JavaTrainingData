package cn.hncu.bookStore.stock.dao.factory;

import cn.hncu.bookStore.stock.dao.dao.StockDao;
import cn.hncu.bookStore.stock.dao.impl.StockDaoImpl;

/**
 * ������-���
 * @author �º���
 *
 * @version 1.0  2016-4-20
 */
public class StockDaoFactory {
	/**
	 * ��������
	 * @return --- new һ�����ݲ�ʵ��
	 */
	public static StockDao getStockDao(){
		return new StockDaoImpl();
	}
	
}
