package cn.hncu.xh.bookStore.out.dao.impl;

import java.util.ArrayList;
import java.util.List;

import cn.hncu.xh.bookStore.out.dao.dao.OutDetailDAO;
import cn.hncu.xh.bookStore.out.vo.OutDetailModel;
import cn.hncu.xh.bookStore.out.vo.OutDetailQueryModel;
import cn.hncu.xh.bookStore.util.FileIOUtil;

/**
 * <p>
 * Title:OutDetailDAOImpl
 * </p>
 * 
 * @author <a href="mailto:1225268923@qq.com">xionghui</a>
 * @date Aug 27, 2015
 */
public class OutDetailDAOImpl implements OutDetailDAO {
	private final static String FILE_NAME = "OutDetail.txt";// 销售明细存储的文件位置

	// 新增明细
	public boolean create(OutDetailModel OutDetail) {
		List<OutDetailModel> list = getAll(); // 获得全部已存在元素
		// 遍历list，判断是否已经在同样uuid的元素，存在直接退出，反之加入进去
		for (OutDetailModel model : list) {
			if (model.getUuid().equals(OutDetail.getUuid())) {
				return false;
			}
		}
		list.add(OutDetail); // 把OutDetail加入list中
		FileIOUtil.writeToFile(FILE_NAME, list); // 写入到对应文件中
		return true;
	}

	public boolean delete(String uuid) {
		List<OutDetailModel> list = getAll(); // 获得全部已存在元素
		// 遍历list，判断是否已经在同样uuid的元素，存在直接删除
		for (OutDetailModel model : list) {
			if (model.getUuid().equals(uuid)) {
				list.remove(model);
				FileIOUtil.writeToFile(FILE_NAME, list);// 写入到对应文件中
				return true;
			}
		}
		return false;
	}

	public boolean update(OutDetailModel OutDetail) {
		List<OutDetailModel> list = getAll(); // 获得全部已存在元素
		// 遍历list，匹配uuid，在list中找到对应位置，并替换掉，然后写入对应文件
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).equals(OutDetail)) {
				list.set(i, OutDetail);
				return FileIOUtil.writeToFile(FILE_NAME, list);// 写入到对应文件中
			}
		}
		return false;
	}

	public List<OutDetailModel> getAll() {
		return FileIOUtil.readFromFile(FILE_NAME); // 直接从内存中对应文件中读取出来
	}

	public List<OutDetailModel> getByCondition(OutDetailQueryModel odqm) {
		List<OutDetailModel> list = getAll();// 获得全部已存在元素
  		List<OutDetailModel> result = new ArrayList<OutDetailModel>();//用来存放满足odqm要求的元素
  		
  		for(OutDetailModel model : list){
  			if(odqm.getUuid()!=null && odqm.getUuid().trim().length()>0){ ////判断是否合法
  				if(!odqm.getUuid().equals(model.getUuid())){ //过滤不匹配的
  					continue;
  				}
  			}
  			if(odqm.getOutUuid()!=null && odqm.getOutUuid().trim().length()>0){//判断是否合法
  				if(!odqm.getOutUuid().equals(model.getOutUuid())){//过滤不匹配的
  					continue;
  				}
  			}
  			if(odqm.getBookUuid()!=null && odqm.getBookUuid().trim().length()>0){//判断是否合法
  				if(!odqm.getBookUuid().equals(model.getBookUuid())){//过滤不匹配的
  					continue;
  				}
  			}
  			
  			
  			if(odqm.getSumNum()>0){//比最小值小的，过滤掉
  				if(odqm.getSumNum()>model.getSumNum()){
  					continue;
  				}
  			}
  			if(odqm.getSumNum2()>0){//最大值大的，过滤掉
  				if(odqm.getSumNum2()<model.getSumNum()){
  					continue;
  				}
  			}
  			if(odqm.getSumMoney()>0){//比最小值小的，过滤掉
  				if(odqm.getSumMoney()>model.getSumMoney()){
  					continue;
  				}
  			}
  			if(odqm.getSumMoney2()>0){//最大值大的，过滤掉
  				if(odqm.getSumMoney2()<model.getSumMoney()){
  					continue;
  				}
  			}
  			result.add(model);
  		}
  		return result;
	}

	public OutDetailModel getSingle(String uuid) {
		List<OutDetailModel> list = getAll(); //获取全部的销售明细
		//遍历所有的销售明细，判断是否存在匹配我指定uuid的销售明细
		for (int i = 0; i < list.size(); i++) {
			OutDetailModel model = list.get(i);
			if (model.getUuid().equals(uuid)) {//若匹配到，直接返回销售明细
				return model; 
			}
		}
		return null;
	}

}
