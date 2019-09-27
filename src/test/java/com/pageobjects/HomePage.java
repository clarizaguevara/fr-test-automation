package com.pageobjects;

import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import com.utils.DataHelper;

public class HomePage extends BasePage{

	private static final Logger log = LogManager.getLogger(HomePage.class);
	
	/* Page Elements */
	@FindBy(css= "div[class='browse-page']")
	private WebElement page_browse;
	
	@FindBy(xpath= "//a[contains (text(), 'Home')]")
	private WebElement btn_Home;
	
	@FindBy(xpath= "//input[@placeholder='Filter title...']")
	private WebElement fld_filterTitle;
	
	@FindBy(xpath= "//button[text()='Apply']")
	private WebElement btn_Apply;
	
	@FindBy(xpath= "//a[text()='Events']")
	private WebElement btn_events;
	
	@FindBy(xpath= "//a[text()='Maintenance']")
	private WebElement btn_maintenance;
	
	@FindBy(xpath= "//a[text()='Access Management']")
	private WebElement btn_accessmanagement;
	
	@FindBy(xpath= "//a[text()='Keyword Lists']")
	private WebElement btn_keywordlists;
	
	@FindBy(xpath= "//a[text()='Templates Management']")
	private WebElement btn_templatesmanagement;
	
	@FindBy(xpath= "//button[contains (text(), ' Create New Filter')]")
	private WebElement btn_createNewFilter;
	
	@FindBy(xpath= "//label[text()='Source:']//following::select")
	private WebElement fld_filterSource;
	
	@FindBys(value = @FindBy (xpath = "//label[text()='Source:']//following::select//option"))
	private List<WebElement> list_filterSource;
	
	@FindBy(xpath= "//label[text()='Status:']//following::select")
	private WebElement fld_filterStatus;
	
	@FindBys(value = @FindBy (xpath = "//label[text()='Status:']//following::select//option"))
	private List<WebElement> list_filterStatus;
	
	@FindBy(xpath= "//div[@role='combobox']//input")
	private WebElement fld_category;
	
	@FindBy(xpath= "//div[@role='combobox']//following::i[@class='dropdown icon']")
	private WebElement btn_category;
	
	@FindBy(xpath= "//a[@href='/events']")
	private WebElement btn_eventspage;
	
	/* Methods */
	
	/**
	 * Navigate to Home Page
	 */
	public void verifySuccessfulNavigationToHomePage() {
		log.entry();
		Assert.assertTrue("Unsuccessful navigation in Command Center Home Page", driverHelper.isElementPresent(page_browse));
		driverHelper.explicitWait();
		driverHelper.embedScreenshot(scenario);
		log.exit();
	}
	
	/**
	 * Click Home Button
	 */
	public void clickHomeButton() {
		log.entry();
		if(driverHelper.isElementPresent(btn_Home)) {
			driverHelper.clickButton(btn_Home);
		} else {
			Assert.assertTrue("Home Button is not present.", driverHelper.isElementPresent(btn_Home));
		}
		log.exit();
	}
	
	/**
	 *Input Filter title to search
	 */
	public void inputFilterTitle(String filterName) {
		log.entry();
		if(driverHelper.isElementPresent(fld_filterTitle)) {
			driverHelper.inputFieldValue(fld_filterTitle, filterName);
			driverHelper.embedScreenshot(scenario);
		} else {
			Assert.assertTrue("Filter Title field is not present.", driverHelper.isElementPresent(fld_filterTitle));
		}
		log.exit();
	}
	
	/**
	 * Click Apply Button
	 */
	public void clickApplyButton() {
		log.entry();
		if(driverHelper.isElementPresent(btn_Apply)) {
			driverHelper.clickButton(btn_Apply);
			driverHelper.explicitWait();
			driverHelper.embedScreenshot(scenario);
		} else {
			Assert.assertTrue("Apply Button is not present.", driverHelper.isElementPresent(btn_Apply));
		}
		log.exit();
	}
	
