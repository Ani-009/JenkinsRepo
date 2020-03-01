package com.Blazedemo.POM;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Listeners.ExtentTestManager;
import com.aventstack.extentreports.Status;

public class BookTicketTest extends BlazedemoBaseClass{

	

	@Test
	public void bookTicket() {

		
		loginPage.enterCredentails("abc@gmail.com", "password");
		ExtentTestManager.getTest().log(Status.INFO, "User logged in with userName and Password");
		successLogin.getBlazeDemo();
		ExtentTestManager.getTest().log(Status.INFO, "User logged in successfully ");
		
		home.chooseCities();
		ExtentTestManager.getTest().log(Status.INFO, "User Chose City ");
		
		reserve.chooseFlight();
		ExtentTestManager.getTest().log(Status.INFO, "User selected Flight ");
		purch.enterUserInformation();
		conf.verifyConfrimationText();
		
		
		String expectedMessage= "Thank you for your purchase today!";
		WebElement actualMessage = conf.verifyConfrimationText();
		String actual=  actualMessage.getText();
		Assert.assertEquals(actual, expectedMessage);
	}


	
}
