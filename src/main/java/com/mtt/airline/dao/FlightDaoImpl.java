package com.mtt.airline.dao;

import java.math.BigDecimal;
import java.util.Arrays;

import org.springframework.stereotype.Component;

import com.mtt.airline.model.Fare;
import com.mtt.airline.model.FarePrices;
import com.mtt.airline.model.Flight;
import com.mtt.airline.model.FlightOffer;
import com.mtt.airline.model.FlightOfferXML;
import com.mtt.airline.model.FlightQuery;
import com.mtt.airline.model.Price;

import feign.Feign;
import feign.Param;
import feign.RequestLine;
import feign.jaxb.JAXBContextFactory;
import feign.jaxb.JAXBDecoder;
import feign.jaxb.JAXBEncoder;

@Component
public class FlightDaoImpl implements FlightDao {

	private String endpoint = "http://private-72732-mockairline.apiary-mock.com/flights";
	
	private JAXBContextFactory jaxbFactory = new JAXBContextFactory.Builder().withMarshallerJAXBEncoding("UTF-8")
    .withMarshallerSchemaLocation("http://private-72732-mockairline.apiary-mock.com/xsd").build();


	/**
	 * {@inheritDoc}
	 */
	@Override
	public FlightOffer getFlights(FlightQuery flightQuery) {

		FlightProvider flightProvider = Feign.builder().encoder(new JAXBEncoder(jaxbFactory)).decoder(new JAXBDecoder(jaxbFactory))
				.target(FlightProvider.class, endpoint);
		
		FlightOfferXML flightOfferXML = flightProvider.getFlightOfferFor(flightQuery.getCityFrom(), 
				flightQuery.getCityTo(), flightQuery.getDateFrom(),flightQuery.getDateTo(), flightQuery.getQuantity());
		
		return buildFlightOfferFrom(flightOfferXML);
	}

	
	/**
	 * 
	 * @param flightOfferXML
	 * @return
	 */
	private FlightOffer buildFlightOfferFrom(FlightOfferXML flightOfferXML) {
		
		Price price1 = new Price("USD", new BigDecimal(1));
		Price price2 = new Price("USD", new BigDecimal(10));
		Price price3 = new Price("USD", new BigDecimal(100));
		Fare fare = new Fare(price1, price2, price3);

		Price pricea1 = new Price("USD", new BigDecimal(2));
		Price pricea2 = new Price("USD", new BigDecimal(20));
		Price pricea3 = new Price("USD", new BigDecimal(200));
		Fare farea = new Fare(pricea1, pricea2, pricea3);

		Price priceb1 = new Price("USD", new BigDecimal(3));
		Price priceb2 = new Price("USD", new BigDecimal(30));
		Price priceb3 = new Price("USD", new BigDecimal(300));
		Fare fareb = new Fare(priceb1, priceb2, priceb3);

		FarePrices farePrices = new FarePrices(fare, farea, fareb);

		Flight flight = new Flight("UA", "UA304", "MUC", "IST", null, null,
				null, farePrices);

		return new FlightOffer(Arrays.asList(flight));
	}
	
	private interface FlightProvider {

		@RequestLine("GET /{airportFrom}/{airportTo}/{dateFrom}/{dateTo}/{quantity}")
		public FlightOfferXML getFlightOfferFor(
				@Param("airportFrom") String airportFrom,
				@Param("airportTo") String airportTo,
				@Param("dateFrom") String dateFrom,
				@Param("dateTo") String dateTo,
				@Param("quantity") Integer integer);
	}

}
