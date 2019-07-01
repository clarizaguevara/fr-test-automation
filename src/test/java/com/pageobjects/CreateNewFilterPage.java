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
	
	@FindBy(xpath= "//button[@type='button']//i[@class='fa fa-save']")
	private WebElement btn_Save;
	
	@FindBy(xpath= "//label[@class='label text-success mt-2']")
	private WebElement label_Save;
	
	@FindBy(xpath= "//label[@class='label text-secondary mt-2 font-italic']")
	private WebElement label_SaveUnsuccessful;
	
	@FindBy(xpath="//span[@class='loader']")
	private WebElement icn_loading;
	
	@FindBy(xpath= "//h4[text()='Extended Rules']//following::button[contains(text(), 'Add Rule')]")
	private WebElement btn_addExtendedRule;
	
	@FindBy(xpath= "//a[text()='Home']")
	private WebElement btn_Home;
	
	@FindBy(xpath="//span[text()='NEW']")
	private WebElement icn_new;
	
	@FindBy(xpath="//span[text()='EDIT']")
	private WebElement icn_edit;
	
	@FindBy(xpath= "//button[@title='Delete filter']")
	private WebElement btn_Delete;
	
	@FindBy(xpath= "//input[@id='filterEnableDisable' and @checked]")
	private WebElement btn_enableDisableFilter;
	
	
	/* Methods */
	
	/**
	 * Navigate to Create New Filter Page
	 */
	public void verifySuccessfulNavigationToCreateNewFilterPage() {
		log.entry();
		Assert.assertTrue("Unsuccessful navigation to Command Center Create New Filter Page", driverHelper.isElementPresent(page_filter));
		Assert.assertTrue("Unsuccessful navigation to Command Center Create New Filter Page", driverHelper.isElementPresent(icn_new));
		driverHelper.embedScreenshot(scenario);
		log.exit();
	}
	
	/**
	 * Click Create New Filter Button
	 */
	public void clickCreateNewFilterButton() {
		log.entry();
		if(driverHelper.isElementPresent(btn_createNewFilter)) {
			driverHelper.clickButton(btn_createNewFilter);
			log.exit();
		} else {
			System.out.println("Create New Filter Button is not present.");
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
			driverHelper.clearText(fld_ownerName);
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
		//Assert.assertTrue("Unsuccessful navigation to Command Center Edit Filter Page", driverHelper.isElementPresent(icn_edit));
		driverHelper.embedScreenshot(scenario);
		log.exit();
	}
	
	/**
	 * Verify Filter is NOT successfully saved
	 */
	public void verifyFilterisNOTSuccessfullySaved() {
		log.entry();
		driverHelper.waitForElementNotVisible(icn_loading);
		Assert.assertTrue("Filter is Successfully saved.", driverHelper.isElementNotPresent(label_Save));
		driverHelper.embedScreenshot(scenario);
		log.exit();
	}
	
	/**
	 * Click Add Rule button (in Extended Rule)
	 */
	public void addExtendedRule() {
		log.entry();
		if(driverHelper.isElementPresent(btn_addExtendedRule)) {
			driverHelper.clickButton(btn_addExtendedRule);
			driverHelper.embedScreenshot(scenario);
			log.exit();
		} else {
			System.out.println("Add Rule button in Extended Rules is not present.");
			log.exit();
		}
	}
	
	/**
	 * Click Home Button
	 */
	public void clickHomeButton() {
		log.entry();
		if(driverHelper.isElementPresent(btn_Home)) {
			driverHelper.clickButton(btn_Home);
			driverHelper.explicitWait();
			log.exit();
		} else {
			System.out.println("Home Button is not present.");
			log.exit();
		}
	}
	
	/**
	 * Verify if Create New Filter page is for Edit Filter
	 */
	public void verifySuccessfulNavigationToEditFilterPage() {
		log.entry();
		driverHelper.waitForElementVisible(fld_action);
		Assert.assertTrue("Unsuccessful navigation to Command Center Edit Filter Page", driverHelper.isElementPresent(icn_edit));
		driverHelper.embedScreenshot(scenario);
		log.exit();
	}
	
	/**
	 * Check Filter Name
	 */
	public void checkFilterName(String filterName) {
		log.entry();
		Assert.assertTrue("Values are not the same", (fld_filterName.getAttribute("value")).equals(filterName));
		log.exit();
	}
	
	/**
	 * Click Delete Button
	 */
	public void clickDeleteButton() {
		log.entry();
		if(driverHelper.isElementPresent(btn_Delete)) {
			driverHelper.clickButton(btn_Delete);
			log.exit();
		} else {
			System.out.println("Delete Button is not present.");
			log.exit();
		}
	}
	
	/**
	 * Enable/Disable filter
	 * Accepts "enabled" if filter is to enable. Else, "disabled"
	 */
	public void enableOrDisableFilter(String filterState) {
		log.entry();
		if(filterState.equals("enabled")) {
			if(!driverHelper.isElementPresent(btn_enableDisableFilter)) {
    			driverHelper.clickButton(btn_enableDisableFilter);
    		}
		} else {
			if(driverHelper.isElementPresent(btn_enableDisableFilter)) {
    			driverHelper.clickButton(btn_enableDisableFilter);
    		}
		}
		log.exit();
	}
	
}
