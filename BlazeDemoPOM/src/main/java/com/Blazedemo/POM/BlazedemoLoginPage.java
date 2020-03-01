package com.Blazedemo.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BlazedemoLoginPage {

	@FindBy(id = "email")
	private WebElement email;

	@FindBy(id = "password")
	private WebElement password;

	@FindBy(css = "#app > div > div > div > div > div.panel-body > form > div:nth-child(4) > div > div > label > input[type=checkbox]")
	private WebElement rememberMe;

	@FindBy(css = "#app > div > div > div > div > div.panel-body > form > div:nth-child(5) > div > button")
	private WebElement login;

	public BlazedemoLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void enterCredentails(String emailId, String pass) {
		email.sendKeys(emailId);
		password.sendKeys(pass);
		rememberMe.click();
		login.click();

	}

}
