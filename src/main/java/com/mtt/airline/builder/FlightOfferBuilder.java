package com.mtt.airline.builder;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;

import com.mtt.airline.dao.model.FareXml;
import com.mtt.airline.dao.model.FlightOfferXml;
import com.mtt.airline.dao.model.FlightXml;
import com.mtt.airline.model.Fare;
import com.mtt.airline.model.FarePrices;
import com.mtt.airline.model.Flight;
import com.mtt.airline.model.FlightOffer;
import com.mtt.airline.model.Price;
import com.mtt.airline.utils.DateUtils;


public class FlightOfferBuilder {
	
	private static final String REGEX_SEPARATOR = " ";
	
	private static final String ECONOMY_CLASS = "YIF";
	private static final String BUSINESS_CLASS = "CIF";
	private static final String FIRST_CLASS = "FIF";
		

	/**
	 * Method that encapsulate all the necessary logic to build a Flight offer object from
	 * a flightOfferXML.
	 * 
	 * @param flightOfferXML
	 * @return {@link FlightOffer}
	 * @throws ParseException
	 */
	public static FlightOffer builder(FlightOfferXml flightOfferXML) throws ParseException{
		List<Flight>flightList = new LinkedList<Flight>();
		for (FlightXml flightXml : flightOfferXML.getFlight()) {
			flightList.add(buildFlight(flightXml));
		}
		
		return new FlightOffer(flightList);
	}

	/**	
	 *  It has the logic to build a flight object 
	 * 
	 * @param flightXml 
	 * @return {@link Flight}
	 * @throws ParseException
	 */
	private static Flight buildFlight(FlightXml flightXml) throws ParseException{
		Flight flight = new Flight();
		flight.setDepartsFrom(flightXml.getOriginAirport());
		flight.setArrivesAt(flightXml.getDestinationAirport());
		flight.setFlightNumber(flightXml.getFlightDesignator());
		flight.setOperator(flightXml.getCarrierCode());
		flight.setDepartingDate(DateUtils.convertDateFromYMDHMS(flightXml.getDepartureDate()));
		flight.setArrivingDate(DateUtils.convertDateFromYMDHMS(flightXml.getArrivalDate()));
		
		flight.setFarePrices(buildFares(flightXml.getFares()));
		
		return flight;
	}
	 
	/**
	 * Encapsules all the rules to build Fares.
	 * @param fares
	 * 
	 * @return {@link FarePrices}
	 */
	private static FarePrices buildFares(List<FareXml> fares){
		FarePrices farePrices = new FarePrices();
		
		//TODO Improving this logic with a regex. 
		for (FareXml fare : fares) {
			
			String[] baseParts  = fare.getBasePrice().split(REGEX_SEPARATOR);
			Price basePrice = new Price(baseParts[0], new BigDecimal(baseParts[1]));

			String[] feeParts  = fare.getFees().split(REGEX_SEPARATOR);
			Price feePrice = new Price(feeParts[0], new BigDecimal(feeParts[1]));
			
			String[] taxParts  = fare.getTax().split(REGEX_SEPARATOR);
			Price taxPrice = new Price(taxParts[0], new BigDecimal(taxParts[1]));
			
			if(fare.getKlass().equals(FIRST_CLASS)){
				farePrices.setFirst(new Fare(basePrice, feePrice, taxPrice));
				continue;
			}else if(fare.getKlass().equals(BUSINESS_CLASS)){
				farePrices.setBusiness(new Fare(basePrice, feePrice, taxPrice));
				continue;
			}else if(fare.getKlass().equals(ECONOMY_CLASS)){
				farePrices.setEconomy(new Fare(basePrice, feePrice, taxPrice));
				continue;
			}
		}

		return farePrices;
	}	
}
