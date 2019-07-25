package cn.hncu.xh.bookStore.user.business.ebo;

import java.util.List;

import cn.hncu.xh.bookStore.book.vo.BookModel;
import cn.hncu.xh.bookStore.common.constance.UuidModelConstance;
import cn.hncu.xh.bookStore.common.dao.factory.UuidDaoFactory;
import cn.hncu.xh.bookStore.user.business.ebi.UserEbi;
import cn.hncu.xh.bookStore.user.constance.UserTypeEnum;
import cn.hncu.xh.bookStore.user.dao.dao.UserDao;
import cn.hncu.xh.bookStore.user.dao.factory.UserDaoFactory;
import cn.hncu.xh.bookStore.user.vo.UserModel;
import cn.hncu.xh.bookStore.user.vo.UserQueryModel;

/**
 * <p>
 * Title:UserEbo
 * </p>
 * 
 * @author <a href="mailto:1225268923@qq.com">xionghui</a>
 * @date Aug 22, 2015
 */
// 实现类
public class UserEbo implements UserEbi { // 实现UserEbi接口
	// 增加给定的UserModel
	public boolean create(UserModel user) {
		// 这里是防止别人黑我们
		if (user.getName() == null || user.getName().trim().length() <= 0) { // 如果名字为空，或者名字去掉空格后长度小于等于零，则直接放回false
			return false;
		}
		// 直接调用dao的工厂方法，下面相同
		UserDao dao = UserDaoFactory.getUserDao();
		// 补uuid
		String uuid = UuidDaoFactory.getUuidDao().getNextNum(
				UuidModelConstance.USER);
		user.setUuid(uuid);
		return dao.create(user);
	}

	// 删除对应uuid的UserModel
	public boolean delete(String uuid) {
		UserDao dao = UserDaoFactory.getUserDao();
		return dao.delete(uuid);
	}

	// 修改UserModel
	public boolean update(UserModel user) {
		UserDao dao = UserDaoFactory.getUserDao();
		return dao.update(user);
	}

	// 获取所有元素
	public List<UserModel> getAll() {
		UserDao dao = UserDaoFactory.getUserDao();
		return dao.getAll();
	}
	//获取所有销售人员
	public List<UserModel> getAllOut(){
		UserQueryModel uqm = new UserQueryModel();
		uqm.setType(UserTypeEnum.OUT.getType());
		List<UserModel> users = getBycondition(uqm);
		return users;
	}
	// 获得单个UserModel
	public UserModel getSingle(String uuid) {
		UserDao dao = UserDaoFactory.getUserDao();
		return dao.getSingle(uuid);
	}

	// 查询
	public List<UserModel> getBycondition(UserQueryModel uqm) {
		UserDao dao = UserDaoFactory.getUserDao();
		return dao.getBycondition(uqm);
	}
	//获取所有进货人
	public List<UserModel> getAllIn() {
		UserQueryModel uqm = new UserQueryModel();
		uqm.setType(UserTypeEnum.IN.getType());
		List<UserModel> users = getBycondition(uqm);
		return users;
	}
	public UserModel getsingle(String userName) {
		List<UserModel> users=getAll();
		for(UserModel user:users){
			if(user.getName().equals(userName)){
				return user;
			}
		}
		return null;
	}
}
