package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.utils.WebDriverHelper;
import com.utils.ScenarioName;

import cucumber.api.Scenario;

public abstract class BasePage {
	WebDriver driver;
	WebDriverHelper driverHelper;
	public Scenario scenario;
	
	public void setDriver(WebDriverHelper driverHelper, ScenarioName scenarioName) {
        this.driverHelper = driverHelper;
        this.driver = driverHelper.getDriver();
        this.scenario = scenarioName.getScenario();
        PageFactory.initElements(driver, this);
    }
	
	public Scenario getScenario() {
		return scenario;
	}
}
