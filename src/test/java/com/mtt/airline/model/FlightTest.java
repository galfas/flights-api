package com.mtt.airline.model;

import java.text.ParseException;
import java.util.Date;
import java.util.Map;

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
	
	@Test
	public void shouldHaveAllTheFields() throws ParseException{
		Flight flight = new Flight("ABC","1234","SPO","DUB", DateTestBuilder.build("2014-01-10T10:20:00.000Z"),
				DateTestBuilder.build("2014-01-01T10:20:00.000Z"), new FarePrices());
		
		Map<String, Object> map = flight.getStrings();
		Assert.assertTrue(map.containsKey("operator"));
		Assert.assertEquals(map.get("operator"), flight.getOperator());
		
		Assert.assertTrue(map.containsKey("flightNumber"));
		Assert.assertEquals(map.get("flightNumber"), flight.getFlightNumber());
		
		Assert.assertTrue(map.containsKey("departsFrom"));
		Assert.assertEquals(map.get("departsFrom"), flight.getDepartsFrom());
		
		Assert.assertTrue(map.containsKey("arrivesAt"));
		Assert.assertEquals(map.get("arrivesAt"), flight.getArrivesAt());
		
		
		
		Assert.assertTrue(map.containsKey("flightTime"));
		Assert.assertEquals(map.get("flightTime"), flight.getFlightTime());
		
		Assert.assertTrue(map.containsKey("farePrices"));
		Assert.assertEquals(map.get("farePrices"), flight.getFarePrices());
		
		Assert.assertTrue(map.containsKey("departsOn"));
		
		Assert.assertTrue(map.containsKey("arrivesOn"));
	}
}
