package com.qa.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import com.qa.pages.AccountPage;
import com.qa.pages.LoginPage;
import com.qa.util.GenericFunction;

public class BaseTest {
	
	public Properties prop;
	public BasePage basePage = new BasePage();
	public WebDriver driver;
	public LoginPage loginPage;
	public AccountPage accountPage;

	
	/**
	 * This method is responsible setUp the test 
	 */
	@BeforeMethod
	public void setUp() {
		prop = basePage.initlizeProperties(); 
		String browser = prop.getProperty("browser");
		driver = basePage.initilizebrowser(browser);
		loginPage = new LoginPage(driver);
		accountPage = new AccountPage(driver);
		String url = prop.getProperty("url");
		driver.get(url);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	public void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
