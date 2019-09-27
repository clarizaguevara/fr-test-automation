package com.pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
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
			fld_slackChannel.clear();
			driverHelper.inputFieldValue(fld_slackChannel, slackChannel);
			driverHelper.embedScreenshot(scenario);
		} else {
			Assert.assertTrue("Slack Channel is not present.", driverHelper.isElementPresent(fld_slackChannel));
		}
		log.exit();
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
		} else {
			Assert.assertTrue("Slack Message field is not present.", driverHelper.isElementPresent(fld_slackMessage));
		}
		log.exit();
	}
	
	/**
	 * Check include original alert message
	 */
	public void checkIncludeOriginalAlertMessage() {
		log.entry();
		if(driverHelper.isElementPresent(btn_includeOriginalAlertMessage)) {
			driverHelper.clickButton(btn_includeOriginalAlertMessage);
			driverHelper.embedScreenshot(scenario);
		} else {
			Assert.assertTrue("Include original alert checkbox is not present.", driverHelper.isElementPresent(btn_includeOriginalAlertMessage));
		}
		log.exit();
	}
}
