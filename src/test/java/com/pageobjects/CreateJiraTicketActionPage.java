package com.pageobjects;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class CreateJiraTicketActionPage extends BasePage {
	
	private static final Logger log = LogManager.getLogger(CreateJiraTicketActionPage.class);

	/* Page Elements */
	@FindBys(value = @FindBy (xpath = "//label[contains(text(), 'Project:')]//following::div[@class='col-sm-9'][1]//select//option"))
	private List<WebElement> list_project;
	
	@FindBy(xpath= "//label[contains(text(), 'Project:')]//following::div[@class='col-sm-9'][1]//select")
	private WebElement fld_project;
	
	@FindBy(xpath= "//label[contains(text(), 'Summary:')]//following::div[@class='col-sm-9'][1]//input[@class='form-control']")
	private WebElement fld_summary;
	
	@FindBy(xpath= "//textarea[@class='form-control noresize']")
	private WebElement fld_description;
	
	@FindBys(value = @FindBy (xpath = "//label[contains(text(), 'Brand(JP18SS):')]//following::div[@class='col-sm-5'][1]//select//option"))
	private List<WebElement> list_brand;
	
	@FindBy(xpath= "//label[contains(text(), 'Brand(JP18SS):')]//following::div[@class='col-sm-5'][1]//select")
	private WebElement fld_brand;
	
	@FindBy(xpath= "//input[@value='--']")
	private WebElement fld_closingCondition;
	
	@FindBys(value = @FindBy (xpath = "//label[contains(text(), 'Priority')]//following::div[@class='col-sm-5'][1]//select//option"))
	private List<WebElement> list_priority;
	
	@FindBy(xpath= "//label[contains(text(), 'Priority')]//following::div[@class='col-sm-5'][1]//select")
	private WebElement fld_priority;
	
	@FindBy(xpath= "//label[contains(text(), 'Assignee:')]//following::div[@class='css-rsyb7x'][1]//input[@id='react-select-2-input']")
	private WebElement fld_assignee;
	
	@FindBy(xpath= "//label[contains(text(), 'Watchers:')]//following::div[@class='css-rsyb7x'][1]//input[@id='react-select-3-input']")
	private WebElement fld_watchers;
	
	@FindBy(xpath= "//label[contains(text(), 'Labels:')]//following::div[@class='css-rsyb7x'][1]//input")
	private WebElement fld_labels;
	
	@FindBy(xpath= "//div[@class='col-sm-auto my-1 pl-2']//input[@type='checkbox']")
	private WebElement btn_sendToSlackChannel;
	
	@FindBy(xpath= "//input[@placeholder='Slack channel']")
	private WebElement fld_slackChannel;
	
	@FindBy(xpath= "//label[contains(text(), 'Platform/System(ACPF)')]//following::div[@class='css-rsyb7x'][1]//input[@id='react-select-2-input']")
	private WebElement fld_platform;
	
	@FindBy(xpath= "//label[contains(text(), 'Markets:')]//following::div[@class='col-sm-5'][1]//input[@id='react-select-3-input']")
	private WebElement fld_markets;
	
	@FindBy(xpath="//label[contains(text(), 'Assignee:')]//following::div[@class='css-rsyb7x'][1]//input[@id='react-select-2-input']//following::div[@class='css-1n9lbrx'][1]")
	private WebElement fld_assigneeOptions;
	
	@FindBy(xpath="//label[contains(text(), 'Watchers:')]//following::div[@class='css-rsyb7x'][1]//input[@id='react-select-3-input']//following::div[@class='css-1n9lbrx'][1]")
	private WebElement fld_watchersOptions;
	
	@FindBy(xpath= "//label[contains(text(), 'Progress:')]//following::div[@class='col-sm-5'][1]//select")
	private WebElement fld_progress;
	
	/* Methods */
	
	/**
	 * Select Project Type
	 */
	public void selectProject(String project) {
		log.entry();
		driverHelper.waitForElementClickable(fld_project);
		if(driverHelper.isElementVisible(fld_project)) {
			driverHelper.clickButton(fld_project);
			driverHelper.inputFieldValue(fld_project, project);
			driverHelper.explicitWait();
			driverHelper.embedScreenshot(scenario);
			log.exit();
		} else {
			System.out.println("Project field is not present.");
			log.exit();
		}
	}
	
	/**
	 *Input Summary
	 */
	public void inputSummary(String summary) {
		log.entry();
		driver.switchTo().defaultContent();
		if(driverHelper.isElementPresent(fld_summary)) {
			driverHelper.scrollIntoView(fld_summary);
			driverHelper.clickButton(fld_summary);
			driverHelper.inputFieldValue(fld_summary, summary);
			driverHelper.embedScreenshot(scenario);
			log.exit();
		} else {
			System.out.println("Summary field is not present.");
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
	 * Select Brand
	 */
	public void selectBrand(String brand) {
		log.entry();
		driverHelper.waitForPageLoaded();
		if(driverHelper.isElementPresent(fld_brand)) {
			driverHelper.clickButton(fld_brand);
			driverHelper.inputFieldValue(fld_brand, brand);
			driverHelper.embedScreenshot(scenario);
			log.exit();
		} else {
			System.out.println("Brand field is not present.");
			log.exit();
		}
	}
	
	/**
	 *Input Closing Condition
	 */
	public void inputClosingCondition(String closingCondition) {
		log.entry();
		driverHelper.waitForPageLoaded();
		if(driverHelper.isElementPresent(fld_closingCondition)) {
			fld_closingCondition.clear();
			driverHelper.inputFieldValue(fld_closingCondition, closingCondition);
			driverHelper.embedScreenshot(scenario);
			log.exit();
		} else {
			System.out.println("Closing Condition field is not present.");
			log.exit();
		}
	}
	
	/**
	 * Select Priority
	 */
	public void selectPriority(String priority) {
		log.entry();
		driverHelper.waitForPageLoaded();
		if(driverHelper.isElementPresent(fld_priority)) {
			driverHelper.clickButton(fld_priority);
			driverHelper.inputFieldValue(fld_priority, priority);
			driverHelper.embedScreenshot(scenario);
			log.exit();
		} else {
			System.out.println("Priority field is not present.");
			log.exit();
		}
	}
	
	/**
	 * Set Assignee
	 */
	public void setAssignee(String assignee) {
		log.entry();
		driverHelper.waitForPageLoaded();
		if(driverHelper.isElementPresent(fld_assignee)) {
			//driverHelper.clickButton(fld_assignee);
			driverHelper.inputFieldValue(fld_assignee, assignee);
			driverHelper.waitForElementVisible(fld_assigneeOptions);
			driverHelper.explicitWait();
			driverHelper.clickEnter(fld_assignee);
			driverHelper.embedScreenshot(scenario);
			log.exit();
		} else {
			System.out.println("Assignee field is not present.");
			log.exit();
		}
	}
	
	/**
	 * Set Watchers
	 */
	public void setWatchers(String watchers) {
		log.entry();
		driverHelper.waitForPageLoaded();
		if(driverHelper.isElementPresent(fld_watchers)) {
			//driverHelper.clickButton(fld_watchers);
			driverHelper.inputFieldValue(fld_watchers, watchers);
			driverHelper.waitForElementVisible(fld_watchersOptions);
			driverHelper.explicitWait();
			driverHelper.clickEnter(fld_watchers);
			driverHelper.embedScreenshot(scenario);
			log.exit();
		} else {
			System.out.println("Watchers field is not present.");
			log.exit();
		}
	}
	
	/**
	 *Input Labels
	 */
	public void inputLabels(String labels) {
		log.entry();
		driver.switchTo().defaultContent();
		if(driverHelper.isElementPresent(fld_labels)) {
			driverHelper.inputFieldValue(fld_labels, labels);
			driverHelper.embedScreenshot(scenario);
			log.exit();
		} else {
			System.out.println("Labels field is not present.");
			log.exit();
		}
	}
	
	/**
	 * Check send ticket to slack ID channel
	 */
	public void checkSendTicketToSlackIDChannel() {
		log.entry();
		driverHelper.waitForPageLoaded();
		if(driverHelper.isElementPresent(btn_sendToSlackChannel)) {
			driverHelper.clickButton(btn_sendToSlackChannel);
			driverHelper.embedScreenshot(scenario);
			log.exit();
		} else {
			System.out.println("Send ticket to Slack ID channel checkbox is not present.");
			log.exit();
		}
	}
	
	/**
	 *Input Slack Channel
	 */
	public void inputSlackChannel(String slackChannel) {
		log.entry();
		driverHelper.waitForPageLoaded();
		if(driverHelper.isElementPresent(fld_slackChannel)) {
			fld_slackChannel.clear();
			driverHelper.inputFieldValue(fld_slackChannel, slackChannel);
			driverHelper.embedScreenshot(scenario);
			log.exit();
		} else {
			System.out.println("Slack Channel field is not present.");
			log.exit();
		}
	}
	
	/**
	 * Select Platform/System(ACPF)
	 */
	public void selectPlatform(String platform) {
		log.entry();
		driverHelper.waitForPageLoaded();
		driver.switchTo().defaultContent();
		if(driverHelper.isElementPresent(fld_platform)) {
			driverHelper.jsClick(fld_platform);
			driverHelper.inputFieldValue(fld_platform, platform);
			driverHelper.clickEnter(fld_platform);
			driverHelper.embedScreenshot(scenario);
			log.exit();
		} else {
			System.out.println("Platform/System(ACPF) field is not present.");
			log.exit();
		}
	}
	
	/**
	 * Select Markets
	 */
	public void selectMarkets(String market) {
		log.entry();
		driver.switchTo().defaultContent();
		if(driverHelper.isElementPresent(fld_markets)) {
			driverHelper.clickButton(fld_markets);
			driverHelper.inputFieldValue(fld_markets, market);
			driverHelper.clickEnter(fld_markets);
			driverHelper.embedScreenshot(scenario);
			log.exit();
		} else {
			System.out.println("Market field is not present.");
			log.exit();
		}
	}
	
	/**
	 * Select Progress
	 */
	public void selectProgress(String progress) {
		log.entry();
		driver.switchTo().defaultContent();
		if(driverHelper.isElementPresent(fld_progress)) {
			driverHelper.clickButton(fld_progress);
			driverHelper.inputFieldValue(fld_progress, progress);
			driverHelper.clickEnter(fld_progress);
			driverHelper.embedScreenshot(scenario);
			log.exit();
		} else {
			System.out.println("Progress field is not present.");
			log.exit();
		}
	}
}
