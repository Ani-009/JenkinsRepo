package com.edureka.JenkinsDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class VerifyTitle {
	WebDriver driver;

	@BeforeTest
	public void openBrowser() {
		System.out.println("openBrowser : BaseClass");

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
          System.out.println("-------");

          System.out.printl("added more");
		System.out.printl("added more");

		driver.get("https://facebook.com");

	}

	@Test
	public void verifyTitle() {

		// 3) Verify if the title is - Facebook- log in or sign up
		String expectedTitle = "Facebook – log in or sign up";
		String actualTitle = driver.getTitle();

		if (expectedTitle.equals(actualTitle)) {
			System.out.println("Test Case Passed");
		}

		else {
			System.out.println("Test Case Failed");
		}
	}

	@AfterTest
	public void closeBrowser() {
		driver.close();
	}

}
