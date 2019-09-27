package com.pageobjects;

import java.util.ArrayList;
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
	
	@FindBy(xpath= "//span[text()='PREVIEW']")
	private WebElement label_preview;
	
	
	/* Methods */
	
	/**
	 * Select Template Type
	 */
	public void selectTemplateType(String templateType) {
		log.entry();
		if(driverHelper.isElementPresent(fld_templateType)) {
			driverHelper.clickButton(fld_templateType);
			driverHelper.setValueDropdown(list_templateType, fld_templateType, templateType);
			driverHelper.embedScreenshot(scenario);
		} else {
			Assert.assertTrue("Template Type field is not present", driverHelper.isElementPresent(fld_templateType));
		}
		log.exit();
	}
	
	/**
	 *Input Template Name
	 */
	public void inputTemplateName(String templateName) {
		log.entry();
		if(driverHelper.isElementPresent(fld_templateName)) {
			driverHelper.inputFieldValue(fld_templateName, templateName);
			driverHelper.embedScreenshot(scenario);
		} else {
			Assert.assertTrue("Template Name field is not present", driverHelper.isElementPresent(fld_templateName));
		}
		log.exit();
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
		} else {
			Assert.assertTrue("Apply Changes button is not present", driverHelper.isElementPresent(btn_ApplyChanges));
		}
		log.exit();
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
		} else {
			Assert.assertTrue("Move selected right button is not present", driverHelper.isElementPresent(btn_moveSelectedRight));
		}
		log.exit();
	}
	
	/**
	 * Click Apply Button (in Apply Changes pop up)
	 */
	public void clickApply() {
		log.entry();
		if(driverHelper.isElementPresent(btn_ApplyChangesPopUp_Apply)) {
			driverHelper.clickButton(btn_ApplyChangesPopUp_Apply);
			driverHelper.explicitWait();
			driverHelper.embedScreenshot(scenario);
		} else {
			Assert.assertTrue("Apply button is not present", driverHelper.isElementPresent(btn_ApplyChangesPopUp_Apply));
		}
		log.exit();
	}
	
	/**
	 * Click Cancel Button (in Apply Changes pop up)
	 */
	public void clickCancel() {
		log.entry();
		if(driverHelper.isElementPresent(btn_ApplyChangesPopUp_Cancel)) {
			driverHelper.clickButton(btn_ApplyChangesPopUp_Cancel);
			driverHelper.embedScreenshot(scenario);
		} else {
			Assert.assertTrue("Cancel button is not present", driverHelper.isElementPresent(btn_ApplyChangesPopUp_Cancel));
		}
		log.exit();
	}
	
	/**
	 * Verify filters in Apply Changes pop up
	 */
	public void verifyTemplateVersionOfFilters(String versionNumber) {
		log.entry();
		int current_versionNumber = Integer.parseInt(versionNumber.substring(1));
		//log.info("Current template version: " + current_versionNumber);
		By label_versionNumber = By.xpath("//p[contains(@class,'MuiListItemText-secondary')]");
		
		if(!driverHelper.isElementPresent(label_versionNumber)) {
			Assert.assertTrue("Version number is not indicated", driverHelper.isElementPresent(label_versionNumber));
		} else {
			List<WebElement> list_fld_versionNumbers = driver.findElements(label_versionNumber);
			for (WebElement selected_versionNumber : list_fld_versionNumbers) {
				int int_selected_versionNumber = Integer.parseInt((selected_versionNumber.getText()).substring(1));
				Assert.assertTrue("Version is not an old version", int_selected_versionNumber < current_versionNumber); 
			}
		}
		log.exit();
	}
	
	/**
	 * Click checkbox of Filter in Apply Changes pop up
	 */
	public void clickCheckboxOfFilter(String filterName) {
		log.entry();
		By label_filterName = By.xpath("//span[contains(@class,'MuiListItemText-primary')]");
		
		if(!driverHelper.isElementPresent(label_filterName)) {
			Assert.assertTrue("Filter name is not indicated", driverHelper.isElementPresent(label_filterName));
		} else {
			List<WebElement> list_fld_filterNames = driver.findElements(label_filterName);
			for (WebElement selected_filterName : list_fld_filterNames) {
				if((selected_filterName.getText()).equals(filterName)) {
					By btn_filter = By.xpath("//span[text()='" + selected_filterName.getText() + "']//preceding::input[@type='checkbox']");
					if(driverHelper.isElementPresent(btn_filter)) {
						driverHelper.clickButton(btn_filter);
						driverHelper.embedScreenshot(scenario);
					} else {
						Assert.assertTrue("Checkbox of filter " + selected_filterName.getText() + " is not present", driverHelper.isElementPresent(btn_filter));
					}
				}
			}
		}
		log.exit();
	}
	
	/**
	 * Click preview button of Filter in Apply Changes pop up
	 */
	public void clickPreviewButtonOfFilter(String filterName) {
		log.entry();
		By label_filterName = By.xpath("//span[contains(@class,'MuiListItemText-primary')]");
		
		if(!driverHelper.isElementPresent(label_filterName)) {
			Assert.assertTrue("Filter name is not indicated", driverHelper.isElementPresent(label_filterName));
		} else {
			List<WebElement> list_fld_filterNames = driver.findElements(label_filterName);
			for (WebElement selected_filterName : list_fld_filterNames) {
				if((selected_filterName.getText()).equals(filterName)) {
					By btn_preview = By.xpath("//span[text()='" + selected_filterName.getText() + "']//preceding::button[@type='button']");
					if(driverHelper.isElementPresent(btn_preview)) {
						driverHelper.clickButton(btn_preview);
						ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
						driver.switchTo().window(tabs.get(1));
						driverHelper.waitForPageLoaded();
					} else {
						Assert.assertTrue("Preview button of filter " + selected_filterName.getText() + " is not present", driverHelper.isElementPresent(btn_preview));
					}
				}
			}
		}
		log.exit();
	}
	
	/**
	 * Preview Filter page
	 */
	public void verifySuccessfulNavigationToPreviewFilterPage() {
		log.entry();
		driverHelper.explicitWait();
		Assert.assertTrue("Unsuccessful navigation to Preview Filter Page", driverHelper.isElementPresent(label_preview));
		driverHelper.embedScreenshot(scenario);
		log.exit();
	}
	
	/**
	 * Verify filter name in preview
	 */
	public void verifyFilterNameInPreview(String filterName) {
		log.entry();
		By fld_filterName = By.xpath("//input[@type='text' and @disabled and @value ='" + filterName + "']");
		Assert.assertTrue("Wrong filter is loaded", driverHelper.isElementPresent(fld_filterName));
		log.exit();
	}

}
