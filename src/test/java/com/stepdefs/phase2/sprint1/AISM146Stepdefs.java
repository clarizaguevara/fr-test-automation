package com.stepdefs.phase2.sprint1;

import com.constants.CommonConstants;
import com.pageobjects.AccessManagementPage;
import com.pageobjects.HomePage;
import com.pageobjects.KeywordListsPage;
import com.stepdefs.ScenarioHooks;

import cucumber.api.java8.En;

public class AISM146Stepdefs implements En {
	
	public AISM146Stepdefs(ScenarioHooks hooks, HomePage homePage, KeywordListsPage keywordListsPage, AccessManagementPage accessManagementPage) {
		
		And("I am on Keyword Lists page", () -> {
			homePage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			homePage.verifySuccessfulNavigationToHomePage();
			homePage.clickMaintenanceTab(CommonConstants.PAGE_MAINTENANCE_KEYWORDS);
			keywordListsPage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			keywordListsPage.verifySuccessfulNavigationToKeywordListsPage();
		});
		
		When("I select Keyword Lists", () -> {
			homePage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			homePage.clickMaintenanceTab(CommonConstants.PAGE_MAINTENANCE_KEYWORDS);
			keywordListsPage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
		});
		
		When("I add new keyword list", () -> {
			keywordListsPage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			keywordListsPage.clickNewKeywordListButton();
			keywordListsPage.inputListName(CommonConstants.KEYWORD_LISTNAME);
			keywordListsPage.inputKeywords(CommonConstants.KEYWORD_KEYWORDVALUE);
			keywordListsPage.clickAddIcon();
			keywordListsPage.clickSaveButton();
		});
		
		When("I edit existing keyword lists", () -> {
			keywordListsPage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			keywordListsPage.selectKeywordInList(CommonConstants.KEYWORD_LISTNAME);
			keywordListsPage.inputListName(CommonConstants.KEYWORD_LISTNAME_EDITED);
			keywordListsPage.clickSaveButton();
		});
		
		When("I delete existing keyword lists", () -> {
			keywordListsPage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			accessManagementPage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			accessManagementPage.clickDeleteButtonOfSelected(CommonConstants.KEYWORD_LISTNAME_EDITED);
			keywordListsPage.clickDeleteKeywordButton();
		});
		
		When("I left mandatory fields blank in Add New Keyword List popup", () -> {
			keywordListsPage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			keywordListsPage.clickNewKeywordListButton();
			keywordListsPage.clickSaveButton();
		});
		
		Then("Keyword Lists page should be loaded successfully", () -> {
			keywordListsPage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			keywordListsPage.verifySuccessfulNavigationToKeywordListsPage();
		});
		
		Then("I should be able to add keyword list successfully", () -> {
			keywordListsPage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			keywordListsPage.verifyKeywordListIsSaved(CommonConstants.KEYWORD_LISTNAME, true);
		});
		
		Then("I should be able to edit keyword list successfully", () -> {
			keywordListsPage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			keywordListsPage.verifyKeywordListIsEdited(CommonConstants.KEYWORD_LISTNAME_EDITED);
		});
		
		Then("I should be able to delete keyword list successfully", () -> {
			keywordListsPage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			keywordListsPage.isKeywordListPresent(CommonConstants.KEYWORD_LISTNAME_EDITED, false);
		});
		
		Then("Keyword list should not be added successfully", () -> {
			keywordListsPage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			keywordListsPage.verifyKeywordListIsSaved(CommonConstants.KEYWORD_LISTNAME, false);
		});
	}
}
