package com.shoplaptop.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class XDate {
	
	static SimpleDateFormat formater = new SimpleDateFormat();

	
	public static Date toDate(String date, String pattern) {
		
		
		if (date == null || date.isEmpty()) {
			return null;
		}
		try {
			
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