package com.Blazedemo.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BlazeDemoPurchase {

	@FindBy(id = "inputName")
	private WebElement name;

	@FindBy(id = "address")
	private WebElement address;

	@FindBy(id = "city")
	private WebElement city;

	@FindBy(id = "state")
	private WebElement state;

	@FindBy(id = "zipCode")
	private WebElement zipCode;

	@FindBy(css = "body > div.container > form > div:nth-child(12) > div > input")
	private WebElement purcahseFlight;

	public BlazeDemoPurchase(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void enterUserInformation() {
		name.sendKeys("AJ");
		address.sendKeys("b street");
		city.sendKeys("Atlanta");
		state.sendKeys("Georgia");
		zipCode.sendKeys("300000");
		purcahseFlight.click();
	}

}