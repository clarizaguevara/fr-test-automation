package com.stepdefs.phase2.sprint2;

import com.pageobjects.CreateNewFilterPage;
import com.pageobjects.CreateNewTemplatePage;
import com.pageobjects.DeleteFilterPage;
import com.pageobjects.FilterRulePage;
import com.pageobjects.HomePage;
import com.pageobjects.TemplatesManagementPage;
import com.stepdefs.ScenarioHooks;

import cucumber.api.java8.En;

public class AISM149Stepdefs implements En {
	
	public AISM149Stepdefs(ScenarioHooks hooks, HomePage homePage, TemplatesManagementPage templatesManagementPage,
			CreateNewTemplatePage createNewTemplatePage, CreateNewFilterPage createNewFilterPage, FilterRulePage filterRulePage, DeleteFilterPage deleteFilterPage) {
		
		And("I am on Templates Management page", () -> {
			homePage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			homePage.verifySuccessfulNavigationToHomePage();
			homePage.clickMaintenanceTab();
			homePage.clickTemplatesManagement();
			templatesManagementPage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			templatesManagementPage.verifySuccessfulNavigationToTemplatesManagementPage();
		});
		
		/*-----------------------------*/
		
		And("I select Templates Management", () -> {
			homePage.clickTemplatesManagement();
			templatesManagementPage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
		});
		
		Then("Templates Management page should be loaded successfully", () -> {
			templatesManagementPage.verifySuccessfulNavigationToTemplatesManagementPage();
		});
		
		/*-----------------------------*/
		
		When("I create a Template with template name (.*), template type (.*) and (.*) as source", (String templateName, String templateType, String source) -> {
			createNewTemplatePage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			createNewFilterPage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			
			templatesManagementPage.clickCreateNewTemplateButton();
			createNewFilterPage.verifySuccessfulNavigationToCreateNewFilterPage();
			createNewTemplatePage.inputTemplateName(templateName);
			createNewTemplatePage.selectTemplateType(templateType);
			createNewFilterPage.selectSource(source);
		});
		
		Then("template should be saved successfully", () -> {
			createNewFilterPage.clickSaveButton();
			createNewFilterPage.verifyFilterSuccessfullySaved();
		});
		
		/*-----------------------------*/
		
		Then("template should not be saved", () -> {
			createNewFilterPage.clickSaveButton();
			createNewFilterPage.verifyFilterisNOTSuccessfullySaved();
		});
		
		/*-----------------------------*/
		
		When("I go back to Template Browse page and open template (.*)", (String templateName) -> {
			homePage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			homePage.verifySuccessfulNavigationToHomePage();
			homePage.clickMaintenanceTab();
			homePage.clickTemplatesManagement();
			templatesManagementPage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			templatesManagementPage.verifySuccessfulNavigationToTemplatesManagementPage();
			templatesManagementPage.selectTemplateInList(templateName);
			createNewFilterPage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			createNewFilterPage.verifySuccessfulNavigationToEditFilterPage();
		});
		
		Then("template (.*) should be editted successfully with new Filter rule values: (.*) (.*) (.*)", (String templateName, String keyword, String comparator, String keywordValue) -> {
			homePage.clickMaintenanceTab();
			homePage.clickTemplatesManagement();
			templatesManagementPage.verifySuccessfulNavigationToTemplatesManagementPage();
			templatesManagementPage.selectTemplateInList(templateName);
			createNewFilterPage.verifySuccessfulNavigationToEditFilterPage();
			createNewTemplatePage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			createNewTemplatePage.checkTemplateName(templateName);
			filterRulePage.checkKeywordValue(keywordValue);
		});
		
		/*-----------------------------*/
		
		Then("version number of template (.*) should be (.*)", (String templateName, String versionNumber) -> {
			templatesManagementPage.verifyTemplateVersion(templateName, versionNumber);
		});
		
	}

}
