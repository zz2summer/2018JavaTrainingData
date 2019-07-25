package cn.hncu.xh.bookStore.book.business.ebo;

import java.util.List;

import cn.hncu.xh.bookStore.book.business.ebi.BookEbi;
import cn.hncu.xh.bookStore.book.dao.factory.BookDaoFactory;
import cn.hncu.xh.bookStore.book.vo.BookModel;
import cn.hncu.xh.bookStore.book.vo.BookQueryModel;
import cn.hncu.xh.bookStore.common.constance.UuidModelConstance;
import cn.hncu.xh.bookStore.common.dao.factory.UuidDaoFactory;

/**
 * <p>
 * Title:BookEbo
 * </p>
 * 
 * @author <a href="mailto:1225268923@qq.com">xionghui</a>
 * @date Aug 23, 2015
 */
// 实现类
public class BookEbo implements BookEbi {//实现了BookEbi接口
	//增加给定的BookModel
	public boolean create(BookModel book) {
		//直接调用BOOkDao的工厂方法，下面相同
		//补uuid
		String uuid=UuidDaoFactory.getUuidDao().getNextNum(UuidModelConstance.BOOK); //调用唱票模块的工厂方法，或的uuid
		book.setUuid(uuid); //设置uuid
		return BookDaoFactory.getBookDao().create(book);
	}
	//删除指定uuid的BookModel
	public boolean delete(String uuid) {
		return BookDaoFactory.getBookDao().delete(uuid);
	}
	//获取所有元素
	public List<BookModel> getAll() {
		return BookDaoFactory.getBookDao().getAll();
	}
	//查询
	public List<BookModel> getBycondition(BookQueryModel bqm) {
		return BookDaoFactory.getBookDao().getBycondition(bqm);
	}
	//获得指定uuid的BookModel
	public BookModel getSingle(String uuid) {
		return BookDaoFactory.getBookDao().getSingle(uuid);
	}
	//修改BookModel
	public boolean update(BookModel book) {
		return BookDaoFactory.getBookDao().update(book);
	}
	public BookModel getsingle(String bookName) {
		List<BookModel> list=getAll();
		for(BookModel book:list){
			if(book.getName().equals(bookName)){
				return book;
			}
		}
		return null;
	}

}
