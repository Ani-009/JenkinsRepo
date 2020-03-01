package com.Blazedemo.MavenDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LandingPage {
	
	//private WebElement sourceCity = driver.findElement(By.name("fromPort"));
	
	@FindBy(name="fromPort") 
	private WebElement sourceCity;
	
	@FindBy(name="toPort")
	private WebElement destinationCity;
	
	@FindBy(css="body > div.container > form > div > input")
	private WebElement findFlights;
	
	@FindBy(linkText="home")
	private WebElement home;
	
	public LandingPage(WebDriver driver) {
		//The web-elements of LandingPage class are to found on the driver initialized in the test class.
		PageFactory.initElements(driver, this);
	}
	
	public void chooseCities() {
		Select select = new Select(sourceCity);
		Select select2 = new Select(destinationCity);
		select.selectByIndex(2);
		select2.selectByIndex(4);
		findFlights.click();
	}
	
	public void clickHome() {
		home.click();
	}
	

}
