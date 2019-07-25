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
// ʵ����
public class UserEbo implements UserEbi { // ʵ��UserEbi�ӿ�
	// ���Ӹ�����UserModel
	public boolean create(UserModel user) {
		// �����Ƿ�ֹ���˺�����
		if (user.getName() == null || user.getName().trim().length() <= 0) { // �������Ϊ�գ���������ȥ���ո�󳤶�С�ڵ����㣬��ֱ�ӷŻ�false
			return false;
		}
		// ֱ�ӵ���dao�Ĺ���������������ͬ
		UserDao dao = UserDaoFactory.getUserDao();
		// ��uuid
		String uuid = UuidDaoFactory.getUuidDao().getNextNum(
				UuidModelConstance.USER);
		user.setUuid(uuid);
		return dao.create(user);
	}

	// ɾ����Ӧuuid��UserModel
	public boolean delete(String uuid) {
		UserDao dao = UserDaoFactory.getUserDao();
		return dao.delete(uuid);
	}

	// �޸�UserModel
	public boolean update(UserModel user) {
		UserDao dao = UserDaoFactory.getUserDao();
		return dao.update(user);
	}

	// ��ȡ����Ԫ��
	public List<UserModel> getAll() {
		UserDao dao = UserDaoFactory.getUserDao();
		return dao.getAll();
	}
	//��ȡ����������Ա
	public List<UserModel> getAllOut(){
		UserQueryModel uqm = new UserQueryModel();
		uqm.setType(UserTypeEnum.OUT.getType());
		List<UserModel> users = getBycondition(uqm);
		return users;
	}
	// ��õ���UserModel
	public UserModel getSingle(String uuid) {
		UserDao dao = UserDaoFactory.getUserDao();
		return dao.getSingle(uuid);
	}

	// ��ѯ
	public List<UserModel> getBycondition(UserQueryModel uqm) {
		UserDao dao = UserDaoFactory.getUserDao();
		return dao.getBycondition(uqm);
	}
	//��ȡ���н�����
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
