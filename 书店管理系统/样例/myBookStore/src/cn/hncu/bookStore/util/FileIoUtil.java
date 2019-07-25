package cn.hncu.bookStore.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * �û��Ĺ������ݶ�ȡд����
 * @author �º���
 *
 * @version 1.0
 */
public class FileIoUtil {

	public FileIoUtil() {
	}
	
	
	/**
	 *  �����ݿ��ж�ȡ���е����ݲ����س���
	 *  
	 * @param fileName��(���ݱ��Ӧ���ļ�����)
	 * @return ���б�ļ�¼��
	 */
	@SuppressWarnings("unchecked")//ѹ����
	public static<E> List<E> readFormFile(String fileName){
		List<E> list = new ArrayList<E>();
		final File file = new File(fileName);
		
		ObjectInputStream in =null;
		if(!file.exists()){
			//JOptionPane.showMessageDialog(null, "���ݱ����ڣ�");
			return list;
		}
		try {
			in = new ObjectInputStream(new FileInputStream(fileName));
			try {
				list = (List<E>) in.readObject();
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(in!=null){
				try {
					in.close();
				} catch (IOException e) {
					throw new RuntimeException("���ݿ�ر�ʧ��");
				}
			}
		}
		return list;
	}
	
	
	/**
	 * д��һ��list���Ͻ��������ļ�fileName
	 * 
	 * @param list(��Ҫ�洢�����ݼ���)
	 * @param fileName(д�뵽�ĸ��ļ����ļ�����)
	 */
	public static<E> void write2file(List<E> list, String fileName){
		ObjectOutputStream out = null;
		
		try {
			out = new ObjectOutputStream(new FileOutputStream(fileName));
			out.writeObject(list);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(out!=null){
				try {
					out.close();
				} catch (IOException e) {
					throw new RuntimeException("���ݿ�ر�ʧ��!");
				}
			}
		}
	}
	
}
