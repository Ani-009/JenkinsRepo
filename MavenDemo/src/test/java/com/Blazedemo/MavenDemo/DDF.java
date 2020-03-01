package com.Blazedemo.MavenDemo;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import utils.ReadExcel;

public class DDF extends BaseClass{
	
	@Test
	public void validateUserDDF() throws IOException {	
		
		String[][] data = ReadExcel.getData("TestData.xlsx", "Sheet1");
		
		for(int i=1; i<data.length; i++) {
			
			String username = data[i][1];
			String password = data[i][2];
			
			login.applicationLogin(username,password);
			
			String expectedMessage = "You are logged in!";
			String actualMessage = home.getLoginSuccessMessage().getText();
			
			Assert.assertEquals(actualMessage, expectedMessage);
			
			home.logoutOfTheApp();
			landingPage.clickHome();
		}
	}


}
