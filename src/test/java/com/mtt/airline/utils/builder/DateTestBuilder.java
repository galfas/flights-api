package com.mtt.airline.utils.builder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTestBuilder {

	static SimpleDateFormat defaultInputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

	public static Date build(String stringDate) throws ParseException{
		return defaultInputFormat.parse(stringDate);
	}
}
