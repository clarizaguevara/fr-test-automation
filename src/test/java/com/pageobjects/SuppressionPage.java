package com.pageobjects;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class SuppressionPage extends BasePage {
	
	private static final Logger log = LogManager.getLogger(SuppressionPage.class);

	
	/* Page Elements */
	
	@FindBys(value = @FindBy (xpath = "//label[contains(text(),'Time:')]//following::div[@class='form-inline timepicker'][1]//select[@class='form-control'][1]//option"))
	private List<WebElement> list_timeFrom_hours;
	
	@FindBy(xpath= "//label[contains(text(),'Time:')]//following::div[@class='form-inline timepicker'][1]//select[@class='form-control'][1]")
	private WebElement fld_timeFrom_hours;
	
	@FindBys(value = @FindBy (xpath = "//label[contains(text(),'Time:')]//following::div[@class='form-inline timepicker'][1]//select[@class='form-control'][2]//option"))
	private List<WebElement> list_timeFrom_minutes;
	
	@FindBy(xpath= "//label[contains(text(),'Time:')]//following::div[@class='form-inline timepicker'][1]//select[@class='form-control'][2]")
	private WebElement fld_timeFrom_minutes;
	
	@FindBys(value = @FindBy (xpath = "//label[contains(text(),'Time:')]//following::div[@class='form-inline timepicker'][2]//select[@class='form-control'][1]//option"))
	private List<WebElement> list_timeTo_hours;
	
	@FindBy(xpath= "//label[contains(text(),'Time:')]//following::div[@class='form-inline timepicker'][2]//select[@class='form-control'][1]")
	private WebElement fld_timeTo_hours;
	
	@FindBys(value = @FindBy (xpath = "//label[contains(text(),'Time:')]//following::div[@class='form-inline timepicker'][2]//select[@class='form-control'][2]//option"))
	private List<WebElement> list_timeTo_minutes;
	
	@FindBy(xpath= "//label[contains(text(),'Time:')]//following::div[@class='form-inline timepicker'][2]//select[@class='form-control'][2]")
	private WebElement fld_timeTo_minutes;
	
	@FindBy (xpath ="//div[@class='css-108yccl']//input")
	private WebElement fld_timezone;
	
	@FindBy (xpath ="//div[@class='css-1wy0on6']//following::div[@class='css-1n9lbrx']")
	private WebElement fld_timezoneOptions;
	
	@FindBy(xpath= "//label[text()='Days:']//following::div[@data-toggle='buttons'][1]")
	private WebElement btn_MON;
	
	@FindBy(xpath= "//label[text()='Days:']//following::div[@data-toggle='buttons'][2]")
	private WebElement btn_TUE;
	
	@FindBy(xpath= "//label[text()='Days:']//following::div[@data-toggle='buttons'][3]")
	private WebElement btn_WED;
	
	@FindBy(xpath= "//label[text()='Days:']//following::div[@data-toggle='buttons'][4]")
	private WebElement btn_THU;
	
	@FindBy(xpath= "//label[text()='Days:']//following::div[@data-toggle='buttons'][5]")
	private WebElement btn_FRI;
	
	@FindBy(xpath= "//label[text()='Days:']//following::div[@data-toggle='buttons'][6]")
	private WebElement btn_SAT;
	
	@FindBy(xpath= "//label[text()='Days:']//following::div[@data-toggle='buttons'][7]")
	private WebElement btn_SUN;
	
	@FindBys(value = @FindBy (xpath = "//div[@class='col-sm-2 offset-sm-1 pl-1 pr-0']//select[@class='form-control']//option"))
	private List<WebElement> list_timeRange;
	
	@FindBy(xpath= "//div[@class='col-sm-2 offset-sm-1 pl-1 pr-0']//select[@class='form-control']")
	private WebElement fld_timeRange;
	
	
	/* Methods */
	
	/**
	 * Select From time
	 */
	public void selectTimeFrom(String timeFrom_hours, String timeFrom_minutes) {
		log.entry();
		if(driverHelper.isElementPresent(fld_timeFrom_hours)) {
			driverHelper.clickButton(fld_timeFrom_hours);
			driverHelper.setValueDropdown(list_timeFrom_hours, fld_timeFrom_hours, timeFrom_hours);
			driverHelper.embedScreenshot(scenario);
			log.exit();
		} else {
			System.out.println("From time (hours) field is not present.");
			log.exit();
		}
		if(driverHelper.isElementPresent(fld_timeFrom_minutes)) {
			driverHelper.clickButton(fld_timeFrom_minutes);
			driverHelper.setValueDropdown(list_timeFrom_minutes, fld_timeFrom_minutes, timeFrom_minutes);
			driverHelper.embedScreenshot(scenario);
			log.exit();
		} else {
			System.out.println("From time (minutes) field is not present.");
			log.exit();
		}
	}
	
	/**
	 * Select To time
	 */
	public void selectTimeTo(String timeTo_hours, String timeTo_minutes) {
		log.entry();
		if(driverHelper.isElementPresent(fld_timeTo_hours)) {
			driverHelper.clickButton(fld_timeTo_hours);
			driverHelper.setValueDropdown(list_timeTo_hours, fld_timeTo_hours, timeTo_hours);
			driverHelper.embedScreenshot(scenario);
			log.exit();
		} else {
			System.out.println("To time (hours) field is not present.");
			log.exit();
		}
		if(driverHelper.isElementPresent(fld_timeTo_minutes)) {
			driverHelper.clickButton(fld_timeTo_minutes);
			driverHelper.setValueDropdown(list_timeTo_minutes, fld_timeTo_minutes, timeTo_minutes);
			driverHelper.embedScreenshot(scenario);
			log.exit();
		} else {
			System.out.println("To time (minutes) field is not present.");
			log.exit();
		}
	}
	
	/**
	 * Set timezone
	 */
	public void setTimezone(String timezone) {
		log.entry();
		if(driverHelper.isElementPresent(fld_timezone)) {
			//driverHelper.clickButton(fld_timezone);
			driverHelper.inputFieldValue(fld_timezone, timezone);
			driverHelper.waitForElementVisible(fld_timezoneOptions);
			driverHelper.explicitWait();
			driverHelper.clickEnter(fld_timezone);
			driverHelper.embedScreenshot(scenario);
			log.exit();
		} else {
			System.out.println("Timezone field is not present.");
			log.exit();
		}
	}
	
	/**
	 * Click MON button
	 */
	public void selectMON() {
		log.entry();
		if(driverHelper.isElementPresent(btn_MON)) {
			driverHelper.clickButton(btn_MON);
			log.exit();
		} else {
			System.out.println("MON button is not present.");
			log.exit();
		}
	}
	
	/**
	 * Click TUE button
	 */
	public void selectTUE() {
		log.entry();
		if(driverHelper.isElementPresent(btn_TUE)) {
			driverHelper.clickButton(btn_TUE);
			log.exit();
		} else {
			System.out.println("TUE button is not present.");
			log.exit();
		}
	}
	
	/**
	 * Click WED button
	 */
	public void selectWED() {
		log.entry();
		if(driverHelper.isElementPresent(btn_WED)) {
			driverHelper.clickButton(btn_WED);
			log.exit();
		} else {
			System.out.println("WED button is not present.");
			log.exit();
		}
	}
	
	/**
	 * Click THU button
	 */
	public void selectTHU() {
		log.entry();
		if(driverHelper.isElementPresent(btn_THU)) {
			driverHelper.clickButton(btn_THU);
			log.exit();
		} else {
			System.out.println("THU button is not present.");
			log.exit();
		}
	}
	
	/**
	 * Click FRI button
	 */
	public void selectFRI() {
		log.entry();
		if(driverHelper.isElementPresent(btn_FRI)) {
			driverHelper.clickButton(btn_FRI);
			log.exit();
		} else {
			System.out.println("FRI button is not present.");
			log.exit();
		}
	}
	
	/**
	 * Click SAT button
	 */
	public void selectSAT() {
		log.entry();
		if(driverHelper.isElementPresent(btn_SAT)) {
			driverHelper.clickButton(btn_SAT);
			log.exit();
		} else {
			System.out.println("SAT button is not present.");
			log.exit();
		}
	}
	
	/**
	 * Click SUN button
	 */
	public void selectSUN() {
		log.entry();
		if(driverHelper.isElementPresent(btn_SUN)) {
			driverHelper.clickButton(btn_SUN);
			log.exit();
		} else {
			System.out.println("SUN button is not present.");
			log.exit();
		}
	}
	
	/**
	 * Select Within/Beyond
	 */
	public void selectTimeRange(String timeRange) {
		log.entry();
		if(driverHelper.isElementPresent(fld_timeRange)) {
			driverHelper.clickButton(fld_timeRange);
			driverHelper.setValueDropdown(list_timeRange, fld_timeRange, timeRange);
			driverHelper.embedScreenshot(scenario);
			log.exit();
		} else {
			System.out.println("Time range field is not present.");
			log.exit();
		}
	}

}
