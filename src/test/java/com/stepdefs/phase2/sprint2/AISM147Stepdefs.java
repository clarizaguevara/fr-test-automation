package com.stepdefs.phase2.sprint2;

import com.pageobjects.FilterRulePage;
import com.stepdefs.ScenarioHooks;

import cucumber.api.java8.En;

public class AISM147Stepdefs implements En {
	
	public AISM147Stepdefs(ScenarioHooks hooks, FilterRulePage filterRulePage) {
		
		And("(.*) group has conditions: (.*)", (String groupNumber, String rules) -> {
			filterRulePage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			filterRulePage.selectRulesByGroup(String.valueOf(groupNumber.charAt(0)), rules);
		});
		
		And("I add another group - (.*) (.*)", (String condition, String groupNumber) -> {
			filterRulePage.clickAddGroupButton();
			filterRulePage.clickANDORGroupButton(groupNumber, condition);
		});
	}

}
