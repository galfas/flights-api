package com.mtt.airline.dao;

import com.mtt.airline.model.FlightQuery;
import com.mtt.airline.model.Offers;

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
	 */
	public Offers getFlights(FlightQuery flightQuery);
}
