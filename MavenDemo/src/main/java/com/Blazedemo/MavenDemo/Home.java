package com.Blazedemo.MavenDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {

	@FindBy(css = "#app > div > div > div > div > div.panel-body")
	private WebElement loginSuccessMessage;

	@FindBy(linkText = "BlazeDemo")
	private WebElement blazeDemo;
	
	@FindBy(css="#app-navbar-collapse > ul.nav.navbar-nav.navbar-right > li > a")
	private WebElement user;
	
	@FindBy(linkText="Logout")
	private WebElement logout;

	public Home(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getLoginSuccessMessage() {
		return loginSuccessMessage;
	}
	
	public void clickBlazeDemo() {
		blazeDemo.click();
	}
	
	public void logoutOfTheApp() {
		user.click();
		logout.click();
	}

}
