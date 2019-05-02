package com.browserhelper;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.utils.PropertyUtil;

public class IEBrowserDriver extends InternetExplorerDriver {
	
    public static WebDriver buildIEBrowser(){
    	DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer() ;      
    	capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
    	System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\" + PropertyUtil.getConfig("local.internetexplorer.driver.location"));
    	InternetExplorerDriver browser = new InternetExplorerDriver();
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return browser;
    }

}
