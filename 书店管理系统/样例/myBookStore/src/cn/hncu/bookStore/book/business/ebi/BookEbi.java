package cn.hncu.bookStore.book.business.ebi;

import java.util.List;

import cn.hncu.bookStore.book.vo.BookModel;
import cn.hncu.bookStore.book.vo.BookQueryModel;

/**
 * 
 * @author �º���
 *
 * @version 1.0
 * ͼ��ģ����߼���ӿ�
 */
public interface BookEbi {
		
		/**
		 * ���ܣ�����һ��ͼ��
		 * 
		 * @param bookModel---��Ҫ������ͼ������
		 * @return---true��ʾ�����ɹ���false��ʾ����ʧ��
		 */
		public boolean create(BookModel book);
		
		
		/**
		 * ���ܣ�����ͼ���Ψһ��ʶ��uuidɾ��һ��ͼ��
		 * 
		 * @param uuid---ͼ��Ψһ�ı�ʶ�룬ÿ��ͼ�鶼������ͬ
		 * @return---true��ʾɾ���ɹ���false��ʾɾ��ʧ��
		 */
		public boolean delete(String uuid);
		 
		
		/**
		 * ���ܣ��޸�ͼ�����������
		 * 
		 * @param user---��Ҫ�޸ĵ�ͼ�����ݲ�����
		 * @return ����true-��ʾ�޸ĳɹ��ˣ�����false-��ʾ�޸�ʧ��
		 */
		public boolean update(BookModel book);
		
		
		/**
		 * ���ܣ��õ����е�ͼ������
		 * 
		 * @return---һ��BookModel���ϣ�Ҳ����ͼ�������
		 */
		public List<BookModel> getAll();
		
		
		/**
		 * ���ܣ�����һ���Ĳ����������в��ң�
		 * <br/>
		 * ���������������ͼ�����ݷ��ء�
		 * 
		 * @param bqm---����װ�Ĳ�������
		 * @return---�������������ͼ�����ݼ���
		 */
		public List<BookModel> getbyCondition(BookQueryModel bqm);
		
		
		/**
		 * ���ܣ��õ�һ��ȷ����ͼ�����������
		 * 
		 * @param uuid---ͼ��Ψһ��ʶ��
		 * @return ---���ذ����Ψһ��ʶ���ҵ���ͼ������
		 */
		public BookModel getSingle(String uuid);
		
		/**
		 * ���ܣ�����������ֵõ����uuid
		 * @param bookName---�������
		 * @return---�������uuid�����û���ҵ��Ǳ��飬����null
		 */
		public BookModel getBookByName(String bookName);
		
	}
