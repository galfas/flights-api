package com.mtt.airline.model;

import java.util.Date;

public class FlightQuery {
	private String cityFrom;
	private String cityTo;
	private Date dateFrom;
	private Date dateTo;
	private Integer quantity;
	
	
	public FlightQuery() {
		super();
	}
	public FlightQuery(String cityFrom, String cityTo, Date dateFrom,
			Date dateTo, Integer quantity) {
		super();
		this.cityFrom = cityFrom;
		this.cityTo = cityTo;
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
		this.quantity = quantity;
	}


	public String getCityFrom() {
		return cityFrom;
	}
	public void setCityFrom(String cityFrom) {
		this.cityFrom = cityFrom;
	}
	public String getCityTo() {
		return cityTo;
	}
	public void setCityTo(String cityTo) {
		this.cityTo = cityTo;
	}
	public Date getDateFrom() {
		return dateFrom;
	}
	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}
	public Date getDateTo() {
		return dateTo;
	}
	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}
