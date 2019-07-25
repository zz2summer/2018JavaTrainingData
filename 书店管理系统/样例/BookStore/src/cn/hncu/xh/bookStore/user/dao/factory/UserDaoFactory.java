package cn.hncu.xh.bookStore.user.dao.factory;

import cn.hncu.xh.bookStore.user.dao.dao.UserDao;
import cn.hncu.xh.bookStore.user.dao.impl.UserDaoImpl;

/**
 *<p>Title:UserDaoFactory</p>
 * @author <a href="mailto:1225268923@qq.com">xionghui</a>
 * @date Aug 22, 2015
 */
//����������ͨ����������������ʵ����
public class UserDaoFactory {
	public static UserDao getUserDao(){
		return new UserDaoImpl();
	}
}
