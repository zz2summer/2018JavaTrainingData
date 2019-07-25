package cn.hncu.bookStore.out.dao.factory;

import cn.hncu.bookStore.out.dao.dao.OutDetailDao;
import cn.hncu.bookStore.out.dao.impl.OutDetailDaoSerImpl;

/**
 * ��������----new һ��������ϸ��ʵ����
 * @author �º���
 *
 * @version 1.0
 */
public class OutDetailDaoFactory {
	
	public static OutDetailDao getOutDetailDao(){
		return new OutDetailDaoSerImpl();
	}
}
