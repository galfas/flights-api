	package com.mtt.airline.model;

import java.math.BigDecimal;

public class Price {
	
	private String currency;
	private BigDecimal ammount;
	
	
	public Price() {
		super();
	}
	public Price(String currency, BigDecimal ammount) {
		super();
		this.currency = currency;
		this.ammount = ammount;
	}
	
	
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public BigDecimal getAmmount() {
		return ammount;
	}
	public void setAmmount(BigDecimal ammount) {
		this.ammount = ammount;
	}
}
