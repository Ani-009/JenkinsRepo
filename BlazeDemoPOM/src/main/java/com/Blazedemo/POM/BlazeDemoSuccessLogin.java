package com.Blazedemo.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BlazeDemoSuccessLogin {

	
	
	@FindBy(css = "#app > div > div > div > div > div.panel-body")
	private WebElement successMessage;

	@FindBy(linkText="BlazeDemo")
	private WebElement blazeDemoLink;
	
	@FindBy(css ="#app-navbar-collapse > ul.nav.navbar-nav.navbar-right > li > a")
	private WebElement user;
	
	@FindBy(linkText = "Logout")
	private WebElement logout;
	
	
	public BlazeDemoSuccessLogin(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getSuccessMessage() {
		
		
		return successMessage;
		
	}
	
	public void getBlazeDemo() {
		blazeDemoLink.click();
	}
	
	public void logout() {
		user.click();
		logout.click();
	}
	
}
