package com.pageobjects;

import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
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
	
	@FindBy(xpath= "//h4[text()='Extended Conditions']//following::button[contains(text(), 'Add Rule')]")
	private WebElement btn_addExtendedRule;
	
	@FindBy(xpath= "//a[text()='Home']")
	private WebElement btn_Home;
	
	@FindBy(xpath="//span[text()='NEW']")
	private WebElement icn_new;
	
	@FindBy(xpath="//span[text()='EDIT']")
	private WebElement icn_edit;
	
	@FindBy(xpath= "//button[@title='Delete filter']")
	private WebElement btn_Delete;
	
	@FindBy(xpath= "//input[@class='form-check-input' and @checked]")
	private WebElement btn_enableDisableFilter;
	
	@FindBy(xpath= "//button[@title='Apply Templates']")
	private WebElement btn_applyTemplates;
	
	@FindBy(xpath= "//div[@role='combobox']//input")
	private WebElement fld_category;
	
	@FindBy(xpath= "//div[@role='combobox']//following::i[@class='dropdown icon']")
	private WebElement btn_category;
	
	
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
			Assert.assertTrue("Create New Filter Button is not present.", driverHelper.isElementPresent(btn_createNewFilter));
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
			Assert.assertTrue("Filter Name field is not present.", driverHelper.isElementPresent(fld_filterName));
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
			Assert.assertTrue("Source field is not present.", driverHelper.isElementPresent(fld_source));
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
			Assert.assertTrue("Owner Name field is not present.", driverHelper.isElementPresent(fld_ownerName));
			log.exit();
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
			Assert.assertTrue("Action field is not present.", driverHelper.isElementPresent(fld_action));
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
			Assert.assertTrue("Save Button is not present.", driverHelper.isElementPresent(btn_Save));
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
			Assert.assertTrue("Add Rule button in Extended Conditions is not present.", driverHelper.isElementPresent(btn_addExtendedRule));
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
			Assert.assertTrue("Home Button is not present.", driverHelper.isElementPresent(btn_Home));
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
			Assert.assertTrue("Delete Button is not present.", driverHelper.isElementPresent(btn_Delete));
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
	
	/**
	 * Click Apply Templates Button
	 */
	public void clickApplyTemplatesButton() {
		log.entry();
		if(driverHelper.isElementPresent(btn_applyTemplates)) {
			driverHelper.clickButton(btn_applyTemplates);
			log.exit();
		} else {
			Assert.assertTrue("Apply Templates Button is not present.", driverHelper.isElementPresent(btn_applyTemplates));
			log.exit();
		}
	}
	
	/**
	 * Verify if template is applied
	 */
	public void verifyIfTemplateIsApplied(String templateName, String versionNumber) {
		log.entry();
		By label_templateName_fieldConditions = By.xpath("//h4[text()='Filter Conditions']//following::label[text()='" + templateName + " [" + versionNumber + "]'][1]");
		By label_templateName_extConditions = By.xpath("//h4[text()='Extended Conditions']//following::label[text()='" + templateName + " [" + versionNumber + "]'][1]");
		By label_templateName_actions = By.xpath("//h4[text()='Actions']//following::label[text()='" + templateName + " [" + versionNumber + "]'][1]");
		
		Assert.assertTrue("Template is not applied to filter conditions", driverHelper.isElementPresent(label_templateName_fieldConditions));
		Assert.assertTrue("Template is not applied to extended conditions", driverHelper.isElementPresent(label_templateName_extConditions));
		Assert.assertTrue("Template is not applied to actions", driverHelper.isElementPresent(label_templateName_actions));
		
		driverHelper.embedScreenshot(scenario);
		log.exit();
	}
	
	/**
	 * Input Categories
	 */
	public void inputCategory(String categories) {
		log.entry();
		if(driverHelper.isElementPresent(fld_category)) {
			
			if(driverHelper.isElementPresent(btn_category)) {
				driverHelper.clickButton(btn_category);
			} else {
				Assert.assertTrue("Category field button is not present.", driverHelper.isElementPresent(btn_category));
				log.exit();
			}
			
			categories = categories.replaceAll("\\[|\\]|\\s", "");
			List<String> list_categories = Arrays.asList(categories.split(","));
			
			for (String category : list_categories) {
				driverHelper.inputFieldValue(fld_category, category);
				driverHelper.clickEnter(fld_category);
			}
			
			driverHelper.embedScreenshot(scenario);
			
		} else {
			Assert.assertTrue("Category field is not present.", driverHelper.isElementPresent(fld_category));
		}
		
		log.exit();
	}
	
	/**
	 * Click Delete Button of Categories
	 */
	public void removeCategory(String categories) {
		log.entry();
		categories = categories.replaceAll("\\[|\\]|\\s", "");
		List<String> list_categories = Arrays.asList(categories.split(","));
		
		for (String category : list_categories) {
			By btn_delete_category = By.xpath("//a[text()='" + category + "']//i");
			if(driverHelper.isElementPresent(btn_delete_category)) {
				driverHelper.clickButton(btn_delete_category);
				driverHelper.embedScreenshot(scenario);
			} else {
				Assert.assertTrue("Delete Button of Category is not present.", driverHelper.isElementPresent(btn_delete_category));
			}
		}
		log.exit();
	}
	
	/**
	 * Verify Categories
	 */
	public void verifyCategory(String categories) {
		log.entry();
		categories = categories.replaceAll("\\[|\\]|\\s", "");
		List<String> list_categories = Arrays.asList(categories.split(","));
		
		for (String category : list_categories) {
			By selected_category = By.xpath("//a[@value='" + category + "']");
			Assert.assertTrue("Category is not selected.", driverHelper.isElementPresent(selected_category));
		}
		log.exit();
	}
	
}
