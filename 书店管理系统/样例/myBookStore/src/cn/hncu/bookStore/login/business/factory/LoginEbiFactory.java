package cn.hncu.bookStore.login.business.factory;

import cn.hncu.bookStore.login.business.ebi.LoginEbi;
import cn.hncu.bookStore.login.business.ebo.LoginEbo;

/**
 * 登录模块的工厂类
 * @author 陈浩翔
 *
 * @version 1.0  2016-4-20
 */
public class LoginEbiFactory {
	
	/**
	 * 工厂方法
	 * @return
	 */
	public static LoginEbi getLoginEbi(){
		return new LoginEbo();
	}
}
