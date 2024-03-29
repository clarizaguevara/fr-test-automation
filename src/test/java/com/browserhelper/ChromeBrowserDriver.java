package com.browserhelper;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.browserhelper.ChromeBrowserDriver;
import com.utils.PropertyUtil;

public class ChromeBrowserDriver extends ChromeDriver {
	
	public static WebDriver buildChromeDriver(){
    	DesiredCapabilities capabilities = DesiredCapabilities.chrome () ;      
    	capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
    	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\" + PropertyUtil.getConfig("local.chrome.driver.location"));
        ChromeBrowserDriver browser = new ChromeBrowserDriver();
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return browser;
    }
}
