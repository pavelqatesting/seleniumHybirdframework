package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	WebDriver driver;
	Properties prop;
	
	/**
	 * This method is responsible for initilize the browser basics of given browser.......
	 * @param browser
	 * @return it return the WebDriver driver reference 
	 */
	public WebDriver initilizebrowser(String browser) {
		System.out.println(browser+" browser launch========");
		
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if (browser.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
		}
		else {
			System.out.println("Please pass the correct browser value "+browser);
		}
	
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		return driver;
	}
	
	/**
	 * This method is responsible for the load the properties from config.properties file
	 * @return return the Properties prof reference
	 */
	public Properties initlizeProperties() {
		prop = new Properties();
		try {
			FileInputStream fils = new FileInputStream("./src/main/java/com/qa/config/config.properties");
			prop.load(fils);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
	
}
