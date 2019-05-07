package com.pageobjects;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class ExtendedRulePage extends BasePage {
	
	private static final Logger log = LogManager.getLogger(ExtendedRulePage.class);

	
	/* Page Elements */
	
	@FindBy(xpath= "//h4[text()='Extended Rules']//following::span[contains(@class,'delete')]")
	private WebElement btn_deleteExtendedRule;
	
	@FindBys(value = @FindBy (xpath = "//div[@class='col-sm-3 px-1']//select[@class='form-control']//option"))
	private List<WebElement> list_extendedRule;
	
	@FindBy(xpath= "//div[@class='col-sm-3 px-1']//select[@class='form-control']")
	private WebElement fld_extendedRule;
	
	
	/* Methods */
	
	/**
	 * Click Delete Extended rule button
	 */
	public void deleteExtendedRule() {
		log.entry();
		if(driverHelper.isElementPresent(btn_deleteExtendedRule)) {
			driverHelper.clickButton(btn_deleteExtendedRule);
			log.exit();
		} else {
			System.out.println("Delete Rule button in Extended Rules is not present.");
			log.exit();
		}
	}
	
	/**
	 * Select Extended Rule
	 */
	public void selectExtendedRule(String extendedRule) {
		log.entry();
		if(driverHelper.isElementPresent(fld_extendedRule)) {
			driverHelper.clickButton(fld_extendedRule);
			driverHelper.setValueDropdown(list_extendedRule, fld_extendedRule, extendedRule);
			driverHelper.embedScreenshot(scenario);
			log.exit();
		} else {
			System.out.println("Extended Rule field is not present.");
			log.exit();
		}
	}
	

}
