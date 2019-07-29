package com.pageobjects;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.Arrays;

public class FilterRulePage extends BasePage {

	private static final Logger log = LogManager.getLogger(FilterRulePage.class);

	
	/* Page Elements */
	
	@FindBy(css= "div[class='filter-details']")
	private WebElement page_filter;
	
	@FindBys(value = @FindBy (xpath = "//div[@class='col-sm-auto px-2']//select[@class='form-control']//option"))
	private List<WebElement> list_keyword;
	
	@FindBy(xpath= "//div[@class='col-sm-auto px-2']//select")
	private WebElement fld_keyword;
	
	@FindBys(value = @FindBy (xpath = "//div[@class='col-sm-auto px-1'][2]//select[@class='form-control']//option"))
	private List<WebElement> list_comparator;
	
	@FindBy(xpath= "//div[@class='col-sm-auto px-1'][2]//select")
	private WebElement fld_comparator;
	
	@FindBy(xpath= "//div[@class='col-sm']//input[not(contains(@class, 'form-control block borderless-input'))]")
	private WebElement fld_keywordvalue;
	
	@FindBy(xpath= "//label[@class='btn w-100' and text()='NOT']")
	private WebElement btn_NOT;
	
	@FindBys(value = @FindBy (xpath = "//div[@class='col-sm-auto px-1']//select[@class='form-control w-auto']//option"))
	private List<WebElement> list_keywordValue;
	
	@FindBy(xpath= "//div[@class='col-sm-auto px-1']//select[@class='form-control w-auto']")
	private WebElement fld_keywordvaluedropdown;
	
