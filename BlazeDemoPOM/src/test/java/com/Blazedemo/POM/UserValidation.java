package com.Blazedemo.POM;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import utils.ReadExcel;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UserValidation extends BlazedemoBaseClass {

	@Test
	public void validateUser() throws IOException {
	

		loginPage.enterCredentails("abc@gmail.com", "password");
		
		WebElement message = successLogin.getSuccessMessage();
		String expectedMessage = "You are logged in!";
		String successMessage = message.getText();
		Assert.assertEquals(successMessage, expectedMessage);
		

	}

}
