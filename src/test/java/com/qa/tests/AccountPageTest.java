package com.qa.tests;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.base.BaseTest;
import com.qa.util.Constants;

public class AccountPageTest extends BaseTest {
	
	@Test(priority = 0)
	public void verifyAccountPageHeaderTextTest() {
		String user = prop.getProperty("username");
		String pass = prop.getProperty("password");
		accountPage = loginPage.doLogin(user, pass);
		String actualtext = accountPage.getAccountPageHeaderText();
		System.out.println(actualtext);
		Assert.assertTrue(actualtext.contains("Your Store"));	
	}

	@Test(priority = 1)
	public void verifyPageTitleTest() {
		String user = prop.getProperty("username");
		String pass = prop.getProperty("password");
		accountPage = loginPage.doLogin(user, pass);
		String actualTitle = accountPage.getLoginPageTitle();
		System.out.println(actualTitle);
		Assert.assertTrue(actualTitle.contains(Constants.ACCOUNT_PAGE_TITLE));	
	}
	
	@Test(priority = 2)
	public void verifyAccountSectionListTest() {
		String user = prop.getProperty("username");
		String pass = prop.getProperty("password");
		accountPage = loginPage.doLogin(user, pass);
		int accountSize = accountPage.getAccountHeadersSectionSize();
		Assert.assertEquals(accountSize, 4);
		System.out.println(accountSize);
		List<String> accountHeaderList = accountPage.getAccountSectionList();
		Assert.assertEquals(accountHeaderList, Constants.GET_ACCOUNT_SECTION_LIST());
		System.out.println(accountHeaderList);
		
	}
	
	@Test
	public void searchProductTest() {
		String user = prop.getProperty("username");
		String pass = prop.getProperty("password");
		accountPage = loginPage.doLogin(user, pass);
		String product = "MAC BOOK";
		accountPage.searchProduct(product);
		sleep(5000);
		accountPage.isSeachproductDisplay();
		
	}
}
