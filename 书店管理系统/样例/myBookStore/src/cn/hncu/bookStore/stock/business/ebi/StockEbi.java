package cn.hncu.bookStore.stock.business.ebi;

import java.util.List;

import cn.hncu.bookStore.stock.vo.StockModel;
import cn.hncu.bookStore.stock.vo.StockQueryModel;


/**
 * 库存逻辑层的接口
 * @author 陈浩翔
 *
 * @version 1.0  2016-4-20
 */
public interface StockEbi {
	/**
	 * 得到所有的库存对象
	 * @return---所有的库存对象集合
	 */
	public List<StockModel> getAll();
	
	/**
	 * 根据查询条件，查询所有符合条件的库存对象
	 * @param sqm---查询条件
	 * @return---所有符合条件的库存对象集合
	 */
	public List<StockModel> getByCondition(StockQueryModel sqm);
	
}
