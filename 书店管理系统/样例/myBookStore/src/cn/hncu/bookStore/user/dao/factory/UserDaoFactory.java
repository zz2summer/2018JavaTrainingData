package cn.hncu.bookStore.user.dao.factory;

import cn.hncu.bookStore.user.dao.dao.UserDao;
import cn.hncu.bookStore.user.dao.impl.UserDaoSerImpl;
/**
 * ��������<br/>
 * new һ��dao��ʵ��
 * @author �º���
 *
 * @version 1.0
 * 
 */
public class UserDaoFactory {
	public static UserDao getUserDao(){
		return new UserDaoSerImpl();
	}
}
