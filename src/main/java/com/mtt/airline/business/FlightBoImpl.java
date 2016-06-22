package com.mtt.airline.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mtt.airline.dao.FlightDao;
import com.mtt.airline.model.FlightQuery;
import com.mtt.airline.model.FlightOffer;

@Component
public class FlightBoImpl implements FlightBo {
	
	@Autowired
	private FlightDao flightDao;
	
	/**
	 * {@inheritDoc}
	 */
	public FlightOffer getTicket(FlightQuery flightQuery){
		
		return flightDao.getFlights(flightQuery);
	}
}
