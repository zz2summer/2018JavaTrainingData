package cn.hncu.xh.bookStore.user.business.ebi;

import java.util.List;

import cn.hncu.xh.bookStore.user.vo.UserModel;
import cn.hncu.xh.bookStore.user.vo.UserQueryModel;

/**
 * <p>
 * Title:UserEbi
 * </p>
 * 
 * @author <a href="mailto:1225268923@qq.com">xionghui</a>
 * @date Aug 22, 2015
 */
// 接口类
public interface UserEbi {
	public boolean create(UserModel user); // 创建接口

	public boolean delete(String uuid); // 删除接口

	public boolean update(UserModel user); // 修改接口

	public List<UserModel> getAll(); // 返回全部对象接口

	public UserModel getSingle(String uuid);// 获取编号接口

	public List<UserModel> getBycondition(UserQueryModel uqm);// 查询接口

	public List<UserModel> getAllIn();

	public UserModel getsingle(String userName);

	public List<UserModel> getAllOut();
}
