package com.Blazedemo.MavenDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Listeners.ExtentTestManager;
import com.aventstack.extentreports.Status;

public class BookTicketTest extends BaseClass {
	
	@Test
	public void bookTicket() {				
			login.applicationLogin("abc@gmail.com", "password");
			ExtentTestManager.getTest().log(Status.INFO, "Username and password entered successfully");
			home.clickBlazeDemo();
			ExtentTestManager.getTest().log(Status.INFO, "Clicked on BlazeDemo");
			landingPage.chooseCities();
			ExtentTestManager.getTest().log(Status.INFO, "Chose Cities for travel");
			listOfFlights.selectFlight();		
			ExtentTestManager.getTest().log(Status.INFO, "Selected the flight");
			blazeDemoPurchase.enterMandatoryInformation();	
			ExtentTestManager.getTest().log(Status.INFO, "Entered Mandatory Details");
			
			String expectedMessage = "Thank you for your purchase today!";
			String actualMessage = blazedemoConfirmation.getConfirmationMessage().getText();
			
			Assert.assertEquals(actualMessage, expectedMessage);	
	}
	
}
