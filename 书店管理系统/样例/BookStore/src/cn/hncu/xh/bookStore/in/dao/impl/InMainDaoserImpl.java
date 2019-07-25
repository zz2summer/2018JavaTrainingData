package cn.hncu.xh.bookStore.in.dao.impl;

import java.util.ArrayList;
import java.util.List;

import cn.hncu.xh.bookStore.in.dao.dao.InMainDao;
import cn.hncu.xh.bookStore.in.vo.InMainModel;
import cn.hncu.xh.bookStore.in.vo.InMainQueryModel;
import cn.hncu.xh.bookStore.util.FileIOUtil;

/**
 * <p>
 * Title:InMainDaoserImpl
 * </p>
 * 
 * @author <a href="mailto:1225268923@qq.com">xionghui</a>
 * @date Aug 25, 2015
 */
// 实现类
public class InMainDaoserImpl implements InMainDao {// 实现InMainDao接口
	private static final String FILE_NAME = "inMain.txt";

	public boolean create(InMainModel inMain) {
		List<InMainModel> list = getAll(); // 获得全部已存在元素
		// 遍历list，判断是否已经在同样uuid的元素，存在直接退出，反之加入进去
		for (InMainModel model : list) {
			if (model.getUuid().equals(inMain.getUuid())) {
				return false;
			}
		}
		list.add(inMain); // 把inMian加入list中
		FileIOUtil.writeToFile(FILE_NAME, list); // 写入到对应文件中
		return true;
	}

	public boolean delete(String uuid) {
		List<InMainModel> list = getAll(); // 获得全部已存在元素
		// 遍历list，判断是否已经在同样uuid的元素，存在直接删除
		for (InMainModel model : list) {
			if (model.getUuid().equals(uuid)) {
				list.remove(model);
				FileIOUtil.writeToFile(FILE_NAME, list);
				return true;
			}
		}
		return false;
	}

	public List<InMainModel> getAll() {
		return FileIOUtil.readFromFile(FILE_NAME);
	}

	public List<InMainModel> getBycondition(InMainQueryModel imqm) {
		List<InMainModel> list = getAll(); // 从后台把所有的数据集读取出来
		List<InMainModel> ret = new ArrayList<InMainModel>();// 存放结果集
		if (imqm == null) {
			return list;
		}
		// 然后利用卫条件进行筛选，筛选剩下的就是查询结果
		for (InMainModel inMain : list) {
			// 反逻辑，卫条件，判断uuid
			if (imqm.getUuid() != null && imqm.getUuid().trim().length() > 0) {// 先验证查询条件有效
				if (!imqm.getUuid().equals(inMain.getUuid())) { // 过滤掉uuid不匹配的
					continue;
				}
			}
			// 卫条件，inUseruuid进货人
			if (imqm.getInUserUuid() != null
					&& imqm.getInUserUuid().trim().length() > 0) {// 先验证查询条件有效
				if (!imqm.getInUserUuid().contains(inMain.getInUserUuid())) { // 过滤掉uuid不匹配的
					continue;
				}
			}
			// 卫条件，inDate开始进货时间（小于小的，过滤）
			if (imqm.getInDate() > 0) { // 如果用户没有选用户类型，那么就默认全部都需要查到
				if (imqm.getInDate() > inMain.getInDate()) { 
					continue;
				}
			}
			// 卫条件，inDate2结束进货时间（大于大的，过滤）
			if (imqm.getInDate2() > 0) { // 如果用户没有选用户类型，那么就默认全部都需要查到
				if (imqm.getInDate2()< inMain.getInDate()) { 
					continue;
				}
			}
			ret.add(inMain);
		}
		return ret;

	}

	public InMainModel getSingle(String uuid) {
		List<InMainModel> list = getAll();
		for (int i = 0; i < list.size(); i++) {
			InMainModel model = list.get(i);
			if (model.getUuid().equals(uuid)) {
				return list.get(i);
			}
		}
		return null;
	}

	public boolean update(InMainModel inMain) {
		List<InMainModel> list = getAll();
		for (int i = 0; i < list.size(); i++) {
			InMainModel model = list.get(i);
			if (model.getUuid().equals(inMain.getUuid())) {
				list.set(i, inMain);
				FileIOUtil.writeToFile(FILE_NAME, list);
				return true;
			}
		}
		return false;
	}

}
