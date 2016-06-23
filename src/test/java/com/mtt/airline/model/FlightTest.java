package com.mtt.airline.model;

import java.text.ParseException;
import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.mtt.airline.utils.builder.DateTestBuilder;


public class FlightTest {
	
	Flight flight;
	
	@Before
	public void setup(){
		flight = new Flight();
	}
	
	@Test
	public void shouldReturnJustMinutes() throws ParseException{
		Date from = DateTestBuilder.build("2014-01-02T10:10:00.000Z");
		Date to = DateTestBuilder.build("2014-01-02T10:20:00.000Z");
		
		flight.setDepartingDate(from);
		flight.setArrivingDate(to);
		
		Assert.assertEquals("00:10", flight.getFlightTime());
	}
	
	@Test
	public void shouldReturnJustHours() throws ParseException{
		Date from = DateTestBuilder.build("2014-01-02T10:20:00.000Z");
		Date to = DateTestBuilder.build("2014-01-02T17:20:00.000Z");
		
		flight.setDepartingDate(from);
		flight.setArrivingDate(to);
		
		Assert.assertEquals("07:00", flight.getFlightTime());
	}
	
	@Test
	public void shouldReturnTwoDaysInHour() throws ParseException{
		Date from = DateTestBuilder.build("2014-01-02T10:20:00.000Z");
		Date to = DateTestBuilder.build("2014-01-05T10:20:00.000Z");
		
		flight.setDepartingDate(from);
		flight.setArrivingDate(to);
		
		Assert.assertEquals("72:00", flight.getFlightTime());
	}
	
	@Test
	public void shouldReturnZeroDifference() throws ParseException{
		Date from = DateTestBuilder.build("2014-01-02T10:20:00.000Z");
		Date to = DateTestBuilder.build("2014-01-02T10:20:00.000Z");
		
		flight.setDepartingDate(from);
		flight.setArrivingDate(to);
		
		Assert.assertEquals("00:00", flight.getFlightTime());
	}
}
