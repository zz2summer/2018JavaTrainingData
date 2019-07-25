package cn.hncu.xh.bookStore.user.dao.dao;

import java.util.List;

import cn.hncu.xh.bookStore.user.vo.UserModel;
import cn.hncu.xh.bookStore.user.vo.UserQueryModel;

/**
 *<p>Title:UserDao</p>
 * @author <a href="mailto:1225268923@qq.com">xionghui</a>
 * @date Aug 21, 2015
 */
//接口类
public interface UserDao {
	/*
	 * 如果数据中不存在该user对象，则创建一个新的。如果存在，则直接放回false
	 * @param user 将要被创建的用户对象
	 * @return  如果创建成功则返回true，否则返回false
	 */
	public boolean create(UserModel user); // 创建接口

	public boolean delete(String uuid); // 删除接口

	public boolean update(UserModel user); // 修改接口

	public List<UserModel> getAll(); // 返回全部对象接口

	public UserModel getSingle(String uuid);// 获取编号接口

	public List<UserModel> getBycondition(UserQueryModel uqm);// 查询接口
	
}
