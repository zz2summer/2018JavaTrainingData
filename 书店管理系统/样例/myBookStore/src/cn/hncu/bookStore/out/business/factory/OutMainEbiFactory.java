package cn.hncu.bookStore.out.business.factory;

import cn.hncu.bookStore.out.business.ebi.OutMainEbi;
import cn.hncu.bookStore.out.business.ebo.OutMainEbo;

/**
 * ��������
 * @author �º���
 *
 * @version 1.0
 */
public class OutMainEbiFactory {
	/**
	 * 
	 * @return---newһ���߼���Ľӿڵ�ʵ��
	 */
	public static OutMainEbi getOutMainEbi(){
		return new OutMainEbo();
	}
}