	@FindBy(xpath= "//button[contains(@class,'add-condition-button')]")
	private WebElement btn_addGroup;
	
	
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
			driverHelper.clearText(fld_keywordvalue);
			driverHelper.inputFieldValue(fld_keywordvalue, keywordValue);
			driverHelper.embedScreenshot(scenario);
			log.exit();
		} else {
			System.out.println("Keyword Value field is not present.");
			log.exit();
		}
	}
	
	/**
	 * Click NOT Button
	 * Accepts "enabled" if button is to enable. Else, "disabled"
	 */
	public void clickNOTButton(String btnState) {
		log.entry();
		if(btnState.equals("enabled")) {
			if(driverHelper.isElementPresent(btn_NOT)) {
    			driverHelper.clickButton(btn_NOT);
    		}
		} else {
			if(!driverHelper.isElementPresent(btn_NOT)) {
    			driverHelper.clickButton(btn_NOT);
    		}
		}
		log.exit();
	}
	
	/**
	 * Check Keyword Value
	 */
	public void checkKeywordValue(String keywordValue) {
		log.entry();
		Assert.assertTrue("Values are not the same", (fld_keywordvalue.getAttribute("value")).equals(keywordValue));
		log.exit();
	}
	
	/**
	 * Verify keyword dropdown for source
	 */
	public void verifyKeywordDropdownValues(String dropdownValues) {
		log.entry();
		List<String> keywordDropdownValues = Arrays.asList(dropdownValues.split(","));
		for (WebElement webElement : list_keyword) {
			String dropdownValue = webElement.getText();
			//log.info(keywordDropdownValues.size() + " " + list_keyword.size());
			Assert.assertTrue("Keyword dropdown value is incorrect", dropdownValues.contains(dropdownValue));
			Assert.assertTrue("Number of values is incorrect", keywordDropdownValues.size() == list_keyword.size()); 
		}
		log.exit();
	}
	

	/**
	 *Input Keyword Value
	 */
	public void selectKeywordValue(String keywordValue) {
		log.entry();
		if(driverHelper.isElementPresent(fld_keywordvaluedropdown)) {
			driverHelper.clickButton(fld_keywordvaluedropdown);
			driverHelper.setValueDropdown(list_keywordValue, fld_keywordvaluedropdown, keywordValue);
			driverHelper.embedScreenshot(scenario);
			log.exit();
		} else {
			System.out.println("Keyword Value field is not present.");
			log.exit();
		}
	}
	
	/**
	 * Click Add Rule Button (for AND/OR)
	 */
	private void clickAddRuleButton(String groupNumber, String ruleNumber) {
		log.entry();
		By btn_AddRule = By.xpath("//div[contains(@class,'condition-group')][" + groupNumber + "]//button[contains(text(),'Add Rule')]");
		if(driverHelper.isElementPresent(btn_AddRule)) {
			driverHelper.clickButton(btn_AddRule);
			log.exit();
		} else {
			System.out.println("Add Rule Button is not present.");
			log.exit();
		}
	}
	
	/**
	 * Click Add Group Button
	 */
	public void clickAddGroupButton() {
		log.entry();
		if(driverHelper.isElementPresent(btn_addGroup)) {
			driverHelper.clickButton(btn_addGroup);
			log.exit();
		} else {
			System.out.println("Add Group Button is not present.");
			log.exit();
		}
	}
	
	/**
	 * Click AND/OR Rule Button
	 * 
	 */
	private void clickANDORRuleButton(String groupNumber, String ruleNumber, String condition) {
		log.entry();
		By btn_ANDORrule = By.xpath("//div[contains(@class,'condition-group')][" + groupNumber + "]//div[contains(@class,'justify-content-start')][" + ruleNumber + "]//label[text()='" + condition + "']");
		if(driverHelper.isElementPresent(btn_ANDORrule)) {
			driverHelper.clickButton(btn_ANDORrule);
    	}
		log.exit();
	}
	
	/**
	 * Select Keyword (for AND/OR)
	 */
	private void selectKeyword(String keyword, String groupNumber, String ruleNumber) {
		log.entry();
		By fld_keyword = By.xpath("//div[contains(@class,'condition-group')][" + groupNumber + "]//div[contains(@class,'justify-content-start')][" + ruleNumber + "]//div[@class='col-sm-auto px-1'][1]");
		By list_keyword = By.xpath("//div[contains(@class,'condition-group')][" + groupNumber + "]//div[contains(@class,'justify-content-start')][" + ruleNumber + "]//div[@class='col-sm-auto px-1'][1]//option");
		if(driverHelper.isElementPresent(fld_keyword)) {
			driverHelper.clickButton(fld_keyword);
			driverHelper.setValueDropdown(driver.findElements(list_keyword), driver.findElement(fld_keyword), keyword);
			driverHelper.embedScreenshot(scenario);
			log.exit();
		} else {
			System.out.println("Keyword field is not present.");
			log.exit();
		}
	}
	
	/**
	 * Select Comparator (for AND/OR)
	 */
	private void selectComparator(String comparator, String groupNumber, String ruleNumber) {
		log.entry();
		By fld_comparator = By.xpath("//div[contains(@class,'condition-group')][" + groupNumber + "]//div[contains(@class,'justify-content-start')][" + ruleNumber + "]//div[@class='col-sm-auto px-1'][3]//select");
		By list_comparator = By.xpath("//div[contains(@class,'condition-group')][" + groupNumber + "]//div[contains(@class,'justify-content-start')][" + ruleNumber + "]//div[@class='col-sm-auto px-1'][3]//select//option");
		if(driverHelper.isElementPresent(fld_comparator)) {
			driverHelper.clickButton(fld_comparator);
			driverHelper.setValueDropdown(driver.findElements(list_comparator), driver.findElement(fld_comparator), comparator);
			driverHelper.embedScreenshot(scenario);
			log.exit();
		} else {
			System.out.println("Comparator field is not present.");
			log.exit();
		}
	}
	
	/**
	 *Input Keyword Value (for AND/OR)
	 */
	private void inputKeywordValue(String keywordValue, String groupNumber, String ruleNumber) {
		log.entry();
		By fld_keywordValue = By.xpath("//div[contains(@class,'condition-group')][" + groupNumber + "]//div[contains(@class,'justify-content-start')][" + ruleNumber + "]//div[@class='col-sm']//input[not(contains(@class, 'form-control block borderless-input'))]");
		if(driverHelper.isElementPresent(fld_keywordValue)) {
			driverHelper.clearText(fld_keywordValue);
			driverHelper.inputFieldValue(driver.findElement(fld_keywordValue), keywordValue);
			driverHelper.embedScreenshot(scenario);
			log.exit();
		} else {
			System.out.println("Keyword Value field is not present.");
			log.exit();
		}
	}
	
	/**
	 * Click NOT Button (for AND/OR)
	 * Accepts "enabled" if button is to enable. Else, "disabled"
	 */
	private void clickNOTButton(String btnState, String groupNumber, String ruleNumber) {
		log.entry();
		By btn_NOT = By.xpath("//div[contains(@class,'condition-group')][" + groupNumber + "]//div[contains(@class,'justify-content-start')][" + ruleNumber + "]//label[@class='btn w-100' and text()='NOT']");
		if(btnState.equals("enabled")) {
			if(driverHelper.isElementPresent(btn_NOT)) {
    			driverHelper.clickButton(btn_NOT);
    		}
		} else {
			if(!driverHelper.isElementPresent(btn_NOT)) {
    			driverHelper.clickButton(btn_NOT);
    		}
		}
		log.exit();
	}
	
	/**
	 * Click AND/OR Group Button
	 * 
	 */
	public void clickANDORGroupButton(String groupNumber, String condition) {
		log.entry();
		By btn_ANDORGroup = By.xpath("//div[contains(@class,'condition-group')][" + groupNumber + "]//label[contains(@class,'justify-content-center')]//span[text()='and']");
		if(condition.equals("AND")) {
			if(!driverHelper.isElementPresent(btn_ANDORGroup)) {
    			driverHelper.clickButton(btn_ANDORGroup);
    		}
		} else {
			//OR
			if(driverHelper.isElementPresent(btn_ANDORGroup)) {
    			driverHelper.clickButton(btn_ANDORGroup);
    		}
		}
		log.exit();
	}
	
	/**
	 * Select Rules by Group (AND/OR)
	 */
	public void selectRulesByGroup(String groupNumber, String rules) {
		log.entry();
		int ruleNumber = 1;
		List<String> splittedRules = Arrays.asList(rules.split(" "));
		for (String ruleEntry : splittedRules) {
			ruleEntry = ruleEntry.replace("_", " ");
			if(ruleEntry.equals("AND") || ruleEntry.equals("OR")) {
				//click Add Rule button
				clickAddRuleButton(groupNumber, String.valueOf(ruleNumber));
				//click AND/OR rule button
				clickANDORRuleButton(groupNumber, String.valueOf(ruleNumber), ruleEntry.toLowerCase());
				//indicating next rule
				++ruleNumber;
			} else {
				//keyword-comparator-keywordvalue or keyword-NOT-comparator-keywordvalue
				List<String> conditions = Arrays.asList(ruleEntry.split("-"));
				if(conditions.contains("NOT")) {
					selectKeyword(conditions.get(0), groupNumber, String.valueOf(ruleNumber));
					clickNOTButton("enabled", groupNumber, String.valueOf(ruleNumber));
					selectComparator(conditions.get(2), groupNumber, String.valueOf(ruleNumber));
					inputKeywordValue(conditions.get(3), groupNumber, String.valueOf(ruleNumber));
				} else {
					selectKeyword(conditions.get(0), groupNumber, String.valueOf(ruleNumber));
					selectComparator(conditions.get(1), groupNumber, String.valueOf(ruleNumber));
					inputKeywordValue(conditions.get(2), groupNumber, String.valueOf(ruleNumber));
				}
				driverHelper.embedScreenshot(scenario);
			}
		}
		log.exit();
	}
	
	/**
	 * Verify comparator dropdown values
	 */
	public void verifyComparatorDropdownValues(String dropdownValues) {
		log.entry();
		List<String> comparatorDropdownValues = Arrays.asList(dropdownValues.split(","));
		for (WebElement webElement : list_comparator) {
			String dropdownValue = webElement.getText();
			Assert.assertTrue("Comparator dropdown value is incorrect", dropdownValues.contains(dropdownValue));
			Assert.assertTrue("Number of values is incorrect", comparatorDropdownValues.size() == list_comparator.size()); 
		}
		log.exit();
	}
	
}
