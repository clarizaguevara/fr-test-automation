package com.pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SendToSlackActionPage extends BasePage {
	
	private static final Logger log = LogManager.getLogger(SendToSlackActionPage.class);

	/* Page Elements */
	@FindBy(xpath= "//input[@placeholder='Slack channel']")
	private WebElement fld_slackChannel;
	
	@FindBy(xpath= "//textarea[@placeholder='Enter message here...']")
	private WebElement fld_slackMessage;
	
	@FindBy(xpath= "//div[@class='col-sm-auto']//input[@class='form-check-input']")
	private WebElement btn_includeOriginalAlertMessage;
	
	/* Methods */
	
	/**
	 *Input Slack Channel
	 */
	public void inputSlackChannel(String slackChannel) {
		log.entry();
		if(driverHelper.isElementPresent(fld_slackChannel)) {
			driverHelper.inputFieldValue(fld_slackChannel, slackChannel);
			driverHelper.embedScreenshot(scenario);
			log.exit();
		} else {
			System.out.println("Slack Channel field is not present.");
			log.exit();
		}
	}
	
	/**
	 *Input Slack Message
	 */
	public void inputSlackMessage(String slackMessage) {
		log.entry();
		if(driverHelper.isElementPresent(fld_slackMessage)) {
			fld_slackMessage.clear();
			driverHelper.inputFieldValue(fld_slackMessage, slackMessage);
			driverHelper.embedScreenshot(scenario);
			log.exit();
		} else {
			System.out.println("Slack Message field is not present.");
			log.exit();
		}
	}
	
	/**
	 * Check include original alert message
	 */
	public void checkIncludeOriginalAlertMessage() {
		log.entry();
		if(driverHelper.isElementPresent(btn_includeOriginalAlertMessage)) {
			driverHelper.clickButton(btn_includeOriginalAlertMessage);
			driverHelper.embedScreenshot(scenario);
			log.exit();
		} else {
			System.out.println("Include Original Alert Message checkbox is not present.");
			log.exit();
		}
	}
}
