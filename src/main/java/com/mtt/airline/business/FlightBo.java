package com.mtt.airline.business;

import com.mtt.airline.model.FlightQuery;
import com.mtt.airline.model.FlightOffer;

/**
 * This class is responsible for handling the flights searches.
 * 
 * @author Marcelo Saciloto
 */
public interface FlightBo {
	
	/**
	 * Fetch all the available flights for a given fligthe query
	 * 
	 * @param flightQuery - object that contains the terms for the query
	 * 
	 * @return All the available flights.
	 */
	public FlightOffer getTicket(FlightQuery flightQuery);
}
