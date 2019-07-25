package cn.hncu.bookStore.in.dao.factory;

import cn.hncu.bookStore.in.dao.dao.InDetailDao;
import cn.hncu.bookStore.in.dao.impl.InDetailDaoSerImpl;

/**
 * ��������----new һ��������ϸ��ʵ����
 * @author �º���
 *
 * @version 1.0
 */
public class InDetailDaoFactory {
	
	public static InDetailDao getInDetailDao(){
		return new InDetailDaoSerImpl();
	}
}
