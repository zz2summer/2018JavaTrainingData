package cn.hncu.bookStore.login.business.ebo;

import cn.hncu.bookStore.login.business.ebi.LoginEbi;
import cn.hncu.bookStore.user.business.ebi.UserEbi;
import cn.hncu.bookStore.user.business.factory.UserEbiFactory;
import cn.hncu.bookStore.user.vo.UserModel;

/**
 * ��¼ģ���ʵ����
 * @author �º���
 *
 * @version 1.0  2016-4-20
 */
public class LoginEbo implements LoginEbi{

	@Override
	public String login(String name, String pwd) {
		UserEbi ebi = UserEbiFactory.getUserEbi();
		UserModel user = ebi.getUserByName(name);
		if(user==null){
			return "�Բ��𣬸��û�������!";
		}
		if(!user.getPwd().equals(pwd)){
			return "����������벻��ȷ!";			
		}
		return null;
	}
 
}
