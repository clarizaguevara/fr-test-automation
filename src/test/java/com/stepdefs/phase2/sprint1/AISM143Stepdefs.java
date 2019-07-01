package com.stepdefs.phase2.sprint1;

import com.pageobjects.CreateNewFilterPage;
import com.pageobjects.FilterRulePage;
import com.stepdefs.ScenarioHooks;
import com.utils.DataHelper;

import cucumber.api.java8.En;

public class AISM143Stepdefs implements En {
	
	public AISM143Stepdefs(ScenarioHooks hooks, CreateNewFilterPage createNewFilterPage, FilterRulePage filterRulePage) {
		
		When("I select (.*) as source", (String source) -> {
			createNewFilterPage.selectSource(source);
		});
		
		Then("Keyword dropdown should have the correct values for source: (.*)", (String source) -> {
			filterRulePage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			filterRulePage.verifyKeywordDropdownValues(DataHelper.getLOV(source));
		});
		
	}

}
