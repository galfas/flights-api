package com.mtt.airline.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Class that should encapsulate all the helper functions with dates.
 *  
 * @author Marcelo Saciloto
 */
public class DateUtils {
	
	public static Date getDateFrom(String dateAsString) throws ParseException{
		
		SimpleDateFormat originalFormat = new SimpleDateFormat("yyyyMMdd");
		Date date = originalFormat.parse(dateAsString);
		
		return date;
	}
	
}
