package com.mtt.airline.dao;

import java.text.ParseException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.mtt.airline.builder.FlightOfferBuilder;
import com.mtt.airline.dao.model.FlightOfferXml;
import com.mtt.airline.model.FlightOffer;
import com.mtt.airline.model.FlightQuery;

import feign.Feign;
import feign.Param;
import feign.RequestLine;
import feign.jaxb.JAXBContextFactory;
import feign.jaxb.JAXBDecoder;
import feign.jaxb.JAXBEncoder;

@Component
public class FlightDaoImpl implements FlightDao {

	private static final Logger logger = LoggerFactory.getLogger(FlightDaoImpl.class);
	
	@Value("${flight.fare.api}")
	private String apiEndpoint;
	
	@Value("$flight.fare.xsd")
	private String xsdEnpoint;

	
	private JAXBContextFactory jaxbFactory = new JAXBContextFactory.Builder().withMarshallerJAXBEncoding("UTF-8")
    .withMarshallerSchemaLocation(xsdEnpoint).build();


	/**
	 * {@inheritDoc}
	 * @throws ParseException 
	 */
	@Override
	public FlightOffer getFlights(FlightQuery flightQuery) throws ParseException {

		logger.debug(String.format("The fetch of data will be performed with the follow parameters '%s'", flightQuery.toString()));
		
		FlightProvider flightProvider = Feign.builder().encoder(new JAXBEncoder(jaxbFactory)).decoder(new JAXBDecoder(jaxbFactory))
				.target(FlightProvider.class, apiEndpoint);
		
		
		FlightOfferXml flightOfferXML = flightProvider.getFlightOfferFor(flightQuery.getCityFrom(), 
				flightQuery.getCityTo(), flightQuery.getDateFrom(),flightQuery.getDateTo(), flightQuery.getQuantity());


		return FlightOfferBuilder.build(flightOfferXML);
	}
	
	
	private interface FlightProvider {

		@RequestLine("GET /{airportFrom}/{airportTo}/{dateFrom}/{dateTo}/{quantity}")
		public FlightOfferXml getFlightOfferFor(
				@Param("airportFrom") String airportFrom,
				@Param("airportTo") String airportTo,
				@Param("dateFrom") String dateFrom,
				@Param("dateTo") String dateTo,
				@Param("quantity") Integer integer);
	}

}
