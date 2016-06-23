package com.mtt.airline.dao.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
public class FlightXml {

	private String carrierCode;
	private String flightDesignator;
	private String originAirport;
	private String destinationAirport;	
	private String departureDate;
	private String arrivalDate;
	private List<FareXml> fares;
	
	
	public FlightXml(String carrierCode, String flightDesignator,
			String originAirport, String destinationAirport,
			String departureDate, String arrivalDate, List<FareXml> fares) {
		super();
		this.carrierCode = carrierCode;
		this.flightDesignator = flightDesignator;
		this.originAirport = originAirport;
		this.destinationAirport = destinationAirport;
		this.departureDate = departureDate;
		this.arrivalDate = arrivalDate;
		this.fares = fares;
	}


	public String getCarrierCode() {
		return carrierCode;
	}
	@XmlElement(name="CarrierCode")
	public void setCarrierCode(String carrierCode) {
		this.carrierCode = carrierCode;
	}

	public String getFlightDesignator() {
		return flightDesignator;
	}
	@XmlElement(name="FlightDesignator")
	public void setFlightDesignator(String flightDesignator) {
		this.flightDesignator = flightDesignator;
	}

	public String getOriginAirport() {
		return originAirport;
	}
	@XmlElement(name="OriginAirport")
	public void setOriginAirport(String originAirport) {
		this.originAirport = originAirport;
	}

	public String getDestinationAirport() {
		return destinationAirport;
	}
	@XmlElement(name="DestinationAirport")
	public void setDestinationAirport(String destinationAirport) {
		this.destinationAirport = destinationAirport;
	}

	public String getDepartureDate() {
		return departureDate;
	}
	@XmlElement(name="DepartureDate")
	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	public String getArrivalDate() {
		return arrivalDate;
	}
	@XmlElement(name="ArrivalDate")
	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public List<FareXml> getFares() {
		return fares;
	}
	@XmlElementWrapper(name = "Fares")
	@XmlElement(name="Fare")
	public void setFares(List<FareXml> fares) {
		this.fares = fares;
	}
}