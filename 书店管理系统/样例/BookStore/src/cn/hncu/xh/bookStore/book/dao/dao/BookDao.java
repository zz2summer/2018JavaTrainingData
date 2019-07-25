package cn.hncu.xh.bookStore.book.dao.dao;

import java.util.List;

import cn.hncu.xh.bookStore.book.vo.BookModel;
import cn.hncu.xh.bookStore.book.vo.BookQueryModel;

/**
 *<p>Title:BookDao</p>
 * @author <a href="mailto:1225268923@qq.com">xionghui</a>
 * @date Aug 23, 2015
 */
//接口类
public interface BookDao {
	public boolean create(BookModel book); // 创建接口

	public boolean delete(String uuid); // 删除接口

	public boolean update(BookModel book); // 修改接口

	public List<BookModel> getAll(); // 返回全部对象接口

	public BookModel getSingle(String uuid);// 获取编号接口
	

	public List<BookModel> getBycondition(BookQueryModel bqm);// 查询接口
}
