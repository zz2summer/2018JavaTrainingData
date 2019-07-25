package cn.hncu.xh.bookStore.stock.business.ebo;

import java.util.List;

import cn.hncu.xh.bookStore.stock.business.ebi.StockEbi;
import cn.hncu.xh.bookStore.stock.dao.factory.StockDAOFactory;
import cn.hncu.xh.bookStore.stock.vo.StockModel;
import cn.hncu.xh.bookStore.stock.vo.StockQueryModel;

/**
 *<p>Title:StockEbo</p>
 * @author <a href="mailto:1225268923@qq.com">xionghui</a>
 * @date Aug 27, 2015
 */
public class StockEbo implements StockEbi {

	public List<StockModel> getAll() {
		return StockDAOFactory.getStockDAO().getAll(); //直接调用DAO工厂方法，下同
	}

	public List<StockModel> getByCondition(StockQueryModel sqm) {
		return StockDAOFactory.getStockDAO().getBycondition(sqm);
	}

}
