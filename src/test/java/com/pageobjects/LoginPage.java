package com.pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.pageobjects.LoginPage;
import com.utils.PropertyUtil;

public class LoginPage extends BasePage {

	private static final Logger log = LogManager.getLogger(LoginPage.class);
	
	
	/* Methods */
	
	/**
	 * Go to Command Center Login Page
	 */
	public void navigateToLoginPage() {
		log.entry();
		driverHelper.get(PropertyUtil.getConfig("fr.dev.url"));
		log.exit();
	}
	
}
