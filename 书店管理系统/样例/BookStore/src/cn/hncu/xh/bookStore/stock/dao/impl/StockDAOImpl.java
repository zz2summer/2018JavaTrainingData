package cn.hncu.xh.bookStore.stock.dao.impl;

import java.util.ArrayList;
import java.util.List;

import cn.hncu.xh.bookStore.stock.dao.dao.StockDAO;
import cn.hncu.xh.bookStore.stock.vo.StockModel;
import cn.hncu.xh.bookStore.stock.vo.StockQueryModel;
import cn.hncu.xh.bookStore.util.FileIOUtil;

/**
 * <p>
 * Title:StockDAOImpl
 * </p>
 * 
 * @author <a href="mailto:1225268923@qq.com">xionghui</a>
 * @date Aug 27, 2015
 */
public class StockDAOImpl implements StockDAO {
	private final String FILE_NAME = "Stock.txt"; // 库存数据存储的位置

	// 新增
	public boolean create(StockModel stock) {
		List<StockModel> list = getAll(); // 获得所有库存数据
		// 遍历list，匹配uuid，如果没有匹配成功，说明没有重复的，可以新增进去
		for (StockModel model : list) {
			if (model.getUuid().equals(stock.getUuid())) {
				return false;
			}
		}
		list.add(stock);
		FileIOUtil.writeToFile(FILE_NAME, list);// 写入对应文件
		return true;
	}
	//修改
	public boolean update(StockModel stock) {
		List<StockModel> list = getAll();// 获得所有库存数据
		// 遍历list，匹配需要修改的库存的uuid，匹配成功就替换掉
		for(int i=0;i<list.size();i++){
			if(list.get(i).getUuid().equals(stock.getUuid())){
				list.set(i, stock);
				FileIOUtil.writeToFile(FILE_NAME, list);
				return true;
			}
		}
		return false;
	}
	//删除
	public boolean delete(String uuid) {
		List<StockModel> list = getAll();// 获得所有库存数据
		// 遍历list，匹配uuid，匹配到了就删除，对应的库存数据
		for (StockModel model : list) {
			if (model.getUuid().equals(uuid)) {
				list.remove(model);
				FileIOUtil.writeToFile(FILE_NAME, list);// 写入对应文件
				return true;
			}
		}
		return false;
	}
	//获得所有
	public List<StockModel> getAll() {
		return FileIOUtil.readFromFile(FILE_NAME);// 从对应文件中读取库存数据
	}
	//查询
	public List<StockModel> getBycondition(StockQueryModel sqm) {
		List<StockModel> stocks = getAll();// 获得所有库存数据
		List<StockModel> ret = new ArrayList<StockModel>(); //用来装满足条件的库存数据，最后返回出去
		//遍历所有数据
		for(StockModel stock: stocks){
			//4个卫条件： uuid, bookUuid, (sumNum, sumNum2)
			if(sqm.getUuid()!=null && sqm.getUuid().trim().length()>0){ //判断是否合法
				if(!sqm.getUuid().equals(stock.getUuid())){ //过滤不匹配的
					continue;
				}
			}
			
			if(sqm.getBookUuid()!=null && sqm.getBookUuid().trim().length()>0){ //判断是否合法
				if(!sqm.getBookUuid().equals(stock.getBookUuid())){ //过滤不匹配的
					continue;
				}
			}
			
			if(sqm.getSumNum()>0){ //过滤比最小查询数量还小的
				if(stock.getSumNum() < sqm.getSumNum() ){
					continue;
				}
			}
			if(sqm.getSumNum2()>0){//过滤比最大查询数量还大的
				if(stock.getSumNum() > sqm.getSumNum2() ){
					continue;
				}
			}
			ret.add(stock);//加入到list中
		}
		return ret;
		
		
	}
	//获得单个
	public StockModel getSingle(String uuid) {
		List<StockModel> list = getAll();// 获得所有库存数据
		// 遍历list，匹配uuid，匹配到了，直接返回对应库存数据
		for(StockModel model: list){
			if(model.getUuid().equals(uuid)){
				return model;
			}
		}
		return null;
	}
}
