package com.Blazedemo.MavenDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class UserValidationTest extends BaseClass {	
	
	@Test
	public void validateUser() {	
		login.applicationLogin("abc@gmail.com","password");
		
		String expectedMessage = "You are logged inn!";
		String actualMessage = home.getLoginSuccessMessage().getText();
		
		Assert.assertEquals(actualMessage, expectedMessage);
		
	}

}
