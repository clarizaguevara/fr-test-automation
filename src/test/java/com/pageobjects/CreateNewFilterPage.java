package com.pageobjects;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class CreateNewFilterPage extends BasePage {

	private static final Logger log = LogManager.getLogger(CreateNewFilterPage.class);

	/* Page Elements */
	@FindBy(css= "div[class='filter-details']")
	private WebElement page_filter;
	
	@FindBy(xpath= "//button[contains (text(), ' Create New Filter')]")
	private WebElement btn_createNewFilter;
	
	@FindBy(xpath= "//input[@placeholder ='Filter name...']")
	private WebElement fld_filterName;
	
	@FindBy(xpath= "//div[@class='col-sm-3 input-group']//select[@class='form-control']")
	private WebElement fld_source;
	
	@FindBy(xpath= "//input[@value='AISM001']")
	private WebElement fld_ownerName;
	
	@FindBys(value = @FindBy (xpath = "//div[@class='col-sm-3 input-group']//select[@class='form-control']//option"))
	private List<WebElement> list_source;
	
	@FindBy(xpath= "//h4[contains(text(), 'Actions')]//following::div[@class='col-sm-4 py-0 px-1'][1]//select")
	private WebElement fld_action;
	
	@FindBys(value = @FindBy (xpath = "//h4[contains(text(), 'Actions')]//following::div[@class='col-sm-4 py-0 px-1'][1]//select//option"))
	private List<WebElement> list_action;
	
	@FindBy(xpath= "//div[@class='col-sm-auto text-right px-0']//button[@class='btn btn-primary pt-2']")
	private WebElement btn_Save;
	
	@FindBy(xpath= "//label[@class='label text-success mt-2']")
	private WebElement label_Save;
	
	@FindBy(xpath= "//label[@class='label text-secondary mt-2 font-italic']")
	private WebElement label_SaveUnsuccessful;
	
	@FindBy(xpath="//span[@class='loader']")
	private WebElement icn_loading;
	
	/* Methods */
	
	/**
	 * Navigate to Create New Filter Page
	 */
	public void verifySuccessfulNavigationToCreateNewFilterPage() {
		log.entry();
		driverHelper.embedScreenshot(scenario);
		Assert.assertTrue("Successful navigation in Command Center Create New Filter Page", driverHelper.isElementPresent(page_filter));
		log.exit();
	}
	
	/**
	 * Click Create New Filter Button
	 */
	public void clickCreateNewFilterButton() {
		log.entry();
		if(driverHelper.isElementPresent(btn_createNewFilter)) {
			driverHelper.embedScreenshot(scenario);
			driverHelper.clickButton(btn_createNewFilter);
			log.exit();
		} else {
			System.out.println("Home Button is not present.");
			log.exit();
		}
	}
	
	/**
	 *Input Filter Name
	 */
	public void inputFilterName(String filterName) {
		log.entry();
		if(driverHelper.isElementPresent(fld_filterName)) {
			driverHelper.inputFieldValue(fld_filterName, filterName);
			driverHelper.embedScreenshot(scenario);
			log.exit();
		} else {
			System.out.println("Filter Name field is not present.");
			log.exit();
		}
	}
	
	/**
	 * Select Source
	 */
	public void selectSource(String source) {
		log.entry();
		if(driverHelper.isElementPresent(fld_source)) {
			driverHelper.clickButton(fld_source);
			driverHelper.setValueDropdown(list_source, fld_source, source);
			driverHelper.embedScreenshot(scenario);
			log.exit();
		} else {
			System.out.println("Source field is not present.");
			log.exit();
		}
	}
	
	/**
	 * Input owner name
	 */
	public void inputOwnerName(String ownerName) {
		log.entry();
		if(driverHelper.isElementPresent(fld_ownerName)) {
			fld_ownerName.clear();
			driverHelper.inputFieldValue(fld_ownerName, ownerName);
			driverHelper.embedScreenshot(scenario);
			log.exit();
		} else {
			System.out.println("Owner Name field is not present.");
		}
	}
	
	/**
	 * Select Action
	 */
	public void selectAction(String action) {
		log.entry();
		if(driverHelper.isElementPresent(fld_action)) {
			driverHelper.scrollIntoView(fld_action);
			driverHelper.clickButton(fld_action);
			driverHelper.setValueDropdown(list_action, fld_action, action);
			driverHelper.embedScreenshot(scenario);
			driverHelper.waitForElementNotVisible(icn_loading);
			log.exit();
		} else {
			System.out.println("Action field is not present.");
			log.exit();
		}
	}
	
	/**
	 * Click Save Button
	 */
	public void clickSaveButton() {
		log.entry();
		if(driverHelper.isElementPresent(btn_Save)) {
			driverHelper.clickButton(btn_Save);
			log.exit();
		} else {
			System.out.println("Save button is not present.");
			log.exit();
		}
	}
	
	/**
	 * Verify Filter is successfully saved
	 */
	public void verifyFilterSuccessfullySaved() {
		log.entry();
		driverHelper.waitForElementNotVisible(icn_loading);
		Assert.assertTrue("Filter is NOT Successfully saved.", driverHelper.isElementPresent(label_Save));
		log.exit();
	}
	
	/**
	 * Verify Filter is NOT successfully saved
	 */
	public void verifyFilterisNOTSuccessfullySaved() {
		log.entry();
		driverHelper.waitForElementNotVisible(icn_loading);
		Assert.assertTrue("Filter is Successfully saved.", driverHelper.isElementPresent(label_SaveUnsuccessful));
		log.exit();
	}
}
