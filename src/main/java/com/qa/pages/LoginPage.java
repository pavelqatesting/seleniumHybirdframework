package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.util.Constants;
import com.qa.util.GenericFunction;

public class LoginPage {

	//1. By Locator AKA OR(Object Repository)
	private WebDriver driver;
	private GenericFunction genericFunction;
	
	private By username = By.cssSelector("#input-email");
	private By password = By.cssSelector("#input-password");
	private By loginButton = By.cssSelector("input.btn.btn-primary");
	private By forgotPasswordLink = By.linkText("Forgotten Password");
	
	//2. Constructor of the page class
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		genericFunction = new GenericFunction(driver);
	}
	
	//3. Page actions features of the page in the form of methods 
	
	/**
	 * This methods is responsible for return the page loginPage title
	 * @return it return the page title
	 */
	public String getLoginPageTitle() {
		return genericFunction.waitForTitlePresent(Constants.LOGIN_PAGE_TITLE, 20);
	}
	
	/**
	 * This methods is responsible for to check if the sign up link display or not on the loginPage 
	 * @return return true if the link display otherwise return false 
	 */
	public boolean forgotPassordLinkDisplay() {
		return genericFunction.doIsDisplayed(forgotPasswordLink);
	}
	
	/**
	 * This method is responsible for entering the username 
	 * @param user
	 */
	public void enterUsername(String user) {
		System.out.println("Login with username: "+user);
		genericFunction.doSendKeys(username, user);
	}
	
	/**
	 * This method is responsible for entering passoword 
	 * @param pass
	 */
	public void enterPassword(String pass) {
		System.out.println("Login with password: "+pass);
		genericFunction.doSendKeys(password, pass);
	}
	
	/**
	 * This method is responsible for click on the login button
	 */
	public void clickOnLoginButton() {
		genericFunction.doClick(loginButton);
	}
	
	/**
	 * This methods is responsible for the login to the application
	 * And will do the chaining with AccountPage class 
	 * @return the AccountPage reference 
	 */
	public AccountPage doLogin(String user, String pass) {
		System.out.println("Login with username: "+user +" and password: "+pass);
		genericFunction.doSendKeys(username, user);
		genericFunction.doSendKeys(password, pass);
		genericFunction.doClick(loginButton);
		return new AccountPage(driver);
	}
}
