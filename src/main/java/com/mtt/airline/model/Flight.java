package com.mtt.airline.model;

import java.util.Calendar;

public class Flight {
	
	private String operator;
	private String flightNumber;
	private String departsFrom;
	private String arrivesAt;
	private Calendar departsOn;
	private Calendar arrivesOn;
	private Calendar flightTime;
	private FarePrices farePrices;
	
	
	public Flight() {
		super();
	}
	public Flight(String operator, String flightNumber, String departsFrom,
			String arrivesAt, Calendar departsOn, Calendar arrivesOn,
			Calendar flightTime, FarePrices farePrices) {
		super();
		this.operator = operator;
		this.flightNumber = flightNumber;
		this.departsFrom = departsFrom;
		this.arrivesAt = arrivesAt;
		this.departsOn = departsOn;
		this.arrivesOn = arrivesOn;
		this.flightTime = flightTime;
		this.farePrices = farePrices;
	}


	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getDepartsFrom() {
		return departsFrom;
	}
	public void setDepartsFrom(String departsFrom) {
		this.departsFrom = departsFrom;
	}

	public String getArrivesAt() {
		return arrivesAt;
	}
	public void setArrivesAt(String arrivesAt) {
		this.arrivesAt = arrivesAt;
	}

	public Calendar getDepartsOn() {
		return departsOn;
	}
	public void setDepartsOn(Calendar departsOn) {
		this.departsOn = departsOn;
	}

	public Calendar getArrivesOn() {
		return arrivesOn;
	}
	public void setArrivesOn(Calendar arrivesOn) {
		this.arrivesOn = arrivesOn;
	}

	public Calendar getFlightTime() {
		return flightTime;
	}
	public void setFlightTime(Calendar flightTime) {
		this.flightTime = flightTime;
	}

	public FarePrices getFarePrices() {
		return farePrices;
	}
	public void setFarePrices(FarePrices farePrices) {
		this.farePrices = farePrices;
	}
	
	

}
