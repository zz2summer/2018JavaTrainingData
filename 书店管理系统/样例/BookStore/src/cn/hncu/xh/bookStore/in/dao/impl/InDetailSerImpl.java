package cn.hncu.xh.bookStore.in.dao.impl;

import java.util.ArrayList;
import java.util.List;

import cn.hncu.xh.bookStore.in.dao.dao.InDtailDao;
import cn.hncu.xh.bookStore.in.vo.InDetailModel;
import cn.hncu.xh.bookStore.in.vo.InDetailQueryModel;
import cn.hncu.xh.bookStore.util.FileIOUtil;

/**
 *<p>Title:InDetailSerImpl</p>
 * @author <a href="mailto:1225268923@qq.com">xionghui</a>
 * @date Aug 25, 2015
 */
//实现类
public class InDetailSerImpl implements InDtailDao {

	private static final String FILE_NAME = "inDetail.txt";

	public boolean create(InDetailModel inDetail) {
		List<InDetailModel> list = getAll(); // 获得全部已存在元素
		// 遍历list，判断是否已经在同样uuid的元素，存在直接退出，反之加入进去
		for (InDetailModel model : list) {
			if (model.getUuid().equals(inDetail.getUuid())) {
				return false;
			}
		}
		list.add(inDetail); // 把inDetail加入list中
		FileIOUtil.writeToFile(FILE_NAME, list); // 写入到对应文件中
		return true;
	}

	public boolean delete(String uuid) {
		List<InDetailModel> list = getAll(); // 获得全部已存在元素
		// 遍历list，判断是否已经在同样uuid的元素，存在直接删除
		for (InDetailModel model : list) {
			if (model.getUuid().equals(uuid)) {
				list.remove(model);
				FileIOUtil.writeToFile(FILE_NAME, list);
				return true;
			}
		}
		return false;
	}
	//返货内存中所有的订单明细
	public List<InDetailModel> getAll() {
		return FileIOUtil.readFromFile(FILE_NAME);
	}

	public List<InDetailModel> getBycondition(InDetailQueryModel idqm) {
		List<InDetailModel> list = getAll();		// 从后台把所有的数据集读取出来
		List<InDetailModel> ret = new ArrayList<InDetailModel>();// 存放结果集
		if (idqm == null) {
			return list;
		}
		// 然后利用卫条件进行筛选，筛选剩下的就是查询结果
		for (InDetailModel inDetail : list) {
			// 卫条件，判断uuid
			if (idqm.getUuid() != null && idqm.getUuid().trim().length() > 0) {// 先验证查询条件有效
				if (!idqm.getUuid().equals(inDetail.getUuid())) { //过滤掉uuid不匹配的
					continue;
				}
			}
			// 卫条件，判断inUuid
			if (idqm.getInUuid() != null && idqm.getInUuid().trim().length() > 0) {// 先验证查询条件有效
				if (!idqm.getInUuid().equals(inDetail.getInUuid())) { //过滤掉inUuid不匹配的
					continue;
				}
			}
			// 卫条件，判断bookUuid
			if (idqm.getBookUuid() != null && idqm.getBookUuid().trim().length() > 0) {// 先验证查询条件有效
				if (!idqm.getBookUuid().equals(inDetail.getBookUuid())) { //过滤掉bookUuid不匹配的
					continue;
				}
			}
			//反逻辑，卫条件,书数量的最小值
			if(idqm.getSumNum()>0){
				if(idqm.getSumNum()>inDetail.getSumNum()){ //过滤比最小数量小的
					continue;
				}
			}
			//反逻辑，卫条件,书数量的最大值
			if(idqm.getSumNum2()>0){
				if(idqm.getSumNum2()<inDetail.getSumNum()){ //过滤比最大数量大的
					continue;
				}
			}
			//反逻辑，卫条件,总金额的最小值
			if(idqm.getSumNum()>0){
				if(idqm.getSumNum()>inDetail.getSumNum()){ //过滤比最小总金额小的
					continue;
				}
			}
			//反逻辑，卫条件,总金额的最大值
			if(idqm.getSumNum2()>0){
				if(idqm.getSumNum2()<inDetail.getSumNum()){ //过滤比最大总金额大的
					continue;
				}
			}
			ret.add(inDetail);
		}
		return ret;
		
	}
	//获得指定uuid的订单明细
	public InDetailModel getSingle(String uuid) {
		List<InDetailModel> list = getAll(); //获取全部的订单明细
		//遍历所有的订单明细，判断是否存在匹配我指定uuid的订单明细
		for (int i = 0; i < list.size(); i++) {
			InDetailModel model = list.get(i);
			if (model.getUuid().equals(uuid)) {//若匹配到，直接返回订单明细
				return model; 
			}
		}
		return null;
	}
	
	public boolean update(InDetailModel inMain) {
		List<InDetailModel> list = getAll();
		for (int i = 0; i < list.size(); i++) {
			InDetailModel model = list.get(i);
			if (model.getUuid().equals(inMain.getUuid())) {
				list.set(i, inMain);
				FileIOUtil.writeToFile(FILE_NAME, list);
				return true;
			}
		}
		return false;
	}

}
