package com.mtt.airline.model;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

public class PriceTest {
	
	@Test
	public void shouldReturned2DecimalsFromJustOne(){
		Price price = new Price("EUR", new BigDecimal(2.10));
		Assert.assertEquals("2.10", price.displayAmmount());
	}
	
	@Test
	public void shouldReturned2DecimalsFromTwo(){
		Price price = new Price("EUR", new BigDecimal(2.12));
		Assert.assertEquals("2.12", price.displayAmmount());
	}
	
	@Test
	public void shouldReturn2DecimalFromBigNumber(){
		Price price = new Price("EUR", new BigDecimal(200000));
		Assert.assertEquals("200000.00", price.displayAmmount());
	}
	
}
