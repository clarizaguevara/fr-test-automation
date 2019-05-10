package com.pageobjects;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class AccessManagementPage extends BasePage {
	
	private static final Logger log = LogManager.getLogger(AccessManagementPage.class);
	
	
	/* Page Elements */
	
	@FindBy(css= "div[class='access-management-page']")
	private WebElement page_accessManagement;
	
	@FindBy(xpath= "//button[text()='Add User']")
	private WebElement btn_addUser;
	
	@FindBy(xpath= "//label[text()='Roles']")
	private WebElement btn_roles;
	
	@FindBy(xpath= "//button[text()='Add Role']")
	private WebElement btn_addRole;
	
	@FindBy(xpath= "//div[@class='card-body']")
	private WebElement page_popUp;
	
	@FindBy(xpath= "//strong[text()='Add New User']")
	private WebElement label_addUser;
	
	@FindBy(xpath= "//strong[text()='Edit User']")
	private WebElement label_editUser;
	
	@FindBy(xpath= "//strong[text()='Delete User']")
	private WebElement label_deleteUser;
	
	@FindBy(xpath= "//strong[text()='Add Role']")
	private WebElement label_addRole;
	
	@FindBy(xpath= "//strong[text()='Edit Role']")
	private WebElement label_editRole;
	
	@FindBy(xpath= "//strong[text()='Delete Role']")
	private WebElement label_deleteRole;
	
	@FindBy(xpath= "//button[text()='Save']")
	private WebElement btn_save;
	
	@FindBy(xpath= "//button[text()='Delete user']")
	private WebElement btn_deleteUser;
	
	@FindBy(xpath= "//button[text()='Delete role']")
	private WebElement btn_deleteRole;
	
	@FindBy(xpath= "//button[text()='Cancel']")
	private WebElement btn_cancel;
	
	@FindBy(xpath= "//label[text()='Employee ID:']//following::input[1]")
	private WebElement fld_employeeId;
	
	@FindBy(xpath= "//label[text()='Name:']//following::input[1]")
	private WebElement fld_name;
	
	@FindBy(xpath= "//label[text()='Role:']//following::select")
	private WebElement fld_role;
	
	@FindBys(value = @FindBy (xpath = "//label[text()='Role:']//following::select//option"))
	private List<WebElement> list_role;
	
	@FindBy(xpath= "//label[text()='From:']//following::div[@class='react-datepicker__input-container'][1]//input")
	private WebElement fld_dateFrom;
	
	@FindBy(xpath= "//label[text()='From:']//following::div[@class='react-datepicker__input-container'][2]//input")
	private WebElement fld_dateTo;
	
	@FindBy(xpath= "//input[@placeholder='Role name...']")
	private WebElement fld_roleName;
	
	@FindBy(xpath= "//label[text()='New user was successfully added.']")
	private WebElement label_successfullyAddedUser;
	
	@FindBy(xpath= "//label[text()='New role was successfully added.']")
	private WebElement label_successfullyAddedRole;
	
	
	/* Methods */
	
	/**
	 * Navigate to Access Management Page
	 */
	public void verifySuccessfulNavigationToAccessManagementPage() {
		log.entry();
		driverHelper.embedScreenshot(scenario);
		Assert.assertTrue("Unsuccessful navigation to Access Management Page", driverHelper.isElementPresent(page_accessManagement));
		log.exit();
	}
	
	/**
	 * Click Add User Button
	 */
	public void clickAddUserButton() {
		log.entry();
		if(driverHelper.isElementPresent(btn_addUser)) {
			driverHelper.clickButton(btn_addUser);
			driverHelper.waitForPageLoaded();
			log.exit();
		} else {
			System.out.println("Add User button is not present.");
			log.exit();
		}
	}
	
	/**
	 * Click Roles Button
	 */
	public void clickRolesButton() {
		log.entry();
		if(driverHelper.isElementPresent(btn_roles)) {
			driverHelper.clickButton(btn_roles);
			driverHelper.waitForPageLoaded();
			log.exit();
		} else {
			System.out.println("Roles button is not present.");
			log.exit();
		}
	}
	
	/**
	 * Click Add Role Button
	 */
	public void clickAddRoleButton() {
		log.entry();
		if(driverHelper.isElementPresent(btn_addRole)) {
			driverHelper.clickButton(btn_addRole);
			driverHelper.waitForPageLoaded();
			log.exit();
		} else {
			System.out.println("Add Role button is not present.");
			log.exit();
		}
	}
	
	/**
	 * Click Delete Button of selected User/Role
	 */
	public void clickDeleteButtonOfSelected(String name) {
		log.entry();
		By btn_delete = By.xpath("//td[text()='" + name + "']//following::label[@title='Delete']//i");
		if(driverHelper.isElementPresent(btn_delete)) {
			driverHelper.clickButton(btn_delete);
			driverHelper.waitForPageLoaded();
			log.exit();
		} else {
			System.out.println("Delete button is not present.");
			log.exit();
		}
	}
	
	/**
	 * Verify Add User Pop-up
	 */
	public void verifyAddUserPopUp() {
		log.entry();
		driverHelper.embedScreenshot(scenario);
		Assert.assertTrue("Add User pop-up is not loaded", driverHelper.isElementPresent(page_popUp));
		Assert.assertTrue("Add User pop-up is not loaded", driverHelper.isElementPresent(label_addUser));
		log.exit();
	}
	
	/**
	 * Verify Edit User Pop-up
	 */
	public void verifyEditUserPopUp() {
		log.entry();
		driverHelper.embedScreenshot(scenario);
		Assert.assertTrue("Edit User pop-up is not loaded", driverHelper.isElementPresent(page_popUp));
		Assert.assertTrue("Edit User pop-up is not loaded", driverHelper.isElementPresent(label_editUser));
		log.exit();
	}
	
	/**
	 * Verify Delete User Pop-up
	 */
	public void verifyDeleteUserPopUp() {
		log.entry();
		driverHelper.embedScreenshot(scenario);
		Assert.assertTrue("Delete User pop-up is not loaded", driverHelper.isElementPresent(page_popUp));
		Assert.assertTrue("Delete User pop-up is not loaded", driverHelper.isElementPresent(label_deleteUser));
		log.exit();
	}
	
	/**
	 * Verify Add Role Pop-up
	 */
	public void verifyAddRolePopUp() {
		log.entry();
		driverHelper.embedScreenshot(scenario);
		Assert.assertTrue("Add Role pop-up is not loaded", driverHelper.isElementPresent(page_popUp));
		Assert.assertTrue("Add Role pop-up is not loaded", driverHelper.isElementPresent(label_addRole));
		log.exit();
	}
	
	/**
	 * Verify Edit Role Pop-up
	 */
	public void verifyEditRolePopUp() {
		log.entry();
		driverHelper.embedScreenshot(scenario);
		Assert.assertTrue("Edit Role pop-up is not loaded", driverHelper.isElementPresent(page_popUp));
		Assert.assertTrue("Edit Role pop-up is not loaded", driverHelper.isElementPresent(label_editRole));
		log.exit();
	}
	
	/**
	 * Verify Delete Role Pop-up
	 */
	public void verifyDeleteRolePopUp() {
		log.entry();
		driverHelper.embedScreenshot(scenario);
		Assert.assertTrue("Delete Role pop-up is not loaded", driverHelper.isElementPresent(page_popUp));
		Assert.assertTrue("Delete Role pop-up is not loaded", driverHelper.isElementPresent(label_deleteRole));
		log.exit();
	}
	
	/**
	 * Click Save Button
	 */
	public void clickSaveButton() {
		log.entry();
		if(driverHelper.isElementPresent(btn_save)) {
			driverHelper.clickButton(btn_save);
			driverHelper.waitForPageLoaded();
			driverHelper.explicitWait();
			log.exit();
		} else {
			System.out.println("Save button is not present.");
			log.exit();
		}
	}
	
	/**
	 * Click Delete user Button
	 */
	public void clickDeleteUserButton() {
		log.entry();
		if(driverHelper.isElementPresent(btn_deleteUser)) {
			driverHelper.clickButton(btn_deleteUser);
			driverHelper.waitForPageLoaded();
			driverHelper.explicitWait();
			log.exit();
		} else {
			System.out.println("Delete user button is not present.");
			log.exit();
		}
	}
	
	/**
	 * Click Delete role Button
	 */
	public void clickDeleteRoleButton() {
		log.entry();
		if(driverHelper.isElementPresent(btn_deleteRole)) {
			driverHelper.clickButton(btn_deleteRole);
			driverHelper.waitForPageLoaded();
			driverHelper.explicitWait();
			log.exit();
		} else {
			System.out.println("Delete role button is not present.");
			log.exit();
		}
	}
	
	/**
	 * Click Cancel Button
	 */
	public void clickCancelButton() {
		log.entry();
		if(driverHelper.isElementPresent(btn_cancel)) {
			driverHelper.clickButton(btn_cancel);
			driverHelper.waitForPageLoaded();
			log.exit();
		} else {
			System.out.println("Cancel button is not present.");
			log.exit();
		}
	}
	
	/**
	 *Input Employee ID
	 */
	public void inputEmployeeId(String employeeId) {
		log.entry();
		if(driverHelper.isElementPresent(fld_employeeId)) {
			fld_employeeId.clear();
			driverHelper.inputFieldValue(fld_employeeId, employeeId);
			driverHelper.embedScreenshot(scenario);
			log.exit();
		} else {
			System.out.println("Employee Id field is not present.");
			log.exit();
		}
	}
	
	/**
	 *Input Name
	 */
	public void inputName(String name) {
		log.entry();
		if(driverHelper.isElementPresent(fld_name)) {
			fld_name.clear();
			driverHelper.inputFieldValue(fld_name, name);
			driverHelper.embedScreenshot(scenario);
			log.exit();
		} else {
			System.out.println("Name field is not present.");
			log.exit();
		}
	}
	
	/**
	 * Select Role
	 */
	public void selectRole(String role) {
		log.entry();
		if(driverHelper.isElementPresent(fld_role)) {
			driverHelper.clickButton(fld_role);
			driverHelper.setValueDropdown(list_role, fld_role, role);
			driverHelper.embedScreenshot(scenario);
			log.exit();
		} else {
			System.out.println("Role field is not present.");
			log.exit();
		}
	}
	
	/**
	 * Input From date
	 */
	public void inputDateFrom(String dateFrom) {
		log.entry();
		if(driverHelper.isElementPresent(fld_dateFrom)) {
			fld_dateFrom.clear();
			driverHelper.inputFieldValue(fld_dateFrom, dateFrom);
			driverHelper.clickEnter(fld_dateFrom);
			driverHelper.embedScreenshot(scenario);
			log.exit();
		} else {
			System.out.println("From date field is not present.");
		}
	}
	
	/**
	 * Input To date
	 */
	public void inputDateTo(String dateTo) {
		log.entry();
		if(driverHelper.isElementPresent(fld_dateTo)) {
			fld_dateTo.clear();
			driverHelper.inputFieldValue(fld_dateTo, dateTo);
			driverHelper.clickEnter(fld_dateTo);
			driverHelper.embedScreenshot(scenario);
			log.exit();
		} else {
			System.out.println("To date field is not present.");
		}
	}
	
	/**
	 *Input Role Name
	 */
	public void inputRoleName(String roleName) {
		log.entry();
		if(driverHelper.isElementPresent(fld_roleName)) {
			fld_roleName.clear();
			driverHelper.inputFieldValue(fld_roleName, roleName);
			driverHelper.embedScreenshot(scenario);
			log.exit();
		} else {
			System.out.println("Role Name field is not present.");
			log.exit();
		}
	}
	
	/**
	 * Verify that user is successfully added
	 */
	public void verifySuccessfulSavingOfUser() {
		log.entry();
		driverHelper.embedScreenshot(scenario);
		Assert.assertTrue("User is not added", driverHelper.isElementPresent(label_successfullyAddedUser));
		log.exit();
	}
	
	/**
	 * Verify that role is successfully added
	 */
	public void verifySuccessfulSavingOfRole() {
		log.entry();
		driverHelper.embedScreenshot(scenario);
		Assert.assertTrue("Role is not added", driverHelper.isElementPresent(label_successfullyAddedRole));
		log.exit();
	}
	
	/**
	 * Verify that user is not successfully added
	 */
	public void verifyUnsuccessfulSavingOfUser() {
		log.entry();
		driverHelper.embedScreenshot(scenario);
		Assert.assertTrue("User is added", driverHelper.isElementNotPresent(label_successfullyAddedUser));
		log.exit();
	}
	
	/**
	 * Verify that role is not successfully added
	 */
	public void verifyUnsuccessfulSavingOfRole() {
		log.entry();
		driverHelper.embedScreenshot(scenario);
		Assert.assertTrue("Role is added", driverHelper.isElementNotPresent(label_successfullyAddedRole));
		log.exit();
	}
	
	/**
	 * Select User/Role in the list
	 */
	public void selectInList(String name) {
		log.entry();
		By fld_name = By.xpath("//td[text()='" + name + "']");
		if(driverHelper.isElementPresent(fld_name)) {
			driverHelper.clickButton(fld_name);
			driverHelper.waitForPageLoaded();	
		} else {
			System.out.println("User is not present.");
			log.exit();
		}
		log.exit();
	}
	
	/**
	 * Get Employee Id
	 */
	public String getEmployeeId() {
		log.entry();
		String employeeId = fld_employeeId.getAttribute("value");
		log.exit();
		return employeeId;
	}
	
	/**
	 * Get Name
	 */
	public String getName() {
		log.entry();
		String name = fld_name.getAttribute("value");
		log.exit();
		return name;
	}
	
	/**
	 * Get Role Name
	 */
	public String getRoleName() {
		log.entry();
		String name = fld_roleName.getAttribute("value");
		log.exit();
		return name;
	}
	
	/**
	 * Verify if User is deleted
	 */
	public void verifyIfDeleted(String name) {
		log.entry();
		By fld_user = By.xpath("//td[text()='" + name + "']");
		Assert.assertFalse("User is present", driverHelper.isElementPresent(fld_user));
		log.exit();
	}
	
	/**
	 * Select Roles
	 */
	public void selectRoles(String roleName) {
		log.entry();
		By fld_roleName = By.xpath("//label[text()='" + roleName + "']");
		if(driverHelper.isElementPresent(fld_roleName)) {
			driverHelper.clickButton(fld_roleName);
		} else {
			System.out.println("Role is not present.");
			log.exit();
		}
		log.exit();
	}

}
