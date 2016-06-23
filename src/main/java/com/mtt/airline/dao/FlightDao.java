package com.mtt.airline.dao;

import java.text.ParseException;

import com.mtt.airline.model.FlightOffer;
import com.mtt.airline.model.FlightQuery;

/**
 * This class is responsible for fetching the data from external.
 * 
 * @author Marcelo Saciloto
 */
public interface FlightDao {
	
	/**
	 * Searches for all the available flights based on the query object.
	 * @param flightQuery
	 * @return
	 * @throws ParseException 
	 */
	public FlightOffer getFlights(FlightQuery flightQuery) throws ParseException;
}
