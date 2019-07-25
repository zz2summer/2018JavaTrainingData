package cn.hncu.bookStore.user.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import cn.hncu.bookStore.common.UserTypeEnum;
import cn.hncu.bookStore.user.business.factory.UserEbiFactory;
import cn.hncu.bookStore.user.dao.dao.UserDao;
import cn.hncu.bookStore.user.vo.UserModel;
import cn.hncu.bookStore.user.vo.UserQueryModel;
import cn.hncu.bookStore.util.FileIoUtil;
import cn.hncu.bookStore.util.StringComparison;

/**
 * <br/>
 * ���û����ݴ���ľ���ʵ���� ----ʵ����UserDao�ӿ�
 * 
 * @author �º���
 * 
 * @version 1.0
 */
public class UserDaoSerImpl implements UserDao {

	private static final String FILE_NAME = "User.txt";

	@Override
	public boolean create(UserModel user) {
		
		if(user.getName().equals("admin")){
			return false;
		}
		
		// 1�Ȱ����е����ݷ����л�(��)����
		List<UserModel> list = FileIoUtil.readFormFile(FILE_NAME);
		// 2�жϸ��û��Ƿ��Ѿ����ڣ��پ����Ƿ񴴽�
		for (UserModel userModel : list) {
			// ���2���û���uuid��ȣ��û�������ͬ��
			if (userModel.getUuid().equals(user.getUuid())) {
				return false;// �û��Ѿ������ˣ�����false
			}
			if (userModel.getName().equals(user.getName())) {
				return false;// �û������Ѿ������ˣ�����false
			}
		}
		// 3����û������ڣ��ʹ���
		list.add(user);
		FileIoUtil.write2file(list, FILE_NAME);
		return true;// �����ɹ�������true
	}

	@Override
	public boolean delete(String uuid) {

		// 1�Ȱ����е����ݷ����л�(��)����
		List<UserModel> list = FileIoUtil.readFormFile(FILE_NAME);

		// 2�жϸ��û��Ƿ��Ѿ����ڣ��پ����Ƿ�ɾ��

		// for(int i=0;i<list.size();i++){
		// if(list.get(i).getUuid().equals(uuid)){
		// list.remove(i);
		// FileIoUtil.write2file(list, FILE_NAME);
		// return true;
		// }
		// }

		for (UserModel userModel : list) {
			// ���2���û���uuid��ȣ��û�������ͬ��
			if (userModel.getUuid().equals(uuid)) {
				list.remove(userModel);
				FileIoUtil.write2file(list, FILE_NAME);
				// ɾ���ɹ�������true
				return true;
			}
		}
		// 3�û�������
		// ɾ��ʧ�ܣ�����false
		return false;
	}

	@Override
	public boolean update(UserModel user) {
		// 1�Ȱ����е����ݷ����л�(��)����
		List<UserModel> list = FileIoUtil.readFormFile(FILE_NAME);

		// 2�жϸ��û��Ƿ��Ѿ����ڣ��پ����Ƿ񴴽�
		for (int i = 0; i < list.size(); i++) {
			// uuid�ǲ��ܸĵģ�ͨ��uuid���ҵ��Ǹ��û����ݣ����޸ľ�ok��
			if (list.get(i).getUuid().equals(user.getUuid())) {
				// ���ҵ����û��޸ĳ�user
				list.set(i, user);
				FileIoUtil.write2file(list, FILE_NAME);
				// �ҵ��û�������true
				return true;
			}
		}
		// 3�����û������ڣ����޸�ʧ��
		return false;
	}

	@Override
	public List<UserModel> getAll() {
		return FileIoUtil.readFormFile(FILE_NAME);
	}

	@Override
	public List<UserModel> getbyCondition(UserQueryModel uqm) {
		List<UserModel> list = UserEbiFactory.getUserEbi().getAll();
		List<UserModel> results = new ArrayList<UserModel>();
		
		for(UserModel user : list){
			//���߼���������: ����ж��û������Ƿ��ǲ�ѯ����;�ڲ��жϸö����Ƿ���ϲ�ѯ����
			if(!StringComparison.stringEquals(user.getUuid(), uqm.getUuid())){
				continue;
			}//��ȷƥ��
			
			//��������ģ��ƥ��
			if(!StringComparison.stringIndexOf(user.getName(), uqm.getName())){
				continue;
			}
			
			if(uqm.getType()>0){//����ж�
					if(user.getType()!=uqm.getType()){//�ڲ��ж�--��ȷ��ѯ
						continue;
				}
			}
			
			results.add(user);
		}
		
		return results;
	}

	@Override
	public UserModel getSingle(String uuid) {
		// 1�Ȱ����е����ݷ����л�(��)����
		List<UserModel> list = FileIoUtil.readFormFile(FILE_NAME);

		// 2�жϸ��û��Ƿ��Ѿ�����,���ھͷ����Ǹ��û�
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getUuid().equals(uuid)) {
				return list.get(i);
			}
		}
		
		// 3�����û�������,����null
		return null;
	}

}
