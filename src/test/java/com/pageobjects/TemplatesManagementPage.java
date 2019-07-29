package com.pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TemplatesManagementPage extends BasePage {
	
	private static final Logger log = LogManager.getLogger(TemplatesManagementPage.class);
	
	
	/* Page Elements */
	
	@FindBy(css= "div[class='Maintenance Page']")
	private WebElement page_browseTemplates;
	
	@FindBy(xpath= "//a[contains (text(), 'Home')]")
	private WebElement btn_Home;
	
	@FindBy(xpath= "//a[text()='Events']")
	private WebElement btn_events;
	
	@FindBy(xpath= "//a[text()='Maintenance']")
	private WebElement btn_maintenance;
	
	@FindBy(xpath= "//a[text()='Access Management']")
	private WebElement btn_accessmanagement;
	
	@FindBy(xpath= "//a[text()='Keyword Lists']")
	private WebElement btn_keywordlists;
	
	@FindBy(xpath= "//button[contains (text(), 'Create Template')]")
	private WebElement btn_createNewTemplate;
	
	
	/* Methods */
	
	/**
	 * Navigate to Templates Management Page
	 */
	public void verifySuccessfulNavigationToTemplatesManagementPage() {
		log.entry();
		Assert.assertTrue("Unsuccessful navigation in Command Center Templates Management Page", driverHelper.isElementPresent(page_browseTemplates));
		driverHelper.embedScreenshot(scenario);
		log.exit();
	}
	
	/**
	 * Click Home Button
	 */
	public void clickHomeButton() {
		log.entry();
		if(driverHelper.isElementPresent(btn_Home)) {
			driverHelper.clickButton(btn_Home);
			log.exit();
		} else {
			System.out.println("Home Button is not present.");
			log.exit();
		}
	}
	
	/**
	 * Select Template in the list
	 */
	public void selectTemplateInList(String templateName) {
		log.entry();
		By fld_template = By.xpath("//td[text()='" + templateName + "']");
		if(driverHelper.isElementPresent(fld_template)) {
			driverHelper.clickButton(fld_template);
			log.info(templateName + " is selected");
			driverHelper.waitForPageLoaded();	
		} else {
			Assert.assertTrue("Template is not present", driverHelper.isElementPresent(fld_template));
			log.exit();
		}
		log.exit();
	}
	
	/**
	 * Verify Template is not found
	 */
	public void verifyTemplateNotFound(String templateName) {
		log.entry();
		By fld_template = By.xpath("//td[text()='" + templateName + "']");
		Assert.assertFalse("Template is present", driverHelper.isElementPresent(fld_template));
		log.exit();
	}
	
	/**
	 * Click Events tab
	 */
	public void clickEventsTab() {
		log.entry();
		if(driverHelper.isElementPresent(btn_events)) {
			driverHelper.clickButton(btn_events);
			driverHelper.explicitWait();
			log.exit();
		} else {
			System.out.println("Events tab is not present.");
			log.exit();
		}
	}
	
	/**
	 * Click Maintenance tab
	 */
	public void clickMaintenanceTab() {
		log.entry();
		if(driverHelper.isElementPresent(btn_maintenance)) {
			driverHelper.clickButton(btn_maintenance);
			driverHelper.embedScreenshot(scenario);
			log.exit();
		} else {
			System.out.println("Maintenance tab is not present.");
			log.exit();
		}
	}
	
	/**
	 * Click Access Management
	 */
	public void clickAccessManagement() {
		log.entry();
		if(driverHelper.isElementPresent(btn_accessmanagement)) {
			driverHelper.clickButton(btn_accessmanagement);
			driverHelper.explicitWait();
			log.exit();
		} else {
			System.out.println("Access Management is not present.");
			log.exit();
		}
	}
	
	/**
	 * Click Keyword Lists
	 */
	public void clickKeywordLists() {
		log.entry();
		if(driverHelper.isElementPresent(btn_keywordlists)) {
			driverHelper.clickButton(btn_keywordlists);
			driverHelper.explicitWait();
			log.exit();
		} else {
			System.out.println("Keyword Lists is not present.");
			log.exit();
		}
	}
	
	/**
	 * Click Create New Template Button
	 */
	public void clickCreateNewTemplateButton() {
		log.entry();
		if(driverHelper.isElementPresent(btn_createNewTemplate)) {
			driverHelper.clickButton(btn_createNewTemplate);
			log.exit();
		} else {
			System.out.println("Create New Template Button is not present.");
			log.exit();
		}
	}
	
	/**
	 * Verify version number of template
	 */
	public void verifyTemplateVersion(String templateName, String versionNumber) {
		log.entry();
		By fld_template_version = By.xpath("//td[text()='" + templateName + "']//following::td[text()='" + versionNumber + "']");
		Assert.assertTrue("Template has wrong version number", driverHelper.isElementPresent(fld_template_version));
		log.exit();
	}

}
