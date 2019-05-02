package com.stepdefs;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.browserhelper.BrowserBuilder;
import com.stepdefs.ScenarioHooks;
import com.utils.ScenarioName;
import com.utils.WebDriverHelper;

import cucumber.api.Scenario;
import cucumber.api.java8.En;

public class ScenarioHooks implements En{
	private static final Logger log = LogManager.getLogger(ScenarioHooks.class);
	public WebDriverHelper driverHelper;
	public static ScenarioName scenarioName;
	
	public WebDriverHelper getDriverHelper() {
		return driverHelper;
	}
	
	public static ScenarioName getScenarioName() {
		return scenarioName;
	}
	
	public String takeScreenShot(Scenario scenario) {
		String outPath = "target/screenshots/" + scenario.getId() + scenario.getName() + "/" + scenario.getName().replaceAll("[; !@#$%^&()+=]", "_")+".png";
		try {
			File scrFile = ((TakesScreenshot) driverHelper.getDriver()).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(outPath).getAbsoluteFile());
        } catch (Throwable e) {
            e.printStackTrace();
        }
		return outPath;
	}
	
	public ScenarioHooks() {
		Before(new String[] { "@scenarios" }, (Scenario scenario) -> {
			if (driverHelper == null) {
				log.info("Scenario: {}", scenario.getName());
				try {
					WebDriver driver = BrowserBuilder.getDriverBrowser();
					driver.manage().deleteAllCookies();
					driver.manage().window().maximize();
					driverHelper = new WebDriverHelper(driver);
					scenarioName = new ScenarioName(scenario);
				} catch (Exception e) {
					log.error("WebDriver initialization failed : {}", e);
				}
			}
		});
		
		After(new String[] { "@scenarios" }, (Scenario scenario) -> {
//			if (scenario.isFailed()) {
//				driverHelper.embedScreenshot(scenario);
//			}
			log.info("Closing the driver instance.");
			driverHelper.getDriver().quit();
			driverHelper = null;
			log.info("End of Scenario: " + scenario.getName());
		});
	}
	
}
