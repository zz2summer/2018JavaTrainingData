package cn.hncu.xh.bookStore.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * <p>
 * Title:DateUtil
 * </p>
 * 
 * @author <a href="mailto:1225268923@qq.com">xionghui</a>
 * @date Aug 26, 2015
 */
public class DateUtil {
	private DateUtil() {
	}

	// ��ʽ�����ڣ��������Լ���Ҫ�����
	public static String LongToString(long inDate) {
		// ʹ�ø�����inDate����һ������
		Calendar date = Calendar.getInstance();
		date.setTimeInMillis(inDate);
		// ��Calendar�࣬ת����Date����
		Date time = date.getTime();
		// ������������ĸ�ʽ
		SimpleDateFormat df = new SimpleDateFormat("yyyy��MM��dd�� HH:mm:ss");
		// ��ʽ�����
		return df.format(time);
	}
	public static long StringToLong(String dateStr) {
		// ������������ĸ�ʽ
		SimpleDateFormat df = new SimpleDateFormat("yyyy��MM��dd�� HH:mm:ss");
		Date d=null;
		try {
			d=df.parse(dateStr); //������Date��
		} catch (ParseException e) {
			e.printStackTrace();
		}
		// ��ʽ�����
		return d.getTime();
	}
}
