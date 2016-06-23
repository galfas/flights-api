package com.mtt.airline.business;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mtt.airline.dao.FlightDao;
import com.mtt.airline.model.FlightOffer;
import com.mtt.airline.model.FlightQuery;

@Component
public class FlightBoImpl implements FlightBo {
	
	@Autowired
	private FlightDao flightDao;
	
	/**
	 * {@inheritDoc}
	 * @throws ParseException 
	 */
	public FlightOffer getTicket(FlightQuery flightQuery) throws ParseException{
		
		return flightDao.getFlights(flightQuery);
	}
}
