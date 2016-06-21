package com.mtt.airline.model;

public class Fare {
	
	private Price ticket;
	private Price bookingFee;
	private Price tax;


	public Fare() {
		super();
	}
	public Fare(Price ticket, Price bookingFee, Price tax) {
		super();
		this.ticket = ticket;
		this.bookingFee = bookingFee;
		this.tax = tax;
	}


	public Price getTicket() {
		return ticket;
	}
	public void setTicket(Price ticket) {
		this.ticket = ticket;
	}
	public Price getBookingFee() {
		return bookingFee;
	}
	public void setBookingFee(Price bookingFee) {
		this.bookingFee = bookingFee;
	}
	public Price getTax() {
		return tax;
	}
	public void setTax(Price tax) {
		this.tax = tax;
	}
}
