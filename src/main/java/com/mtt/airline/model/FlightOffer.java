package com.mtt.airline.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FlightOffer {
	
	private List<Flight> availability;

	
	public FlightOffer() {
		super();
	}
	public FlightOffer(List<Flight> availability) {
		super();
		this.availability = availability;
	}
	
	
	public List<Flight> getAvailability() {
		return availability;
	}
	
	public void setAvailability(List<Flight> availability) {
		this.availability = availability;
	}
}
