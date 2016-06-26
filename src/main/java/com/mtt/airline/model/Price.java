	package com.mtt.airline.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize
public class Price {
	
	private String currency;
	private BigDecimal ammount;
	
	
	public Price() {
		super();
	}
	public Price(String currency, BigDecimal ammount) {
		super();
		this.currency = currency;
		this.ammount  = ammount.setScale(2, BigDecimal.ROUND_HALF_EVEN);

	}
	
	
	@JsonGetter
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	@JsonGetter("ammount")
	public String displayAmmount() {	
		return ammount.setScale(2, BigDecimal.ROUND_HALF_EVEN).toString();
	}
	
	@JsonIgnore
	public BigDecimal getAmmount() {
		return  ammount;
	}
	public void setAmmount(BigDecimal ammount) {
		this.ammount = ammount.setScale(2, BigDecimal.ROUND_HALF_EVEN);
	}
}
