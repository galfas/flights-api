package com.mtt.airline.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="Availability")
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
public class FlightOfferXML {

	private List<FlightXML> flight;


	public List<FlightXML> getFlight() {
		return flight;
	}
	@XmlElement(name="Flight")
	public void setFlight(List<FlightXML> flight) {
		this.flight = flight;
	}
}

@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
class FlightXML {

	private String carrierCode;
	private String flightDesignator;
	private String originAirport;
	private String destinationAirport;	
	private String departureDate;
	private String arrivalDate;
	private List<FareXML> fares;


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

	public List<FareXML> getFares() {
		return fares;
	}
	@XmlElementWrapper(name = "Fares")
	@XmlElement(name="Fare")
	public void setFares(List<FareXML> fares) {
		this.fares = fares;
	}
}

@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
@XmlRootElement(name="Fare")
class FareXML{
	
	private String klass;
	private String basePrice;
	private String fees;
	private String tax;


	public String getKlass() {
		return klass;
	}
	@XmlAttribute(name="class")
	public void setKlass(String klass) {
		this.klass = klass;
	}

	public String getBasePrice() {
		return basePrice;
	}
	@XmlElement(name="BasePrice")
	public void setBasePrice(String basePrice) {
		this.basePrice = basePrice;
	}

	public String getFees() {
		return fees;
	}
	@XmlElement(name="Fees")
	public void setFees(String fees) {
		this.fees = fees;
	}

	public String getTax() {
		return tax;
	}
	@XmlElement(name="Tax")
	public void setTax(String tax) {
		this.tax = tax;
	}
}