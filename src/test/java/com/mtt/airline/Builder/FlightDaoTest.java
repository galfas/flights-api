package com.mtt.airline.Builder;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.stereotype.Component;

import com.mtt.airline.builder.FlightOfferBuilder;
import com.mtt.airline.dao.model.FareXml;
import com.mtt.airline.dao.model.FlightOfferXml;
import com.mtt.airline.dao.model.FlightXml;
import com.mtt.airline.model.FlightOffer;

@Component
public class FlightDaoTest {

	 
	@Test
	public void shouldReturnCompleteFlightDetailsObject() throws ParseException{
		
		FlightOfferXml flightOfferXml = flightOfferXmlBuilder();
		
		FlightOffer flightOffer= FlightOfferBuilder.build(flightOfferXml);
		
		Assert.assertEquals("IST", flightOffer.getAvailability().get(0).getDepartsFrom());
		Assert.assertEquals("DUB", flightOffer.getAvailability().get(0).getArrivesAt());
		Assert.assertEquals("EI", flightOffer.getAvailability().get(0).getOperator());
		Assert.assertEquals("EI554", flightOffer.getAvailability().get(0).getFlightNumber());
		
		
	}
	
	@Test
	public void shouldReturnCompleteFares() throws ParseException{
		FlightOfferXml flightOfferXml = flightOfferXmlBuilder();
		
		FlightOffer flightOffer= FlightOfferBuilder.build(flightOfferXml);
		
		Assert.assertEquals(BigDecimal.valueOf(300.12), flightOffer.getAvailability().get(0).getFarePrices().getFirst().getTicket().getAmmount());
		Assert.assertEquals(BigDecimal.valueOf(30.01), flightOffer.getAvailability().get(0).getFarePrices().getFirst().getBookingFee().getAmmount());
		Assert.assertEquals(BigDecimal.valueOf(3.62), flightOffer.getAvailability().get(0).getFarePrices().getFirst().getTax().getAmmount());
		
		Assert.assertEquals(BigDecimal.valueOf(200.22), flightOffer.getAvailability().get(0).getFarePrices().getBusiness().getTicket().getAmmount());
		Assert.assertEquals(BigDecimal.valueOf(20.11), flightOffer.getAvailability().get(0).getFarePrices().getBusiness().getBookingFee().getAmmount());
		Assert.assertEquals(BigDecimal.valueOf(2.19), flightOffer.getAvailability().get(0).getFarePrices().getBusiness().getTax().getAmmount());

		Assert.assertEquals(BigDecimal.valueOf(100.72), flightOffer.getAvailability().get(0).getFarePrices().getEconomy().getTicket().getAmmount());
		Assert.assertEquals(BigDecimal.valueOf(10.01), flightOffer.getAvailability().get(0).getFarePrices().getEconomy().getBookingFee().getAmmount());
		Assert.assertEquals(BigDecimal.valueOf(1.91), flightOffer.getAvailability().get(0).getFarePrices().getEconomy().getTax().getAmmount());
		
		Assert.assertEquals("EUR", flightOffer.getAvailability().get(0).getFarePrices().getFirst().getTax().getCurrency());
	}
	
	@Test
	public void shouldReturnCompleteDynamicaFields() throws ParseException{
		FlightOfferXml flightOfferXml = flightOfferXmlBuilder();
		
		FlightOffer flightOffer= FlightOfferBuilder.build(flightOfferXml);
		
		Assert.assertEquals("02:16", flightOffer.getAvailability().get(0).getFlightTime());
		Assert.assertEquals("02-01-2014", flightOffer.getAvailability().get(0).getDepartsOn().getDate());
		Assert.assertEquals("10:48 AM", flightOffer.getAvailability().get(0).getDepartsOn().getTime());
		Assert.assertEquals("02-01-2014", flightOffer.getAvailability().get(0).getArrivesOn().getDate());
		Assert.assertEquals("01:04 PM", flightOffer.getAvailability().get(0).getArrivesOn().getTime());
	}

	private FlightOfferXml flightOfferXmlBuilder() throws ParseException {

		FareXml fif = new FareXml("FIF", "EUR 300.12","EUR 30.01","EUR 3.62");
		FareXml cif = new FareXml("CIF", "EUR 200.22","EUR 20.11","EUR 2.19");
		FareXml yif = new FareXml("YIF", "EUR 100.72","EUR 10.01","EUR 1.91");
	
		FlightXml flightXml = new FlightXml("EI", "EI554", "IST", "DUB", "2014-01-02T10:48:00.000Z",
				"2014-01-02T13:04:00.000Z", Arrays.asList(fif,cif,yif));
	
		FlightOfferXml flightOfferXml = new FlightOfferXml();
		flightOfferXml.setFlight(Arrays.asList(flightXml));
		
		return flightOfferXml;
	}
		
	
}
