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
	
	@FindBy(css= "button[class='btn btn-primary']")
	private WebElement btn_newKeywordLists;
	
	@FindBy(xpath= "//label[contains(text(), 'List name:')]//following::div[@class='col-sm'][1]//input[@class='form-control']")
	private WebElement fld_listName;
	
	@FindBy(xpath= "//label[contains(text(), 'Keywords:')]//following::div[@class='col-sm-10 pr-0'][1]//input[@class='form-control']")
	private WebElement fld_keyword;
	
	@FindBy(css= "div[class='col-sm pl-0 pr-3'] button[class='btn btn-primary btn-block']")
	private WebElement btn_add;
	
	@FindBy(css= "div[class='col-sm pl-0'] button[class='btn btn-primary btn-block']")
	private WebElement btn_save;
	
	@FindBy(xpath= "//label[contains(text(), 'New keyword list successfully saved.')]")
	private WebElement lbl_keywordSavedSuccessfully;
	
	@FindBy(xpath= "//label[contains(text(), 'Keyword list successfully updated.')]")
	private WebElement lbl_keywordEditedSuccessfully;
	
	@FindBy(css= "div[class='col-sm pr-0 mr-1'] button[class='btn btn-secondary btn-block']")
	private WebElement btn_cancel;
	
	@FindBys(value = @FindBy (xpath = "//table[@class='table table-sm table-bordered table-hover table-striped']//td[2]"))
	private List<WebElement> list_keywords;
	
	@FindBy(xpath= "//button[text()='Delete']")
	private WebElement btn_delete;
	
	@FindBy(xpath= "//div[contains(text(), 'List name cannot be empty.')]")
	private WebElement lbl_keywordSavedUnSuccessfully;
	
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
		driverHelper.explicitWait();
		if(driverHelper.isElementPresent(btn_newKeywordLists)) {
			driverHelper.embedScreenshot(scenario);
			driverHelper.clickButton(btn_newKeywordLists);
			log.exit();
		} else {
			System.out.println("New Keyword List button is not present.");
			log.exit();
		}
	}
	
	/**
	 * Input Keyword List name
	 */
	public void inputListName(String listName) {
		log.entry();
		if(driverHelper.isElementPresent(fld_listName)) {
			fld_listName.clear();
			driverHelper.inputFieldValue(fld_listName, listName);
			driverHelper.embedScreenshot(scenario);
			log.exit();
		} else {
			System.out.println("List Name field is not present.");
			log.exit();
		}
	}
	
	/**
	 * Input Keywords
	 */
	public void inputKeywords(String keyword) {
		log.entry();
		if(driverHelper.isElementPresent(fld_keyword)) {
			driverHelper.inputFieldValue(fld_keyword, keyword);
			driverHelper.embedScreenshot(scenario);
			log.exit();
		} else {
			System.out.println("Keyword field is not present.");
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
			System.out.println("Add icon is not present.");
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
			System.out.println("Save button is not present.");
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
			System.out.println("Keyword is not present.");
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
			System.out.println("Delete keyword button is not present.");
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
}