package com.pageobjects;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class CorrelationPage extends BasePage {
	
	private static final Logger log = LogManager.getLogger(CorrelationPage.class);

	
	/* Page Elements */
	
	@FindBy(xpath= "//h4[text()='Extended Conditions']//following::input[@class='form-control px-1'][1]")
	private WebElement fld_frequency;
	
	@FindBy(xpath= "//h4[text()='Extended Conditions']//following::input[@class='form-control px-1'][2]")
	private WebElement fld_timeValue;
	
	@FindBys(value = @FindBy (xpath = "//h4[text()='Extended Conditions']//following::div[@class='col-sm']//select[@class='form-control']//option"))
	private List<WebElement> list_timeUnit;
	
	@FindBy(xpath= "//h4[text()='Extended Conditions']//following::div[@class='col-sm']//select[@class='form-control']")
	private WebElement fld_timeUnit;
	
	@FindBys(value = @FindBy (xpath = "//select[contains(@class,'text-variable')]//option"))
	private List<WebElement> list_variable;
	
	@FindBy(xpath= "//select[contains(@class,'text-variable')]")
	private WebElement fld_variable;
	
	
	/* Methods */
	
	/**
	 * Input frequency
	 */
	public void inputFrequency(String frequency) {
		log.entry();
		if(driverHelper.isElementPresent(fld_frequency)) {
			driverHelper.clearText(fld_frequency);
			driverHelper.inputFieldValue(fld_frequency, frequency);
			driverHelper.embedScreenshot(scenario);
		} else {
			Assert.assertTrue("Frequency field is not present", driverHelper.isElementPresent(fld_frequency));
		}
		log.exit();
	}
	
	/**
	 * Input time value
	 */
	public void inputTimeValue(String timeValue) {
		log.entry();
		if(driverHelper.isElementPresent(fld_timeValue)) {
			driverHelper.clearText(fld_timeValue);
			driverHelper.inputFieldValue(fld_timeValue, timeValue);
			driverHelper.embedScreenshot(scenario);
		} else {
			Assert.assertTrue("Time value field is not present", driverHelper.isElementPresent(fld_timeValue));
		}
		log.exit();
	}
	
	/**
	 * Select time unit
	 */
	public void selectTimeUnit(String timeUnit) {
		log.entry();
		if(driverHelper.isElementPresent(fld_timeUnit)) {
			driverHelper.clickButton(fld_timeUnit);
			driverHelper.setValueDropdown(list_timeUnit, fld_timeUnit, timeUnit);
			driverHelper.embedScreenshot(scenario);
		} else {
			Assert.assertTrue("Time unit field is not present", driverHelper.isElementPresent(fld_timeUnit));
		}
		log.exit();
	}
	
	/**
	 * Select Variable
	 */
	public void selectVariable(String variable) {
		log.entry();
		variable = "${" + variable + "}";
		if(driverHelper.isElementPresent(fld_variable)) {
			driverHelper.clickButton(fld_variable);
			driverHelper.setValueDropdown(list_variable, fld_variable, variable);
			driverHelper.embedScreenshot(scenario);
		} else {
			Assert.assertTrue("Variable field is not present", driverHelper.isElementPresent(fld_variable));
		}
		log.exit();
	}

}
