package com.pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SendEmailActionPage extends BasePage {
	
	private static final Logger log = LogManager.getLogger(SendEmailActionPage.class);

	/* Page Elements */
	@FindBy(xpath= "//label[contains(text(), 'To:')]//following::div[@class='css-rsyb7x'][1]//input")
	private WebElement fld_To;
	
	@FindBy(xpath= "//label[contains(text(), 'Cc:')]//following::div[@class='css-rsyb7x'][1]//input")
	private WebElement fld_cc;
	
	@FindBy(xpath= "//label[contains(text(), 'Cc:')]//following::div[@class='css-rsyb7x'][2]//input")
	private WebElement fld_bcc;
	
	@FindBy(xpath= "//input[@name='subject']")
	private WebElement fld_subject;
	
	@FindBy(xpath= "//textarea[@placeholder='Enter message here...']")
	private WebElement fld_emailMessage;
	
	@FindBy(xpath= "//div[@class='col-sm-auto']//input[@class='form-check-input']")
	private WebElement btn_includeOriginalAlertMessage;
	
	/* Methods */
	
	/**
	 *Input in To field
	 */
	public void inputTo(String toEmail) {
		log.entry();
		if(driverHelper.isElementPresent(fld_To)) {
			driverHelper.inputFieldValue(fld_To, toEmail);
			driverHelper.embedScreenshot(scenario);
		} else {
			Assert.assertTrue("To field is not present.", driverHelper.isElementPresent(fld_To));
		}
		log.exit();
	}
	
	/**
	 *Input CC email
	 */
	public void inputCC(String ccEmail) {
		log.entry();
		if(driverHelper.isElementPresent(fld_cc)) {
			driverHelper.inputFieldValue(fld_cc, ccEmail);
			driverHelper.embedScreenshot(scenario);
		} else {
			Assert.assertTrue("CC field is not present.", driverHelper.isElementPresent(fld_cc));
		}
		log.exit();
	}
	
	/**
	 *Input BCC email
	 */
	public void inputBCC(String bccEmail) {
		log.entry();
		if(driverHelper.isElementPresent(fld_bcc)) {
			driverHelper.inputFieldValue(fld_bcc, bccEmail);
			driverHelper.embedScreenshot(scenario);
		} else {
			Assert.assertTrue("BCC field is not present.", driverHelper.isElementPresent(fld_bcc));
		}
		log.exit();
	}
	
	/**
	 *Input Subject
	 */
	public void inputSubject(String subject) {
		log.entry();
		if(driverHelper.isElementPresent(fld_subject)) {
			driverHelper.inputFieldValue(fld_subject, subject);
			driverHelper.embedScreenshot(scenario);
		} else {
			Assert.assertTrue("Subject field is not present.", driverHelper.isElementPresent(fld_subject));
		}
		log.exit();
	}
	
	/**
	 *Input Email Message
	 */
	public void inputEmailMessage(String emailMessage) {
		log.entry();
		if(driverHelper.isElementPresent(fld_emailMessage)) {
			driverHelper.inputFieldValue(fld_emailMessage, emailMessage);
			driverHelper.embedScreenshot(scenario);
		} else {
			Assert.assertTrue("Email message field is not present.", driverHelper.isElementPresent(fld_emailMessage));
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
