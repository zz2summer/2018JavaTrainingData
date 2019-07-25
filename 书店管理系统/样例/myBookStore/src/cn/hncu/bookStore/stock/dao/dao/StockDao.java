package cn.hncu.bookStore.stock.dao.dao;

import java.util.List;

import cn.hncu.bookStore.stock.vo.StockModel;
import cn.hncu.bookStore.stock.vo.StockQueryModel;

/**
 * 库存模块的数据层接口
 * @author 陈浩翔
 *
 * @version 1.0  2016-4-20
 */
public interface StockDao {
	/**
	 * 创建一个库存对象
	 * @param stock
	 * @return
	 */
	public boolean create(StockModel stock);
	
	/**
	 * 
	 * @return 返回所有的库存对象数据
	 */
	public List<StockModel> getAl();
	
	/**
	 * 根据uuid  -- 修改为传入的库存对象
	 * @param stock
	 * @return
	 */
	public boolean update(StockModel stock);
	
	/**
	 * 查询 符合条件 的 库存对象集合
	 * @param sqm---查询条件
	 * @return---符合条件的库存对象集合
	 */
	public List<StockModel> getByCondition(StockQueryModel sqm);
	
	/**
	 * 根据uuid查找当前的uuid对应的库存对象
	 * @param uuid
	 * @return
	 */
	public StockModel getSingle(String uuid);
	
}
