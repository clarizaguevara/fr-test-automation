package com.pageobjects;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import com.constants.CommonConstants;
import com.utils.DataHelper;

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
		} else {
			Assert.assertTrue("Add User button is not present.", driverHelper.isElementPresent(btn_addUser));
		}
		log.exit();
	}
	
	/**
	 * Click Roles Button
	 */
	public void clickRolesButton() {
		log.entry();
		if(driverHelper.isElementPresent(btn_roles)) {
			driverHelper.clickButton(btn_roles);
			driverHelper.waitForPageLoaded();
		} else {
			Assert.assertTrue("Roles button is not present.", driverHelper.isElementPresent(btn_roles));
		}
		log.exit();
	}
	
	/**
	 * Click Add Role Button
	 */
	public void clickAddRoleButton() {
		log.entry();
		if(driverHelper.isElementPresent(btn_addRole)) {
			driverHelper.clickButton(btn_addRole);
			driverHelper.waitForPageLoaded();
		} else {
			Assert.assertTrue("Add Role button is not present.", driverHelper.isElementPresent(btn_addRole));
		}
		log.exit();
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
		} else {
			Assert.assertTrue("Delete button of " + name + " is not present.", driverHelper.isElementPresent(btn_delete));
		}
		log.exit();
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
		} else {
			Assert.assertTrue("Save button is not present.", driverHelper.isElementPresent(btn_save));
		}
		log.exit();
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
		} else {
			Assert.assertTrue("Delete user button is not present.", driverHelper.isElementPresent(btn_deleteUser));
		}
		log.exit();
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
		} else {
			Assert.assertTrue("Delete role button is not present.", driverHelper.isElementPresent(btn_deleteRole));
		}
		log.exit();
	}
	
	/**
	 * Click Cancel Button
	 */
	public void clickCancelButton() {
		log.entry();
		if(driverHelper.isElementPresent(btn_cancel)) {
			driverHelper.clickButton(btn_cancel);
			driverHelper.waitForPageLoaded();
		} else {
			Assert.assertTrue("Cancel button is not present.", driverHelper.isElementPresent(btn_cancel));
		}
		log.exit();
	}
	
	/**
	 *Input Employee ID
	 */
	public void inputEmployeeId(String employeeId) {
		log.entry();
		if(driverHelper.isElementPresent(fld_employeeId)) {
			driverHelper.clearText(fld_employeeId);
			driverHelper.inputFieldValue(fld_employeeId, employeeId);
			driverHelper.embedScreenshot(scenario);
		} else {
			Assert.assertTrue("Employee Id field is not present.", driverHelper.isElementPresent(fld_employeeId));
		}
		log.exit();
	}
	
	/**
	 *Input Name
	 */
	public void inputName(String name) {
		log.entry();
		if(driverHelper.isElementPresent(fld_name)) {
			driverHelper.clearText(fld_name);
			driverHelper.inputFieldValue(fld_name, name);
			driverHelper.embedScreenshot(scenario);
		} else {
			Assert.assertTrue("Name field is not present.", driverHelper.isElementPresent(fld_name));
		}
		log.exit();
	}
	
	/**
	 * Select Role (Role dropdown in User management)
	 */
	public void selectRole(String role) {
		log.entry();
		if(driverHelper.isElementPresent(fld_role)) {
			driverHelper.clickButton(fld_role);
			driverHelper.setValueDropdown(list_role, fld_role, role);
			driverHelper.embedScreenshot(scenario);
		} else {
			Assert.assertTrue("Role field is not present.", driverHelper.isElementPresent(fld_role));
		}
		log.exit();
	}
	
	/**
	 * Input From date
	 */
	public void inputDateFrom(String dateFrom) {
		log.entry();
		if(driverHelper.isElementPresent(fld_dateFrom)) {
			driverHelper.clearText(fld_dateFrom);
			driverHelper.inputFieldValue(fld_dateFrom, dateFrom);
			driverHelper.clickEnter(fld_dateFrom);
			driverHelper.embedScreenshot(scenario);
		} else {
			Assert.assertTrue("From date field is not present.", driverHelper.isElementPresent(fld_dateFrom));
		}
		log.exit();
	}
	
	/**
	 * Input To date
	 */
	public void inputDateTo(String dateTo) {
		log.entry();
		if(driverHelper.isElementPresent(fld_dateTo)) {
			driverHelper.clearText(fld_dateTo);
			driverHelper.inputFieldValue(fld_dateTo, dateTo);
			driverHelper.clickEnter(fld_dateTo);
			driverHelper.embedScreenshot(scenario);
		} else {
			Assert.assertTrue("To date field is not present.", driverHelper.isElementPresent(fld_dateTo));
		}
		log.exit();
	}
	
	/**
	 *Input Role Name
	 */
	public void inputRoleName(String roleName) {
		log.entry();
		if(driverHelper.isElementPresent(fld_roleName)) {
			driverHelper.clearText(fld_roleName);
			driverHelper.inputFieldValue(fld_roleName, roleName);
			driverHelper.embedScreenshot(scenario);
		} else {
			Assert.assertTrue("Role Name is not present.", driverHelper.isElementPresent(fld_roleName));
		}
		log.exit();
	}
	
	/**
	 * Verify if user is saved
	 */
	public void verifySuccessfulSavingOfUser(boolean shouldBeSaved) {
		log.entry();
		driverHelper.embedScreenshot(scenario);
		boolean isUserSaved = false;
		
		if(driverHelper.isElementPresent(label_successfullyAddedUser)) {
			isUserSaved = true;
		} else {
			isUserSaved = false;
		}
		
		if(isUserSaved != shouldBeSaved) {
			Assert.assertTrue("Is user saved? Expected: " + shouldBeSaved + " Actual: " + isUserSaved, false);
		}
		log.exit();
	}
	
	/**
	 * Verify if role is saved
	 */
	public void verifySuccessfulSavingOfRole(boolean shouldBeSaved) {
		log.entry();
		driverHelper.embedScreenshot(scenario);
		boolean isRoleSaved = false;
		
		if(driverHelper.isElementPresent(label_successfullyAddedRole)) {
			isRoleSaved = true;
		} else {
			isRoleSaved = false;
		}
		
		if(isRoleSaved != shouldBeSaved) {
			Assert.assertTrue("Is role saved? Expected: " + shouldBeSaved + " Actual: " + isRoleSaved, false);
		}
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
			Assert.assertTrue(name + " is not present.", driverHelper.isElementPresent(fld_name));
		}
		log.exit();
	}
	
	/**
	 * Check Employee Id
	 */
	public void checkEmployeeId(String employeeId) {
		log.entry();
		Assert.assertTrue("Values are not the same", (fld_employeeId.getAttribute("value")).equals(employeeId));
		log.exit();
	}
	
	/**
	 * Check Name
	 */
	public void checkName(String name) {
		log.entry();
		Assert.assertTrue("Values are not the same", (fld_name.getAttribute("value")).equals(name));
		log.exit();
	}
	
	/**
	 * Check Role Name
	 */
	public void checkRoleName(String roleName) {
		log.entry();
		Assert.assertTrue("Values are not the same", (fld_roleName.getAttribute("value")).equals(roleName));
		log.exit();
	}
	
	/**
	 * Verify if User/Role is present in table
	 */
	public void verifyIfUserRoleIsPresent(String name, boolean shouldBePresent) {
		log.entry();
		By fld_user = By.xpath("//td[text()='" + name + "']");
		boolean isPresent = false;
		
		if(driverHelper.isElementPresent(fld_user)) {
			isPresent = true;
		} else {
			isPresent = false;
		}
		
		if(isPresent != shouldBePresent) {
			Assert.assertTrue("Is user/role present? Expected: " + shouldBePresent + " Actual: " + isPresent, false);
		}
		log.exit();
	}
	
	/**
	 * Select/Deselect Roles
	 */
	public void selectRoles(String roleNames) {
		log.entry();
		String all_roles = CommonConstants.LOV_ROLES.replaceAll("\\[|\\]|\\s", "");
		List<String> LOV_ROLES = Arrays.asList(all_roles.split(","));
		List<String> selectedRoles = Arrays.asList(roleNames.split(","));
    	
    	for (int counter = 0; counter < LOV_ROLES.size(); counter++) {
    		By fld_roleName = By.xpath("//label[text()='" + LOV_ROLES.get(counter) + "']");
    		By fld_roleName_active = By.xpath("//label[@class='btn w-100 active w-100' and text()='" + LOV_ROLES.get(counter) + "']");
    		
    		//Check if the role is selected
    		if(selectedRoles.contains(LOV_ROLES.get(counter))) {
    			//Role is selected
    			
	    		//Check if the selected role is inactive
	    		//If so, select it. If not, do nothing
	    		if(!driverHelper.isButtonSelected(fld_roleName_active)) {
	    			driverHelper.clickButton(fld_roleName);
	    		}
    		} else {
    			//Role is not selected
    			
    			//Check if the unselected role is active
	    		//If so, deselect it. If not, do nothing
	    		if(driverHelper.isButtonSelected(fld_roleName_active)) {
	    			driverHelper.clickButton(fld_roleName);
	    		}
    		}
    	}
		log.exit();
	}
	
	/**
	 * Verify if role/s is/are selected
	 */
	public void verifyIfRoleIsSelected(String roleNames) {
		log.entry();
		List<String> selectedRoles = Arrays.asList(roleNames.split(","));
    	
    	for (int counter = 0; counter < selectedRoles.size(); counter++) {
    		By fld_roleName_active = By.xpath("//label[@class='btn w-100 active w-100' and text()='" + selectedRoles.get(counter) + "']");
    		
    		Assert.assertTrue("Role is not selected", driverHelper.isElementPresent(fld_roleName_active));
    	}
		log.exit();
	}
	
	/**
	 * Verify From and To dates
	 */
	public void verifyFromAndToDates() {
		log.entry();
		String dateFormat = "MM/dd/yyyy";
		Date dtDateFrom = DataHelper.parseDateTime(dateFormat, fld_dateFrom.getAttribute("value"));
		Date dtDateTo = DataHelper.parseDateTime(dateFormat, fld_dateTo.getAttribute("value"));
		
		Assert.assertTrue("From date is greater than To date", dtDateFrom.before(dtDateTo)); 
		log.exit();
	}

}
