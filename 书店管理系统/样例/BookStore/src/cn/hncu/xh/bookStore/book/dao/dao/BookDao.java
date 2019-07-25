package cn.hncu.xh.bookStore.book.dao.dao;

import java.util.List;

import cn.hncu.xh.bookStore.book.vo.BookModel;
import cn.hncu.xh.bookStore.book.vo.BookQueryModel;

/**
 *<p>Title:BookDao</p>
 * @author <a href="mailto:1225268923@qq.com">xionghui</a>
 * @date Aug 23, 2015
 */
//�ӿ���
public interface BookDao {
	public boolean create(BookModel book); // �����ӿ�

	public boolean delete(String uuid); // ɾ���ӿ�

	public boolean update(BookModel book); // �޸Ľӿ�

	public List<BookModel> getAll(); // ����ȫ������ӿ�

	public BookModel getSingle(String uuid);// ��ȡ��Žӿ�
	

	public List<BookModel> getBycondition(BookQueryModel bqm);// ��ѯ�ӿ�
}
