package cn.hncu.xh.bookStore.in.dao.factory;

import cn.hncu.xh.bookStore.in.dao.dao.InDtailDao;
import cn.hncu.xh.bookStore.in.dao.impl.InDetailSerImpl;

/**
 *<p>Title:InDetailDAOFactory</p>
 * @author <a href="mailto:1225268923@qq.com">xionghui</a>
 * @date Aug 25, 2015
 */
public class InDetailDAOFactory {
	public static InDtailDao getInDetailDao(){
		return new InDetailSerImpl();
	}
}	
