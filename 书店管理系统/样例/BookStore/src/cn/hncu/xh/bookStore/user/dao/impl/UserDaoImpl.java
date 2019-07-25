package cn.hncu.xh.bookStore.user.dao.impl;

import java.util.ArrayList;
import java.util.List;

import cn.hncu.xh.bookStore.user.dao.dao.UserDao;
import cn.hncu.xh.bookStore.user.vo.UserModel;
import cn.hncu.xh.bookStore.user.vo.UserQueryModel;
import cn.hncu.xh.bookStore.util.FileIOUtil;

/**
 * <p>
 * Title:UserDaoImpl
 * </p>
 * 
 * @author <a href="mailto:1225268923@qq.com">xionghui</a>
 * @date Aug 21, 2015
 */
//实现类
public class UserDaoImpl implements UserDao { //实现了UserDao接口
	private final String FILE_NAME = "User.txt";
	//代码测试
//	public static void main(String[] args) {
//		UserDaoImpl dao = new UserDaoImpl();
//		dao.create(new UserModel("002", "刘三", 2, "1234"));
//		dao.create(new UserModel("001", "Jack", 1, "1234"));
//		// dao.delete("002");
//		// System.out.println(dao.getSingle("001"));
//		List<UserModel> list = dao.getAll();
//		System.out.println(list);
//	}

	// 增加
	public boolean create(UserModel user) {
		List<UserModel> list = getAll();
		if (list != null) {
			// 遍历list，如果其中存在user则返回false，否则吧user存入数据库中
			for (UserModel u : list) {
				if (u.getUuid().equals(user.getUuid())) {
					return false;
				}
			}
		}
		list.add(user);
		// 把更新后的list存入数据库
		FileIOUtil.writeToFile(FILE_NAME, list);
		return true;
	}

	// 删除
	public boolean delete(String uuid) {
		List<UserModel> list = getAll();
		if (list == null) {
			return false;
		}
		// 遍历list把需要删除的对象在list中的位置找到，并删除
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getUuid().equals(uuid)) {
				list.remove(i);
				FileIOUtil.writeToFile(FILE_NAME, list);
				return true;
			}
		}
		return false;
	}

	// 修改
	public boolean update(UserModel user) {
		List<UserModel> list = getAll();
		if (list == null) {
			return false;
		}
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getUuid().equals(user.getUuid())) {
				list.set(i, user);
				FileIOUtil.writeToFile(FILE_NAME, list);// 写回数据层
				return true;
			}
		}
		return false;
	}

	// 获得全部
	public List<UserModel> getAll() {
		List<UserModel> list = FileIOUtil.readFromFile(FILE_NAME);
		return list;
	}

	// 获得单个
	public UserModel getSingle(String uuid) {
		List<UserModel> list = getAll();//把数据库中的元素全部读取出来
		//遍历list，找到我需要找的元素为止
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getUuid().equals(uuid)) {
				return list.get(i);  //直接返回这个元素
			}
		}
		return null;//走到这一步，就说明list中没有这个uuid的元素，返回null
	}

	// 获得查询
	public List<UserModel> getBycondition(UserQueryModel uqm) {
		List<UserModel> list = getAll();		// 从后台把所有的数据集读取出来
		List<UserModel> ret = new ArrayList<UserModel>();// 存放结果集
		if (uqm == null) {
			return list;
		}
		// 然后利用卫条件进行筛选，筛选剩下的就是查询结果
		for (UserModel user : list) {
			// 卫条件，判断uuid
			if (uqm.getUuid() != null && uqm.getUuid().trim().length() > 0) {// 先验证查询条件有效
				if (!user.getUuid().equals(uqm.getUuid())) { //过滤掉uuid不匹配的
					continue;
				}
			}
			// 卫条件，判断用户名
			if (uqm.getName() != null && uqm.getName().trim().length() > 0) {// 先验证查询条件有效
				if (!user.getName().contains(uqm.getName().trim())) { //过滤掉名字不匹配的
					continue;
				}
			}
			// 卫条件，判断用户类型
			if (uqm.getType() > 0) {  //如果用户没有选用户类型，那么就默认全部都需要查到
				if (uqm.getType() != user.getType()) { //过滤掉类型不匹配的
					continue;
				}
			}
			ret.add(user);
		}
		return ret;
	}

}
