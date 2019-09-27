package com.pageobjects;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class CreateSNOWTicketPage extends BasePage {

	private static final Logger log = LogManager.getLogger(CreateSNOWTicketPage.class);
	
	
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
	
	@FindBys(value = @FindBy (xpath ="//label[contains(text(), 'Ticket Type')]//following::div[@class='col-sm-4'][1]//select//option"))
	private List<WebElement> list_ticketType;
	
	@FindBy (xpath ="//label[contains(text(), 'Language')]//following::div[@class='css-rsyb7x'][1]//input[@id='react-select-2-input']")
	private WebElement fld_language;
	
	@FindBy (xpath ="//label[contains(text(), 'Contact Type')]//following::div[@class='col-sm-4'][1]//select")
	private WebElement fld_contactType;
	
	@FindBys(value = @FindBy (xpath ="//label[contains(text(), 'Contact Type')]//following::div[@class='col-sm-4'][1]//select//option"))
	private List<WebElement> list_contactType;
	
	@FindBy (xpath ="//label[contains(text(), 'Impact')]//following::div[@class='col-sm-4'][1]//select")
	private WebElement fld_impact;
	
	@FindBys(value = @FindBy (xpath ="//label[contains(text(), 'Impact')]//following::div[@class='col-sm-4'][1]//select//option"))
	private List<WebElement> list_impact;
	
	@FindBy (xpath ="//label[contains(text(), 'Urgency')]//following::div[@class='col-sm-4'][1]//select")
	private WebElement fld_urgency;
	
	@FindBys(value = @FindBy (xpath ="//label[contains(text(), 'Urgency')]//following::div[@class='col-sm-4'][1]//select//option"))
	private List<WebElement> list_urgency;
	
	@FindBy (xpath ="//label[contains(text(), 'Priority')]//following::div[@class='col-sm-4'][1]//select")
	private WebElement fld_priority;
	
	@FindBys(value = @FindBy (xpath ="//label[contains(text(), 'Priority')]//following::div[@class='col-sm-4'][1]//select//option"))
	private List<WebElement> list_priority;
	
	@FindBy (xpath ="//label[contains(text(), 'Description')]//following::div[@class='col-sm'][2]//textarea")
	private WebElement fld_description;
	
	@FindBy (xpath ="//label[contains(text(), 'Short Description')]//following::div[@class='col-sm'][1]//input")
	private WebElement fld_shortDescription;
	
	@FindBy(xpath= "//div[@class='col-sm-4 offset-sm-2 pt-2']//div[@class='form-check']//input[@type='checkbox']")
	private WebElement btn_pendingLevel;
	
	@FindBy(xpath= "//label[contains(text(),'Description')]//following::input[@type='checkbox'][1]")
	private WebElement btn_automaticallyClosedTicket;
	
	@FindBy(xpath= "//div[@class='col-sm-auto offset-sm-2 pt-2']//input[@type='checkbox']")
	private WebElement btn_sendToSlackChannel;
	
	@FindBy(xpath= "//input[@placeholder='Slack channel']")
	private WebElement fld_slackChannel;
	
	@FindBy(xpath= "//label[contains(text(),'Automatically')]//following::input[@type='checkbox'][1]")
	private WebElement btn_consolidateTicket;
	
	
	/* Methods */
	
	/**
	 * Set Impacted Users
	 */
	public void setImpactedUsers(String impactedUsers) {
		log.entry();
		if(driverHelper.isElementPresent(fld_impactedUsers)) {
			driverHelper.inputFieldValue(fld_impactedUsers, impactedUsers);
			driverHelper.explicitWaitSNOW();
			driverHelper.clickEnter(fld_impactedUsers);
			driverHelper.embedScreenshot(scenario);
		} else {
			Assert.assertTrue("Impacted User field is not present.", driverHelper.isElementPresent(fld_impactedUsers));
		}
		log.exit();
	}
	
	/**
	 * Set Assignment Group
	 */
	public void setAssignmentGroup(String assignmentGroup) {
		log.entry();
		if(driverHelper.isElementPresent(fld_assignmentGroup)) {
			driverHelper.inputFieldValue(fld_assignmentGroup, assignmentGroup);
			driverHelper.explicitWaitSNOW();
			driverHelper.clickEnter(fld_assignmentGroup);
			driverHelper.embedScreenshot(scenario);
		} else {
			Assert.assertTrue("Assignment Group field is not present.", driverHelper.isElementPresent(fld_assignmentGroup));
		}
		log.exit();
	}
	
	/**
	 * Set Assigned To
	 */
	public void setAssignedTo(String assignedTo) {
		log.entry();
		if(driverHelper.isElementPresent(fld_assignedTo)) {
			driverHelper.inputFieldValue(fld_assignedTo, assignedTo);
			driverHelper.explicitWaitSNOW();
			driverHelper.clickEnter(fld_assignedTo);
			driverHelper.embedScreenshot(scenario);
		} else {
			Assert.assertTrue("Assigned To field is not present.", driverHelper.isElementPresent(fld_assignedTo));
		}
		log.exit();
	}
	
	/**
	 * Set Category
	 */
	public void setCategory(String category) {
		log.entry();
		if(driverHelper.isElementPresent(fld_category)) {
			driverHelper.inputFieldValue(fld_category, category);
			driverHelper.explicitWaitSNOW();
			driverHelper.clickEnter(fld_category);
			driverHelper.embedScreenshot(scenario);
		} else {
			Assert.assertTrue("Category field is not present.", driverHelper.isElementPresent(fld_category));
		}
		log.exit();
	}
	
	/**
	 * Set SubCategory
	 */
	public void setSubCategory(String subCategory) {
		log.entry();
		if(driverHelper.isElementPresent(fld_subCategory)) {
			driverHelper.inputFieldValue(fld_subCategory, subCategory);
			driverHelper.explicitWaitSNOW();
			driverHelper.clickEnter(fld_subCategory);
			driverHelper.embedScreenshot(scenario);
		} else {
			Assert.assertTrue("Sub-Category field is not present.", driverHelper.isElementPresent(fld_subCategory));
		}
		log.exit();
	}
	
	/**
	 * Set Area
	 */
	public void setArea(String area) {
		log.entry();
		if(driverHelper.isElementPresent(fld_area)) {
			driverHelper.inputFieldValue(fld_area, area);
			driverHelper.explicitWaitSNOW();
			driverHelper.clickEnter(fld_area);
			driverHelper.embedScreenshot(scenario);
		} else {
			Assert.assertTrue("Area field is not present.", driverHelper.isElementPresent(fld_area));
		}
		log.exit();
	}
	
	/**
	 * Select Ticket Type
	 */
	public void selectTicketType(String ticketType) {
		log.entry();
		if(driverHelper.isElementPresent(fld_ticketType)) {
			driverHelper.clickButton(fld_ticketType);
			driverHelper.setValueDropdown(list_ticketType, fld_ticketType, ticketType);
			driverHelper.embedScreenshot(scenario);
		} else {
			Assert.assertTrue("Ticket Type field is not present.", driverHelper.isElementPresent(fld_ticketType));
		}
		log.exit();
	}
	
	/**
	 * Select Preferred Support Language
	 */
	public void selectLanguage(String language) {
		log.entry();
		if(driverHelper.isElementPresent(fld_language)) {
			driverHelper.inputFieldValue(fld_language, language);
			driverHelper.explicitWaitSNOW();
			driverHelper.clickEnter(fld_language);
			driverHelper.embedScreenshot(scenario);
		} else {
			Assert.assertTrue("Language field is not present.", driverHelper.isElementPresent(fld_language));
		}
		log.exit();
	}
	
	/**
	 * Select Contact Type
	 */
	public void selectContactType(String contactType) {
		log.entry();
		if(driverHelper.isElementPresent(fld_contactType)) {
			driverHelper.clickButton(fld_contactType);
			driverHelper.setValueDropdown(list_contactType, fld_contactType, contactType);
			driverHelper.embedScreenshot(scenario);
		} else {
			Assert.assertTrue("Contact Type field is not present.", driverHelper.isElementPresent(fld_contactType));
		}
		log.exit();
	}
	
	/**
	 * Select Impact
	 */
	public void selectImpact(String impact) {
		log.entry();
		if(driverHelper.isElementPresent(fld_impact)) {
			driverHelper.clickButton(fld_impact);
			driverHelper.setValueDropdown(list_impact, fld_impact, impact);
			driverHelper.embedScreenshot(scenario);
		} else {
			Assert.assertTrue("Impact field is not present.", driverHelper.isElementPresent(fld_impact));
		}
		log.exit();
	}
	
	/**
	 * Select Urgency
	 */
	public void selectUrgency(String urgency) {
		log.entry();
		if(driverHelper.isElementPresent(fld_urgency)) {
			driverHelper.clickButton(fld_urgency);
			driverHelper.setValueDropdown(list_urgency, fld_urgency, urgency);
			driverHelper.embedScreenshot(scenario);
		} else {
			Assert.assertTrue("Urgency field is not present.", driverHelper.isElementPresent(fld_urgency));
		}
		log.exit();
	}
	
	/**
	 * Select Priority
	 */
	public void selectPriority(String priority) {
		log.entry();
		if(driverHelper.isElementPresent(fld_priority)) {
			driverHelper.clickButton(fld_priority);
			driverHelper.setValueDropdown(list_priority, fld_priority, priority);
			driverHelper.embedScreenshot(scenario);
		} else {
			Assert.assertTrue("Priority field is not present.", driverHelper.isElementPresent(fld_priority));
		}
		log.exit();
	}
	
	/**
	 *Input Description
	 */
	public void inputDescription(String description) {
		log.entry();
		driverHelper.waitForPageLoaded();
		if(driverHelper.isElementPresent(fld_description)) {
			driverHelper.clearText(fld_description);
			driverHelper.inputFieldValue(fld_description, description);
			driverHelper.embedScreenshot(scenario);
		} else {
			Assert.assertTrue("Description field is not present.", driverHelper.isElementPresent(fld_description));
		}
		log.exit();
	}
	
	/**
	 *Input Short Description
	 */
	public void inputShortDescription(String shortDescription) {
		log.entry();
		driverHelper.waitForPageLoaded();
		if(driverHelper.isElementPresent(fld_shortDescription)) {
			driverHelper.clearText(fld_shortDescription);
			driverHelper.inputFieldValue(fld_shortDescription, shortDescription);
			driverHelper.embedScreenshot(scenario);
		} else {
			Assert.assertTrue("Short Description field is not present.", driverHelper.isElementPresent(fld_shortDescription));
		}
		log.exit();
	}
	
	/**
	 *Input Short Description
	 */
	public void clearShortDescription() {
		log.entry();
		driverHelper.waitForPageLoaded();
		if(driverHelper.isElementPresent(fld_shortDescription)) {
			driverHelper.clearText(fld_shortDescription);
			driverHelper.embedScreenshot(scenario);
		} else {
			Assert.assertTrue("Short Description field is not present.", driverHelper.isElementPresent(fld_shortDescription));
		}
		log.exit();
	}
	
	/**
	 * Check Pending Level 1
	 */
	public void checkPendingLevel() {
		log.entry();
		if(driverHelper.isElementPresent(btn_pendingLevel)) {
			driverHelper.clickButton(btn_pendingLevel);
			driverHelper.embedScreenshot(scenario);
		} else {
			Assert.assertTrue("Pending Level 1 field is not present.", driverHelper.isElementPresent(btn_pendingLevel));
		}
		log.exit();
	}
	
	/**
	 * Check Automatically Close Ticket
	 */
	public void checkAutomaticallyClosedTicket() {
		log.entry();
		if(driverHelper.isElementPresent(btn_automaticallyClosedTicket)) {
			driverHelper.clickButton(btn_automaticallyClosedTicket);
			driverHelper.embedScreenshot(scenario);
		} else {
			Assert.assertTrue("Automatically Closed Ticket checkbox is not present.", driverHelper.isElementPresent(btn_automaticallyClosedTicket));
		}
		log.exit();
	}
	
	/**
	 * Check send ticket to slack ID channel
	 */
	public void checkSendTicketToSlackIDChannel() {
		log.entry();
		if(driverHelper.isElementPresent(btn_sendToSlackChannel)) {
			driverHelper.clickButton(btn_sendToSlackChannel);
			driverHelper.embedScreenshot(scenario);
		} else {
			Assert.assertTrue("Send ticket to Slack ID channel checkbox is not present.", driverHelper.isElementPresent(btn_sendToSlackChannel));
		}
		log.exit();
	}
	
	/**
	 *Input Slack Channel
	 */
	public void inputSlackChannel(String slackChannel) {
		log.entry();
		if(driverHelper.isElementPresent(fld_slackChannel)) {
			driverHelper.clearText(fld_slackChannel);
			driverHelper.inputFieldValue(fld_slackChannel, slackChannel);
			driverHelper.embedScreenshot(scenario);
		} else {
			Assert.assertTrue("Slack Channel field is not present.", driverHelper.isElementPresent(fld_slackChannel));
		}
		log.exit();
	}
	
	/**
	 * Check Slack channel value
	 */
	public void checkSlackChannelValue(String slackChannelValue) {
		log.entry();
		Assert.assertTrue("Values are not the same", (fld_slackChannel.getAttribute("value")).equals(slackChannelValue));
		log.exit();
	}
	
	/**
	 * Check Consolidate Ticket
	 */
	public void checkConsolidateTicket() {
		log.entry();
		if(driverHelper.isElementPresent(btn_consolidateTicket)) {
			driverHelper.clickButton(btn_consolidateTicket);
			driverHelper.embedScreenshot(scenario);
		} else {
			Assert.assertTrue("Consolidate Ticket checkbox is not present.", driverHelper.isElementPresent(btn_consolidateTicket));
		}
		log.exit();
	}
	
}
