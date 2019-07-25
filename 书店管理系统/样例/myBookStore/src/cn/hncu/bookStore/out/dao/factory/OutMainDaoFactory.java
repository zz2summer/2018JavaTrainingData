package cn.hncu.bookStore.out.dao.factory;

import cn.hncu.bookStore.out.dao.dao.OutMainDao;
import cn.hncu.bookStore.out.dao.impl.OutMainDaoSerImpl;

/**
 * ��������---new һ������ʵ����
 * @author �º���
 * @version 1.0
 */
public class OutMainDaoFactory {
	
	public static OutMainDao getOutMainDao(){
		return new OutMainDaoSerImpl();
	}
}