	/**
	 * Select Filter in the list
	 */
	public void selectFilterInList(String filterName) {
		log.entry();
		inputFilterTitle(filterName);
		clickApplyButton();
		By fld_filter = By.xpath("//td[text()='" + filterName + "']//following::td[1]");
		if(driverHelper.isElementPresent(fld_filter)) {
			driverHelper.clickButton(fld_filter);
			driverHelper.waitForPageLoaded();	
		} else {
			Assert.assertTrue(filterName + " is not present.", driverHelper.isElementPresent(fld_filter));
		}
		log.exit();
	}
	
	/**
	 * Verify if Filter is in browse page
	 */
	public void verifyIfFilterIsPresent(String filterName, boolean shouldBePresent) {
		log.entry();
		By fld_filter = By.xpath("//td[text()='" + filterName + "']");
		boolean isFilterPresent = false;
		
		if(driverHelper.isElementPresent(fld_filter)) {
			isFilterPresent = true;
		} else {
			isFilterPresent = false;
		}
		
		if(isFilterPresent != shouldBePresent) {
			Assert.assertTrue(filterName + " is present? Expected: " + shouldBePresent + " Actual: " + isFilterPresent, false);
		}
		
		log.exit();
	}
	
	/**
	 * Click Events tab
	 */
	public void clickEventsTab() {
		log.entry();
		if(driverHelper.isElementPresent(btn_events)) {
			driverHelper.clickButton(btn_events);
			clickEventsPage();
		} else {
			Assert.assertTrue("Events tab is not present.", driverHelper.isElementPresent(btn_events));
		}
		log.exit();
	}
	
	/**
	 * Click Events page
	 */
	public void clickEventsPage() {
		log.entry();
		if(driverHelper.isElementPresent(btn_eventspage)) {
			driverHelper.clickButton(btn_eventspage);
			driverHelper.explicitWait();
		} else {
			Assert.assertTrue("Events page is not present.", driverHelper.isElementPresent(btn_eventspage));
		}
		log.exit();
	}
	
	/**
	 * Click Maintenance pages
	 */
	public void clickMaintenanceTab(String maintenance_page) {
		log.entry();
		WebElement wE_page = null;
		
		if(driverHelper.isElementPresent(btn_maintenance)) {
			driverHelper.clickButton(btn_maintenance);
			
			switch(maintenance_page) {
			case "Access Management": wE_page = btn_accessmanagement; break;
			case "Keyword Lists": wE_page = btn_keywordlists; break;
			case "Templates Management": wE_page = btn_templatesmanagement; break;
			default: break;
			}
			
			if(driverHelper.isElementPresent(wE_page)) {
				driverHelper.clickButton(wE_page);
				driverHelper.explicitWait();
				driverHelper.embedScreenshot(scenario);
			} else {
				Assert.assertTrue(maintenance_page + " is not present.", driverHelper.isElementPresent(wE_page));
			}
			
		} else {
			Assert.assertTrue("Maintenance tab is not present.", driverHelper.isElementPresent(btn_maintenance));
		}
		
		log.exit();
	}
	
	/**
	 * Click Create New Filter Button
	 */
	public void clickCreateNewFilterButton() {
		log.entry();
		if(driverHelper.isElementPresent(btn_createNewFilter)) {
			driverHelper.clickButton(btn_createNewFilter);
		} else {
			Assert.assertTrue("Create New Filter Button is not present.", driverHelper.isElementPresent(btn_createNewFilter));
		}
		log.exit();
	}
	
	/**
	 * Verify source of search results
	 */
	public void verifySourceOfSearchResults(String source) {
		log.entry();
		By search_source = By.xpath("//tbody//tr//td[3]");
		String abbr_source = DataHelper.convertSourceName(source);
		for (WebElement searchEntry : driver.findElements(search_source)) {
			Assert.assertTrue("Values do not match", (searchEntry.getText()).equals(abbr_source)); 
		}
		log.exit();
	}
	
	/**
	 * Select Source
	 */
	public void selectSource(String source) {
		log.entry();
		if(driverHelper.isElementPresent(fld_filterSource)) {
			driverHelper.clickButton(fld_filterSource);
			driverHelper.setValueDropdown(list_filterSource, fld_filterSource, source);
			driverHelper.embedScreenshot(scenario);
		} else {
			Assert.assertTrue("Source field is not present.", driverHelper.isElementPresent(fld_filterSource));
		}
		log.exit();
	}
	
