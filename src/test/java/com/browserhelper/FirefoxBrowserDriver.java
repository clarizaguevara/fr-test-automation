package com.browserhelper;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.utils.PropertyUtil;

public class FirefoxBrowserDriver extends FirefoxDriver {
	
	public static WebDriver buildFirefoxDriver(){
    	DesiredCapabilities capabilities = DesiredCapabilities.firefox () ;      
    	capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
    	System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\" + PropertyUtil.getConfig("local.firefox.driver.location"));
    	FirefoxBrowserDriver browser = new FirefoxBrowserDriver();
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return browser;
    }

}
