package com.mtt.airline.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mtt.airline.controller.FlightController;
import com.mtt.airline.utils.DateUtils;

public class FlightQuery {
	
	private static final Logger logger = LoggerFactory.getLogger(FlightController.class);
	
	private String cityFrom;
	private String cityTo;
	private String dateFrom;
	private String dateTo;
	private Integer quantity;
	
	
	public FlightQuery(String cityFrom, String cityTo, String dateFrom,
			String dateTo, Integer quantity) {
		
		if(!DateUtils.isValidDateYMD(dateFrom)){
			logger.error("The date from provided are not valid. %s", dateFrom);
			throw new IllegalArgumentException();
		
		}else if(DateUtils.isValidDateYMD(dateTo)){
			logger.error("The date To provided are not valid. %s", dateTo);
			throw new IllegalArgumentException();
		}
		
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


	@Override
	public String toString() {
		return "cityFrom=" + cityFrom + ", cityTo=" + cityTo
				+ ", dateFrom=" + dateFrom + ", dateTo=" + dateTo
				+ ", quantity=" + quantity;
	}
	
	
}
