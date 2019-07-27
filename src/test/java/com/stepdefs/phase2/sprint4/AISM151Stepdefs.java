package com.stepdefs.phase2.sprint4;

import com.pageobjects.ApplyTemplatesPage;
import com.pageobjects.CreateNewFilterPage;
import com.pageobjects.CreateNewTemplatePage;
import com.pageobjects.HomePage;
import com.pageobjects.TemplatesManagementPage;
import com.stepdefs.ScenarioHooks;

import cucumber.api.java8.En;

public class AISM151Stepdefs implements En {
	
	public AISM151Stepdefs(ScenarioHooks hooks, HomePage homePage, TemplatesManagementPage templatesManagementPage,
			CreateNewTemplatePage createNewTemplatePage, CreateNewFilterPage createNewFilterPage, ApplyTemplatesPage applyTemplatesPage) {
		
		And("I apply template (.*)", (String templateName) -> {
			createNewFilterPage.clickApplyTemplatesButton();
			applyTemplatesPage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			applyTemplatesPage.verifyApplyTemplatesPopUp();
			applyTemplatesPage.inputTemplateName(templateName);
			applyTemplatesPage.verifyIfTemplateIsSelected(templateName);
			applyTemplatesPage.clickApply();
		});
		
		And("filter conditions and actions of (.*) (.*) should be applied", (String templateName, String versionNumber) -> {
			createNewFilterPage.verifyIfTemplateIsApplied(templateName, versionNumber);
			createNewFilterPage.clickApplyTemplatesButton();
			applyTemplatesPage.verifyApplyTemplatesPopUp();
			applyTemplatesPage.verifyActiveTemplate(templateName);
		});
		
		/*-----------------------------*/
		
		Then("I should not be able to apply (.*)", (String templateName) -> {
			createNewFilterPage.clickApplyTemplatesButton();
			applyTemplatesPage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			applyTemplatesPage.verifyApplyTemplatesPopUp();
			applyTemplatesPage.inputTemplateName(templateName);
			applyTemplatesPage.verifyIfTemplateIsNotSelected(templateName);
			applyTemplatesPage.clickCancel();
		});
		
		/*-----------------------------*/
		
		When("I go back to Templates Management page", () -> {
			homePage.clickMaintenanceTab();
			homePage.clickTemplatesManagement();
			templatesManagementPage.verifySuccessfulNavigationToTemplatesManagementPage();
		});
		
		When("I open template (.*)", (String templateName) -> {
			templatesManagementPage.selectTemplateInList(templateName);
		});
		
		And("click Apply Changes", () -> {
			createNewTemplatePage.clickApplyChangesButton();
			createNewTemplatePage.verifyApplyChangesPopUp();
		});
		
		Then("it should list all filters that uses the template with version older than (.*)", (String versionNumber) -> {
			
		});
		
	}

}
