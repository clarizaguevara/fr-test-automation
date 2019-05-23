package com.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.constants.CommonConstants;
import com.cucumber.listener.Reporter;

import cucumber.api.Scenario;

public class WebDriverHelper {
	private static final Logger log = LogManager.getLogger(WebDriverHelper.class);
	private WebDriver driver;
	
    private static final String GENERIC_EXCEPTION_OCCURRED = "Generic Exception occurred: ";
    //private static final String CHECK_IF_ELEMENT_IS_VISIBLE = "Check if element is visible.";
    private static final String ELEMENT_NOT_FOUND = "Element not found: {}";

    public WebDriverHelper(WebDriver driver) {
        this.driver = driver;
    }
    
    public WebDriver getDriver() {
        return driver;
    }
    
    /**
     * Description: Switch to a specified frame
     */
    public void switchToFrame(By elementBy) {
        log.info("Switch to default content.");
        driver.switchTo().defaultContent();
        log.info("Switch to frame: " + elementBy);
        driver.switchTo().frame(driver.findElement(elementBy));
        log.info("Successfully Switched to frame: " + elementBy);
    }
    
    /**
     * Check if element is present
     * @param locator
     * @return
     */
    public boolean isElementPresent(By locator) {
        try {
            driver.manage().timeouts().implicitlyWait(CommonConstants.DEFAULT_WAIT_FOR_ELEMENT, TimeUnit.SECONDS);
            WebDriverWait wait = new WebDriverWait(driver, CommonConstants.DEFAULT_WEBDRIVER_TIMEOUT);
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			return true;
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            log.error(ELEMENT_NOT_FOUND, e);
        } catch (Exception e) {
            log.error(GENERIC_EXCEPTION_OCCURRED, e);
        } finally {
            driver.manage().timeouts().implicitlyWait(CommonConstants.DEFAULT_IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
        }
        return false;
    }
    
    /**
     * Check if element is present
     * @param element
     * @return
     */
    public boolean isElementPresent(WebElement element) {
        try {
            driver.manage().timeouts().implicitlyWait(CommonConstants.DEFAULT_WAIT_FOR_ELEMENT, TimeUnit.SECONDS);
        	element.isDisplayed();
            return true;
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            log.error(ELEMENT_NOT_FOUND, e);
        } catch (Exception e) {
            log.error(GENERIC_EXCEPTION_OCCURRED, e);
        } finally {
            driver.manage().timeouts().implicitlyWait(CommonConstants.DEFAULT_IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
        }
        return false;
    }
    
    /**
     * Check if element is NOT present
     * @param element
     * @return
     */
    public boolean isElementNotPresent(WebElement element) {
    	try {
    		element.isDisplayed();
    		log.error("Element is Present");
    		return false;
		} catch (Exception e) {
			log.info("Element is NOT present.");
			return true;
		}
    }
    
    /**
     * Check if element is visible in the page.
     * @param element
     * @return
     */
    public boolean isElementVisible(WebElement element) {
    	driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    	WebDriverWait wait = new WebDriverWait(driver, CommonConstants.DEFAULT_WEBDRIVER_TIMEOUT);
    	try {
			wait.until(ExpectedConditions.visibilityOf(element));
			return true;
		} catch (Exception e) {
			log.error("Element is NOT visible.",  e);
		} finally {
			driver.manage().timeouts().implicitlyWait(CommonConstants.DEFAULT_IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
		}
    	return false;
    }

    /**
     * Click a button
     * @param buttonElement
     */
    public void clickButton(WebElement buttonElement) {
    	if (isElementPresent(buttonElement)) {
    		buttonElement.click();
    		log.info("Button is clicked.");
    	} else {
    		log.error("Button is NOT present.");
    	}
    }
    
    /**
     * Click a button
     * @param buttonElement
     */
    public void clickButton(By buttonElement) {
    	if (isElementPresent(buttonElement)) {
    		driver.findElement(buttonElement).click();
    		log.info("Button is clicked.");
    	} else {
    		log.error("Button is NOT present.");
    	}
    }
    
    /**
     * Description: Method to wait for page to get loaded
     */
    public void waitForPageLoaded() {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver webdriver) {
                return ((JavascriptExecutor) webdriver).executeScript("return document.readyState").equals("complete");
            }
        };

        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(expectation);
        } catch (Exception e) {
            // Technically not an error so simply log as information
            log.error("document.readyState status not completed after {} seconds", 30);
        }
    }
    
