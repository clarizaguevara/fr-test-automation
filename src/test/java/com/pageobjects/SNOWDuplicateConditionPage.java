package com.pageobjects;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class SNOWDuplicateConditionPage extends BasePage {
	
	private static final Logger log = LogManager.getLogger(SNOWDuplicateConditionPage.class);

	
	/* Page Elements */
	
	@FindBys(value = @FindBy (xpath = "//h4[text()='Extended Conditions']//following::select[@class='form-control'][2]//option"))
	private List<WebElement> list_with;
	
	@FindBy(xpath= "//h4[text()='Extended Conditions']//following::select[@class='form-control'][2]")
	private WebElement fld_with;
	
	@FindBys(value = @FindBy (xpath = "//label[contains(text(),'open tickets')]//following::div[@class='col-sm-auto']//select[contains(@class,'form-control')]//option"))
	private List<WebElement> list_keyword;
	
	@FindBy(xpath= "//label[contains(text(),'open tickets')]//following::div[@class='col-sm-auto']//select[contains(@class,'form-control')]")
	private WebElement fld_keyword;
	
	
	/* Methods */
	
	/**
	 * Select with/without
	 */
	public void selectWithOrWithout(String with) {
		log.entry();
		if(driverHelper.isElementPresent(fld_with)) {
			driverHelper.clickButton(fld_with);
			driverHelper.setValueDropdown(list_with, fld_with, with);
			driverHelper.embedScreenshot(scenario);
			log.exit();
		} else {
			Assert.assertTrue("With/Without field is not present", driverHelper.isElementPresent(fld_with));
			log.exit();
		}
	}
	
	/**
	 * Select keyword
	 */
	public void selectKeyword(String keyword) {
		log.entry();
		keyword = "${" + keyword + "}";
		if(driverHelper.isElementPresent(fld_keyword)) {
			driverHelper.clickButton(fld_keyword);
			driverHelper.setValueDropdown(list_keyword, fld_keyword, keyword);
			driverHelper.embedScreenshot(scenario);
			log.exit();
		} else {
			Assert.assertTrue("Keyword field is not present", driverHelper.isElementPresent(fld_keyword));
			log.exit();
		}
	}

}
