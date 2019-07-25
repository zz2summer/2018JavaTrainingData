package cn.hncu.bookStore.book.dao.factory;

import cn.hncu.bookStore.book.dao.dao.BookDao;
import cn.hncu.bookStore.book.dao.impl.BookDaoSerImpl;
/**
 * ��������
 * newһ��ʵ��
 * @author �º���
 * @version 1.0
 */
public class BookDaoFactory {
	/**
	 * 
	 * @return BookDao�ӿڵ�һ��ʵ��
	 */
	public static BookDao getBookDao(){
		return new BookDaoSerImpl();
	}
}
