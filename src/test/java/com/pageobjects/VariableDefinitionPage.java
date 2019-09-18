package com.pageobjects;

import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class VariableDefinitionPage extends BasePage {

	private static final Logger log = LogManager.getLogger(VariableDefinitionPage.class);

	
	/* Page Elements */
	
	@FindBy(xpath= "//input[@placeholder='Variable name...']")
	private WebElement fld_variableName;
	
	@FindBy(xpath= "//input[@placeholder='Starting keyword...']")
	private WebElement fld_startString;
	
	@FindBy(xpath= "//div[@class='ui fitted checkbox']//input[@type='checkbox']")
	private WebElement btn_includeEndDelimeter;
	
	@FindBy(xpath= "//input[@placeholder='Ending keyword...']")
	private WebElement fld_endDelimeter;
	
	@FindBys(value = @FindBy (xpath = "//div[contains(@class,'form-check-inline')]//select[@class='form-control']//option"))
	private List<WebElement> list_field;
	
	@FindBy(xpath= "//div[contains(@class,'form-check-inline')]//select[@class='form-control']")
	private WebElement fld_field;
	
	
	/* Methods */
	
	/**
	 * Input Variable name
	 */
	public void inputVariableName(String variableName) {
		log.entry();
		if(driverHelper.isElementPresent(fld_variableName)) {
			driverHelper.clearText(fld_variableName);
			driverHelper.inputFieldValue(fld_variableName, variableName);
			driverHelper.embedScreenshot(scenario);
			log.exit();
		} else {
			Assert.assertTrue("Variable Name field is not present.", driverHelper.isElementPresent(fld_variableName));
			log.exit();
		}
	}
	
	/**
	 * Input Start string
	 */
	public void inputStartString(String startString) {
		log.entry();
		if(driverHelper.isElementPresent(fld_startString)) {
			driverHelper.clearText(fld_startString);
			driverHelper.inputFieldValue(fld_startString, startString);
			driverHelper.embedScreenshot(scenario);
			log.exit();
		} else {
			Assert.assertTrue("Start string field is not present.", driverHelper.isElementPresent(fld_startString));
			log.exit();
		}
	}
	
	/**
	 * Click Include end delimeter button
	 */
	public void includeEndDelimeter(String endDelimeter) {
		log.entry();
		if(driverHelper.isElementPresent(btn_includeEndDelimeter)) {
			if(!endDelimeter.equals("(end delimeter not included)")) {
				Actions builder = new Actions(driver);
				builder.moveToElement(btn_includeEndDelimeter).click().perform();
				//driverHelper.clickButton(btn_includeEndDelimeter);
				driverHelper.embedScreenshot(scenario);
				log.exit();
			}
		} else {
			if(endDelimeter.equals("(end delimeter not included)")) {
				Actions builder = new Actions(driver);
				builder.moveToElement(btn_includeEndDelimeter).click().perform();
				//driverHelper.clickButton(btn_includeEndDelimeter);
				driverHelper.embedScreenshot(scenario);
				log.exit();
			}
			//Assert.assertTrue("Include end delimeter button is not present", driverHelper.isElementPresent(btn_includeEndDelimeter));
			//log.exit();
		}
	}
	
	/**
	 * Input End delimeter
	 */
	public void inputEndDelimeter(String endDelimeter) {
		log.entry();
		if(driverHelper.isElementPresent(fld_endDelimeter)) {
			driverHelper.clearText(fld_endDelimeter);
			driverHelper.inputFieldValue(fld_endDelimeter, endDelimeter);
			driverHelper.embedScreenshot(scenario);
			log.exit();
		} else {
			Assert.assertTrue("End delimeter field is not present.", driverHelper.isElementPresent(fld_endDelimeter));
			log.exit();
		}
	}
	
	/**
	 * Select Field
	 */
	public void selectField(String field) {
		log.entry();
		if(driverHelper.isElementPresent(fld_field)) {
			driverHelper.clickButton(fld_field);
			driverHelper.setValueDropdown(list_field, fld_field, field);
			driverHelper.embedScreenshot(scenario);
			log.exit();
		} else {
			Assert.assertTrue("Field selection is not present", driverHelper.isElementPresent(fld_field));
			log.exit();
		}
	}
	
	/**
	 * Click delete button of a variable
	 */
	public void deleteVariable(String variableName) {
		log.entry();
		By btn_delete = By.xpath("//div//input[@value='" + variableName + "']//preceding::span[contains(@class,'btn-delete')]");
		if(driverHelper.isElementPresent(btn_delete)) {
			driverHelper.clickButton(btn_delete);
			driverHelper.embedScreenshot(scenario);
			log.exit();
		} else {
			Assert.assertTrue("Delete button of variable " + variableName + " is not present", driverHelper.isElementPresent(btn_delete));
			log.exit();
		}
	}
	
	/**
	 * Verify if variable is present
	 */
	public void verifyIfVariableIsPresent(String variableName, boolean shouldBePresent) {
		log.entry();
		boolean isVariablePresent = false;
		By fld_variable = By.xpath("//input[@placeholder='Variable name...' and @value='" + variableName + "']");
		
		if(driverHelper.isElementPresent(fld_variable)) {
			isVariablePresent = true;
		} else {
			isVariablePresent = false;
		}
		
		if(isVariablePresent != shouldBePresent) {
			Assert.assertTrue(variableName + " is present? " + isVariablePresent, false);
		}
		log.exit();
	}
	
	/**
	 * Create multiple variables
	 */
	public void createVariableByRow(String variableRow, String rowNumber) {
		log.entry();
		
		//variableName-startString-endDelimeter-field
		List<String> variableFields = Arrays.asList(variableRow.split("-"));
		inputVariableName(variableFields.get(0), String.valueOf(rowNumber));
		inputStartString(variableFields.get(1), String.valueOf(rowNumber));
		includeEndDelimeter(variableFields.get(2), String.valueOf(rowNumber));
		selectField(variableFields.get(3), String.valueOf(rowNumber));
		
		driverHelper.embedScreenshot(scenario);
		log.exit();
	}
	
	/**
	 * Input Variable name (for creating multiple variables)
	 */
	private void inputVariableName(String variableName, String rowNumber) {
		log.entry();
		By fld_variableName = By.xpath("//div[contains(@class,'justify-content-start')][" + rowNumber + "]//input[@placeholder='Variable name...']");
		if(driverHelper.isElementPresent(fld_variableName)) {
			driverHelper.clearText(fld_variableName);
			driverHelper.inputFieldValue(driver.findElement(fld_variableName), variableName);
			log.exit();
		} else {
			Assert.assertTrue("Variable Name field is not present.", driverHelper.isElementPresent(fld_variableName));
			log.exit();
		}
	}
	
	/**
	 * Input Start string (for creating multiple variables)
	 */
	private void inputStartString(String startString, String rowNumber) {
		log.entry();
		By fld_startString = By.xpath("//div[contains(@class,'justify-content-start')][" + rowNumber + "]//input[@placeholder='Starting keyword...']");
		if(driverHelper.isElementPresent(fld_startString)) {
			driverHelper.clearText(fld_startString);
			driverHelper.inputFieldValue(driver.findElement(fld_startString), startString);
			log.exit();
		} else {
			Assert.assertTrue("Start string field is not present.", driverHelper.isElementPresent(fld_startString));
			log.exit();
		}
	}
	
	/**
	 * Click Include end delimeter button (for creating multiple variables)
	 */
	private void includeEndDelimeter(String endDelimeter, String rowNumber) {
		log.entry();
		By btn_includeEndDelimeter = By.xpath("//div[contains(@class,'justify-content-start')][" + rowNumber + "]//div[@class='ui fitted checkbox']//input[@type='checkbox']");
		if(driverHelper.isElementPresent(btn_includeEndDelimeter)) {
			if(!endDelimeter.equals("(end delimeter not included)")) {
				Actions builder = new Actions(driver);
				builder.moveToElement(driver.findElement(btn_includeEndDelimeter)).click().perform();
				inputEndDelimeter(endDelimeter, rowNumber);
				log.exit();
			}
		} else {
			if(endDelimeter.equals("(end delimeter not included)")) {
				Actions builder = new Actions(driver);
				builder.moveToElement(driver.findElement(btn_includeEndDelimeter)).click().perform();
				inputEndDelimeter(endDelimeter, rowNumber);
				log.exit();
			}
		}
	}
	
	/**
	 * Input End delimeter (for creating multiple variables)
	 */
	private void inputEndDelimeter(String endDelimeter, String rowNumber) {
		log.entry();
		By fld_endDelimeter = By.xpath("//div[contains(@class,'justify-content-start')][" + rowNumber + "]//input[@placeholder='Ending keyword...']");
		if(driverHelper.isElementPresent(fld_endDelimeter)) {
			driverHelper.clearText(fld_endDelimeter);
			driverHelper.inputFieldValue(driver.findElement(fld_endDelimeter), endDelimeter);
			log.exit();
		} else {
			Assert.assertTrue("End delimeter field is not present.", driverHelper.isElementPresent(fld_endDelimeter));
			log.exit();
		}
	}
	
	/**
	 * Select Field (for creating multiple variables)
	 */
	private void selectField(String field, String rowNumber) {
		log.entry();
		By fld_field = By.xpath("//div[contains(@class,'justify-content-start')][" + rowNumber + "]//div[contains(@class,'form-check-inline')]//select[@class='form-control']");
		By list_field = By.xpath("//div[contains(@class,'justify-content-start')][" + rowNumber + "]//div[contains(@class,'form-check-inline')]//select[@class='form-control']//option");
		if(driverHelper.isElementPresent(fld_field)) {
			driverHelper.clickButton(fld_field);
			driverHelper.setValueDropdown(driver.findElements(list_field), driver.findElement(fld_field), field);
			log.exit();
		} else {
			Assert.assertTrue("Field selection is not present", driverHelper.isElementPresent(fld_field));
			log.exit();
		}
	}
	
	/**
	 * Verify if variable can be deleted
	 */
	public void verifyIfVariableCanBeDeleted(String variableName) {
		log.entry();
		By btn_delete = By.xpath("//div//input[@value='" + variableName + "']//preceding::span[contains(@class,'btn-delete')]");
		
		if(driverHelper.isElementClickable(btn_delete)) {
			Assert.assertFalse(variableName + " can be deleted", driverHelper.isElementClickable(btn_delete));
		}
		log.exit();
	}
	
}
