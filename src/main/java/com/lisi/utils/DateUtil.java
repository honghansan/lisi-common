package com.lisi.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/**
 * 日期处理类.返回指定日期的月初或月末
 * @ClassName: DateUtil 
 * @Description: TODO
 * @author: charles
 * @date: 2019年5月17日 下午3:13:57
 */
public class DateUtil {

	// 根据传入的参数获取该日器的开始日期
	public static String getStart(String date) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c1 = getCalendar(date);
		//让当前的日期从1号开始
		c1.set(Calendar.DAY_OF_MONTH, 1);
		//获取日期类的日期并格式化返回
		Date time = c1.getTime();
		return  df.format(time);

	}


	// 根据传入的参数获取该日器的开始日期
		public static String getEnd(String date) {

			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			// 获取日期类
			Calendar c1 = getCalendar(date);
			//让当前的月份+1
			c1.add(Calendar.MONTH, 1);
			//设置当前月份的日期为上个月的最后一天
			c1.set(Calendar.DAY_OF_MONTH, 0);
			//获取日期类的日期并格式化返回
			Date time = c1.getTime();
			return  df.format(time);

		}
	
	private  static Calendar getCalendar(String date) {

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		// 获取日期类
		Calendar c1 = Calendar.getInstance();
		if (null != date && date.length() > 0) {
			try {
				Date date2 = df.parse(date);// 把字符串转为date类型
				c1.setTime(date2);

			} catch (ParseException e) {

				e.printStackTrace();
			}
		}
		return c1;
	}
	

}
