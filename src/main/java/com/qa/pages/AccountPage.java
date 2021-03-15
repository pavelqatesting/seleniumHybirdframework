package com.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.base.BasePage;
import com.qa.util.GenericFunction;

public class AccountPage extends BasePage{

	// 1. By Locator AKA OR(Object Repository)
	private WebDriver driver;
	private GenericFunction genericFunction;

	private By accountPageHeader = By.cssSelector("div#logo a");
	private By accountSectionHeaders = By.cssSelector("div#content h2");
	private By searchField = By.cssSelector("input[name='search']");
	private By searchButton = By.cssSelector("div#search button[type='button']");
	private By searchResults = By.cssSelector("div#content div.product-thumb h4 a");

	// 2. Constructor of the page class
	public AccountPage(WebDriver driver) {
			this.driver = driver;
			genericFunction = new GenericFunction(driver);
		}

	// 3. Page actions features of the page in the form of methods

	/**
	 * This methods is responsible for return the page account page title
	 * 
	 * @return it return the page title
	 */
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	/**
	 * This method will be responsible for the returining the text for account page header
	 * @return the account page header text 
	 */
	public String getAccountPageHeaderText() {
		if(genericFunction.doIsDisplayed(accountPageHeader)) {
			return genericFunction.doGetText(accountPageHeader);
		}
		return null;
	}
	
	/**
	 * This method is resposible for return the count of total number of account sections 
	 * @return total number of account sections
	 */
	public int getAccountHeadersSectionSize() {
		return genericFunction.getElements(accountSectionHeaders).size();
	}
	
	/**
	 * This method is responsible fo the getting account section list from the account page header
	 * @return the list of account page headers text
	 */
	public List<String> getAccountSectionList() {
		List<String> accountsList = new ArrayList<>();
		List<WebElement> accountSectionList = genericFunction.getElements(accountSectionHeaders);
		
		for(WebElement e : accountSectionList) {
			String header = e.getText();
			System.out.println(header);
			accountsList.add(header);
		}
		return accountsList;	
	}
	
//	/**
//	 * This methods will be used to get all the header text 
//	 * @return this will return the list of string header text  
//	 */
//	public List<String> getAccountSectionTextValue() {
//		List<String> accountListText = new ArrayList<String>();
//		List<WebElement> accountSectionList = genericFunction.getElements(accountSectionHeaders);
//		
//		for(int i = 0; i < accountSectionList.size(); i++ ) {
//			String text = accountSectionList.get(i).getText();
//			accountListText.add(text);
//			System.out.println(text);
//		}
//		return accountListText;
//	}
	
	
	/**
	 * This method is responsible for the seach a product on account page 
	 * @param product
	 */
	public void searchProduct(String product) {
		genericFunction.doSendKeys(searchField, product);
		genericFunction.doActionsClick(searchButton);
	}
	
	/**
	 * This method will be responsible for checking if a search product display or not 
	 * @return 
	 */
	public boolean isSeachproductDisplay() {
		List<WebElement> results = genericFunction.getElements(searchResults);
		int productResultSize = results.size();
		System.out.println("There total "+productResultSize +" product display");
		if(productResultSize > 0) {
			return true;
		} 
		return false;
	}
	
	
	

}
