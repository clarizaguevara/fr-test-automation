package com.pageobjects;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

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
	
	@FindBys(value = @FindBy (xpath = "//table[@class='table table-sm table-bordered table-hover table-striped']//td[2]"))
	private List<WebElement> list_keywords;
	
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
			log.exit();
		} else {
			Assert.assertTrue("New Keyword List button is not present.", driverHelper.isElementPresent(btn_newKeywordLists));
			log.exit();
		}
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
			log.exit();
		} else {
			Assert.assertTrue("List Name field is not present.", driverHelper.isElementPresent(fld_listName));
			log.exit();
		}
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
			log.exit();
		} else {
			Assert.assertTrue("Keyword field is not present.", driverHelper.isElementPresent(fld_keyword));
			log.exit();
		}
	}
	
	/**
	 * Click add icon
	 */
	public void clickAddIcon() {
		log.entry();
		if(driverHelper.isElementPresent(btn_add)) {
			driverHelper.embedScreenshot(scenario);
			driverHelper.clickButton(btn_add);
			log.exit();
		} else {
			Assert.assertTrue("Add icon is not present.", driverHelper.isElementPresent(btn_add));
			log.exit();
		}
	}
	
	/**
	 * Click save button
	 */
	public void clickSaveButton() {
		log.entry();
		if(driverHelper.isElementPresent(btn_save)) {
			driverHelper.embedScreenshot(scenario);
			driverHelper.clickButton(btn_save);
			log.exit();
		} else {
			Assert.assertTrue("Save button is not present.", driverHelper.isElementPresent(btn_save));
			log.exit();
		}
	}
	
	/**
	 * Verify if keyword list saved successfully
	 * @param keywordValue
	 */
	public void verifyKeywordListIsSaved(String keywordValue) {
		log.entry();
		driverHelper.explicitWait();
		Assert.assertTrue("Keyword List not save successfully.", driverHelper.isElementPresent(lbl_keywordSavedSuccessfully));
		driverHelper.clickButton(btn_cancel);
		driverHelper.explicitWait();
		Assert.assertTrue("Keyword List not save successfully.", keywordListIsKeywordTable(keywordValue));
		log.exit();
	}
	
	/**
	 * Check if keyword list is present on the keyword table
	 * @param keywordValue
	 * @return
	 */
	public boolean keywordListIsKeywordTable(String keywordValue) {
		log.entry();
		for (WebElement webElement : list_keywords) {
			String keyword = webElement.getText();
			if(keyword.equalsIgnoreCase(keywordValue)) {
				log.exit();
				return true;
			}
		}
		return false;
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
			log.exit();
		}
		log.exit();
	}
	
	/**
	 * Verify if keyword list edited successfully
	 * @param keywordValue
	 */
	public void verifyKeywordListIsEdited(String keywordValue) {
		log.entry();
		driverHelper.explicitWait();
		Assert.assertTrue("Keyword List not edited successfully.", driverHelper.isElementPresent(lbl_keywordEditedSuccessfully));
		driverHelper.clickButton(btn_cancel);
		driverHelper.explicitWait();
		Assert.assertTrue("Keyword List not edited successfully.", keywordListIsKeywordTable(keywordValue));
		log.exit();
	}
	
	/**
	 * Click Delete keyword Button
	 */
	public void clickDeleteKeywordButton() {
		log.entry();
		if(driverHelper.isElementPresent(btn_delete)) {
			driverHelper.clickButton(btn_delete);
			driverHelper.waitForPageLoaded();
			driverHelper.explicitWait();
			log.exit();
		} else {
			Assert.assertTrue("Delete keyword button is not present.", driverHelper.isElementPresent(btn_delete));
			log.exit();
		}
	}
	
	/**
	 * Verify if keyword list deleted successfully
	 * @param keywordValue
	 */
	public void verifyKeywordListIsDeleted(String keywordValue) {
		log.entry();
		driverHelper.explicitWait();
		Assert.assertFalse("Keyword List not deleted successfully.", keywordListIsKeywordTable(keywordValue));
		log.exit();
	}
	
	/**
	 * Verify if keyword list is not saved
	 * @param keywordValue
	 */
	public void verifyKeywordListIsNotSaved() {
		log.entry();
		driverHelper.explicitWait();
		Assert.assertTrue("Keyword List saved successfully.", driverHelper.isElementPresent(lbl_keywordSavedUnSuccessfully));
		driverHelper.clickButton(btn_cancel);
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
			log.exit();
		} else {
			Assert.assertTrue("Clear button is not present.", driverHelper.isElementPresent(btn_clear));
			log.exit();
		}
	}
	
}
