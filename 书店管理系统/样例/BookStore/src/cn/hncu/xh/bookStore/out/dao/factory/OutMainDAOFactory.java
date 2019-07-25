package cn.hncu.xh.bookStore.out.dao.factory;

import cn.hncu.xh.bookStore.out.dao.dao.OutMainDAO;
import cn.hncu.xh.bookStore.out.dao.impl.OutMainDAOImpl;

/**
 *<p>Title:OutMainDAOFactory</p>
 * @author <a href="mailto:1225268923@qq.com">xionghui</a>
 * @date Aug 27, 2015
 */
//工厂类
public class OutMainDAOFactory {
	public static OutMainDAO getOutMainDAO(){
		return new OutMainDAOImpl();  //通过实现类，获得接口
	}
}
