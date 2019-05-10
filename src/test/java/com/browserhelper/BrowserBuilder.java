package com.browserhelper;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.utils.PropertyUtil;

public class BrowserBuilder {
	private static final Logger log = LogManager.getLogger(BrowserBuilder.class);
	
	public static WebDriver getDriverBrowser(){
    	WebDriver driver = getWebDriver();
    	if (driver != null) {
    		driver.manage().deleteAllCookies();
    		driver.manage().window().maximize();
    	}
        return driver;
    }
	
private static WebDriver getWebDriver() {
		
		String desiredBrowserName = PropertyUtil.getProp("src/test/resources/properties/config.properties", "capabilities.browserName");
		WebDriver driver = null;
		log.info("\nSelected browser: {} \nSelected Execution Mode: {}", PropertyUtil.getConfig("capabilities.browserName"), PropertyUtil.getConfig("execution.mode"));
		if (PropertyUtil.getConfig("execution.mode").equalsIgnoreCase("Local")) {
			switch (desiredBrowserName) {
	        case "Chrome":
	        	driver = ChromeBrowserDriver.buildChromeDriver();
	            break;
	        case "InternetExplorer":
	        	driver = IEBrowserDriver.buildIEBrowser();
	            break;
	        default:
	            break;
			}
			
		} else if (PropertyUtil.getConfig("execution.mode").equalsIgnoreCase("Grid")) {
			
			DesiredCapabilities capabilities = null;
	        if (PropertyUtil.getConfig("capabilities.browserName").equalsIgnoreCase("Chrome")) {
	        	capabilities = DesiredCapabilities.chrome();
	        } else if (PropertyUtil.getConfig("capabilities.browserName").equalsIgnoreCase("internetExplorer")) {
	        	capabilities = DesiredCapabilities.internetExplorer();
	        } 	        
	        try {
	        	driver = new RemoteWebDriver(new URL("http://16.158.142.149:4444/wd/hub"), capabilities);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}
		driver.manage().window().maximize();
		return driver;
	}
}
