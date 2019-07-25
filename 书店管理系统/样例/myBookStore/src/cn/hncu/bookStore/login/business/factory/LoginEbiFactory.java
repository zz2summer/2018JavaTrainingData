package cn.hncu.bookStore.login.business.factory;

import cn.hncu.bookStore.login.business.ebi.LoginEbi;
import cn.hncu.bookStore.login.business.ebo.LoginEbo;

/**
 * ��¼ģ��Ĺ�����
 * @author �º���
 *
 * @version 1.0  2016-4-20
 */
public class LoginEbiFactory {
	
	/**
	 * ��������
	 * @return
	 */
	public static LoginEbi getLoginEbi(){
		return new LoginEbo();
	}
}
