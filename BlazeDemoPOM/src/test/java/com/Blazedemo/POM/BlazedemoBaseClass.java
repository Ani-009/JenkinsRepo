package com.Blazedemo.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class BlazedemoBaseClass {

	public WebDriver driver;
	public BlazeDemoHome home;
	public BlazeDemoConfirmation conf;
	public BlazeDemoPurchase purch;
	public BlazeDemoReserve reserve;
	public BlazeDemoSuccessLogin successLogin;
	public BlazedemoLoginPage loginPage;
	
	@BeforeClass()
	public void openBrowser() {
		System.out.println("openBrowser : BaseClass");
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("http://blazedemo.com/login");

		home = new BlazeDemoHome(driver);
		conf = new BlazeDemoConfirmation(driver);
		purch = new BlazeDemoPurchase(driver);
		reserve = new BlazeDemoReserve(driver);
		successLogin = new BlazeDemoSuccessLogin(driver);
		loginPage = new BlazedemoLoginPage(driver);

	}

	@AfterClass()
	public void closeBrowser() {
		driver.close();
	}
}
