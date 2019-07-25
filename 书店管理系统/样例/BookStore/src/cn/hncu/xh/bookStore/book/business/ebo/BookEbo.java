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
// ʵ����
public class BookEbo implements BookEbi {//ʵ����BookEbi�ӿ�
	//���Ӹ�����BookModel
	public boolean create(BookModel book) {
		//ֱ�ӵ���BOOkDao�Ĺ���������������ͬ
		//��uuid
		String uuid=UuidDaoFactory.getUuidDao().getNextNum(UuidModelConstance.BOOK); //���ó�Ʊģ��Ĺ������������uuid
		book.setUuid(uuid); //����uuid
		return BookDaoFactory.getBookDao().create(book);
	}
	//ɾ��ָ��uuid��BookModel
	public boolean delete(String uuid) {
		return BookDaoFactory.getBookDao().delete(uuid);
	}
	//��ȡ����Ԫ��
	public List<BookModel> getAll() {
		return BookDaoFactory.getBookDao().getAll();
	}
	//��ѯ
	public List<BookModel> getBycondition(BookQueryModel bqm) {
		return BookDaoFactory.getBookDao().getBycondition(bqm);
	}
	//���ָ��uuid��BookModel
	public BookModel getSingle(String uuid) {
		return BookDaoFactory.getBookDao().getSingle(uuid);
	}
	//�޸�BookModel
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
