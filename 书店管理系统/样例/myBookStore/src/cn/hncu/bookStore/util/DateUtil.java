package cn.hncu.bookStore.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

/**
 * ���ڹ�����
 * @author �º���
 *
 * @version 1.0
 */
public class DateUtil {
	/**
	 * ���ݴ����long���� ����longֵת��Ϊ�̶��������ո�ʽ���
	 * @param d---����Ĳ���
	 * @return---һ���ַ�����������ʽΪ��yyyy��MM��dd�� HH:mm:ss
	 */
	public static String long2String(long d){
		Date date = new Date(d);
		DateFormat df = new SimpleDateFormat("yyyy��MM��dd�� HH:mm:ss");
		String str = df.format(date);
		return str;
	}
	/*
	 * �����ȡ������
	 *   ���Ȳ�Ҫ�롰����ķ�������ôд�����ǰ����ƵĴ��뿽��һ�𣬹۲����еı仯���ֺͲ��仯���֡�
	 *   ����δ������õ��ġ�ǰ�涨��ı�������ȡ�ɷ����Ĳ���--������ΪtxtInDate��erroInfo���ѡ���������ʹ�õġ�������δ�������
	 *   �����ı�������ɷ����ķ���ֵ---����ΪinDate��
	 */
	
	
	/**
	 * ���ݴ�������ڸ�ʽ����String�͵Ĳ���ת����long�Ͳ�������<br/>
	 * �����ʽ������󣬻���ݴ����erroInfo�ַ����������ڸ�����ʾ�� 
	 * @param txtInDate---��������ڡ�
	 * @param erroInfo----����Ĵ�����ʾ��Ϣ
	 * @return---long�͵����֣������ʽת�����󣬷���-1��
	 */
	public static long string2Long(String txtInDate,String erroInfo){
		DateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long inDate=0;
		try {
			Date d = date.parse(txtInDate);
			inDate = d.getTime();
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, erroInfo);
			return -1;
		}
		return inDate;
	}
	
}
