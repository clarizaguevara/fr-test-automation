package com.stepdefs.phase1.sprint3;

import org.junit.Assert;

import com.pageobjects.AccessManagementPage;
import com.pageobjects.HomePage;
import com.stepdefs.ScenarioHooks;
import com.utils.RolesUtil;
import com.utils.SourceUtil;

import cucumber.api.java8.En;

public class AISM39Stepdefs implements En {
	
	public AISM39Stepdefs(ScenarioHooks hooks, HomePage homePage, AccessManagementPage accessManagementPage, 
			SourceUtil sourceUtil, RolesUtil rolesUtil) {
		
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
			Assert.assertTrue("Values are not the same", (accessManagementPage.getEmployeeId()).equals(employeeId));
			Assert.assertTrue("Values are not the same", (accessManagementPage.getName()).equals(name));
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
			rolesUtil.selectRoles(roles,accessManagementPage);
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
		
		And("I edit the fields with values: Role Name: (.*)", (String roleName) -> {
			accessManagementPage.inputRoleName(roleName);
		});
		
		Then("Role should be editted successfully with new values: Role Name: (.*)", (String roleName) -> {
			accessManagementPage.selectInList(roleName);
			accessManagementPage.verifyEditRolePopUp();
			Assert.assertTrue("Values are not the same", (accessManagementPage.getRoleName()).equals(roleName));
		});
		
		/*-----------------------------*/
		
		And("I click the delete button of role (.*)", (String name) -> {
			accessManagementPage.clickDeleteButtonOfSelected(name);
			accessManagementPage.verifyDeleteRolePopUp();
			accessManagementPage.clickDeleteRoleButton();
		});
		
	}

}
