package com.mtt.airline.model;


import org.junit.Assert;
import org.junit.Test;

public class FlightQueryTest {
		
	
	@Test
	public void shouldCreateANewFlighQuery() {
		String cityFrom = "SPO";
		String cityTo 	= "DUB";
		String dateFrom = "20151007";
		String dateTo	= "20151017";
		Integer quantity= 2;
		
		FlightQuery flightQuery = new FlightQuery(cityFrom, cityTo, dateFrom, dateTo, quantity);
		Assert.assertEquals(cityFrom, flightQuery.getCityFrom());
		Assert.assertEquals(cityTo,   flightQuery.getCityTo());
		Assert.assertEquals(dateFrom, flightQuery.getDateFrom());
		Assert.assertEquals(dateTo, flightQuery.getDateTo());
		Assert.assertEquals(quantity, flightQuery.getQuantity());		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void shouldThrowIllegalArgumentException() {
		String cityFrom = "SPO";
		String cityTo 	= "DUB";
		String dateFrom = "10";
		String dateTo	= "20151017";
		Integer quantity= 2;
		
		FlightQuery flightQuery = new FlightQuery(cityFrom, cityTo, dateFrom, dateTo, quantity);
		Assert.assertEquals(cityFrom, flightQuery.getCityFrom());
		Assert.assertEquals(cityTo,   flightQuery.getCityTo());
		Assert.assertEquals(dateFrom, flightQuery.getDateFrom());
		Assert.assertEquals(dateTo, flightQuery.getDateTo());
		Assert.assertEquals(quantity, flightQuery.getQuantity());		
	}


}
