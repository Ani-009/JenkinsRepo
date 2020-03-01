package com.Blazedemo.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BlazeDemoConfirmation {
	
	
	@FindBy(css = "body > div.container > div > h1")
	private WebElement confirmationText;
	
	

	public BlazeDemoConfirmation(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement verifyConfrimationText() {
		return confirmationText;
	}
	
}
