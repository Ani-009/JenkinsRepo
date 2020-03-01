package com.Blazedemo.MavenDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BlazeDemoPurchase {
	
	@FindBy(id="inputName")
	private WebElement name;
	
	@FindBy(id="address")
	private WebElement address;
	
	@FindBy(id="city")
	private WebElement city;
	
	@FindBy(id="state")
	private WebElement state;
	
	@FindBy(id="zipCode")
	private WebElement zipcode;
	
	@FindBy(id="nameOnCard")
	private WebElement nameOnCard;
	
	@FindBy(id="rememberMe")
	private WebElement rememberMe;
	
	@FindBy(css="body > div.container > form > div:nth-child(12) > div > input")
	private WebElement purchaseFlight;
	
	public BlazeDemoPurchase(WebDriver driver) {		
		PageFactory.initElements(driver, this);
	}
	
	public void enterMandatoryInformation() {
		name.sendKeys("Deepinder");
		address.sendKeys("123 ABC Avenue");
		state.sendKeys("StateA");
		zipcode.sendKeys("5522336");
		nameOnCard.sendKeys("Deepinder Singh");
		rememberMe.click();
		purchaseFlight.click();
	}
	
	

}
