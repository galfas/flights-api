package com.mtt.airline.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Class that should encapsulate all the helper functions with dates.
 *  
 * @author Marcelo Saciloto
 */
public class DateUtils {
	
	public static boolean isValidDate(String dateAsString) {
		boolean isValidDate = true;
		SimpleDateFormat originalFormat = new SimpleDateFormat("yyyyMMdd");
		try {
			originalFormat.parse(dateAsString);
		} catch (ParseException e) {
			isValidDate =false;
		}
		
		return isValidDate;
	}
}
