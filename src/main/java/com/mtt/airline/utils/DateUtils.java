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
	
	static SimpleDateFormat dateFormatYMD 			= new SimpleDateFormat("yyyyMMdd");
	static SimpleDateFormat inputFormatYMDHMS 		= new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
	static SimpleDateFormat outputDateFormatDMY  	= new SimpleDateFormat("dd-MM-yyyy");
	static SimpleDateFormat outputTimeFormatHM	 	= new SimpleDateFormat("HH:mm");
	static SimpleDateFormat outputTimeDayFormatHMA 	= new SimpleDateFormat("hh:mm a");
	
	
	public static boolean isValidDateYMD(String dateAsString) {
		boolean isValidDate = false;
		if(dateAsString!= null){
			try {
				dateFormatYMD.parse(dateAsString);
				isValidDate =true;
			} catch (ParseException e) {
				isValidDate =false;
			}
		}
		
		return isValidDate;
	}
	
	public static Date convertDateFromYMDHMS(String dateAsString) throws ParseException {
		
		return inputFormatYMDHMS.parse(dateAsString);
	}
	
	public static String getDateDMY(Date date){
		return outputDateFormatDMY.format(date);
	}
	
	public static String getTimeDayHMA(Date date){
		return outputTimeDayFormatHMA.format(date);
	}
	
	public static String getTimeHM(Date date){
		return outputTimeFormatHM.format(date);
	}
	
}
