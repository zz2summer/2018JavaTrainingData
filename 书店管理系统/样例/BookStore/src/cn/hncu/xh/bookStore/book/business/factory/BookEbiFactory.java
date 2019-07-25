package cn.hncu.xh.bookStore.book.business.factory;

import cn.hncu.xh.bookStore.book.business.ebi.BookEbi;
import cn.hncu.xh.bookStore.book.business.ebo.BookEbo;

/**
 *<p>Title:BookEbiFactory</p>
 * @author <a href="mailto:1225268923@qq.com">xionghui</a>
 * @date Aug 23, 2015
 */
//工厂类，调用实现类
public class BookEbiFactory {
	public static BookEbi getBookEbi(){
		return new BookEbo();
	}
}
