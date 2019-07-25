package cn.hncu.xh.bookStore.out.dao.impl;

import java.util.ArrayList;
import java.util.List;

import cn.hncu.xh.bookStore.out.dao.dao.OutMainDAO;
import cn.hncu.xh.bookStore.out.vo.OutMainModel;
import cn.hncu.xh.bookStore.out.vo.OutMainQueryModel;
import cn.hncu.xh.bookStore.util.FileIOUtil;

/**
 * <p>
 * Title:OutMainDAOImpl
 * </p>
 * 
 * @author <a href="mailto:1225268923@qq.com">xionghui</a>
 * @date Aug 27, 2015
 */
public class OutMainDAOImpl implements OutMainDAO {
	private final static String FILE_NAME = "OutMian.txt"; // 销售单存储的文件位置

	// 新增销售单
	public boolean create(OutMainModel OutMain) {
		List<OutMainModel> list = getAll(); // 获得全部已存在元素
		// 遍历list，判断是否已经在同样uuid的元素，存在直接退出，反之加入进去
		for (OutMainModel model : list) {
			if (model.getUuid().equals(OutMain.getUuid())) {
				return false;
			}
		}
		list.add(OutMain); // 把inMian加入list中
		FileIOUtil.writeToFile(FILE_NAME, list); // 写入到对应文件中
		return true;
	}

	public boolean delete(String uuid) {
		List<OutMainModel> list = getAll(); // 获得全部已存在元素
		// 遍历list，判断是否已经在同样uuid的元素，存在直接删除
		for (OutMainModel model : list) {
			if (model.getUuid().equals(uuid)) {
				list.remove(model);
				FileIOUtil.writeToFile(FILE_NAME, list);
				return true;
			}
		}
		return false;
	}

	public boolean update(OutMainModel OutMain) {
		List<OutMainModel> list = getAll(); // 获得全部已存在元素
		// 遍历list，匹配uuid，在list中找到对应位置，并替换掉，然后写入对应文件
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).equals(OutMain)) {
				list.set(i, OutMain);
				return FileIOUtil.writeToFile(FILE_NAME, list);
			}
		}
		return false;
	}

	public List<OutMainModel> getAll() {
		return FileIOUtil.readFromFile(FILE_NAME); //直接从内存中对应文件中读取出来
	}

	public List<OutMainModel> getByCondition(OutMainQueryModel omqm) {
		List<OutMainModel> list = getAll();// 获得全部已存在元素
  		List<OutMainModel> result = new ArrayList<OutMainModel>(); //用来存放满足omqm要求的元素
  		//利用增强for循环遍历list，筛选掉不满足条件的
  		for(OutMainModel model : list){
  			if(omqm.getUuid()!=null && omqm.getUuid().trim().length()>0){ //判断是否合法
  				if(!omqm.getUuid().equals(model.getUuid())){ //过滤掉不相匹配的
  					continue;
  				}
  			}
  			if(omqm.getOutUserUuid()!=null && omqm.getOutUserUuid().trim().length()>0){//判断是否合法
  				if(!omqm.getOutUserUuid().equals(model.getOutUserUuid())){ //过滤掉不相匹配的
  					continue;
  				}
  			}
  			if(omqm.getOutDate()>0){//比最小值小的，过滤掉
  				if(omqm.getOutDate()>model.getOutDate()){
  					continue;
  				}
  			}
  			if(omqm.getOutDate2()>0){//最大值大的，过滤掉
  				if(omqm.getOutDate2()<model.getOutDate()){
  					continue;
  				}
  			}
  			result.add(model);
  		}
  		return result;
	}

	public OutMainModel getSingle(String uuid) {
		List<OutMainModel> list = getAll();// 获得全部已存在元素
		//利用增强for循环遍历list，匹配对应uuid的OutMainModel，并输出来
		for(OutMainModel model : list){
			if(model.getUuid().equals(uuid)){
				return model;
			}
		}
		return null;
	}

}
