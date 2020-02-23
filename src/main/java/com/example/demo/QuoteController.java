package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/land")
public class QuoteController {

	@RequestMapping(value="/quote", method = RequestMethod.GET)
	public Rate getQuote() {
		System.out.println("getQuote invoked.");
		Rate rate = new Rate();
		rate.setQuote("$20000.00");		
		return rate;
	}
	
	
	@RequestMapping(value="/updatetax", method = RequestMethod.POST)
	public ResponseEntity<Rate> updateQuote(@RequestBody(required = true)Rate rate) {
		System.out.println("updatequote invoked.");
		double tax = 0.0;
		if(rate.getPrice()!=null) {
			tax = rate.getPrice() * 1.3;
		}
		rate.setTax(tax);		
		return ResponseEntity.status(HttpStatus.OK).body(rate);
	}
	
}