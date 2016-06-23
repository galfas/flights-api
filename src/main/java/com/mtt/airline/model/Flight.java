package com.mtt.airline.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.mtt.airline.utils.DateUtils;

@JsonPropertyOrder({ "operator", "flightNumber", "departsFrom", "arrivesAt",
	"departsOn", "arrivesOn", "flightTime", "farePrices"})
public class Flight {
	
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
			String arrivesAt, Date departsOn, Date arrivesOn, FarePrices farePrices) {
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
	
	@JsonGetter("flightTime")
	public String getFlightTime() {
		
	    long diff = arrivingDate.getTime() - departingDate.getTime();
	    
	    long diffHours = diff / (60 * 60 * 1000);
	    long diffMinutes = diff / (60 * 1000) % 60;
	    
	    String diffHoursAsString = String.valueOf(diffHours);
	    String diffMinutesAsString =  String.valueOf(diffMinutes);

		if(diffHours<10){
			diffHoursAsString = "0"+diffHours;
		}
		
		if(diffMinutes<10){
			diffMinutesAsString = "0"+diffMinutes;
		}
		return diffHoursAsString+":"+diffMinutesAsString;
	}
	
	@JsonGetter("departsOn")
	public DateTime getDepartsOn(){
		return new DateTime(DateUtils.getDateDMY(departingDate),  
								DateUtils.getTimeDayHMA(departingDate));
	}
	
	@JsonGetter("arrivesOn")
	public DateTime getArrivesOn(){
		return new DateTime(DateUtils.getDateDMY(arrivingDate),  
								DateUtils.getTimeDayHMA(arrivingDate));
	}

	public FarePrices getFarePrices() {
		return farePrices;
	}
	public void setFarePrices(FarePrices farePrices) {
		this.farePrices = farePrices;
	}
}