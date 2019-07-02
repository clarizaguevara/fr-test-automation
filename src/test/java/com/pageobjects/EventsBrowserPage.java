package com.pageobjects;

import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import com.utils.DataHelper;

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
	
	@FindBy(xpath= "//label[text()='Status:']//following::select")
	private WebElement fld_alertStatus;
	
	@FindBys(value = @FindBy (xpath = "//label[text()='Status:']//following::select//option"))
	private List<WebElement> list_alertStatus;
	
	@FindBy(id= "event-id-filter")
	private WebElement fld_eventId;
	
	
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
			driverHelper.clearText(fld_timestampFrom);
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
			driverHelper.clearText(fld_timestampTo);
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
			driverHelper.embedScreenshot(scenario);
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
		String abbr_source = DataHelper.convertSourceName(source);
		List<WebElement> list_search_source = driver.findElements(search_source);
		for (WebElement searchEntry : list_search_source) {
			Assert.assertTrue("Values do not match", (searchEntry.getText()).equals(abbr_source)); 
		}
		log.exit();
	}
	
	/**
	 * Verify date of search results
	 */
	public void verifyDateOfSearchResults(String timestampFrom, String timestampTo) {
		log.entry();
		String timestampFormat_search = "MM/dd/yyyy HH:mm:ss";
		String timestampFormat_field = "MM/dd/yyyy HH:mm";
		Date dtToCompare = null;
		Date dtTimestampFrom = DataHelper.parseDateTime(timestampFormat_field, timestampFrom);
		Date dtTimestampTo = DataHelper.parseDateTime(timestampFormat_field, timestampTo);
		By search_date = By.xpath("//tbody//tr//td[3]");
		
		List<WebElement> list_search_date = driver.findElements(search_date);
		for (WebElement searchEntry : list_search_date) {
			dtToCompare = DataHelper.parseDateTime(timestampFormat_search, searchEntry.getText());
			Assert.assertTrue("Date is not in range", dtToCompare.compareTo(dtTimestampFrom) >= 0 && dtToCompare.compareTo(dtTimestampTo) <= 0); 
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
		for (WebElement searchEntry : list_btn_payload) {
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
	
	/**
	 * Verify From and To timestamps
	 */
	public void verifyFromAndToTimestamps() {
		log.entry();
		String timestampFormat = "MM/dd/yyyy HH:mm";
		Date dtTimestampFrom = DataHelper.parseDateTime(timestampFormat, fld_timestampFrom.getAttribute("value"));
		Date dtTimestampTo = DataHelper.parseDateTime(timestampFormat, fld_timestampTo.getAttribute("value"));
		
		Assert.assertTrue("From date is greater than To date", dtTimestampFrom.before(dtTimestampTo)); 
		log.exit();
	}
	
	/**
	 * Select Status
	 */
	public void selectStatus(String status) {
		log.entry();
		if(driverHelper.isElementPresent(fld_alertStatus)) {
			driverHelper.clickButton(fld_alertStatus);
			driverHelper.setValueDropdown(list_alertStatus, fld_alertStatus, status);
			driverHelper.embedScreenshot(scenario);
			log.exit();
		} else {
			System.out.println("Status field is not present.");
			log.exit();
		}
	}
	
	/**
	 * Verify status of search results
	 */
	public void verifyStatusOfSearchResults(String status) {
		log.entry();
		By success_filters = By.xpath("//tbody//tr//td[5]");
		By partial_filters = By.xpath("//tbody//tr//td[6]");
		By failed_filters = By.xpath("//tbody//tr//td[7]");
		By success_actions = By.xpath("//tbody//tr//td[8]");
		By failed_actions = By.xpath("//tbody//tr//td[9]");
		
		//Check the row color
		checkRowColor(status);
		
		//Check filter and action count
		if(status.equals("Success")) {
			checkCountIfNotZero(success_filters);
			checkCountIfZero(partial_filters);
			checkCountIfZero(failed_filters);
			checkCountIfNotZero(success_actions);
			checkCountIfZero(failed_actions);
		}
		else if(status.equals("Partially Successful")) {
			checkCountIfNotZero(success_filters);
			checkCountIfNotZero(partial_filters);
			checkCountIfNotZero(failed_filters);
			checkCountIfNotZero(success_actions);
			checkCountIfNotZero(failed_actions);
		}
		else if(status.equals("Failed")) {
			checkCountIfZero(success_filters);
			checkCountIfZero(partial_filters);
			checkCountIfNotZero(failed_filters);
			checkCountIfZero(success_actions);
			checkCountIfNotZero(failed_actions);
		}
		else if(status.equals("No Action")) {
			checkCountIfZero(success_filters);
			checkCountIfZero(partial_filters);
			checkCountIfZero(failed_filters);
			checkCountIfZero(success_actions);
			checkCountIfZero(failed_actions);
		}
		
		log.exit();
	}
	
	private void checkRowColor(String status) {
		log.entry();
		String statusColor = "";
		By row_count = By.xpath("//tbody//tr[@class]");
		
		if(!(status.equals("No Action"))) {
			statusColor = "row-" + DataHelper.convertToStatusColor(status);
		}
		
		if(driverHelper.isElementPresent(row_count)) {
			List<WebElement> list_row_count = driver.findElements(row_count);
			if(list_row_count.size() != 0) {
				for (WebElement searchEntry : list_row_count) {
					Assert.assertTrue("Row is not present for status: " + status, (searchEntry.getAttribute("class")).equals(statusColor));
				}
			}
		}
		
		log.exit();
	}
	
	private void checkCountIfZero(By byElement) {
		log.entry();
		if(driverHelper.isElementPresent(byElement)) {
			List<WebElement> list_element_count = driver.findElements(byElement);
			if(list_element_count.size() != 0) {
				for (WebElement searchEntry : list_element_count) {
					Assert.assertTrue("Count not equal to zero", "0".equals(searchEntry.getText()));
				}
			}
		}
		log.exit();
	}
	
	private void checkCountIfNotZero(By byElement) {
		log.entry();
		if(driverHelper.isElementPresent(byElement)) {
			List<WebElement> list_element_count = driver.findElements(byElement);
			if(list_element_count.size() != 0) {
				for (WebElement searchEntry : list_element_count) {
					Assert.assertTrue("Count is equal to zero", !("0".equals(searchEntry.getText())));
				}
			}
		}
		log.exit();
	}
	
	/**
	 * Verify that Event Id field is present
	 */
	public void isEventIdFieldPresent() {
		log.entry();
		Assert.assertTrue("Event Id field is not present", driverHelper.isElementPresent(fld_eventId));
		log.exit();
	}
	
	/**
	 * Input Event ID
	 */
	public void inputEventId(String eventId) {
		log.entry();
		if(driverHelper.isElementPresent(fld_eventId)) {
			driverHelper.clearText(fld_eventId);
			driverHelper.inputFieldValue(fld_eventId, eventId);
			driverHelper.embedScreenshot(scenario);
			log.exit();
		} else {
			System.out.println("Event ID field is not present.");
		}
		log.exit();
	}
	
	/**
	 * Verify event id of search results
	 */
	public void verifyEventIdOfSearchResults(String eventId) {
		log.entry();
		By search_eventId = By.xpath("//tbody//tr//td[1]");
		List<WebElement> list_search_eventId = driver.findElements(search_eventId);
		for (WebElement searchEntry : list_search_eventId) {
			Assert.assertTrue("Values are not equal", (searchEntry.getText()).equals(eventId)); 
		}
		log.exit();
	}
	
	/**
	 * Verify format of timestamps
	 */
	public void verifyTimestampFormat(String format) {
		log.entry();
		By search_timestamp = By.xpath("//tbody//tr//td[3]");
		String strDate = "";
		Date dtDate = null;
		
		List<WebElement> list_search_timestamp = driver.findElements(search_timestamp);
		for (WebElement searchEntry : list_search_timestamp) {
			dtDate = DataHelper.parseDateTime(format, searchEntry.getText());
			strDate = DataHelper.formatDateTime(format, dtDate);
			//log.info(searchEntry.getText() + " " + strDate);
			Assert.assertTrue("Values are not equal", (searchEntry.getText()).equals(strDate)); 
		}
		log.exit();
	}

}
