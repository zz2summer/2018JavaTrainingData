package cn.hncu.xh.bookStore.book.dao.impl;

import java.util.ArrayList;
import java.util.List;

import cn.hncu.xh.bookStore.book.dao.dao.BookDao;
import cn.hncu.xh.bookStore.book.vo.BookModel;
import cn.hncu.xh.bookStore.book.vo.BookQueryModel;
import cn.hncu.xh.bookStore.util.FileIOUtil;

/**
 * <p>
 * Title:BookDaoSerImpl
 * </p>
 * 
 * @author <a href="mailto:1225268923@qq.com">xionghui</a>
 * @date Aug 23, 2015
 */
// 实现类
public class BookDaoSerImpl implements BookDao { // 实现BookDao
	private static String FILE_NAME = "book.txt"; // BookModel存放的路径(这里文件名)

	// 增加（把给定的BookModel加入到对应的数据库中）
	public boolean create(BookModel book) {
		List<BookModel> list = getAll(); // 把数据库中的元素全部通过GetAll()方法读取出来
		// 使用加强for循环遍历list判断其中是的否已经存在需要加进去的元素
		for (BookModel b : list) {
			if (b.getUuid().equals(book.getUuid())) { // 如果uuid能匹配到，说明存在，否则不存在
				return false;
			}
		}
		list.add(book);// 到这一步说明不存在，就把需要加进去的元素加入到list中
		FileIOUtil.writeToFile(FILE_NAME, list);// 把list写到数据库对应的文件中
		return true;
	}

	// 给定指定uuid，删除对应BookModel
	public boolean delete(String uuid) {
		List<BookModel> list = getAll(); // 把数据库中的元素全部通过GetAll()方法读取出来
		// 使用加强for循环遍历list,找到uuid对应的元素，并把他remove掉，然后写回数据库中对应的文件中
		for (BookModel b : list) {
			if (b.getUuid().equals(uuid)) { // 如果uuid能匹配到，说明存在，否则不存在
				list.remove(b);// 把找的元素移除掉
				FileIOUtil.writeToFile(FILE_NAME, list);// 把list写到数据库对应的文件中
				return true;
			}
		}
		return false;
	}

	// 修改
	public boolean update(BookModel book) {
		List<BookModel> list = getAll(); // 把数据库中的元素全部通过GetAll()方法读取出来
		// 遍历list，找到对应的uuid对应的元素，并替换掉
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getUuid().equals(book.getUuid())) { // 找到匹配uuid的元素在list中位置
				list.set(i, book); // 把找到的元素用指定修改元素替换掉
				FileIOUtil.writeToFile(FILE_NAME, list); // 把list写到数据库对应的文件中
				return true;
			}
		}
		return false;
	}
	//查询
	public List<BookModel> getBycondition(BookQueryModel bqm) {
		List<BookModel> list = getAll(); // 把数据库中的元素全部通过GetAll()方法读取出来
		List<BookModel> ret = new ArrayList<BookModel>(); // 用来装查询结果的list
		//如果bqm为ull，则返回所有元素
		if(bqm==null){
			return list;
		}
		//利用增加for循环，遍历list
		for(BookModel book:list){
			//反逻辑，卫条件：uuid
			if(bqm.getUuid()!=null&&bqm.getUuid().trim().length()>0){ //这里是保证数据合法
				if(!bqm.getUuid().equals(book.getUuid())){ //过滤uuid不匹配的元素
					continue;
				}
			}
			//反逻辑，卫条件：name
			if(bqm.getName()!=null&&bqm.getName().trim().length()>0){ //这里是保证数据合法
				if(!book.getName().toLowerCase().contains((bqm.getName().toLowerCase()))){ //过滤name不匹配的元素,忽略大小写
					continue;
				}
			}
			//反逻辑，卫条件：inPrice
			if(bqm.getInPrice()>0){
				if(book.getInPrice()<bqm.getInPrice()){//如果书的进价比用户输入的最小进货价还小，则过滤掉
					continue;
				}
			}
			if(bqm.getInPrice2()>0){
				if(book.getInPrice()>bqm.getInPrice2()){//如果书的进价比用户输入的最大进货价还大，则过滤掉
					continue;
				}
			}
			//反逻辑，卫条件：salePrice
			if(bqm.getSalePrice()>0){
				if(book.getSalePrice()<bqm.getSalePrice()){//如果书的售货价比用户输入的最小售货价还小，则过滤掉
					continue;
				}
			}
			if(bqm.getSalePrice2()>0){
				if(book.getSalePrice()>bqm.getSalePrice2()){//如果书的售货价比用户输入的最大售货价还大，则过滤掉
					continue;
				}
			}
			ret.add(book);
		}
		return ret;
	}

	// 在对应得文件中获得全部元素
	public List<BookModel> getAll() {
		return FileIOUtil.readFromFile(FILE_NAME); // 直接条用Util类中的FileIOUtil的readFromFile方法读取数据
	}

	public BookModel getSingle(String uuid) {
		List<BookModel> list = getAll(); // 把数据库中的元素全部通过GetAll()方法读取出来
		// 遍历list，找到对应的uuid对应的元素，并返回
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getUuid().equals(uuid)) { // 找到匹配uuid的元素在list中位置
				return list.get(i); //直接返回匹配到的元素
			}
		}
		return null;
	}
}
