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

public class CreateNewTemplatePage extends BasePage {
	
	private static final Logger log = LogManager.getLogger(CreateNewTemplatePage.class);

	
	/* Page Elements */
	
	@FindBy(xpath= "//label[text()='Template type:']//following::select")
	private WebElement fld_templateType;
	
	@FindBys(value = @FindBy (xpath = "//label[text()='Template type:']//following::select//option"))
	private List<WebElement> list_templateType;
	
	@FindBy(xpath= "//input[@placeholder ='Template name...']")
	private WebElement fld_templateName;
	
	@FindBy(xpath= "//button[contains(text(),'Apply Changes')]")
	private WebElement btn_ApplyChanges;
	
	@FindBy(xpath= "//div[contains(@class,'card align-self')]//div[@class='card-body']")
	private WebElement page_ApplyChangesPopUp;
	
	@FindBy(xpath= "//button[@aria-label='move selected right']")
	private WebElement btn_moveSelectedRight;
	
	@FindBy(xpath= "//div[@class='row']//following::div//button[text()='Apply']")
	private WebElement btn_ApplyChangesPopUp_Apply;
	
	@FindBy(xpath= "//div[@class='row']//following::div//button[text()='Cancel']")
	private WebElement btn_ApplyChangesPopUp_Cancel;
	
	
	/**
	 * Select Template Type
	 */
	public void selectTemplateType(String templateType) {
		log.entry();
		if(driverHelper.isElementPresent(fld_templateType)) {
			driverHelper.clickButton(fld_templateType);
			driverHelper.setValueDropdown(list_templateType, fld_templateType, templateType);
			driverHelper.embedScreenshot(scenario);
			log.exit();
		} else {
			Assert.assertTrue("Template Type field is not present", driverHelper.isElementPresent(fld_templateType));
			log.exit();
		}
	}
	
	/**
	 *Input Template Name
	 */
	public void inputTemplateName(String templateName) {
		log.entry();
		if(driverHelper.isElementPresent(fld_templateName)) {
			driverHelper.inputFieldValue(fld_templateName, templateName);
			driverHelper.embedScreenshot(scenario);
			log.exit();
		} else {
			Assert.assertTrue("Template Name field is not present", driverHelper.isElementPresent(fld_templateName));
			log.exit();
		}
	}
	
	/**
	 * Check Template Name
	 */
	public void checkTemplateName(String templateName) {
		log.entry();
		Assert.assertTrue("Values are not the same", (fld_templateName.getAttribute("value")).equals(templateName));
		log.exit();
	}
	
	/**
	 * Click Apply Changes Button
	 */
	public void clickApplyChangesButton() {
		log.entry();
		if(driverHelper.isElementPresent(btn_ApplyChanges)) {
			driverHelper.clickButton(btn_ApplyChanges);
			driverHelper.embedScreenshot(scenario);
			log.exit();
		} else {
			Assert.assertTrue("Apply Changes button is not present", driverHelper.isElementPresent(btn_ApplyChanges));
			log.exit();
		}
	}
	
	/**
	 * Apply Changes Pop up
	 */
	public void verifyApplyChangesPopUp() {
		log.entry();
		driverHelper.embedScreenshot(scenario);
		Assert.assertTrue("Apply Changes pop up is not present", driverHelper.isElementPresent(page_ApplyChangesPopUp));
		log.exit();
	}
	
	/**
	 * Click Move Selected - Right Button
	 */
	public void clickMoveSelectedRightButton() {
		log.entry();
		if(driverHelper.isElementPresent(btn_moveSelectedRight)) {
			driverHelper.clickButton(btn_moveSelectedRight);
			driverHelper.embedScreenshot(scenario);
			log.exit();
		} else {
			Assert.assertTrue("Move selected right button is not present", driverHelper.isElementPresent(btn_moveSelectedRight));
			log.exit();
		}
	}
	
	/**
	 * Click Apply Button (in Apply Changes pop up)
	 */
	public void clickApply() {
		log.entry();
		if(driverHelper.isElementPresent(btn_ApplyChangesPopUp_Apply)) {
			driverHelper.clickButton(btn_ApplyChangesPopUp_Apply);
			driverHelper.embedScreenshot(scenario);
			log.exit();
		} else {
			Assert.assertTrue("Apply button is not present", driverHelper.isElementPresent(btn_ApplyChangesPopUp_Apply));
			log.exit();
		}
	}
	
	/**
	 * Click Cancel Button (in Apply Changes pop up)
	 */
	public void clickCancel() {
		log.entry();
		if(driverHelper.isElementPresent(btn_ApplyChangesPopUp_Cancel)) {
			driverHelper.clickButton(btn_ApplyChangesPopUp_Cancel);
			driverHelper.embedScreenshot(scenario);
			log.exit();
		} else {
			Assert.assertTrue("Cancel button is not present", driverHelper.isElementPresent(btn_ApplyChangesPopUp_Cancel));
			log.exit();
		}
	}
	
	/**
	 * Verify filters in Apply Changes pop up
	 */
//	public void verifyFiltersToApply(String filters) {
//		log.entry();
//		eventIds = eventIds.replaceAll("\\[|\\]|\\s", "");
//		List<String> list_eventIds = Arrays.asList(eventIds.split(","));
//		By column_eventId = By.xpath("//table[contains(@class,'table-sm mini-table')]//tbody//tr//td[1]");
//		
//		if(!driverHelper.isElementPresent(column_eventId)) {
//			Assert.assertTrue("Events list is empty", driverHelper.isElementPresent(column_eventId));
//			log.exit();
//		} else {
//			List<WebElement> list_column_eventId = driver.findElements(column_eventId);
//			for (String eventId : list_eventIds) {
//				for (WebElement selected_eventId : list_column_eventId) {
//					Assert.assertTrue("Event ID " + eventId + " is not selected", selected_eventId.getText().contains(eventId)); 
//				}
//			}
//			log.exit();
//		}
//	}

}
