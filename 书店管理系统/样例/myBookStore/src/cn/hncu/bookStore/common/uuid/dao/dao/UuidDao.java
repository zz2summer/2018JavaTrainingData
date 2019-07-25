package cn.hncu.bookStore.common.uuid.dao.dao;

import cn.hncu.bookStore.common.UuidModelConstance;

/**
 * Uuidģ������ݽӿ�
 * @author �º���
 * @version 1.0
 */
public interface UuidDao {
	/**
	 * 
	 * @param uuidEnum---�����ģ������
	 * @return ---���ݴ����ģ���������ֱ𷵻���һ���ڲ����ɵ�Uuid
	 */
	public String getNextUuid(UuidModelConstance uuidEnum);
}
