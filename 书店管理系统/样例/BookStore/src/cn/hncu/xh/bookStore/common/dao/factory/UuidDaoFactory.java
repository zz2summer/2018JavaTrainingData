package cn.hncu.xh.bookStore.common.dao.factory;

import cn.hncu.xh.bookStore.common.dao.dao.UuidDao;
import cn.hncu.xh.bookStore.common.dao.impl.UuidDaoSerImpl;

/**
 *<p>Title:UuidDaoFactory</p>
 * @author <a href="mailto:1225268923@qq.com">xionghui</a>
 * @date Aug 24, 2015
 */
//工厂类，调用实现类，返回接口
public class UuidDaoFactory {
	public static UuidDao getUuidDao(){
		return new UuidDaoSerImpl(); 
	}
}
