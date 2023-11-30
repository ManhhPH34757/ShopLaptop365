package com.shoplaptop.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class XDate {
	
	static SimpleDateFormat formater = new SimpleDateFormat();
<<<<<<< HEAD
	public static Date toDate(String date, String pattern) {
		try {
=======
	
	public static Date toDate(String date, String pattern) {
		
		
		if (date == null || date.isEmpty()) {
			return null;
		}
		try {
			
//			TimeZone timeZone = TimeZone.getTimeZone("Asia/Ho_Chi_Minh");
//			long mili = System.currentTimeMillis();
//			Calendar calendar = Calendar.getInstance();
>>>>>>> 46e398cade36f024900666740023c2d75d07d685
			formater.applyPattern(pattern);
			return formater.parse(date);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
<<<<<<< HEAD
	public String toString(Date date, String pattern) {
=======
	public static String toString(Date date, String pattern) {
>>>>>>> 46e398cade36f024900666740023c2d75d07d685
		try {
			if (date == null) {
				return "";
			}
<<<<<<< HEAD
=======
//			long mili = System.currentTimeMillis();
//			Calendar calendar = Calendar.getInstance();
//			TimeZone timeZone = TimeZone.getTimeZone("Asia/Ho_Chi_Minh");
>>>>>>> 46e398cade36f024900666740023c2d75d07d685
			formater.applyPattern(pattern);
			return formater.format(date);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
<<<<<<< HEAD
	public Date addDays(Date date, long days) {
=======
	public static Date addDays(Date date, long days) {
		if (date == null) {
			return null;
		}
>>>>>>> 46e398cade36f024900666740023c2d75d07d685
		try {
			date.setTime(date.getTime()+days*24*60*60*1000);
			return date;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}
