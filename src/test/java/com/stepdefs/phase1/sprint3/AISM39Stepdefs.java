package com.stepdefs.phase1.sprint3;

import com.pageobjects.AccessManagementPage;
import com.pageobjects.HomePage;
import com.stepdefs.ScenarioHooks;

import cucumber.api.java8.En;

public class AISM39Stepdefs implements En {
	
	public AISM39Stepdefs(ScenarioHooks hooks, HomePage homePage, AccessManagementPage accessManagementPage) {
		
		When("I click Maintenance tab", () -> {
			homePage.clickMaintenanceTab();
		});
		
		And("I select Access Management", () -> {
			homePage.clickAccessManagement();
			accessManagementPage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
		});
		
		Then("Access Management page should be loaded successfully", () -> {
			accessManagementPage.verifySuccessfulNavigationToAccessManagementPage();
		});
		
		/*-----------------------------*/
		
		And("I click Add User button", () -> {
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
		
		And("I click Save", () -> {
			accessManagementPage.clickSaveButton();
		});
		
		Then("User should be added successfully", () -> {
			accessManagementPage.verifySuccessfulSavingOfUser();
		});
		
		/*-----------------------------*/
		
		Then("User should not be added successfully", () -> {
			accessManagementPage.verifyUnsuccessfulSavingOfUser();
		});
		
		/*-----------------------------*/
		
		And("I click the user with name: (.*)", (String name) -> {
			accessManagementPage.selectInList(name);
			accessManagementPage.verifyEditUserPopUp();
		});
		
		And("I edit the fields with values: Employee Id: (.*), Name: (.*), Role: (.*)", (String employeeId, String name, String role) -> {
			accessManagementPage.inputEmployeeId(employeeId);
			accessManagementPage.inputName(name);
			accessManagementPage.selectRole(role);
		});
		
		Then("User should be editted successfully with new values: Employee Id: (.*), Name: (.*), Role: (.*)", (String employeeId, String name, String role) -> {
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
			accessManagementPage.selectInList(name);
			accessManagementPage.verifyEditUserPopUp();
			accessManagementPage.verifyFromAndToDates();
		});
		
		/*-----------------------------*/
		
		And("I click the delete button of user (.*)", (String name) -> {
			accessManagementPage.clickDeleteButtonOfSelected(name);
			accessManagementPage.verifyDeleteUserPopUp();
			accessManagementPage.clickDeleteUserButton();
		});
		
		Then("(.*) should be deleted successfully", (String name) -> {
			accessManagementPage.verifyIfDeleted(name);
		});
		
		/*-----------------------------*/
		
		And("I go to Roles section", () -> {
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
			accessManagementPage.verifySuccessfulSavingOfRole();
		});
		
		/*-----------------------------*/
		
		Then("Role should not be added successfully", () -> {
			accessManagementPage.verifyUnsuccessfulSavingOfRole();
		});
		
		/*-----------------------------*/
		
		And("I click the role with name: (.*)", (String name) -> {
			accessManagementPage.selectInList(name);
			accessManagementPage.verifyEditRolePopUp();
		});
		
		And("I edit the fields with values: Role Name: (.*), Roles: (.*)", (String roleName, String roles) -> {
			accessManagementPage.inputRoleName(roleName);
			accessManagementPage.selectRoles(roles);
		});
		
		Then("Role should be editted successfully with new values: Role Name: (.*), Roles: (.*)", (String roleName, String roles) -> {
			accessManagementPage.selectInList(roleName);
			accessManagementPage.verifyEditRolePopUp();
			accessManagementPage.checkRoleName(roleName);
			accessManagementPage.verifyIfRoleIsSelected(roles);
		});
		
		/*-----------------------------*/
		
		And("I click the delete button of role (.*)", (String name) -> {
			accessManagementPage.clickDeleteButtonOfSelected(name);
			accessManagementPage.verifyDeleteRolePopUp();
			accessManagementPage.clickDeleteRoleButton();
		});
		
	}

}
