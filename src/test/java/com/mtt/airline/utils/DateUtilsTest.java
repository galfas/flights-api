package com.mtt.airline.utils;

import java.text.ParseException;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import com.mtt.airline.utils.builder.DateTestBuilder;



/**
 * Class that should encapsulate all the helper functions with dates.
 *  
 * @author Marcelo Saciloto
 */
public class DateUtilsTest {	
	
	@Test
	public void shouldReturnValidDate(){
		boolean isValid = DateUtils.isValidDateYMD("20151007");
		
		Assert.assertTrue(isValid);
	}
	

	@Test
	public void shouldReturnFalse(){
		boolean isValid = DateUtils.isValidDateYMD("2010");
		
		Assert.assertFalse(isValid);
	}
	
	@Test
	public void shouldReturnFalseWithNullValue(){
		boolean isValid = DateUtils.isValidDateYMD(null);
		
		Assert.assertFalse(isValid);
	}
	
	@Test
	public void shouldReturnFullDateTime() throws ParseException{
		Date date = DateUtils.convertDateFromYMDHMS("2000-01-02T10:48:00.000Z");
		
		Assert.assertEquals(date.getTime(), 946817280000L);
	}
	
	@Test(expected=ParseException.class)
	public void shouldThrowExceptionWithInvalidDate() throws ParseException{
		Date date = DateUtils.convertDateFromYMDHMS("2000");
	}
	
	@Test
	public void  shoudReturnFormatedDateDMY() throws ParseException{
		
		Date expectedDate = DateTestBuilder.build("2014-01-02T10:48:00.000Z");
		
		String dateAsString = DateUtils.getDateDMY(expectedDate);
		Assert.assertEquals("02-01-2014", dateAsString);
	}
	
	@Test
	public void shouldGetTimeDayHMA() throws ParseException{
		Date expectedDate = DateTestBuilder.build("2014-01-02T10:10:00.000Z");
		
		String dateAsString = DateUtils.getTimeDayHMA(expectedDate);
		Assert.assertEquals("10:10 AM", dateAsString);
	}
	
	@Test
	public void shouldGetTimeDayHM() throws ParseException{
		Date expectedDate = DateTestBuilder.build("2014-01-02T10:10:00.000Z");
		
		String dateAsString = DateUtils.getTimeHM(expectedDate);
		Assert.assertEquals("10:10", dateAsString);
	}
	
}
