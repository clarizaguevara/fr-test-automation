package com.pageobjects;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class CreateNewTemplatePage extends BasePage {
	
	private static final Logger log = LogManager.getLogger(CreateNewTemplatePage.class);

	
	/* Page Elements */
	
	@FindBy(xpath= "//label[text()='Template type:']//following::select")
	private WebElement fld_templateType;
	
	@FindBys(value = @FindBy (xpath = "//label[text()='Template type:']//following::select//option"))
	private List<WebElement> list_templateType;
	
	@FindBy(xpath= "//input[@placeholder ='Template name...']")
	private WebElement fld_templateName;
	
	
	/**
	 * Select Template Type
	 */
	public void selectTemplateType(String templateType) {
		log.entry();
		if(driverHelper.isElementPresent(fld_templateType)) {
			driverHelper.clickButton(fld_templateType);
			driverHelper.setValueDropdown(list_templateType, fld_templateType, templateType);
			driverHelper.embedScreenshot(scenario);
			log.exit();
		} else {
			System.out.println("Template Type field is not present.");
			log.exit();
		}
	}
	
	/**
	 *Input Template Name
	 */
	public void inputTemplateName(String templateName) {
		log.entry();
		if(driverHelper.isElementPresent(fld_templateName)) {
			driverHelper.inputFieldValue(fld_templateName, templateName);
			driverHelper.embedScreenshot(scenario);
			log.exit();
		} else {
			System.out.println("Template Name field is not present.");
			log.exit();
		}
	}
	
	/**
	 * Check Template Name
	 */
	public void checkTemplateName(String templateName) {
		log.entry();
		Assert.assertTrue("Values are not the same", (fld_templateName.getAttribute("value")).equals(templateName));
		log.exit();
	}

}
