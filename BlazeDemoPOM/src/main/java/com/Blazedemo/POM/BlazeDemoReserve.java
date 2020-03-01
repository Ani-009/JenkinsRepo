package com.Blazedemo.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BlazeDemoReserve {

	@FindBy(css ="body > div.container > table > tbody > tr:nth-child(1) > td:nth-child(2) > input")
	private WebElement chooseFlights;
	
	public BlazeDemoReserve(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
public void chooseFlight() {
	
	chooseFlights.click();
}
	
	
}
