package com.mtt.airline.business;

import java.text.ParseException;

import com.mtt.airline.model.FlightOffer;
import com.mtt.airline.model.FlightQuery;

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
	 * @throws ParseException 
	 */
	public FlightOffer getTicket(FlightQuery flightQuery) throws ParseException;
}
