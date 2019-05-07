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
	
	@FindBy(xpath= "//input[@placeholder='Filter title...']")
	private WebElement fld_filterTitle;
	
	@FindBy(xpath= "//button[text()='Apply']")
	private WebElement btn_Apply;
	
	@FindBy(xpath= "//td[@class='font-weight-bold']")
	private WebElement link_filtername;
	
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
	
	/**
	 *Input Filter title to search
	 */
	public void inputFilterTitle(String filterName) {
		log.entry();
		if(driverHelper.isElementPresent(fld_filterTitle)) {
			driverHelper.inputFieldValue(fld_filterTitle, filterName);
			driverHelper.embedScreenshot(scenario);
			log.exit();
		} else {
			System.out.println("Filter Title field is not present.");
			log.exit();
		}
	}
	
	/**
	 * Click Apply Button
	 */
	public void clickApplyButton() {
		log.entry();
		if(driverHelper.isElementPresent(btn_Apply)) {
			driverHelper.embedScreenshot(scenario);
			driverHelper.clickButton(btn_Apply);
			driverHelper.explicitWait();
			log.exit();
		} else {
			System.out.println("Apply Button is not present.");
			log.exit();
		}
	}
	
	/**
	 * Click Filter name
	 */
	public void clickFilterName() {
		log.entry();
		if(driverHelper.isElementPresent(link_filtername)) {
			driverHelper.embedScreenshot(scenario);
			driverHelper.clickButton(link_filtername);
			log.exit();
		} else {
			System.out.println("Filter link is not present.");
			log.exit();
		}
	}
	
	/**
	 * Verify Filter is not found
	 */
	public void verifyFilterNotFound() {
		log.entry();
		Assert.assertTrue("Filter is found.", driverHelper.isElementNotPresent(link_filtername));
		log.exit();
	}
}
