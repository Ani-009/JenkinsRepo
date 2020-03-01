package com.Blazedemo.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BlazeDemoHome {

	@FindBy(name = "fromPort")
	private WebElement sourceCity;

	@FindBy(name = "toPort")
	private WebElement destCity;

	@FindBy(linkText = "home")
	private WebElement home;

	@FindBy(css = "body > div.container > form > div > input")
	private WebElement findFlights;

	public BlazeDemoHome(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void chooseCities() {
		Select select = new Select(sourceCity);
		Select dest = new Select(destCity);
		select.selectByIndex(2);
		dest.selectByIndex(3);
		findFlights.click();
	}

	public void clickHome() {
		home.click();
	}
}
