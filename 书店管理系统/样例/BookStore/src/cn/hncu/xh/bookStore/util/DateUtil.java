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

	// 格式化日期，按我们自己需要的输出
	public static String LongToString(long inDate) {
		// 使用给定的inDate构造一个日历
		Calendar date = Calendar.getInstance();
		date.setTimeInMillis(inDate);
		// 把Calendar类，转换成Date类型
		Date time = date.getTime();
		// 设置日期输出的格式
		SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
		// 格式化输出
		return df.format(time);
	}
	public static long StringToLong(String dateStr) {
		// 设置日期输出的格式
		SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
		Date d=null;
		try {
			d=df.parse(dateStr); //解析成Date类
		} catch (ParseException e) {
			e.printStackTrace();
		}
		// 格式化输出
		return d.getTime();
	}
}
