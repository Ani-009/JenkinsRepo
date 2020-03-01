package com.Blazedemo.POM;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import utils.ReadExcel;

public class DDF extends BlazedemoBaseClass {

	@Test
	public void validateUser() throws IOException {
		
		String[][] userData = ReadExcel.getData("TestData.xlsx", "Sheet1");

		for (int i = 1, j = 1, k = 2; i < userData.length; i++) {

			String username = userData[i][j];
			String password = userData[i][k];
			System.out.println(username +"username"+password +"password");
			loginPage.enterCredentails(username, password);

			WebElement message = successLogin.getSuccessMessage();
			String expectedMessage = "You are logged in!";
			String successMessage = message.getText();
			Assert.assertEquals(successMessage, expectedMessage);
			successLogin.logout();
			home.clickHome();

		}
	}

}
