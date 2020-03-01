package com.Blazedemo.MavenDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	
	@FindBy(id="email")
	private WebElement email;
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(css="#app > div > div > div > div > div.panel-body > form > div:nth-child(4) > div > div > label > input[type=checkbox]")
	private WebElement rememberMe;
	
	@FindBy(css="#app > div > div > div > div > div.panel-body > form > div:nth-child(5) > div > button")
	private WebElement login;
	
	public Login(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void applicationLogin(String username, String pass) {
		email.sendKeys(username);
		//Wait here
		
		password.sendKeys(pass);
		rememberMe.click();
		login.click();
		
	}

}
