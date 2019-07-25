package cn.hncu.xh.bookStore.book.dao.factory;

import cn.hncu.xh.bookStore.book.dao.dao.BookDao;
import cn.hncu.xh.bookStore.book.dao.impl.BookDaoSerImpl;

/**
 *<p>Title:BookDaoFactory</p>
 * @author <a href="mailto:1225268923@qq.com">xionghui</a>
 * @date Aug 23, 2015
 */
//�����࣬����ʵ����
public class BookDaoFactory {
	public static BookDao getBookDao(){
		return new BookDaoSerImpl();
	}
}
