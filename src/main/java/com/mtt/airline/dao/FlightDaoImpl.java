package com.mtt.airline.dao;

import java.math.BigDecimal;
import java.util.Arrays;

import org.springframework.stereotype.Component;

import com.mtt.airline.model.Fare;
import com.mtt.airline.model.FarePrices;
import com.mtt.airline.model.Flight;
import com.mtt.airline.model.FlightQuery;
import com.mtt.airline.model.Offers;
import com.mtt.airline.model.Price;

@Component
public class FlightDaoImpl implements FlightDao{

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Offers getFlights(FlightQuery flightQuery) {
		
		Price price1 = new Price("USD",new BigDecimal(1));
    	Price price2 = new Price("USD",new BigDecimal(10));
    	Price price3 = new Price("USD",new BigDecimal(100));
    	Fare fare = new Fare(price1,price2, price3);
    	
    	Price pricea1 = new Price("USD",new BigDecimal(2));
    	Price pricea2 = new Price("USD",new BigDecimal(20));
    	Price pricea3 = new Price("USD",new BigDecimal(200));
    	Fare farea = new Fare(pricea1,pricea2, pricea3);
    	
    	Price priceb1 = new Price("USD",new BigDecimal(3));
    	Price priceb2 = new Price("USD",new BigDecimal(30));
    	Price priceb3 = new Price("USD",new BigDecimal(300));
    	Fare fareb = new Fare(priceb1,priceb2, priceb3);
    	
    	FarePrices farePrices = new FarePrices(fare, farea, fareb);
    	
    	Flight flight = new Flight("UA", "UA304", "MUC", "IST", null, null, null, farePrices);
    	
    	return new Offers(Arrays.asList(flight));
	}
	
}
