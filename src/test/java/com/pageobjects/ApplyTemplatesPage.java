package com.pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ApplyTemplatesPage extends BasePage {
	
	private static final Logger log = LogManager.getLogger(ApplyTemplatesPage.class);

	
	/* Page Elements */
	
	@FindBy(xpath= "//button[text()='Apply']")
	private WebElement btn_ApplyTemplatesPopUp_Apply;
	
	@FindBy(xpath= "//button[text()='Cancel']")
	private WebElement btn_ApplyTemplatesPopUp_Cancel;
	
	@FindBy(xpath= "//div[@class='card-body']//h5//strong[text()='Apply Templates']")
	private WebElement page_ApplyTemplatesPopUp;
	
	@FindBy(xpath= "//strong[text()='Apply Templates']//following::div[@class='css-108yccl']//following::div[@class='css-rsyb7x']//div//input")
	private WebElement fld_searchTemplate;
	
	
	/* Methods */

	/**
	 * Apply Templates Pop up
	 */
	public void verifyApplyTemplatesPopUp() {
		log.entry();
		driverHelper.embedScreenshot(scenario);
		Assert.assertTrue("Apply Templates pop up is not present", driverHelper.isElementPresent(page_ApplyTemplatesPopUp));
		log.exit();
	}
	
	/**
	 * Click Apply
	 */
	public void clickApply() {
		log.entry();
		driver.switchTo().defaultContent();
		if(driverHelper.isElementPresent(btn_ApplyTemplatesPopUp_Apply)) {
			driverHelper.embedScreenshot(scenario);
			driverHelper.clickButton(btn_ApplyTemplatesPopUp_Apply);
			driverHelper.explicitWait();
			log.exit();
		} else {
			log.info("Apply button is not present.");
			log.exit();
		}
	}
	
	/**
	 * Click Cancel
	 */
	public void clickCancel() {
		log.entry();
		if(driverHelper.isElementPresent(btn_ApplyTemplatesPopUp_Cancel)) {
			driverHelper.embedScreenshot(scenario);
			driverHelper.clickButton(btn_ApplyTemplatesPopUp_Cancel);
			driverHelper.explicitWait();
			log.exit();
		} else {
			log.info("Cancel button is not present.");
			log.exit();
		}
	}
	
	/**
	 * Verify if template is selected
	 */
	public void verifyIfTemplateIsSelected(String templateName) {
		log.entry();
		driverHelper.embedScreenshot(scenario);
		By fld_selectedTemplate = By.xpath("//th[text()='Templates selected:']//following::td[text()='" + templateName + "']");
		Assert.assertTrue("Template is not selected", driverHelper.isElementPresent(fld_selectedTemplate));
		log.exit();
	}
	
	/**
	 * Verify if template is not selected
	 */
	public void verifyIfTemplateIsNotSelected(String templateName) {
		log.entry();
		driverHelper.embedScreenshot(scenario);
		By fld_selectedTemplate = By.xpath("//th[text()='Templates selected:']//following::td[text()='" + templateName + "']");
		Assert.assertFalse("Template is selected", driverHelper.isElementPresent(fld_selectedTemplate));
		log.exit();
	}
	
	/**
	 * Verify active template
	 */
	public void verifyActiveTemplate(String templateName) {
		log.entry();
		driverHelper.embedScreenshot(scenario);
		By fld_activeTemplate = By.xpath("//th[text()='Active templates:']//following::td[text()='" + templateName + "']");
		Assert.assertTrue("Template is not active", driverHelper.isElementPresent(fld_activeTemplate));
		log.exit();
	}
	
	/**
	 * Input template name
	 */
	public void inputTemplateName(String templateName) {
		log.entry();
		driver.switchTo().defaultContent();
		By fld_searchTemplate_click = By.xpath("//div[@class='css-1n9lbrx']");
		By fld_searchTemplate_enter = By.xpath("//strong[text()='Apply Templates']//following::div[@class='css-108yccl']");
		if(driverHelper.isElementPresent(fld_searchTemplate)) {
			driverHelper.clickButton(fld_searchTemplate);
			driverHelper.inputFieldValue(fld_searchTemplate, templateName);
			driverHelper.explicitWait();
			driverHelper.clickEnter(fld_searchTemplate);
			driverHelper.embedScreenshot(scenario);
			log.exit();
		} else {
			log.info("Input template field is not present.");
			log.exit();
		}
	}

}
