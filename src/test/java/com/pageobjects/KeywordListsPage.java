package com.pageobjects;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class KeywordListsPage extends BasePage {
	
	private static final Logger log = LogManager.getLogger(KeywordListsPage.class);
	
	
	/* Page Elements */
	
	@FindBy(css= "div[class='keywords-maintenance']")
	private WebElement page_keywordLists;
	
	@FindBy(xpath= "//button[@class='btn btn-primary']")
	private WebElement btn_newKeywordLists;
	
	@FindBy(xpath= "//label[contains(text(), 'List name:')]//following::div[@class='col-sm'][1]//input[@class='form-control']")
	private WebElement fld_listName;
	
	@FindBy(xpath= "//label[contains(text(), 'Keywords:')]//following::div[text()='Add set of keywords...']//following::input[1]")
	private WebElement fld_keyword;
	
	@FindBy(xpath= "//div[@class='col-sm pl-0 pr-3']//button[@class='btn btn-primary btn-block']")
	private WebElement btn_add;
	
	@FindBy(xpath= "//button[text()='Save']")
	private WebElement btn_save;
	
	@FindBy(xpath= "//label[contains(text(), 'New keyword list successfully saved.')]")
	private WebElement lbl_keywordSavedSuccessfully;
	
	@FindBy(xpath= "//label[contains(text(), 'Keyword list successfully updated.')]")
	private WebElement lbl_keywordEditedSuccessfully;
	
	@FindBy(xpath= "//button[text()='Cancel']")
	private WebElement btn_cancel;
	
	@FindBy(xpath= "//button[text()='Delete']")
	private WebElement btn_delete;
	
	@FindBy(xpath= "//div[contains(text(), 'List name cannot be empty.')]")
	private WebElement lbl_keywordSavedUnSuccessfully;
	
	@FindBy(xpath= "//button[text()='Clear']")
	private WebElement btn_clear;
	
	
	/* Methods */
	
	/**
	 * Navigate to Keyword Lists Page
	 */
	public void verifySuccessfulNavigationToKeywordListsPage() {
		log.entry();
		driverHelper.embedScreenshot(scenario);
		Assert.assertTrue("Unsuccessful navigation to Keyword Lists Page", driverHelper.isElementPresent(page_keywordLists));
		log.exit();
	}
	
	/**
	 * Add new Keyword List
	 */
	public void clickNewKeywordListButton() {
		log.entry();
		if(driverHelper.isElementPresent(btn_newKeywordLists)) {
			driverHelper.embedScreenshot(scenario);
			driverHelper.clickButton(btn_newKeywordLists);
		} else {
			Assert.assertTrue("New Keyword List button is not present.", driverHelper.isElementPresent(btn_newKeywordLists));
		}
		log.exit();
	}
	
	/**
	 * Input Keyword List name
	 */
	public void inputListName(String listName) {
		log.entry();
		if(driverHelper.isElementPresent(fld_listName)) {
			driverHelper.clearText(fld_listName);
			driverHelper.inputFieldValue(fld_listName, listName);
			driverHelper.embedScreenshot(scenario);
		} else {
			Assert.assertTrue("List Name field is not present.", driverHelper.isElementPresent(fld_listName));
		}
		log.exit();
	}
	
	/**
	 * Input Keywords
	 */
	public void inputKeywords(String keyword) {
		log.entry();
		By fld_keyword_click = By.xpath("//label[contains(text(), 'Keywords:')]//following::div[text()='Add set of keywords...']");
		
		if(driverHelper.isElementPresent(fld_keyword)) {
			driverHelper.clickButton(fld_keyword_click);
			driverHelper.inputFieldValue(fld_keyword, keyword);
			clickAddIcon();
			driverHelper.embedScreenshot(scenario);
		} else {
			Assert.assertTrue("Keyword field is not present.", driverHelper.isElementPresent(fld_keyword));
		}
		log.exit();
	}
	
	/**
	 * Click add icon
	 */
	public void clickAddIcon() {
		log.entry();
		if(driverHelper.isElementPresent(btn_add)) {
			driverHelper.embedScreenshot(scenario);
			driverHelper.clickButton(btn_add);
		} else {
			Assert.assertTrue("Add icon is not present.", driverHelper.isElementPresent(btn_add));
		}
		log.exit();
	}
	
	/**
	 * Click save button
	 */
	public void clickSaveButton() {
		log.entry();
		if(driverHelper.isElementPresent(btn_save)) {
			driverHelper.embedScreenshot(scenario);
			driverHelper.clickButton(btn_save);
			driverHelper.explicitWait();
		} else {
			Assert.assertTrue("Save button is not present.", driverHelper.isElementPresent(btn_save));
		}
		log.exit();
	}
	
	/**
	 * Verify if keyword list saved successfully
	 * @param keywordListName
	 */
	public void verifyKeywordListIsSaved(String keywordListName, boolean shouldBeSaved) {
		log.entry();
		boolean isKeywordListSaved = false;
		
		if(driverHelper.isElementPresent(lbl_keywordSavedSuccessfully)) {
			isKeywordListSaved = true;
		} else {
			isKeywordListSaved = false;
		}
		
		if(isKeywordListSaved != shouldBeSaved) {
			Assert.assertTrue(keywordListName + " is saved? Expected: " + shouldBeSaved + " Actual: " + isKeywordListSaved, false);
		} else {
			driverHelper.clickButton(btn_cancel);
			driverHelper.explicitWait();
			isKeywordListPresent(keywordListName, shouldBeSaved);
		}
		log.exit();
	}
	
	/**
	 * Check if keyword list is present on the keyword table
	 * @param keywordListName
	 * @return
	 */
	public void isKeywordListPresent(String keywordListName, boolean shouldBePresent) {
		log.entry();
		boolean isKeywordListPresent = false;
		
		//Check if Keyword List is in the table
		if(keywordListIsInTable(keywordListName)) {
			isKeywordListPresent = true;
		} else {
			isKeywordListPresent = false;
		}
		
		if(isKeywordListPresent != shouldBePresent) {
			Assert.assertTrue(keywordListName + " is present? Expected: " + shouldBePresent + " Actual: " + isKeywordListPresent, false);
		}
		log.exit();
	}
	
	/**
	 * Check if keyword list is present on the keyword table
	 * @param keywordListName
	 * @return
	 */
	private boolean keywordListIsInTable(String keywordListName) {
		log.entry();
		By col_keywords = By.xpath("//table[@class='table table-sm table-bordered table-hover table-striped']//td[2]");
		List<WebElement> list_keywords = driver.findElements(col_keywords);
		boolean isPresent = false;
		
		for (WebElement webElement : list_keywords) {
			String keyword = webElement.getText();
			if(keyword.equalsIgnoreCase(keywordListName)) {
				isPresent = true;
			}
		}
		log.exit();
		return isPresent;
	}
	
	/**
	 * Select Keyword in the list
	 */
	public void selectKeywordInList(String name) {
		log.entry();
		By fld_name = By.xpath("//td[text()='" + name + "']");
		
		if(driverHelper.isElementPresent(fld_name)) {
			driverHelper.clickButton(fld_name);
			driverHelper.waitForPageLoaded();	
		} else {
			Assert.assertTrue("Keyword is not present.", driverHelper.isElementPresent(fld_name));
		}
		log.exit();
	}
	
	/**
	 * Verify if keyword list edited successfully
	 * @param keywordValue
	 */
	public void verifyKeywordListIsEdited(String keywordValue) {
		log.entry();
		Assert.assertTrue("Keyword List not edited successfully.", driverHelper.isElementPresent(lbl_keywordEditedSuccessfully));
		log.exit();
	}
	
	/**
	 * Click Delete keyword Button
	 */
	public void clickDeleteKeywordButton() {
		log.entry();
		if(driverHelper.isElementPresent(btn_delete)) {
			driverHelper.clickButton(btn_delete);
			driverHelper.explicitWait();
			driverHelper.embedScreenshot(scenario);
		} else {
			Assert.assertTrue("Delete keyword button is not present.", driverHelper.isElementPresent(btn_delete));
		}
		log.exit();
	}
	
	/**
	 * Click Clear Button
	 */
	public void clickClearButton() {
		log.entry();
		if(driverHelper.isElementPresent(btn_clear)) {
			driverHelper.clickButton(btn_clear);
			driverHelper.embedScreenshot(scenario);
		} else {
			Assert.assertTrue("Clear button is not present.", driverHelper.isElementPresent(btn_clear));
		}
		log.exit();
	}
	
}