    /**
     * Go to default content
     * 
     */
    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }
    
    /**
     * Scroll until the specified element is visible on screen
     * @param elementBy
     */
    public void scrollIntoView(By elementBy) {

        WebElement objElement = driver.findElement(elementBy);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].scrollIntoView();", objElement);

    }
    
    /**
     * Scroll until the specified element is visible on screen
     * @param webElement
     */
    public void scrollIntoView(WebElement webElement) {

        WebElement objElement = webElement;
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].scrollIntoView();", objElement);
    }
    
    /**
     * Method to double click using actions
     * @param webElement        
     */
    public void doubleClickUsingAction(WebElement webElement) {

        try {

            if (isElementPresent(webElement)) {
                Actions actions = new Actions(driver);
                actions.doubleClick(webElement).build().perform();
            }

        } catch (Exception e) {
            log.info("Exception " + e);
        }
    }
    
    /**
     * Method to get text of an element
     * 
     * @param elementBy
     * @return
     * @throws InterruptedException
     */
    public String getText(WebElement webElement) {

        if (isElementPresent(webElement)) {

            return webElement.getText().trim();

        } else {
            return "";
        }
    }
    
    /**
     * Method to click element using javascript
     * 
     * @param elementBy
     * @throws InterruptedException
     */
    public void jsClick(By elementBy) {

        WebElement weElement = driver.findElement(elementBy);
        try {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", weElement);
        } catch (Exception e) {
            log.info("Check element: " + elementBy);
        }
    }
    
    /**
     * Method to click element using javascript
     * 
     * @param WebElement
     * @throws InterruptedException
     */
    public void jsClick(WebElement webElement) {

        WebElement weElement = webElement;
        try {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", weElement);
        } catch (Exception e) {
            log.info("Check element: " + webElement);
        }
    }
    
    /**
     * Method to select value for dropdown list
     * 
     * @param webElement
     * @param value
     */
    public void selectValue(WebElement webElement, String value) {
     Select actualSelect = new Select(webElement);
     actualSelect.selectByValue(value);
    }
    
    /**
     * Method to select value for dropdown list
     * 
     * @param webElementList
     * @param webElement
     * @param value
     */
	public void setValueDropdown(List<WebElement> webElementList, WebElement dropdownField, String value) {
		log.entry();
		waitForPageLoaded();
		scrollIntoView(dropdownField);
//		clickButton(dropdownField);
		waitForPageLoaded();
		boolean isSelected = false;
		
		for (WebElement webElement : webElementList) {
			String tipo = webElement.getText();
			if(tipo.equalsIgnoreCase(value)) {
				webElement.click();
				log.info(value + " is selected");
				isSelected = true;
			} else {
				//log.debug("Option not available.");
			}
		}
		if(!isSelected) {
			log.debug(value + " is not available.");
		}
	}
	
    /**
     * Description: Method to select and compare value for dropdown list
     * @param toSelect
     * @param element
     */
    public void selectOptionOnDropdown(String toSelect, WebElement element) {
        log.entry();
        String value;
        Select select = new Select(element);
        List<WebElement> options = select.getOptions();
        Iterator<WebElement> optionsCount = options.iterator();

        log.info("Select : {}", toSelect);
        while (optionsCount.hasNext()) {
            value = optionsCount.next().getText().trim();
            if (value.equals(toSelect.trim())) {
            	selectValue(element, value);
                log.info("{} is selected", toSelect);
                log.exit();
                return;
            }
        }
        log.exit();
    }
	
    public void get(String url) {
    	try {
    		driver.get(url);
    	} catch (TimeoutException e) {
    		Assert.fail("Page Load Timeout occurred after " + 30 + " seconds waiting time: " + e);
    	} catch (UnreachableBrowserException e) {
    		Assert.fail("Unreachable Browser Exception occurred: " + e);
    	} catch (Exception e) {
    		Assert.fail("Exception: " + e);
    	}
    }
    
    /**
     * Input value to fields
     * @param webElement
     * @param value
     */
	public void inputFieldValue(WebElement webElement, String value) {
		log.entry();
		if (isElementPresent(webElement)) {
//			scrollIntoView(webElement);
			webElement.sendKeys(value);
			log.info(value + " is inputed to the field.");
        } else {
            log.error("Element not found.");
        }
	}
	
    /**
     * Screenshots
     * @param scenario
     * @return String
     */
	public void embedScreenshot(Scenario scenario) {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String outPath = System.getProperty("user.dir") + "\\target\\screenshots\\" + scenario.getId().split(";")[0] + "\\" + scenario.getName().replaceAll("\\s|\"|\\(|\\:|\\,|\\)|\\/", "_") + "_" + timeStamp + ".png";
		//System.out.println(outPath);
		try {
			File scrFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(outPath).getAbsoluteFile());
			Reporter.addScreenCaptureFromPath(outPath);
        } catch (Throwable e) {
            e.printStackTrace();
        }
	}
	
	/**
	 * Wait for element to be invisible
	 * @param element
	 */
	public void waitForElementNotVisible(WebElement element) {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    	WebDriverWait wait = new WebDriverWait(driver, CommonConstants.DEFAULT_WEBDRIVER_TIMEOUT);
    	try {
			wait.until(ExpectedConditions.invisibilityOf(element));
			log.info("Element is NOT visible.");
		} catch (TimeoutException e) {
			log.error("Element is visible.");
		} finally {
			driver.manage().timeouts().implicitlyWait(CommonConstants.DEFAULT_IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
		}
	}
	
	/**
	 * Wait for element to be visible
	 * @param element
	 */
	public void waitForElementVisible(WebElement element) {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    	WebDriverWait wait = new WebDriverWait(driver, CommonConstants.DEFAULT_WEBDRIVER_TIMEOUT);
    	try {
			wait.until(ExpectedConditions.visibilityOf(element));
			log.info("Element is visible.");
		} catch (TimeoutException e) {
			log.error("Element is not visible.");
		} finally {
			driver.manage().timeouts().implicitlyWait(CommonConstants.DEFAULT_IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
		}
	}
	
    /**
     * Check if element is visible in the page.
     * @param element
     * @return
     */
    public void waitForElementClickable(WebElement element) {
    	driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    	WebDriverWait wait = new WebDriverWait(driver, CommonConstants.DEFAULT_WEBDRIVER_TIMEOUT);
    	try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
			log.error("Element is NOT visible.",  e);
		} finally {
			driver.manage().timeouts().implicitlyWait(CommonConstants.DEFAULT_IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
		}
    }
    
	public void refreshPage() {
		log.entry();
		waitForPageLoaded();
		driver.navigate().refresh();
		log.exit();
	}
	
	/**
	 * Click keyboard enter key
	 * @param element
	 */
	public void clickEnter(WebElement element) {
		log.entry();
		element.sendKeys(Keys.ENTER);
		log.info("Enter key is press.");
		log.exit();
	}
	
	/**
	 * Explicitly wait for an element to appear
	 */
	public void explicitWait() {
		log.entry();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		log.exit();
	}
	
	/**
	 * Explicitly wait for an element to appear
	 */
	public void explicitWaitSNOW() {
		log.entry();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		log.exit();
	}
	
	/**
     * Check if button is selected
     * Used in:
     * -Selecting Days in Suppression Condition
     * -Selecting Roles in Access Management
     */
    public boolean isButtonSelected(By locator) {
    	try {
            driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
            WebElement weElement = driver.findElement(locator);
    		weElement.isDisplayed();
            return true;
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            log.error(ELEMENT_NOT_FOUND, e);
            return false;
        } catch (Exception e) {
            log.error(GENERIC_EXCEPTION_OCCURRED, e);
            return false;
        } finally {
            driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
        }
    }
}
