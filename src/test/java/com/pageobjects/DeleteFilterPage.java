package com.pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeleteFilterPage extends BasePage {
	
	private static final Logger log = LogManager.getLogger(DeleteFilterPage.class);

	/* Page Elements */
	
	@FindBy(xpath= "//button[text()='Yes']")
	private WebElement btn_DeletePopUp_Yes;
	
	@FindBy(xpath= "//button[text()='No']")
	private WebElement btn_DeletePopUp_No;
	
	@FindBy(xpath= "//div[@class='card-body']//h5")
	private WebElement page_DeletePopUp;
	
	/* Methods */

	/**
	 * Delete Pop up
	 */
	public void verifyDeletePopUp() {
		log.entry();
		driverHelper.embedScreenshot(scenario);
		Assert.assertTrue("Delete pop up is not present", driverHelper.isElementPresent(page_DeletePopUp));
		log.exit();
	}
	
	/**
	 * Select Yes in Delete pop up
	 */
	public void clickDeleteYesButton() {
		log.entry();
		if(driverHelper.isElementPresent(btn_DeletePopUp_Yes)) {
			driverHelper.embedScreenshot(scenario);
			driverHelper.clickButton(btn_DeletePopUp_Yes);
			driverHelper.explicitWait();
			log.exit();
		} else {
			System.out.println("Yes option is not present.");
			log.exit();
		}
	}
	
	/**
	 * Select Yes in Delete pop up
	 */
	public void clickDeleteNoButton() {
		log.entry();
		if(driverHelper.isElementPresent(btn_DeletePopUp_No)) {
			driverHelper.embedScreenshot(scenario);
			driverHelper.clickButton(btn_DeletePopUp_No);
			driverHelper.explicitWait();
			log.exit();
		} else {
			System.out.println("No option is not present.");
			log.exit();
		}
	}
	
}
