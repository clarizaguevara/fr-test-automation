package com.pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
		} else {
			Assert.assertTrue("Apply button is not present", driverHelper.isElementPresent(btn_ApplyTemplatesPopUp_Apply));
		}
		log.exit();
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
		} else {
			Assert.assertTrue("Cancel button is not present", driverHelper.isElementPresent(btn_ApplyTemplatesPopUp_Cancel));
		}
		log.exit();
	}
	
	/**
	 * Verify if template is selected
	 */
	public void verifyIfTemplateIsSelected(String templateName, boolean shouldBeSelected) {
		log.entry();
		driverHelper.embedScreenshot(scenario);
		By fld_selectedTemplate = By.xpath("//th[text()='Templates selected:']//following::td[text()='" + templateName + "']");
		boolean isTemplateSelected = false;
		
		if(driverHelper.isElementPresent(fld_selectedTemplate)) {
			isTemplateSelected = true;
		} else {
			isTemplateSelected = false;
		}
		
		if(isTemplateSelected != shouldBeSelected) {
			Assert.assertTrue(templateName + " is selected? Expected: " + shouldBeSelected + " Actual: " + isTemplateSelected, false);
		}
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
		By page_popup = By.xpath("//div[@class='card-body']");
		Actions builder = new Actions(driver);
		Dimension pageSize = driver.findElement(page_popup).getSize();
		int yOffset = (pageSize.height/2) - 53;
		int xOffset = pageSize.width/2;
		
		if(driverHelper.isElementPresent(fld_searchTemplate)) {
			driverHelper.clickButton(fld_searchTemplate);
			driverHelper.inputFieldValue(fld_searchTemplate, templateName);
			driverHelper.explicitWait();
			builder.moveToElement(page_ApplyTemplatesPopUp, xOffset, yOffset).click().build().perform();
			driverHelper.embedScreenshot(scenario);
		} else {
			Assert.assertTrue("Input template field is not present", driverHelper.isElementPresent(fld_searchTemplate));
		}
		log.exit();
	}

}
