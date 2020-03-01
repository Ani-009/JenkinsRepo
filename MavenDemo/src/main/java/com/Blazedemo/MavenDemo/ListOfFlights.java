package com.Blazedemo.MavenDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ListOfFlights {
	
	@FindBy(css="body > div.container > table > tbody > tr:nth-child(2) > td:nth-child(2) > input")
	private WebElement chooseFlight;
	
	public ListOfFlights(WebDriver driver) {		
		PageFactory.initElements(driver, this);
	}
	
	public void selectFlight() {
		chooseFlight.click();
	}
}
