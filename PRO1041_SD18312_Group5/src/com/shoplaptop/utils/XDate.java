package com.shoplaptop.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class XDate {
	
	static SimpleDateFormat formater = new SimpleDateFormat();
	
	
	
	public static Date toDate(String date, String pattern) {
		
		
		if (date == null || date.isEmpty()) {
			return null;
		}
		try {
			
//			TimeZone timeZone = TimeZone.getTimeZone("Asia/Ho_Chi_Minh");
//			long mili = System.currentTimeMillis();
//			Calendar calendar = Calendar.getInstance();
			formater.applyPattern(pattern);
			return formater.parse(date);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static String toString(Date date, String pattern) {
		try {
			if (date == null) {
				return "";
			}
//			long mili = System.currentTimeMillis();
//			Calendar calendar = Calendar.getInstance();
//			TimeZone timeZone = TimeZone.getTimeZone("Asia/Ho_Chi_Minh");
			formater.applyPattern(pattern);
			return formater.format(date);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static Date addDays(Date date, long days) {
		if (date == null) {
			return null;
		}
		try {
			date.setTime(date.getTime()+days*24*60*60*1000);
			return date;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}
