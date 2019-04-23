package com.bbva.pibee.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static String formatDate(Date date, String pattern){
		
		SimpleDateFormat formatter = new SimpleDateFormat(pattern);
		return formatter.format(date);		
		
	}
	
	public static Date stringToDate(String stringToConvert, String pattern) throws ParseException{
		SimpleDateFormat formatter = new SimpleDateFormat(pattern);
		Date out = formatter.parse(stringToConvert);
		return out;
	}
	
	public static boolean isGreaterOrEqualsThanToday(Date date) throws ParseException{
		Date today = formatDateWithOutHour(new Date());
		if(date.compareTo(today) >= 0){
			return true;
		}
		return false;
	}
	
	public static Date formatDateWithOutHour(Date in) throws ParseException{
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		Date out = formatter.parse(formatter.format(in));
		return out;
		
	}
	
}
