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

import com.constants.CommonConstants;

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
	
	@FindBys(value = @FindBy (xpath = "//div[@class='col-sm-2 offset-sm-1 pl-1 pr-0']//select[@class='form-control']//option"))
	private List<WebElement> list_timeRange;
	
	@FindBy(xpath= "//div[@class='col-sm-2 offset-sm-1 pl-1 pr-0']//select[@class='form-control']")
	private WebElement fld_timeRange;
	
	
	/* Methods */
	
	/**
	 * Select From time
	 */
	public void selectTimeFrom(String timeFrom) {
		log.entry();
		List<String> time_From = Arrays.asList(timeFrom.split(":"));
		if(driverHelper.isElementPresent(fld_timeFrom_hours)) {
			driverHelper.clickButton(fld_timeFrom_hours);
			driverHelper.setValueDropdown(list_timeFrom_hours, fld_timeFrom_hours, time_From.get(0));
			driverHelper.embedScreenshot(scenario);
		} else {
			Assert.assertTrue("From time (hours) field is not present.", driverHelper.isElementPresent(fld_timeFrom_hours));
		}
		
		if(driverHelper.isElementPresent(fld_timeFrom_minutes)) {
			driverHelper.clickButton(fld_timeFrom_minutes);
			driverHelper.setValueDropdown(list_timeFrom_minutes, fld_timeFrom_minutes, time_From.get(1));
			driverHelper.embedScreenshot(scenario);
		} else {
			Assert.assertTrue("From time (minutes) field is not present.", driverHelper.isElementPresent(fld_timeFrom_minutes));
		}
		log.exit();
	}
	
	/**
	 * Select To time
	 */
	public void selectTimeTo(String timeTo) {
		log.entry();
		List<String> time_To = Arrays.asList(timeTo.split(":"));
		if(driverHelper.isElementPresent(fld_timeTo_hours)) {
			driverHelper.clickButton(fld_timeTo_hours);
			driverHelper.setValueDropdown(list_timeTo_hours, fld_timeTo_hours, time_To.get(0));
			driverHelper.embedScreenshot(scenario);
		} else {
			Assert.assertTrue("To time (hours) field is not present.", driverHelper.isElementPresent(fld_timeTo_hours));
		}
		
		if(driverHelper.isElementPresent(fld_timeTo_minutes)) {
			driverHelper.clickButton(fld_timeTo_minutes);
			driverHelper.setValueDropdown(list_timeTo_minutes, fld_timeTo_minutes, time_To.get(1));
			driverHelper.embedScreenshot(scenario);
		} else {
			Assert.assertTrue("To time (minutes) field is not present.", driverHelper.isElementPresent(fld_timeTo_minutes));
		}
		log.exit();
	}
	
	/**
	 * Set timezone
	 */
	public void setTimezone(String timezone) {
		log.entry();
		if(driverHelper.isElementPresent(fld_timezone)) {
			driverHelper.inputFieldValue(fld_timezone, timezone);
			driverHelper.explicitWait();
			driverHelper.clickEnter(fld_timezone);
			driverHelper.embedScreenshot(scenario);
		} else {
			Assert.assertTrue("Timezone field is not present.", driverHelper.isElementPresent(fld_timezone));
		}
		log.exit();
	}
	
	/**
	 * Select/Deselect Days
	 */
	public void selectDays(String days) {
		log.entry();
		String days_of_the_week = CommonConstants.LOV_DAYS.replaceAll("\\[|\\]|\\s", "");
		List<String> LOV_DAYS = Arrays.asList(days_of_the_week.split(","));
		List<String> selectedDays = Arrays.asList(days.split(","));
    	
    	for (int counter = 0; counter < LOV_DAYS.size(); counter++) {
    		By fld_day = By.xpath("//label[text()='" + LOV_DAYS.get(counter) + "']");
    		By fld_day_active = By.xpath("//label[@class='btn w-100 active w-100' and text()='" + LOV_DAYS.get(counter) + "']");
    		
    		//Check if the day is selected
    		if(selectedDays.contains(LOV_DAYS.get(counter))) {
    			//Day is selected
    			
	    		//Check if the selected day is inactive
	    		//If so, select it. If not, do nothing
	    		if(!driverHelper.isButtonSelected(fld_day_active)) {
	    			driverHelper.clickButton(fld_day);
	    		}
    		} else {
    			//Day is not selected
    			
    			//Check if the unselected day is active
	    		//If so, deselect it. If not, do nothing
	    		if(driverHelper.isButtonSelected(fld_day_active)) {
	    			driverHelper.clickButton(fld_day);
	    		}
    		}
    	}
		log.exit();
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
		} else {
			Assert.assertTrue("Time range field is not present.", driverHelper.isElementPresent(fld_timeRange));
		}
		log.exit();
	}

}
