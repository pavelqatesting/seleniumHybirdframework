package com.qa.util;

import java.util.ArrayList;
import java.util.List;

public class Constants {

	public static String LOGIN_PAGE_TITLE = "Account Login";
	public static String ACCOUNT_PAGE_TITLE = "My Account";
	
	public static List<String> GET_ACCOUNT_SECTION_LIST() {
		List<String> accountList = new ArrayList<String>();
		accountList.add("My Account");
		accountList.add("My Orders");
		accountList.add("My Affiliate Account");
		accountList.add("Newsletter");
		return accountList;
	}
}
