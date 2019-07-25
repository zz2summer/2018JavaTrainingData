package cn.hncu.bookStore.common.uuid.dao.factory;

import cn.hncu.bookStore.common.uuid.dao.dao.UuidDao;
import cn.hncu.bookStore.common.uuid.dao.impl.UuidDaoSerImpl;

/**
 * ��������
 * @author �º���
 * @version 1.0
 */
public class UuidDaoFactory {
	/**
	 * 
	 * @return newһ��UuidDao�ľ���ʵ����
	 */
	public static UuidDao getUuidDao(){
		return new UuidDaoSerImpl();
	}
}
