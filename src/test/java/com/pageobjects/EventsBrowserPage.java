package com.pageobjects;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class EventsBrowserPage extends BasePage {
	
private static final Logger log = LogManager.getLogger(EventsBrowserPage.class);

	
	/* Page Elements */
	
	@FindBy(css= "div[class='events-browser-page']")
	private WebElement page_eventsBrowser;
	
	@FindBy(xpath= "//label[text()='Source:']//following::select")
	private WebElement fld_alertSource;
	
	@FindBys(value = @FindBy (xpath = "//label[text()='Source:']//following::select//option"))
	private List<WebElement> list_alertSource;
	
	@FindBy(xpath= "//label[text()='From']//following::div[@class='react-datepicker__input-container'][1]//input")
	private WebElement fld_timestampFrom;
	
	@FindBy(xpath= "//label[text()='From']//following::div[@class='react-datepicker__input-container'][2]//input")
	private WebElement fld_timestampTo;
	
	@FindBy(xpath= "//button[text()='Apply']")
	private WebElement btn_apply;
	
	@FindBy(xpath= "//button[text()='Back']")
	private WebElement btn_back;
	
	@FindBys(value = @FindBy (xpath = "//tbody//tr//td[3]"))
	private List<WebElement> list_search_timestamp;
	
	@FindBy(xpath= "//div[@class='card-body']")
	private WebElement page_payloadinfo;
	
	@FindBy(xpath= "//strong[text()='Payload Info']")
	private WebElement label_payloadinfo;
	
	@FindBy(css= "div[class='overlay-backdrop']")
	private WebElement page_backdrop;
	
	@FindBy(xpath= "//tbody//tr//td[1]")
	private WebElement link_eventid;
	
	@FindBy(xpath= "//h4[contains(text(),'Filter Details for Event')]")
	private WebElement label_filterdetails;
	
	@FindBy(xpath= "//h4[contains(text(),'Filter Details')]//following::tbody//tr//td[2]")
	private WebElement link_filtername;
	
	@FindBy(xpath= "//h4[contains(text(),'Action Details for Filter')]")
	private WebElement label_actiondetails;
	
	@FindBy(xpath= "//h4[contains(text(),'Action Details')]//following::tbody//tr//td[1]")
	private WebElement link_action;
	
	@FindBy(xpath= "//h4[contains(text(),'Payload')]")
	private WebElement label_payloaddetails;
	
	
	/* Methods */
	
	/**
	 * Navigate to Events Browser Page
	 */
	public void verifySuccessfulNavigationToEventsBrowserPage() {
		log.entry();
		driverHelper.embedScreenshot(scenario);
		Assert.assertTrue("Unsuccessful navigation to Events Browser Page", driverHelper.isElementPresent(page_eventsBrowser));
		log.exit();
	}
	
	/**
	 * Select Source
	 */
	public void selectSource(String source) {
		log.entry();
		if(driverHelper.isElementPresent(fld_alertSource)) {
			driverHelper.clickButton(fld_alertSource);
			driverHelper.setValueDropdown(list_alertSource, fld_alertSource, source);
			driverHelper.embedScreenshot(scenario);
			log.exit();
		} else {
			System.out.println("Source field is not present.");
			log.exit();
		}
	}
	
	/**
	 * Input From timestamp
	 */
	public void inputTimestampFrom(String timestampFrom) {
		log.entry();
		if(driverHelper.isElementPresent(fld_timestampFrom)) {
			fld_timestampFrom.clear();
			driverHelper.inputFieldValue(fld_timestampFrom, timestampFrom);
			driverHelper.clickEnter(fld_timestampFrom);
			driverHelper.embedScreenshot(scenario);
			log.exit();
		} else {
			System.out.println("From timestamp field is not present.");
		}
	}
	
	/**
	 * Input To timestamp
	 */
	public void inputTimestampTo(String timestampTo) {
		log.entry();
		if(driverHelper.isElementPresent(fld_timestampTo)) {
			fld_timestampTo.clear();
			driverHelper.inputFieldValue(fld_timestampTo, timestampTo);
			driverHelper.clickEnter(fld_timestampTo);
			driverHelper.embedScreenshot(scenario);
			log.exit();
		} else {
			System.out.println("To timestamp field is not present.");
		}
	}
	
	/**
	 * Click Apply Button
	 */
	public void clickApplyButton() {
		log.entry();
		if(driverHelper.isElementPresent(btn_apply)) {
			driverHelper.clickButton(btn_apply);
			driverHelper.waitForPageLoaded();
			driverHelper.explicitWait();
			log.exit();
		} else {
			System.out.println("Apply button is not present.");
			log.exit();
		}
	}
	
	/**
	 * Click Back Button
	 */
	public void clickBackButton() {
		log.entry();
		if(driverHelper.isElementPresent(btn_back)) {
			driverHelper.clickButton(btn_back);
			log.exit();
		} else {
			System.out.println("Back button is not present.");
			log.exit();
		}
	}
	
	/**
	 * Verify source of search results
	 */
	public void verifySourceOfSearchResults(String source) {
		log.entry();
		By search_source = By.xpath("//tbody//tr//td[2]");
		driverHelper.embedScreenshot(scenario);
		List<WebElement> list_search_source = driver.findElements(search_source);
		for (int counter = 0; counter < list_search_source.size(); counter++) {
			WebElement searchEntry = list_search_source.get(counter);
			System.out.println(searchEntry.getText());
			Assert.assertTrue("Values do not match", (searchEntry.getText()).equals(source)); 
		}
		log.exit();
	}
	
	/**
	 * Verify if events have payload info
	 */
	public void verifyPayloadInfo() {
		log.entry();
		By btn_payload = By.xpath("//tbody//tr//td[10]//i");
		List<WebElement> list_btn_payload = driver.findElements(btn_payload);
		Actions builder = new Actions(driver); 
		for (int counter = 0; counter < list_btn_payload.size(); counter++) {
			WebElement searchEntry = list_btn_payload.get(counter);
			if(driverHelper.isElementPresent(searchEntry)) {
				driverHelper.clickButton(searchEntry);
				driverHelper.waitForPageLoaded();
				Assert.assertTrue("Payload info is not present", driverHelper.isElementPresent(page_payloadinfo));
				Assert.assertTrue("Payload info is not present", driverHelper.isElementPresent(label_payloadinfo));
				driverHelper.embedScreenshot(scenario);
				builder.moveToElement(page_backdrop, 10, 25).click().build().perform();
			} else {
				System.out.println("Payload button is not present.");
				log.exit();
			}  
		}
		log.exit();
	}
	
	/**
	 * Click Event Id
	 */
	public void clickEventId() {
		log.entry();
		if(driverHelper.isElementPresent(link_eventid)) {
			driverHelper.clickButton(link_eventid);
			log.exit();
		} else {
			System.out.println("Event id link is not present.");
			log.exit();
		}
	}
	
	/**
	 * Verify if event has filter details
	 */
	public void verifyFilterDetails() {
        log.entry();
        driverHelper.embedScreenshot(scenario);
        Assert.assertTrue("Filter details is not present", driverHelper.isElementPresent(label_filterdetails));
//        By link_eventid = By.xpath("//tbody//tr//td[1]");
//		List<WebElement> list_link_eventid = driver.findElements(link_eventid);
//		String eventId = "";
//		for (int counter = 0; counter < list_link_eventid.size(); counter++) {
//			WebElement searchEntry = list_link_eventid.get(counter);
//			if(driverHelper.isElementPresent(searchEntry)) {
//				eventId = searchEntry.getText();
//				System.out.println(eventId);
//				driverHelper.clickButton(searchEntry);
//				driverHelper.waitForPageLoaded();
//				By label_filterDetails = By.xpath("//h4[text()='Filter Details for Event "+ eventId +"']");
//		        Assert.assertTrue("Filter details is not present", driverHelper.isElementPresent(label_filterDetails));
//				driverHelper.embedScreenshot(scenario);
//				btn_back.click();
//				driverHelper.waitForPageLoaded();
//			} else {
//				System.out.println("Event link is not present.");
//				log.exit();
//			}  
//		}
        log.exit();
	}
	
	/**
	 * Click Filter name
	 */
	public void clickFilterName() {
		log.entry();
		if(driverHelper.isElementPresent(link_filtername)) {
			driverHelper.clickButton(link_filtername);
			log.exit();
		} else {
			System.out.println("Filter link is not present.");
			log.exit();
		}
	}
	
	/**
	 * Verify if filter has action details
	 */
	public void verifyActionDetails() {
       log.entry();
       driverHelper.embedScreenshot(scenario);
       Assert.assertTrue("Action details is not present", driverHelper.isElementPresent(label_actiondetails));
       log.exit();
	}
	
	/**
	 * Click Action
	 */
	public void clickAction() {
		log.entry();
		if(driverHelper.isElementPresent(link_action)) {
			driverHelper.clickButton(link_action);
			log.exit();
		} else {
			System.out.println("Action link is not present.");
			log.exit();
		}
	}
	
	/**
	 * Verify if action has payload details
	 */
	public void verifyPayloadDetails() {
       log.entry();
       driverHelper.embedScreenshot(scenario);
       Assert.assertTrue("Payload details is not present", driverHelper.isElementPresent(label_payloaddetails));
       log.exit();
	}


}
