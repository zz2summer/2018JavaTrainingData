package cn.hncu.bookStore.in.business.factory;

import cn.hncu.bookStore.in.business.ebi.InMainEbi;
import cn.hncu.bookStore.in.business.ebo.InMainEbo;

/**
 * ��������
 * @author �º���
 *
 * @version 1.0
 */
public class InMainEbiFactory {
	/**
	 * 
	 * @return---newһ���߼���Ľӿڵ�ʵ��
	 */
	public static InMainEbi getInMainEbi(){
		return new InMainEbo();
	}
}