	/**
	 * Verify filter name of search results
	 */
	public void verifyFilterNameOfSearchResults(String name) {
		log.entry();
		By search_source = By.xpath("//tbody//tr//td[2]");
		for (WebElement searchEntry : driver.findElements(search_source)) {
			Assert.assertTrue("Filter name does not contain keyword", ((searchEntry.getText()).toUpperCase()).contains(name.toUpperCase())); 
		}
		log.exit();
	}
	
	/**
	 * Verify status of search results
	 */
	public void verifyStatusOfSearchResults(String status) {
		log.entry();
		By search_status = By.xpath("//tbody//tr//td[4]");
		for (WebElement searchEntry : driver.findElements(search_status)) {
			Assert.assertTrue("Wrong status searched. Status: " + status + " Search result: " + searchEntry.getText(), (searchEntry.getText()).equals(status)); 
		}
		log.exit();
	}
	
	/**
	 * Select Status
	 */
	public void selectStatus(String status) {
		log.entry();
		if(driverHelper.isElementPresent(fld_filterStatus)) {
			driverHelper.clickButton(fld_filterStatus);
			driverHelper.setValueDropdown(list_filterStatus, fld_filterStatus, status);
			driverHelper.embedScreenshot(scenario);
		} else {
			Assert.assertTrue("Status field is not present.", driverHelper.isElementPresent(fld_filterStatus));
		}
		log.exit();
	}
	
	/**
	 * Input Categories
	 */
	public void inputCategory(String categories) {
		log.entry();
		if(driverHelper.isElementPresent(fld_category)) {
			
			if(driverHelper.isElementPresent(btn_category)) {
				driverHelper.clickButton(btn_category);
			} else {
				Assert.assertTrue("Category field button is not present.", driverHelper.isElementPresent(btn_category));
			}
			
			categories = categories.replaceAll("\\[|\\]|\\s", "");
			List<String> list_categories = Arrays.asList(categories.split(","));
			
			for (String category : list_categories) {
				driverHelper.inputFieldValue(fld_category, category);
				driverHelper.clickEnter(fld_category);
			}
			
			driverHelper.embedScreenshot(scenario);
			
		} else {
			Assert.assertTrue("Category field is not present.", driverHelper.isElementPresent(fld_category));
		}
		
		log.exit();
	}
	
	/**
	 * Click Delete Button of Categories
	 */
	public void removeCategory(String categories) {
		log.entry();
		categories = categories.replaceAll("\\[|\\]|\\s", "");
		List<String> list_categories = Arrays.asList(categories.split(","));
		
		for (String category : list_categories) {
			By btn_delete_category = By.xpath("//a[text()='" + category + "']//i");
			if(driverHelper.isElementPresent(btn_delete_category)) {
				driverHelper.clickButton(btn_delete_category);
				driverHelper.embedScreenshot(scenario);
			} else {
				Assert.assertTrue("Delete Button of Category is not present.", driverHelper.isElementPresent(btn_delete_category));
			}
		}
		log.exit();
	}
	
	/**
	 * Verify Categories of search result
	 */
	public void verifyCategoryOfSearchResults(String categories) {
		log.entry();
		categories = categories.replaceAll("\\[|\\]|\\s", "");
		List<String> list_categories = Arrays.asList(categories.split(","));
		By column_category = By.xpath("//tbody//tr//td[5]");
		boolean isSearched = false;
		
		for (WebElement searchEntry : driver.findElements(column_category)) {
			isSearched = false;
			//log.info("category column: " + searchEntry.getText());
			for (String category : list_categories) {
				String lbl_category = "[" + category + "]";
				if((searchEntry.getText()).contains(lbl_category)){
					isSearched = true;
					//log.info("entry has category: " + lbl_category);
				} 
			}
			Assert.assertTrue("Wrong category is in the search list", isSearched);
		}
		log.exit();
	}
}
