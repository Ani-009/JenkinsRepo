package com.Blazedemo.MavenDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BlazedemoConfirmation {
	
	@FindBy(css="body > div.container > div > h1")
	private WebElement confirmationMessage;
	
	
	public BlazedemoConfirmation(WebDriver driver) {		
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getConfirmationMessage() {
		return confirmationMessage;
	}
}
