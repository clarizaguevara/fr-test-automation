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
	 * Select Template in the list
	 */
	public void selectTemplateInList(String templateName) {
		log.entry();
		By fld_template = By.xpath("//td[text()='" + templateName + "']");
		if(driverHelper.isElementPresent(fld_template)) {
			driverHelper.clickButton(fld_template);
			driverHelper.waitForPageLoaded();	
		} else {
			Assert.assertTrue("Template is not present", driverHelper.isElementPresent(fld_template));
		}
		log.exit();
	}
	
	/**
	 * Click Create New Template Button
	 */
	public void clickCreateNewTemplateButton() {
		log.entry();
		if(driverHelper.isElementPresent(btn_createNewTemplate)) {
			driverHelper.clickButton(btn_createNewTemplate);
		} else {
			Assert.assertTrue("Create New Template button is not present.", driverHelper.isElementPresent(btn_createNewTemplate));
		}
		log.exit();
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
