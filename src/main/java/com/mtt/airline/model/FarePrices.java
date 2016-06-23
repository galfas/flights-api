package com.mtt.airline.model;



public class FarePrices {
	
	private Fare first;
	private Fare business;
	private Fare economy;
	
	
	public FarePrices() {
		super();
	}
	public FarePrices(Fare first, Fare business, Fare economy) {
		super();
		this.first = first;
		this.business = business;
		this.economy = economy;
	}


	public Fare getFirst() {
		return first;
	}
	public void setFirst(Fare first) {
		this.first = first;
	}
	
	public Fare getBusiness() {
		return business;
	}
	public void setBusiness(Fare business) {
		this.business = business;
	}
	
	public Fare getEconomy() {
		return economy;
	}
	public void setEconomy(Fare economy) {
		this.economy = economy;
	}
}