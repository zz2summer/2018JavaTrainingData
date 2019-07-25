package cn.hncu.xh.bookStore.stock.dao.dao;

import java.util.List;

import cn.hncu.xh.bookStore.stock.vo.StockModel;
import cn.hncu.xh.bookStore.stock.vo.StockQueryModel;

/**
 * <p>
 * Title:StockDAO
 * </p>
 * 
 * @author <a href="mailto:1225268923@qq.com">xionghui</a>
 * @date Aug 27, 2015
 */
public interface StockDAO {
	public boolean create(StockModel stock);//创建新库存
 
	public boolean delete(String uuid); //删除指定uuid的库存

	public boolean update(StockModel stock); //修改库存

	public List<StockModel> getAll();  //获得所有库存

	public StockModel getSingle(String uuid); //或的指定uuid的库存

	public List<StockModel> getBycondition(StockQueryModel sqm); //查询库存
}
