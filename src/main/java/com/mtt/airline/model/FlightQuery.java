package com.mtt.airline.model;

import com.mtt.airline.utils.DateUtils;

public class FlightQuery {
	private String cityFrom;
	private String cityTo;
	private String dateFrom;
	private String dateTo;
	private Integer quantity;
	

	public FlightQuery(String cityFrom, String cityTo, String dateFrom,
			String dateTo, Integer quantity) {
		super();
		this.cityFrom = cityFrom;
		this.cityTo = cityTo;
		
		if(DateUtils.isValidDate(dateFrom)){
			this.dateFrom = dateFrom;
		}
		if(DateUtils.isValidDate(dateTo)){
			this.dateTo = dateTo;
		}
		
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
	
	public String getDateFrom() {
		return dateFrom;
	}
	public void setDateFrom(String dateFrom) {
		this.dateFrom = dateFrom;
	}

	public String getDateTo() {
		return dateTo;
	}
	public void setDateTo(String dateTo) {
		this.dateTo = dateTo;
	}

	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}
