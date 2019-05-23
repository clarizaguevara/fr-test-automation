package com.stepdefs.phase2.sprint1;

import com.pageobjects.FilterRulePage;
import com.stepdefs.ScenarioHooks;

import cucumber.api.java8.En;

public class AISM145Stepdefs implements En {
	
	public AISM145Stepdefs(ScenarioHooks hooks, FilterRulePage filterRulePage) {
		
		And("with comparator: Contains Keywords (.*)", (String keywordValue) -> {
			filterRulePage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			filterRulePage.selectKeywordValue(keywordValue);
		});
	}
}
