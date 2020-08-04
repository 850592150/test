package com.xzt.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author xzt85
 */
public class TimeUtil {
	
	public static String formatTimeEight(String time) throws Exception {
		   Date d = null;
		   SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		   d = sd.parse(time);
		//把当前得到的时间用date.getTime()的方法写成时间戳的形式，再加上8小时对应的毫秒数
		   long rightTime = (long) (d.getTime() + 8 * 60 * 60 * 1000);
		//把得到的新的时间戳再次格式化成时间的格式
		   String newtime = sd.format(rightTime);
		   return newtime;
		}
		
}
