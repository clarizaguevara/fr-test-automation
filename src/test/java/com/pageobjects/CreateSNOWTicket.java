package com.pageobjects;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class CreateSNOWTicket extends BasePage {

	private static final Logger log = LogManager.getLogger(CreateSNOWTicket.class);
	
	/* Page Elements */
	@FindBys(value = @FindBy (xpath = "//label[contains(text(), 'Project:')]//following::div[@class='col-sm-9'][1]//select//option"))
	private List<WebElement> list_project;
	
	@FindBy (xpath ="//label[contains(text(), 'Impacted User')]//following::div[@class='css-rsyb7x'][1]//input[@id='react-select-4-input']")
	private WebElement fld_impactedUsers;
	
	@FindBy (xpath ="//label[contains(text(), 'Impacted User')]//following::div[@class='css-rsyb7x'][1]//input//following::div[@class='css-1n9lbrx'][1]")
	private WebElement fld_impactedUsersOptions;
	
	@FindBy (xpath ="//label[contains(text(), 'Assignment group')]//following::div[@class='css-rsyb7x'][1]//input[@id='react-select-6-input']")
	private WebElement fld_assignmentGroup;
	
	@FindBy (xpath ="//label[contains(text(), 'Assignment group')]//following::div[@class='css-rsyb7x'][1]//input//following::div[@class='css-1n9lbrx'][1]")
	private WebElement fld_assignmentGroupOptions;
	
	@FindBy (xpath ="//label[contains(text(), 'Assigned to')]//following::div[@class='css-rsyb7x'][1]//input[@id='react-select-8-input']")
	private WebElement fld_assignedTo;
	
	@FindBy (xpath ="//label[contains(text(), 'Assigned to')]//following::div[@class='css-rsyb7x'][1]//input//following::div[@class='css-1n9lbrx'][1]")
	private WebElement fld_assignedToOptions;
	
	@FindBy (xpath ="//label[contains(text(), 'Category')]//following::div[@class='css-rsyb7x'][1]//input[@id='react-select-3-input']")
	private WebElement fld_category;
	
	@FindBy (xpath ="//label[contains(text(), 'Category')]//following::div[@class='css-rsyb7x'][1]//input//following::div[@class='css-1n9lbrx'][1]")
	private WebElement fld_categoryOptions;
	
	@FindBy (xpath ="//label[contains(text(), 'Sub-category')]//following::div[@class='css-rsyb7x'][1]//input[@id='react-select-5-input']")
	private WebElement fld_subCategory;
	
	@FindBy (xpath ="//label[contains(text(), 'Sub-category')]//following::div[@class='css-rsyb7x'][1]//input//following::div[@class='css-1n9lbrx'][1]")
	private WebElement fld_subCategoryOptions;
	
	@FindBy (xpath ="//label[contains(text(), 'Area')]//following::div[@class='css-rsyb7x'][1]//input[@id='react-select-7-input']")
	private WebElement fld_area;
	
	@FindBy (xpath ="//label[contains(text(), 'Area')]//following::div[@class='css-rsyb7x'][1]//input//following::div[@class='css-1n9lbrx'][1]")
	private WebElement fld_areaOptions;
	
	@FindBy (xpath ="//label[contains(text(), 'Ticket Type')]//following::div[@class='col-sm-4'][1]//select")
	private WebElement fld_ticketType;
	
	@FindBy (xpath ="//label[contains(text(), 'Language')]//following::div[@class='css-rsyb7x'][1]//input[@id='react-select-2-input']")
	private WebElement fld_language;
	
	@FindBy (xpath ="//label[contains(text(), 'Contact Type')]//following::div[@class='col-sm-4'][1]//select")
	private WebElement fld_contactType;
	
	@FindBy (xpath ="//label[contains(text(), 'Impact')]//following::div[@class='col-sm-4'][1]//select")
	private WebElement fld_impact;
	
	@FindBy (xpath ="//label[contains(text(), 'Urgency')]//following::div[@class='col-sm-4'][1]//select")
	private WebElement fld_urgency;
	
	@FindBy (xpath ="//label[contains(text(), 'Priority')]//following::div[@class='col-sm-4'][1]//select")
	private WebElement fld_priority;
	
	@FindBy (xpath ="//label[contains(text(), 'Description')]//following::div[@class='col-sm'][2]//textarea")
	private WebElement fld_description;
	
	@FindBy (xpath ="//label[contains(text(), 'Short Description')]//following::div[@class='col-sm'][1]//input")
	private WebElement fld_shortDescription;
	
	@FindBy(xpath= "//div[@class='col-sm-4 offset-sm-2 pt-2']//div[@class='form-check']//input[@type='checkbox']")
	private WebElement btn_pendingLevel;
	
	@FindBy(xpath= "//div[@class='col-sm-auto offset-sm-2']//div[@class='form-check']//input[@type='checkbox']")
	private WebElement btn_automaticallyClosedTicket;
	
	/* Methods */
	/**
	 * Set Impacted Users
	 */
	public void setImpactedUsers(String impactedUsers) {
		log.entry();
		driverHelper.waitForPageLoaded();
		driver.switchTo().defaultContent();
		if(driverHelper.isElementPresent(fld_impactedUsers)) {
			driverHelper.clickButton(fld_impactedUsers);
			driverHelper.inputFieldValue(fld_impactedUsers, impactedUsers);
			driverHelper.waitForElementVisible(fld_impactedUsersOptions);
			driverHelper.explicitWaitSNOW();
			driverHelper.clickEnter(fld_impactedUsers);
			driverHelper.embedScreenshot(scenario);
			log.exit();
		} else {
			System.out.println("Impacted User field is not present.");
			log.exit();
		}
	}
	
	/**
	 * Set Assignment Group
	 */
	public void setAssignmentGroup(String assignmentGroup) {
		log.entry();
		driverHelper.waitForPageLoaded();
		driver.switchTo().defaultContent();
		if(driverHelper.isElementPresent(fld_assignmentGroup)) {
			driverHelper.clickButton(fld_assignmentGroup);
			driverHelper.inputFieldValue(fld_assignmentGroup, assignmentGroup);
			driverHelper.waitForElementVisible(fld_assignmentGroupOptions);
			driverHelper.explicitWaitSNOW();
			driverHelper.clickEnter(fld_assignmentGroup);
			driverHelper.embedScreenshot(scenario);
			log.exit();
		} else {
			System.out.println("Assignment Group field is not present.");
			log.exit();
		}
	}
	
	/**
	 * Set Assigned To
	 */
	public void setAssignedTo(String assignedTo) {
		log.entry();
		driverHelper.waitForPageLoaded();
		driver.switchTo().defaultContent();
		if(driverHelper.isElementPresent(fld_assignedTo)) {
			driverHelper.clickButton(fld_assignedTo);
			driverHelper.inputFieldValue(fld_assignedTo, assignedTo);
			driverHelper.waitForElementVisible(fld_assignedToOptions);
			driverHelper.explicitWaitSNOW();
			driverHelper.clickEnter(fld_assignedTo);
			driverHelper.embedScreenshot(scenario);
			log.exit();
		} else {
			System.out.println("Assigned To field is not present.");
			log.exit();
		}
	}
	
	/**
	 * Set Category
	 */
	public void setCategory(String category) {
		log.entry();
		driverHelper.waitForPageLoaded();
		driver.switchTo().defaultContent();
		if(driverHelper.isElementPresent(fld_category)) {
			driverHelper.clickButton(fld_category);
			driverHelper.inputFieldValue(fld_category, category);
			driverHelper.waitForElementVisible(fld_categoryOptions);
			driverHelper.explicitWaitSNOW();
			driverHelper.clickEnter(fld_category);
			driverHelper.embedScreenshot(scenario);
			log.exit();
		} else {
			System.out.println("Category field is not present.");
			log.exit();
		}
	}
	
	/**
	 * Set SubCategory
	 */
	public void setSubCategory(String subCategory) {
		log.entry();
		driverHelper.waitForPageLoaded();
		driver.switchTo().defaultContent();
		if(driverHelper.isElementPresent(fld_subCategory)) {
			driverHelper.clickButton(fld_subCategory);
			driverHelper.inputFieldValue(fld_subCategory, subCategory);
			driverHelper.waitForElementVisible(fld_subCategoryOptions);
			driverHelper.explicitWaitSNOW();
			driverHelper.clickEnter(fld_subCategory);
			driverHelper.embedScreenshot(scenario);
			log.exit();
		} else {
			System.out.println("Sub-Category field is not present.");
			log.exit();
		}
	}
	
	/**
	 * Set Area
	 */
	public void setArea(String area) {
		log.entry();
		driverHelper.waitForPageLoaded();
		driver.switchTo().defaultContent();
		if(driverHelper.isElementPresent(fld_area)) {
			driverHelper.clickButton(fld_area);
			driverHelper.inputFieldValue(fld_area, area);
			driverHelper.waitForElementVisible(fld_areaOptions);
			driverHelper.explicitWaitSNOW();
			driverHelper.clickEnter(fld_area);
			driverHelper.embedScreenshot(scenario);
			log.exit();
		} else {
			System.out.println("Area field is not present.");
			log.exit();
		}
	}
	
	/**
	 * Select Ticket Type
	 */
	public void selectTicketType(String ticketType) {
		log.entry();
		driverHelper.waitForPageLoaded();
		driver.switchTo().defaultContent();
		if(driverHelper.isElementPresent(fld_ticketType)) {
			driverHelper.clickButton(fld_ticketType);
			driverHelper.inputFieldValue(fld_ticketType, ticketType);
			driverHelper.explicitWaitSNOW();
			driverHelper.clickEnter(fld_ticketType);
			driverHelper.embedScreenshot(scenario);
			log.exit();
		} else {
			System.out.println("Ticket Type field is not present.");
			log.exit();
		}
	}
	
	/**
	 * Select Preferred Support Language
	 */
	public void selectLanguage(String language) {
		log.entry();
		driverHelper.waitForPageLoaded();
		driver.switchTo().defaultContent();
		if(driverHelper.isElementPresent(fld_language)) {
			driverHelper.clickButton(fld_language);
			driverHelper.inputFieldValue(fld_language, language);
			driverHelper.clickEnter(fld_language);
			driverHelper.explicitWaitSNOW();
			driverHelper.embedScreenshot(scenario);
			log.exit();
		} else {
			System.out.println("Language field is not present.");
			log.exit();
		}
	}
	
	/**
	 * Select Contact Type
	 */
	public void selectContactType(String contactType) {
		log.entry();
		driver.switchTo().defaultContent();
		if(driverHelper.isElementPresent(fld_contactType)) {
			driverHelper.clickButton(fld_contactType);
			driverHelper.inputFieldValue(fld_contactType, contactType);
			driverHelper.clickEnter(fld_contactType);
			driverHelper.explicitWaitSNOW();
			driverHelper.embedScreenshot(scenario);
			log.exit();
		} else {
			System.out.println("Contact Type field is not present.");
			log.exit();
		}
	}
	
	/**
	 * Select Impact
	 */
	public void selectImpact(String impact) {
		log.entry();
		driver.switchTo().defaultContent();
		if(driverHelper.isElementPresent(fld_impact)) {
			driverHelper.clickButton(fld_impact);
			driverHelper.inputFieldValue(fld_impact, impact);
			driverHelper.clickEnter(fld_impact);
			driverHelper.explicitWaitSNOW();
			driverHelper.embedScreenshot(scenario);
			log.exit();
		} else {
			System.out.println("Impact field is not present.");
			log.exit();
		}
	}
	
	/**
	 * Select Urgency
	 */
	public void selectUrgency(String urgency) {
		log.entry();
		driver.switchTo().defaultContent();
		if(driverHelper.isElementPresent(fld_urgency)) {
			driverHelper.clickButton(fld_urgency);
			driverHelper.inputFieldValue(fld_urgency, urgency);
			driverHelper.clickEnter(fld_urgency);
			driverHelper.explicitWaitSNOW();
			driverHelper.embedScreenshot(scenario);
			log.exit();
		} else {
			System.out.println("Urgency field is not present.");
			log.exit();
		}
	}
	
	/**
	 * Select Priority
	 */
	public void selectPriority(String priority) {
		log.entry();
		driver.switchTo().defaultContent();
		if(driverHelper.isElementPresent(fld_priority)) {
			driverHelper.clickButton(fld_priority);
			driverHelper.inputFieldValue(fld_priority, priority);
			driverHelper.clickEnter(fld_priority);
			driverHelper.explicitWaitSNOW();
			driverHelper.embedScreenshot(scenario);
			log.exit();
		} else {
			System.out.println("Priority field is not present.");
			log.exit();
		}
	}
	
	/**
	 *Input Description
	 */
	public void inputDescription(String description) {
		log.entry();
		driverHelper.waitForPageLoaded();
		if(driverHelper.isElementPresent(fld_description)) {
			driverHelper.inputFieldValue(fld_description, description);
			driverHelper.embedScreenshot(scenario);
			log.exit();
		} else {
			System.out.println("Description field is not present.");
			log.exit();
		}
	}
	
	/**
	 *Input Short Description
	 */
	public void inputShortDescription(String shortDescription) {
		log.entry();
		driverHelper.waitForPageLoaded();
		if(driverHelper.isElementPresent(fld_shortDescription)) {
			driverHelper.inputFieldValue(fld_shortDescription, shortDescription);
			driverHelper.embedScreenshot(scenario);
			log.exit();
		} else {
			System.out.println("Short Description field is not present.");
			log.exit();
		}
	}
	
	/**
	 * Check Pending Level 1
	 */
	public void checkPendingLevel() {
		log.entry();
		driverHelper.waitForPageLoaded();
		driver.switchTo().defaultContent();
		if(driverHelper.isElementPresent(btn_pendingLevel)) {
			driverHelper.clickButton(btn_pendingLevel);
			driverHelper.embedScreenshot(scenario);
			log.exit();
		} else {
			System.out.println("Pending Level 1 checkbox is not present.");
			log.exit();
		}
	}
	
	/**
	 * Check Automatically Close Ticket
	 */
	public void checkAutomaticallyClosedTicket() {
		log.entry();
		driverHelper.waitForPageLoaded();
		driver.switchTo().defaultContent();
		if(driverHelper.isElementPresent(btn_automaticallyClosedTicket)) {
			driverHelper.clickButton(btn_automaticallyClosedTicket);
			driverHelper.embedScreenshot(scenario);
			log.exit();
		} else {
			System.out.println("Automatically Closed Ticket checkbox is not present.");
			log.exit();
		}
	}
}
