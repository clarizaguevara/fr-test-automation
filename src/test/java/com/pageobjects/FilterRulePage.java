package com.pageobjects;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class FilterRulePage extends BasePage {

	private static final Logger log = LogManager.getLogger(FilterRulePage.class);

	/* Page Elements */
	@FindBy(css= "div[class='filter-details']")
	private WebElement page_filter;
	
	@FindBys(value = @FindBy (xpath = "//div[@class='col-sm-auto px-1'][1]//select[@class='form-control']//option"))
	private List<WebElement> list_keyword;
	
	@FindBy(xpath= "//div[@class='col-sm-auto px-1'][1]")
	private WebElement fld_keyword;
	
	@FindBys(value = @FindBy (xpath = "//div[@class='col-sm-auto px-1'][3]//select[@class='form-control']//option"))
	private List<WebElement> list_comparator;
	
	@FindBy(xpath= "//div[@class='col-sm-auto px-1'][3]")
	private WebElement fld_comparator;
	
	@FindBy(xpath= "//div[@class='col-sm']//input[not(contains(@class, 'form-control block borderless-input'))]")
	private WebElement fld_keywordvalue;
	
	@FindBy(xpath= "//div[contains(@class, 'btn-group-toggle')]")
	private WebElement btn_NOT;
	
	/* Methods */
	
	/**
	 * Select Keyword
	 */
	public void selectKeyword(String keyword) {
		log.entry();
		if(driverHelper.isElementPresent(fld_keyword)) {
			driverHelper.clickButton(fld_keyword);
			driverHelper.setValueDropdown(list_keyword, fld_keyword, keyword);
			driverHelper.embedScreenshot(scenario);
			log.exit();
		} else {
			System.out.println("Keyword field is not present.");
			log.exit();
		}
	}
	
	/**
	 * Select Comparator
	 */
	public void selectComparator(String comparator) {
		log.entry();
		if(driverHelper.isElementPresent(fld_comparator)) {
			driverHelper.clickButton(fld_comparator);
			driverHelper.setValueDropdown(list_comparator, fld_comparator, comparator);
			driverHelper.embedScreenshot(scenario);
			log.exit();
		} else {
			System.out.println("Keyword field is not present.");
			log.exit();
		}
	}
	
	/**
	 *Input Keyword Value
	 */
	public void inputKeywordValue(String keywordValue) {
		log.entry();
		if(driverHelper.isElementPresent(fld_keywordvalue)) {
			driverHelper.inputFieldValue(fld_keywordvalue, keywordValue);
			driverHelper.embedScreenshot(scenario);
			log.exit();
		} else {
			System.out.println("Keyword Value field is not present.");
			log.exit();
		}
	}
	
	/**
	 * Enable NOT button
	 */
	public void enableNOTButton() {
		log.entry();
		if(driverHelper.isElementPresent(btn_NOT)) {
			driverHelper.clickButton(btn_NOT);
			log.exit();
		} else {
			System.out.println("NOT button is not present.");
			log.exit();
		}
	}
	
	/**
	 * Get Keyword
	 */
	public String getKeyword() {
		log.entry();
		String keyword = fld_keyword.getAttribute("value");
		log.exit();
		return keyword;
	}
	
	/**
	 * Get Comparator
	 */
	public String getComparator() {
		log.entry();
		String comparator = fld_comparator.getAttribute("value");
		log.exit();
		return comparator;
	}
	
	/**
	 * Get Keyword value
	 */
	public String getKeywordValue() {
		log.entry();
		String keywordValue = fld_keywordvalue.getAttribute("value");
		log.exit();
		return keywordValue;
	}
}
