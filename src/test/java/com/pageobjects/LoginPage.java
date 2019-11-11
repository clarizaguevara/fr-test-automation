package com.pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.pageobjects.LoginPage;
import com.utils.PropertyUtil;

public class LoginPage extends BasePage {

	private static final Logger log = LogManager.getLogger(LoginPage.class);
	
	
	/* Page Elements */
	
	@FindBy(xpath= "//div[contains(@class,'modal-content-desktop')]")
	private WebElement page_login;
	
	@FindBy(xpath= "//div[contains(@class,'modal-content-desktop')]//following::input[@id='signInFormUsername']")
	private WebElement fld_username;
	
	@FindBy(xpath= "//div[contains(@class,'modal-content-desktop')]//following::input[@id='signInFormPassword']")
	private WebElement fld_password;
	
	@FindBy(xpath= "//div[contains(@class,'modal-content-desktop')]//following::input[@name='signInSubmitButton']")
	private WebElement btn_signIn;
	
	
	/* Methods */
	
	/**
	 * Go to Command Center Login Page
	 */
	public void navigateToLoginPage() {
		log.entry();
		driverHelper.get(PropertyUtil.getConfig("fr.dev.url"));
		verifySuccessfulNavigationToLoginPage();
		log.exit();
	}
	
	/**
	 * Navigate to Login Page
	 */
	public void verifySuccessfulNavigationToLoginPage() {
		log.entry();
		Assert.assertTrue("Unsuccessful navigation in Command Center Login Page", driverHelper.isElementPresent(page_login));
		driverHelper.explicitWait();
		driverHelper.embedScreenshot(scenario);
		log.exit();
	}
	
	/**
	 *Input Username
	 */
	public void inputUsername(String username) {
		log.entry();
		if(driverHelper.isElementPresent(fld_username)) {
			driverHelper.inputFieldValue(fld_username, username);
			driverHelper.embedScreenshot(scenario);
		} else {
			Assert.assertTrue("Username field is not present.", driverHelper.isElementPresent(fld_username));
		}
		log.exit();
	}
	
	/**
	 *Input Password
	 */
	public void inputPassword(String password) {
		log.entry();
		if(driverHelper.isElementPresent(fld_password)) {
			driverHelper.inputFieldValue(fld_password, password);
			driverHelper.embedScreenshot(scenario);
		} else {
			Assert.assertTrue("Password field is not present.", driverHelper.isElementPresent(fld_password));
		}
		log.exit();
	}
	
	/**
	 * Click Sign In Button
	 */
	public void clickSignInButton() {
		log.entry();
		if(driverHelper.isElementPresent(btn_signIn)) {
			driverHelper.clickButton(btn_signIn);
		} else {
			Assert.assertTrue("Sign In Button is not present.", driverHelper.isElementPresent(btn_signIn));
		}
		log.exit();
	}
	
}
