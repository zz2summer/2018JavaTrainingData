package cn.hncu.bookStore.book.business.factory;

import cn.hncu.bookStore.book.business.ebi.BookEbi;
import cn.hncu.bookStore.book.business.ebo.BookEbo;
/**
 * ��������
 *new һ��ʵ��
 * @author �º���
 * @version 1.0
 */
public class BookEbiFactory {
	
	public static BookEbi getBookEbi(){
		return new BookEbo();
	}
}
