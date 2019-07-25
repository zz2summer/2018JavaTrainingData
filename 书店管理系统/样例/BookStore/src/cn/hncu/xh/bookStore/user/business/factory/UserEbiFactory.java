package cn.hncu.xh.bookStore.user.business.factory;

import cn.hncu.xh.bookStore.user.business.ebi.UserEbi;
import cn.hncu.xh.bookStore.user.business.ebo.UserEbo;

/**
 * <p>
 * Title:UserEbiFactory
 * </p>
 * 
 * @author <a href="mailto:1225268923@qq.com">xionghui</a>
 * @date Aug 22, 2015
 */
//工厂类，返回实现类
public class UserEbiFactory {
	public static UserEbi getUserEbi() {
		return new UserEbo();
	}
}
