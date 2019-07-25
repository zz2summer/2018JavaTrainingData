package cn.hncu.xh.bookStore.out.dao.factory;

import cn.hncu.xh.bookStore.out.dao.dao.OutDetailDAO;
import cn.hncu.xh.bookStore.out.dao.impl.OutDetailDAOImpl;

/**
 *<p>Title:OutDetailDAOFactory</p>
 * @author <a href="mailto:1225268923@qq.com">xionghui</a>
 * @date Aug 27, 2015
 */
public class OutDetailDAOFactory {
	public static OutDetailDAO getOutDetailDAO(){
		return new OutDetailDAOImpl();  //通过实现类，获得接口
	}
}
