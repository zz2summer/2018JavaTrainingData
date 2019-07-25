package cn.hncu.xh.bookStore.user.dao.dao;

import java.util.List;

import cn.hncu.xh.bookStore.user.vo.UserModel;
import cn.hncu.xh.bookStore.user.vo.UserQueryModel;

/**
 *<p>Title:UserDao</p>
 * @author <a href="mailto:1225268923@qq.com">xionghui</a>
 * @date Aug 21, 2015
 */
//�ӿ���
public interface UserDao {
	/*
	 * ��������в����ڸ�user�����򴴽�һ���µġ�������ڣ���ֱ�ӷŻ�false
	 * @param user ��Ҫ���������û�����
	 * @return  ��������ɹ��򷵻�true�����򷵻�false
	 */
	public boolean create(UserModel user); // �����ӿ�

	public boolean delete(String uuid); // ɾ���ӿ�

	public boolean update(UserModel user); // �޸Ľӿ�

	public List<UserModel> getAll(); // ����ȫ������ӿ�

	public UserModel getSingle(String uuid);// ��ȡ��Žӿ�

	public List<UserModel> getBycondition(UserQueryModel uqm);// ��ѯ�ӿ�
	
}
