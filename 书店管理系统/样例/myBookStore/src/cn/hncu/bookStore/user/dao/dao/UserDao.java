package cn.hncu.bookStore.user.dao.dao;

import java.util.List;

import cn.hncu.bookStore.user.vo.UserModel;
import cn.hncu.bookStore.user.vo.UserQueryModel;

/**
 * 
 * @author �º���
 *
 * @version 1.0
 * �û�ģ������ݲ�ӿ�
 */
public interface UserDao {
	/**
	 * ���ܣ�����һ���û�
	 * 
	 * @param userModel---��Ҫ�������û�����
	 * @return---true��ʾ�����ɹ���false��ʾ����ʧ��
	 */
	public boolean create(UserModel user);
	
	/**
	 * ���ܣ������û���Ψһ��ʶ��uuidɾ��һ���û�
	 * 
	 * @param uuid---�û�Ψһ�ı�ʶ�룬ÿ���û���������ͬ
	 * @return---true��ʾɾ���ɹ���false��ʾɾ��ʧ��
	 */
	public boolean delete(String uuid);
	 
	/**
	 * ���ܣ��޸��û�����������
	 * 
	 * @param user---��Ҫ�޸ĵ��û����ݲ�����
	 * @return ����true-��ʾ�޸ĳɹ��ˣ�����false-��ʾ�޸�ʧ��
	 */
	public boolean update(UserModel user);
	
	/**
	 * ���ܣ��õ����е��û�����
	 * 
	 * @return---һ��UserModel���ϣ�Ҳ�����û�������
	 */
	public List<UserModel> getAll();
	
	/**
	 * ���ܣ�����һ���Ĳ����������в��ң�
	 * <br/>
	 * ����������������û����ݷ��ء�
	 * 
	 * @param uqm---����װ�Ĳ�������
	 * @return---��������������û����ݼ���
	 */
	public List<UserModel> getbyCondition(UserQueryModel uqm);
	
	/**
	 * ���ܣ��õ�һ��ȷ�����û�����������
	 * 
	 * @param uuid---�û�Ψһ��ʶ��
	 * @return ---���ذ����Ψһ��ʶ���ҵ����û�����
	 */
	public UserModel getSingle(String uuid);
	
}
