package com.mtt.airline.dao.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
@XmlRootElement(name="Fare")
public class FareXml{
	
	private String klass;
	private String basePrice;
	private String fees;
	private String tax;

	
	public FareXml() {
		super();
	}
	public FareXml(String klass, String basePrice, String fees, String tax) {
		super();
		this.klass = klass;
		this.basePrice = basePrice;
		this.fees = fees;
		this.tax = tax;
	}
	public String getKlass() {
		return klass;
	}
	@XmlAttribute(name="class")
	public void setKlass(String klass) {
		this.klass = klass;
	}

	public String getBasePrice() {
		return basePrice;
	}
	@XmlElement(name="BasePrice")
	public void setBasePrice(String basePrice) {
		this.basePrice = basePrice;
	}

	public String getFees() {
		return fees;
	}
	@XmlElement(name="Fees")
	public void setFees(String fees) {
		this.fees = fees;
	}

	public String getTax() {
		return tax;
	}
	@XmlElement(name="Tax")
	public void setTax(String tax) {
		this.tax = tax;
	}
}