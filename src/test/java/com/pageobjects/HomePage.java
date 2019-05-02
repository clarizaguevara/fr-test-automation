package com.pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.utils.PropertyUtil;

public class HomePage extends BasePage{

	private static final Logger log = LogManager.getLogger(HomePage.class);
	
	/* Page Elements */
	@FindBy(css= "div[class='browse-page']")
	private WebElement page_browse;
	
	@FindBy(xpath= "//a[contains (text(), 'Home')]")
	private WebElement btn_Home;
	
	/* Methods */
	
	/**
	 * Navigate to Home Page
	 */
	public void verifySuccessfulNavigationToHomePage() {
		log.entry();
		driverHelper.embedScreenshot(scenario);
		Assert.assertTrue("Unsuccessful navigation in Command Center Home Page", driverHelper.isElementPresent(page_browse));
		log.exit();
	}
	
	/**
	 * Click Home Button
	 */
	public void clickHomeButton() {
		log.entry();
		if(driverHelper.isElementPresent(btn_Home)) {
			driverHelper.embedScreenshot(scenario);
			driverHelper.clickButton(btn_Home);
			log.exit();
		} else {
			System.out.println("Home Button is not present.");
			log.exit();
		}
	}
}
