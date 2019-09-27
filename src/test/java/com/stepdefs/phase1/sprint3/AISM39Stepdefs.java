package com.stepdefs.phase1.sprint3;

import com.constants.CommonConstants;
import com.pageobjects.AccessManagementPage;
import com.pageobjects.HomePage;
import com.stepdefs.ScenarioHooks;

import cucumber.api.java8.En;

public class AISM39Stepdefs implements En {
	
	public AISM39Stepdefs(ScenarioHooks hooks, HomePage homePage, AccessManagementPage accessManagementPage) {
		
		And("I am on Access Management page", () -> {
			homePage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			homePage.verifySuccessfulNavigationToHomePage();
			homePage.clickMaintenanceTab(CommonConstants.PAGE_MAINTENANCE_ACCESS);
			accessManagementPage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			accessManagementPage.verifySuccessfulNavigationToAccessManagementPage();
		});
		
		/*-----------------------------*/
		
		When("I select Access Management", () -> {
			homePage.clickMaintenanceTab(CommonConstants.PAGE_MAINTENANCE_ACCESS);
			accessManagementPage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
		});
		
		Then("Access Management page should be loaded successfully", () -> {
			accessManagementPage.verifySuccessfulNavigationToAccessManagementPage();
		});
		
		/*-----------------------------*/
		
		When("I click Add User button", () -> {
			accessManagementPage.clickAddUserButton();
			accessManagementPage.verifyAddUserPopUp();
		});
		
		And("I fill-in the fields with values: Employee Id: (.*), Name: (.*), Role: (.*), Expiration date: From (.*) To (.*)", (String employeeId, String name, String role, String dateFrom, String dateTo) -> {
			accessManagementPage.inputEmployeeId(employeeId);
			accessManagementPage.inputName(name);
			accessManagementPage.selectRole(role);
			accessManagementPage.inputDateFrom(dateFrom);
			accessManagementPage.inputDateTo(dateTo);
		});
		
		Then("User should be added successfully", () -> {
			accessManagementPage.clickSaveButton();
			accessManagementPage.verifySuccessfulSavingOfUser(true);
		});
		
		/*-----------------------------*/
		
		Then("User should not be added successfully", () -> {
			accessManagementPage.clickSaveButton();
			accessManagementPage.verifySuccessfulSavingOfUser(false);
		});
		
		/*-----------------------------*/
		
		When("I click the user with name: (.*)", (String name) -> {
			accessManagementPage.selectInList(name);
			accessManagementPage.verifyEditUserPopUp();
		});
		
		And("I edit the fields with values: Employee Id: (.*), Name: (.*), Role: (.*)", (String employeeId, String name, String role) -> {
			accessManagementPage.inputEmployeeId(employeeId);
			accessManagementPage.inputName(name);
			accessManagementPage.selectRole(role);
		});
		
		Then("User should be editted successfully with new values: Employee Id: (.*), Name: (.*), Role: (.*)", (String employeeId, String name, String role) -> {
			accessManagementPage.clickSaveButton();
			accessManagementPage.selectInList(name);
			accessManagementPage.verifyEditUserPopUp();
			accessManagementPage.checkEmployeeId(employeeId);
			accessManagementPage.checkName(name);
		});
		
		/*-----------------------------*/
		
		And("I change the Expiration date to: (.*) to (.*)", (String dateFrom, String dateTo) -> {
			accessManagementPage.inputDateFrom(dateFrom);
			accessManagementPage.inputDateTo(dateTo);
		});
		
		Then("User should be editted successfully and (.*)'s From date is not greater than To date", (String name) -> {
			accessManagementPage.clickSaveButton();
			accessManagementPage.selectInList(name);
			accessManagementPage.verifyEditUserPopUp();
			accessManagementPage.verifyFromAndToDates();
		});
		
		/*-----------------------------*/
		
		When("I click the delete button of user (.*)", (String name) -> {
			accessManagementPage.clickDeleteButtonOfSelected(name);
			accessManagementPage.verifyDeleteUserPopUp();
			accessManagementPage.clickDeleteUserButton();
		});
		
		Then("(.*) should be deleted successfully", (String name) -> {
			accessManagementPage.verifyIfUserRoleIsPresent(name, false);
		});
		
		/*-----------------------------*/
		
		When("I go to Roles section", () -> {
			accessManagementPage.clickRolesButton();
		});
		
		And("I click Add Role button", () -> {
			accessManagementPage.clickAddRoleButton();
			accessManagementPage.verifyAddRolePopUp();
		});
		
		And("I fill-in the fields with values: Role Name: (.*), Roles: (.*)", (String roleName, String roles) -> {
			accessManagementPage.inputRoleName(roleName);
			accessManagementPage.selectRoles(roles);
		});
		
		Then("Role should be added successfully", () -> {
			accessManagementPage.clickSaveButton();
			accessManagementPage.verifySuccessfulSavingOfRole(true);
		});
		
		/*-----------------------------*/
		
		Then("Role should not be added successfully", () -> {
			accessManagementPage.clickSaveButton();
			accessManagementPage.verifySuccessfulSavingOfRole(false);
		});
		
		/*-----------------------------*/
		
		When("I click the role with name: (.*)", (String name) -> {
			accessManagementPage.selectInList(name);
			accessManagementPage.verifyEditRolePopUp();
		});
		
		And("I edit the fields with values: Role Name: (.*), Roles: (.*)", (String roleName, String roles) -> {
			accessManagementPage.inputRoleName(roleName);
			accessManagementPage.selectRoles(roles);
		});
		
		Then("Role should be editted successfully with new values: Role Name: (.*), Roles: (.*)", (String roleName, String roles) -> {
			accessManagementPage.clickSaveButton();
			accessManagementPage.selectInList(roleName);
			accessManagementPage.verifyEditRolePopUp();
			accessManagementPage.checkRoleName(roleName);
			accessManagementPage.verifyIfRoleIsSelected(roles);
		});
		
		/*-----------------------------*/
		
		When("I click the delete button of role (.*)", (String name) -> {
			accessManagementPage.clickDeleteButtonOfSelected(name);
			accessManagementPage.verifyDeleteRolePopUp();
			accessManagementPage.clickDeleteRoleButton();
		});
		
	}

}
