package cn.hncu.bookStore.stock.business.ebo;

import java.util.List;

import cn.hncu.bookStore.stock.business.ebi.StockEbi;
import cn.hncu.bookStore.stock.dao.dao.StockDao;
import cn.hncu.bookStore.stock.dao.factory.StockDaoFactory;
import cn.hncu.bookStore.stock.vo.StockModel;
import cn.hncu.bookStore.stock.vo.StockQueryModel;

/**
 * ����߼���ʵ����
 * @author �º���
 *
 * @version 1.0  2016-4-20
 */
public class StockEbo implements StockEbi{
	//ע�� dao 
	StockDao dao = StockDaoFactory.getStockDao();
	
	@Override
	public List<StockModel> getAll() {
		return dao.getAl();
	}

	@Override
	public List<StockModel> getByCondition(StockQueryModel sqm) {
		return dao.getByCondition(sqm);
	}
	
}
