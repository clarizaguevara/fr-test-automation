package com.stepdefs.phase2.sprint1;

import com.pageobjects.FilterRulePage;
import com.pageobjects.KeywordListsPage;
import com.stepdefs.ScenarioHooks;

import cucumber.api.java8.En;

public class AISM145Stepdefs implements En {
	
	public AISM145Stepdefs(ScenarioHooks hooks, FilterRulePage filterRulePage, KeywordListsPage keywordListsPage) {
		
		And("I create a new Keyword List with name: (.*)", (String keywordName) -> {
			keywordListsPage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			keywordListsPage.clickNewKeywordListButton();
			keywordListsPage.inputListName(keywordName);
		});
		
		And("with Keyword values: (.*)", (String keywordValues) -> {
			keywordListsPage.inputKeywords(keywordValues);
			keywordListsPage.clickAddIcon();
			keywordListsPage.clickSaveButton();
		});
		
		Then("Keyword List with name: (.*) should be created successfully", (String keywordName) -> {
			keywordListsPage.verifyKeywordListIsSaved(keywordName);
		});
		
		And("with comparator: Contains Keywords (.*)", (String keywordValue) -> {
			filterRulePage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			filterRulePage.selectKeywordValue(keywordValue);
		});
	}
}
