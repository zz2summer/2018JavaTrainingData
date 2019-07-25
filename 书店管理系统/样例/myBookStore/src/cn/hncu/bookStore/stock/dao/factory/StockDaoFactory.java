package cn.hncu.bookStore.stock.dao.factory;

import cn.hncu.bookStore.stock.dao.dao.StockDao;
import cn.hncu.bookStore.stock.dao.impl.StockDaoImpl;

/**
 * 工厂类-库存
 * @author 陈浩翔
 *
 * @version 1.0  2016-4-20
 */
public class StockDaoFactory {
	/**
	 * 工厂方法
	 * @return --- new 一个数据层实例
	 */
	public static StockDao getStockDao(){
		return new StockDaoImpl();
	}
	
}
