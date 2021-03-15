package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.base.BaseTest;
import com.qa.util.Constants;



public class LoginPageTest extends BaseTest {

	/**
	 * This method will be used to verify the page title 
	 */
	@Test (priority = 0)
	public void verifyLoginPageTitleTest() {
		String actualTitle = loginPage.getLoginPageTitle();
		String expectedtitle = Constants.LOGIN_PAGE_TITLE;
		Assert.assertEquals(expectedtitle, actualTitle);
	}
	
	/**
	 * This method will be used to verify if the forgort link display or not 
	 */
	@Test (priority = 1)
	public void verifyForgotLinkDisplaytest() {
		Assert.assertTrue(loginPage.forgotPassordLinkDisplay());
	}
	
	/**
	 * This methods will be responsible for enter the username & password then will click on the login button
	 */
	@Test (priority = 2)
	public void verifyLoginTest() {
		String user = prop.getProperty("username");
		loginPage.enterUsername(user);
		String pass = prop.getProperty("password");
		loginPage.enterPassword(pass);
		loginPage.clickOnLoginButton();
	}
		

	
	
}
