package com.mtt.airline.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mtt.airline.business.FlightBo;
import com.mtt.airline.model.FlightQuery;
import com.mtt.airline.model.Offers;
import com.mtt.airline.utils.DateUtils;


@RestController
@RequestMapping("/flights")
public class FlightController {

	@Autowired
	private FlightBo flightBo;
	
    @RequestMapping(method=RequestMethod.GET, 
    		value="/from/{cityFrom}/to/{cityTo}/datefrom/{dateFrom}/dateto/{dateTo}/quantity/{quantity}")
    public Offers getFligths(@PathVariable(value="cityFrom") String cityFrom,
    		@PathVariable(value="cityTo") String cityTo,
    		@PathVariable(value="dateFrom") String dateFrom,
    		@PathVariable(value="dateTo") String dateTo,
    		@PathVariable(value="quantity") Integer quantity) throws ParseException {
    	
    	FlightQuery flightQuery = new FlightQuery(cityFrom, cityTo, 
    			DateUtils.getDateFrom(dateFrom), DateUtils.getDateFrom(dateTo), quantity);
    	
    	return flightBo.getTicket(flightQuery);
    }

}

