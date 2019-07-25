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
// �ӿ���
public interface UserEbi {
	public boolean create(UserModel user); // �����ӿ�

	public boolean delete(String uuid); // ɾ���ӿ�

	public boolean update(UserModel user); // �޸Ľӿ�

	public List<UserModel> getAll(); // ����ȫ������ӿ�

	public UserModel getSingle(String uuid);// ��ȡ��Žӿ�

	public List<UserModel> getBycondition(UserQueryModel uqm);// ��ѯ�ӿ�

	public List<UserModel> getAllIn();

	public UserModel getsingle(String userName);

	public List<UserModel> getAllOut();
}
