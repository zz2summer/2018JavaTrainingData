package cn.hncu.bookStore.stock.business.factory;

import cn.hncu.bookStore.stock.business.ebi.StockEbi;
import cn.hncu.bookStore.stock.business.ebo.StockEbo;

/**
 * 库存逻辑层工厂类
 * @author 陈浩翔
 *
 * @version 1.0  2016-4-20
 */
public class StockEbiFactory {
	/**
	 * 工厂方法
	 * @return---new一个逻辑层实现类
	 */
	public static StockEbi getStockEbi(){
		return new StockEbo();
	}
}
