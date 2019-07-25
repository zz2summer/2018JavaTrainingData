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
// ʵ����
public class BookDaoSerImpl implements BookDao { // ʵ��BookDao
	private static String FILE_NAME = "book.txt"; // BookModel��ŵ�·��(�����ļ���)

	// ���ӣ��Ѹ�����BookModel���뵽��Ӧ�����ݿ��У�
	public boolean create(BookModel book) {
		List<BookModel> list = getAll(); // �����ݿ��е�Ԫ��ȫ��ͨ��GetAll()������ȡ����
		// ʹ�ü�ǿforѭ������list�ж������ǵķ��Ѿ�������Ҫ�ӽ�ȥ��Ԫ��
		for (BookModel b : list) {
			if (b.getUuid().equals(book.getUuid())) { // ���uuid��ƥ�䵽��˵�����ڣ����򲻴���
				return false;
			}
		}
		list.add(book);// ����һ��˵�������ڣ��Ͱ���Ҫ�ӽ�ȥ��Ԫ�ؼ��뵽list��
		FileIOUtil.writeToFile(FILE_NAME, list);// ��listд�����ݿ��Ӧ���ļ���
		return true;
	}

	// ����ָ��uuid��ɾ����ӦBookModel
	public boolean delete(String uuid) {
		List<BookModel> list = getAll(); // �����ݿ��е�Ԫ��ȫ��ͨ��GetAll()������ȡ����
		// ʹ�ü�ǿforѭ������list,�ҵ�uuid��Ӧ��Ԫ�أ�������remove����Ȼ��д�����ݿ��ж�Ӧ���ļ���
		for (BookModel b : list) {
			if (b.getUuid().equals(uuid)) { // ���uuid��ƥ�䵽��˵�����ڣ����򲻴���
				list.remove(b);// ���ҵ�Ԫ���Ƴ���
				FileIOUtil.writeToFile(FILE_NAME, list);// ��listд�����ݿ��Ӧ���ļ���
				return true;
			}
		}
		return false;
	}

	// �޸�
	public boolean update(BookModel book) {
		List<BookModel> list = getAll(); // �����ݿ��е�Ԫ��ȫ��ͨ��GetAll()������ȡ����
		// ����list���ҵ���Ӧ��uuid��Ӧ��Ԫ�أ����滻��
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getUuid().equals(book.getUuid())) { // �ҵ�ƥ��uuid��Ԫ����list��λ��
				list.set(i, book); // ���ҵ���Ԫ����ָ���޸�Ԫ���滻��
				FileIOUtil.writeToFile(FILE_NAME, list); // ��listд�����ݿ��Ӧ���ļ���
				return true;
			}
		}
		return false;
	}
	//��ѯ
	public List<BookModel> getBycondition(BookQueryModel bqm) {
		List<BookModel> list = getAll(); // �����ݿ��е�Ԫ��ȫ��ͨ��GetAll()������ȡ����
		List<BookModel> ret = new ArrayList<BookModel>(); // ����װ��ѯ�����list
		//���bqmΪull���򷵻�����Ԫ��
		if(bqm==null){
			return list;
		}
		//��������forѭ��������list
		for(BookModel book:list){
			//���߼�����������uuid
			if(bqm.getUuid()!=null&&bqm.getUuid().trim().length()>0){ //�����Ǳ�֤���ݺϷ�
				if(!bqm.getUuid().equals(book.getUuid())){ //����uuid��ƥ���Ԫ��
					continue;
				}
			}
			//���߼�����������name
			if(bqm.getName()!=null&&bqm.getName().trim().length()>0){ //�����Ǳ�֤���ݺϷ�
				if(!book.getName().toLowerCase().contains((bqm.getName().toLowerCase()))){ //����name��ƥ���Ԫ��,���Դ�Сд
					continue;
				}
			}
			//���߼�����������inPrice
			if(bqm.getInPrice()>0){
				if(book.getInPrice()<bqm.getInPrice()){//�����Ľ��۱��û��������С�����ۻ�С������˵�
					continue;
				}
			}
			if(bqm.getInPrice2()>0){
				if(book.getInPrice()>bqm.getInPrice2()){//�����Ľ��۱��û�������������ۻ�������˵�
					continue;
				}
			}
			//���߼�����������salePrice
			if(bqm.getSalePrice()>0){
				if(book.getSalePrice()<bqm.getSalePrice()){//�������ۻ��۱��û��������С�ۻ��ۻ�С������˵�
					continue;
				}
			}
			if(bqm.getSalePrice2()>0){
				if(book.getSalePrice()>bqm.getSalePrice2()){//�������ۻ��۱��û����������ۻ��ۻ�������˵�
					continue;
				}
			}
			ret.add(book);
		}
		return ret;
	}

	// �ڶ�Ӧ���ļ��л��ȫ��Ԫ��
	public List<BookModel> getAll() {
		return FileIOUtil.readFromFile(FILE_NAME); // ֱ������Util���е�FileIOUtil��readFromFile������ȡ����
	}

	public BookModel getSingle(String uuid) {
		List<BookModel> list = getAll(); // �����ݿ��е�Ԫ��ȫ��ͨ��GetAll()������ȡ����
		// ����list���ҵ���Ӧ��uuid��Ӧ��Ԫ�أ�������
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getUuid().equals(uuid)) { // �ҵ�ƥ��uuid��Ԫ����list��λ��
				return list.get(i); //ֱ�ӷ���ƥ�䵽��Ԫ��
			}
		}
		return null;
	}
}
