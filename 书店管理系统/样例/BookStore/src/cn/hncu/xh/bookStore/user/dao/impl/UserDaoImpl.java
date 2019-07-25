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
//ʵ����
public class UserDaoImpl implements UserDao { //ʵ����UserDao�ӿ�
	private final String FILE_NAME = "User.txt";
	//�������
//	public static void main(String[] args) {
//		UserDaoImpl dao = new UserDaoImpl();
//		dao.create(new UserModel("002", "����", 2, "1234"));
//		dao.create(new UserModel("001", "Jack", 1, "1234"));
//		// dao.delete("002");
//		// System.out.println(dao.getSingle("001"));
//		List<UserModel> list = dao.getAll();
//		System.out.println(list);
//	}

	// ����
	public boolean create(UserModel user) {
		List<UserModel> list = getAll();
		if (list != null) {
			// ����list��������д���user�򷵻�false�������user�������ݿ���
			for (UserModel u : list) {
				if (u.getUuid().equals(user.getUuid())) {
					return false;
				}
			}
		}
		list.add(user);
		// �Ѹ��º��list�������ݿ�
		FileIOUtil.writeToFile(FILE_NAME, list);
		return true;
	}

	// ɾ��
	public boolean delete(String uuid) {
		List<UserModel> list = getAll();
		if (list == null) {
			return false;
		}
		// ����list����Ҫɾ���Ķ�����list�е�λ���ҵ�����ɾ��
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getUuid().equals(uuid)) {
				list.remove(i);
				FileIOUtil.writeToFile(FILE_NAME, list);
				return true;
			}
		}
		return false;
	}

	// �޸�
	public boolean update(UserModel user) {
		List<UserModel> list = getAll();
		if (list == null) {
			return false;
		}
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getUuid().equals(user.getUuid())) {
				list.set(i, user);
				FileIOUtil.writeToFile(FILE_NAME, list);// д�����ݲ�
				return true;
			}
		}
		return false;
	}

	// ���ȫ��
	public List<UserModel> getAll() {
		List<UserModel> list = FileIOUtil.readFromFile(FILE_NAME);
		return list;
	}

	// ��õ���
	public UserModel getSingle(String uuid) {
		List<UserModel> list = getAll();//�����ݿ��е�Ԫ��ȫ����ȡ����
		//����list���ҵ�����Ҫ�ҵ�Ԫ��Ϊֹ
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getUuid().equals(uuid)) {
				return list.get(i);  //ֱ�ӷ������Ԫ��
			}
		}
		return null;//�ߵ���һ������˵��list��û�����uuid��Ԫ�أ�����null
	}

	// ��ò�ѯ
	public List<UserModel> getBycondition(UserQueryModel uqm) {
		List<UserModel> list = getAll();		// �Ӻ�̨�����е����ݼ���ȡ����
		List<UserModel> ret = new ArrayList<UserModel>();// ��Ž����
		if (uqm == null) {
			return list;
		}
		// Ȼ����������������ɸѡ��ɸѡʣ�µľ��ǲ�ѯ���
		for (UserModel user : list) {
			// ���������ж�uuid
			if (uqm.getUuid() != null && uqm.getUuid().trim().length() > 0) {// ����֤��ѯ������Ч
				if (!user.getUuid().equals(uqm.getUuid())) { //���˵�uuid��ƥ���
					continue;
				}
			}
			// ���������ж��û���
			if (uqm.getName() != null && uqm.getName().trim().length() > 0) {// ����֤��ѯ������Ч
				if (!user.getName().contains(uqm.getName().trim())) { //���˵����ֲ�ƥ���
					continue;
				}
			}
			// ���������ж��û�����
			if (uqm.getType() > 0) {  //����û�û��ѡ�û����ͣ���ô��Ĭ��ȫ������Ҫ�鵽
				if (uqm.getType() != user.getType()) { //���˵����Ͳ�ƥ���
					continue;
				}
			}
			ret.add(user);
		}
		return ret;
	}

}
