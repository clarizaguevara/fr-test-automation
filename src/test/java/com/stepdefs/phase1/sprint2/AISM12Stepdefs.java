package com.stepdefs.phase1.sprint2;

import com.constants.CommonConstants;
import com.pageobjects.CreateNewFilterPage;
import com.pageobjects.ExtendedRulePage;
import com.pageobjects.SNOWDuplicateConditionPage;
import com.stepdefs.ScenarioHooks;

import cucumber.api.java8.En;

public class AISM12Stepdefs implements En {
	
	public AISM12Stepdefs(ScenarioHooks hooks, CreateNewFilterPage createNewFilterPage,
			ExtendedRulePage extendedRulePage, SNOWDuplicateConditionPage snowDuplicateConditionPage) {

		And("add a Snow Duplicate Check condition: (.*) open tickets where (.*) contains (.*)", (String with, String snowKeyword, String field) -> {
			extendedRulePage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			snowDuplicateConditionPage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			
			createNewFilterPage.addExtendedRule();
			extendedRulePage.selectExtendedRule(CommonConstants.EXTENDED_RULE_SNOW_DUPLICATE);
			snowDuplicateConditionPage.selectWithOrWithout(with);
			snowDuplicateConditionPage.selectSnowKeyword(snowKeyword);
			snowDuplicateConditionPage.selectKeyword(field);
		});
	}
}
