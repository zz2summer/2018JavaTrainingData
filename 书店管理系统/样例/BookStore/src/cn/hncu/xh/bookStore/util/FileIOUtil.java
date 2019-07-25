package cn.hncu.xh.bookStore.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *<p>Title:FileIOUtil</p>
 * @author <a href="mailto:1225268923@qq.com">xionghui</a>
 * @date Aug 21, 2015
 */

/*
 * �����ȡ���裺
 * 1���Ȳ�����дʲô�������ƵĴ��뿽��һ�����
 * 2���۲����еı仯���ֺͲ��仯�Ĳ���
 * 3������δ����� �õ��� ǰ�涨��ı��� ��ȡ�ɷ����Ĳ���
 * 4���� ��������ʹ�õ� ������δ������½��ı��� ����ɷ����ķ���ֵ
 */
//�����Ƕ��ļ�����ֱ�ӵĶ�ȡ�ʹ洢
public class FileIOUtil {
	private FileIOUtil(){//�����࣬��Ĭ�� ���췽��˽�л�
	}
	@SuppressWarnings("unchecked")
	//�����ݿ��ж�Ӧ���ļ��ж�ȡ����
	public static<A> List<A> readFromFile(String fileName) { //��������˷��ͷ��������������Ҷ����ļ�����ʲô���͵�Ԫ�أ��ҷ��س�ȥ�ľ����������͵�Ԫ��
		File file=new File(fileName); //newһ��file����
		//�ж����file�����Ƿ���ڣ���������ھ���Ҫ�Զ��������file����
		if(!file.exists()){ 
			try {
				file.createNewFile(); //����file����
			} catch (IOException e) {
				e.printStackTrace(); //�����쳣
			}
		}
		ObjectInputStream input=null;
		try {
			input=new ObjectInputStream(new FileInputStream(file)); //����Ҫ��file����д�뵽��������
			List<A> list=(List<A>)input.readObject(); //��file���������Ԫ��һ�������뵽list�У���󷵻س�ȥ
			//���file����û�ж���������Ҫ����һ�£���list newһ���ն��󣬷�ֹ���ֿ�ָ���쳣
			if(list==null){
				list=new ArrayList<A>();
			}
			return list;
		} catch (IOException e) {//����Ҫע��ObjectInputStream�������һ������ʱ���׳��쳣��������������쳣ʱ��������
			System.out.println("�ļ���ȡ����������"); //������һ����˵���ļ���ȡ���
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally{
			if(input!=null){ //������Ҫ�����£����inputΪnull�������ǲ��ܹرյ�
				try {
					input.close();
				} catch (IOException e) {
					throw new RuntimeException("�ļ��ر�ʧ��");
				}
			}
		}
		return new ArrayList<A>(); //����list
	}
	//������д����Ӧ���ļ��з������ݿ�
	public static<A> boolean writeToFile(String fileName,List<A> list){  //ʹ�÷��ͷ���
		File file=new File(fileName); //newһ��file����
		ObjectOutputStream output=null;
		try {
			output=new ObjectOutputStream(new FileOutputStream(file)); //���ļ�д���������
			output.writeObject(list); //��list����д��output�У�����Ӧ���ļ���
		} catch (IOException e) {
			return false; //�������ʧ�ܣ�����false
		}finally{
			if(output!=null){ ////������Ҫ�����£����outputΪnull�������ǲ��ܹرյ�
				try {
					output.close();
				} catch (IOException e) {
					throw new RuntimeException("�ļ��ر�ʧ�ܡ�����");
				}
			}
		}
		return true;
	}
}
