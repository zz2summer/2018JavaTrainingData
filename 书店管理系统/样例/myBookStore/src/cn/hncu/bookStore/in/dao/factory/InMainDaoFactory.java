package cn.hncu.bookStore.in.dao.factory;

import cn.hncu.bookStore.in.dao.dao.InMainDao;
import cn.hncu.bookStore.in.dao.impl.InMainDaoSerImpl;

/**
 * ��������---new һ������ʵ����
 * @author �º���
 * @version 1.0
 */
public class InMainDaoFactory {
	
	public static InMainDao getInMainDao(){
		return new InMainDaoSerImpl();
	}
}
