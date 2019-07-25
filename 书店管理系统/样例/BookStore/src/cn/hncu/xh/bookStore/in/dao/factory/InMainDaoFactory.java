package cn.hncu.xh.bookStore.in.dao.factory;

import cn.hncu.xh.bookStore.in.dao.dao.InMainDao;
import cn.hncu.xh.bookStore.in.dao.impl.InMainDaoserImpl;

/**
 *<p>Title:InMainDaoFactory</p>
 * @author <a href="mailto:1225268923@qq.com">xionghui</a>
 * @date Aug 25, 2015
 */
//π§≥ß¿‡
public class InMainDaoFactory {
	public static InMainDao getInMainDao(){
		return new InMainDaoserImpl(); 
	}
}
