package cn.hncu.xh.bookStore.login.business.factory;

import cn.hncu.xh.bookStore.login.business.ebi.LoginEbi;
import cn.hncu.xh.bookStore.login.business.ebo.LoginEbo;

/**
 *<p>Title:LoginEbiFactory</p>
 * @author <a href="mailto:1225268923@qq.com">xionghui</a>
 * @date Aug 27, 2015
 */
public class LoginEbiFactory {
	public static LoginEbi getLoginEbi(){
		return new LoginEbo();
	}
}
