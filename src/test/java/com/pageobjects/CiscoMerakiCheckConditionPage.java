package com.pageobjects;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class CiscoMerakiCheckConditionPage extends BasePage {
	
	private static final Logger log = LogManager.getLogger(CiscoMerakiCheckConditionPage.class);

	
	/* Page Elements */
	
	@FindBys(value = @FindBy (xpath = "//div[@class='col-sm-auto']//select[@class='form-control']//option"))
	private List<WebElement> list_deviceStatus;
	
	@FindBy(xpath= "//div[@class='col-sm-auto']//select[@class='form-control']")
	private WebElement fld_deviceStatus;
	
	
	/* Methods */
	
	/**
	 * Select device status
	 */
	public void selectDeviceStatus(String deviceStatus) {
		log.entry();
		if(driverHelper.isElementPresent(fld_deviceStatus)) {
			driverHelper.clickButton(fld_deviceStatus);
			driverHelper.setValueDropdown(list_deviceStatus, fld_deviceStatus, deviceStatus);
			driverHelper.embedScreenshot(scenario);
			log.exit();
		} else {
			System.out.println("Device status field is not present.");
			log.exit();
		}
	}

}
