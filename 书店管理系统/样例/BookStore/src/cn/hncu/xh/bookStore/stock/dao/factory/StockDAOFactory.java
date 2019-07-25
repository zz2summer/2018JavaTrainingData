package cn.hncu.xh.bookStore.stock.dao.factory;

import cn.hncu.xh.bookStore.stock.dao.dao.StockDAO;
import cn.hncu.xh.bookStore.stock.dao.impl.StockDAOImpl;

/**
 *<p>Title:StockDAOFactory</p>
 * @author <a href="mailto:1225268923@qq.com">xionghui</a>
 * @date Aug 27, 2015
 */
public class StockDAOFactory {
	public static StockDAO getStockDAO(){
		return new StockDAOImpl();
	}
}
