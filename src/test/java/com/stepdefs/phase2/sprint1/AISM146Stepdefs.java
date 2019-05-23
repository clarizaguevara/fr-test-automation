package com.stepdefs.phase2.sprint1;

import com.constants.CommonConstants;
import com.pageobjects.AccessManagementPage;
import com.pageobjects.HomePage;
import com.pageobjects.KeywordListsPage;
import com.stepdefs.ScenarioHooks;

import cucumber.api.java8.En;

public class AISM146Stepdefs implements En {
	
	public AISM146Stepdefs(ScenarioHooks hooks, HomePage homePage, KeywordListsPage keywordListsPage, AccessManagementPage accessManagementPage) {
		
		And("I select Keyword Lists", () -> {
			homePage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			homePage.clickKeywordLists();
		});
		
		And("I add new keyword list", () -> {
			keywordListsPage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			keywordListsPage.clickNewKeywordListButton();
			keywordListsPage.inputListName(CommonConstants.KEYWORD_LISTNAME);
			keywordListsPage.inputKeywords(CommonConstants.KEYWORD_KEYWORDVALUE);
			keywordListsPage.clickAddIcon();
			keywordListsPage.clickSaveButton();
		});
		
		And("I edit existing keyword lists", () -> {
			keywordListsPage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			keywordListsPage.selectKeywordInList(CommonConstants.KEYWORD_LISTNAME);
			keywordListsPage.inputListName(CommonConstants.KEYWORD_LISTNAME_EDITED);
			keywordListsPage.clickSaveButton();
		});
		
		And("I delete existing keyword lists", () -> {
			keywordListsPage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			accessManagementPage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			accessManagementPage.clickDeleteButtonOfSelected(CommonConstants.KEYWORD_LISTNAME_EDITED);
			keywordListsPage.clickDeleteKeywordButton();
		});
		
		And("I left mandatory fields blank in Add New Keyword List popup", () -> {
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
			keywordListsPage.verifyKeywordListIsSaved(CommonConstants.KEYWORD_LISTNAME);
		});
		
		Then("I should be able to edit keyword list successfully", () -> {
			keywordListsPage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			keywordListsPage.verifyKeywordListIsEdited(CommonConstants.KEYWORD_LISTNAME_EDITED);
		});
		
		Then("I should be able to delete keyword list successfully", () -> {
			keywordListsPage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			keywordListsPage.verifyKeywordListIsDeleted(CommonConstants.KEYWORD_LISTNAME_EDITED);
		});
		
		Then("Keyword list should not be added successfully", () -> {
			keywordListsPage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			keywordListsPage.verifyKeywordListIsNotSaved();
		});
	}
}
