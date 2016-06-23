package com.mtt.airline.dao.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="Availability")
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
public class FlightOfferXml {

	private List<FlightXml> flight;

	
	public List<FlightXml> getFlight() {
		return flight;
	}
	@XmlElement(name="Flight")
	public void setFlight(List<FlightXml> flight) {
		this.flight = flight;
	}
}

