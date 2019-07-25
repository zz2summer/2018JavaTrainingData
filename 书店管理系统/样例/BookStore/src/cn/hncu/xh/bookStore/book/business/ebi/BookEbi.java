package cn.hncu.xh.bookStore.book.business.ebi;

import java.util.List;

import cn.hncu.xh.bookStore.book.vo.BookModel;
import cn.hncu.xh.bookStore.book.vo.BookQueryModel;

/**
 *<p>Title:BookEbi</p>
 * @author <a href="mailto:1225268923@qq.com">xionghui</a>
 * @date Aug 23, 2015
 */
//�ӿ���
public interface BookEbi {
	public boolean create(BookModel book); // �����ӿ�

	public boolean delete(String uuid); // ɾ���ӿ�

	public boolean update(BookModel book); // �޸Ľӿ�

	public List<BookModel> getAll(); // ����ȫ������ӿ�

	public BookModel getSingle(String uuid);// ��ȡ��Žӿ�
	
	public BookModel getsingle(String bookName);

	public List<BookModel> getBycondition(BookQueryModel bqm);// ��ѯ�ӿ�
}
