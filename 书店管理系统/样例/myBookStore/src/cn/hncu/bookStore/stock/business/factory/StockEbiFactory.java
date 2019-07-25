package cn.hncu.bookStore.stock.business.factory;

import cn.hncu.bookStore.stock.business.ebi.StockEbi;
import cn.hncu.bookStore.stock.business.ebo.StockEbo;

/**
 * ����߼��㹤����
 * @author �º���
 *
 * @version 1.0  2016-4-20
 */
public class StockEbiFactory {
	/**
	 * ��������
	 * @return---newһ���߼���ʵ����
	 */
	public static StockEbi getStockEbi(){
		return new StockEbo();
	}
}
