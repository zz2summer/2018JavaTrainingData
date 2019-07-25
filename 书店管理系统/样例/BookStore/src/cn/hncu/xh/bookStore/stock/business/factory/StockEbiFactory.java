package cn.hncu.xh.bookStore.stock.business.factory;

import cn.hncu.xh.bookStore.stock.business.ebi.StockEbi;
import cn.hncu.xh.bookStore.stock.business.ebo.StockEbo;

/**
 *<p>Title:StockEbiFactory</p>
 * @author <a href="mailto:1225268923@qq.com">xionghui</a>
 * @date Aug 27, 2015
 */
public class StockEbiFactory {
	public static StockEbi getStockEbi(){
		return new StockEbo();
	}
}
