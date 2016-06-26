package com.mtt.airline.model;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mtt.airline.utils.DateUtils;

public class Flight {

	private static final String TIME_SEPARATOR = ":";
	private String operator;
	private String flightNumber;
	private String departsFrom;
	private String arrivesAt;
	private Date departingDate;
	private Date arrivingDate;
	private FarePrices farePrices;

	public Flight() {
		super();
	}

	public Flight(String operator, String flightNumber, String departsFrom,
			String arrivesAt, Date departsOn, Date arrivesOn,
			FarePrices farePrices) {
		super();
		this.operator = operator;
		this.flightNumber = flightNumber;
		this.departsFrom = departsFrom;
		this.arrivesAt = arrivesAt;
		this.departingDate = departsOn;
		this.arrivingDate = arrivesOn;
		this.farePrices = farePrices;
	}

	public String getOperator() {
		return operator;
	}

	@JsonIgnore
	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	@JsonIgnore
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getDepartsFrom() {
		return departsFrom;
	}

	@JsonIgnore
	public void setDepartsFrom(String departsFrom) {
		this.departsFrom = departsFrom;
	}

	public String getArrivesAt() {
		return arrivesAt;
	}

	@JsonIgnore
	public void setArrivesAt(String arrivesAt) {
		this.arrivesAt = arrivesAt;
	}

	public Date getDepartingDate() {
		return this.departingDate;
	}

	@JsonIgnore
	public void setDepartingDate(Date departingTime) {
		this.departingDate = departingTime;
	}

	public Date getArrivingDate() {
		return this.arrivingDate;
	}

	@JsonIgnore
	public void setArrivingDate(Date arrivingDate) {
		this.arrivingDate = arrivingDate;
	}

	@JsonIgnore
	public String getFlightTime() {

		long diff = arrivingDate.getTime() - departingDate.getTime();

		long diffHours = diff / (60 * 60 * 1000);
		long diffMinutes = diff / (60 * 1000) % 60;

		return roundingTime(diffHours) + TIME_SEPARATOR + roundingTime(diffMinutes);
	}
	
	private String roundingTime(long time){
		String timeAsString = String.valueOf(time);
		if (time < 10) {
			timeAsString = "0" + timeAsString;
		}
		
		return timeAsString;
	}

	@JsonIgnore
	public DateTime getDepartsOn() {
		return new DateTime(DateUtils.getDateDMY(departingDate),
				DateUtils.getTimeDayHMA(departingDate));
	}

	@JsonIgnore
	public DateTime getArrivesOn() {
		return new DateTime(DateUtils.getDateDMY(arrivingDate),
				DateUtils.getTimeDayHMA(arrivingDate));
	}

	@JsonIgnore
	public FarePrices getFarePrices() {
		return farePrices;
	}

	public void setFarePrices(FarePrices farePrices) {
		this.farePrices = farePrices;
	}

	@JsonProperty(value = "flight")
	public Map<String, Object> getStrings() {
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("operator", getOperator());
		map.put("flightNumber", getFlightNumber());
		map.put("departsFrom", getDepartsFrom());
		map.put("arrivesAt", getArrivesAt());
		map.put("departsOn", getDepartsOn());		
		map.put("arrivesOn", getArrivesOn());
		map.put("flightTime", getFlightTime());
		map.put("farePrices", getFarePrices());
		return map;
	}
}