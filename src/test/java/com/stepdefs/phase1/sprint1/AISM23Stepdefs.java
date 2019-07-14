package com.stepdefs.phase1.sprint1;

import com.constants.CommonConstants;
import com.pageobjects.CorrelationPage;
import com.pageobjects.CreateNewFilterPage;
import com.pageobjects.ExtendedRulePage;
import com.stepdefs.ScenarioHooks;

import cucumber.api.java8.En;

public class AISM23Stepdefs implements En {

	public AISM23Stepdefs(ScenarioHooks hooks, CreateNewFilterPage createNewFilterPage,
			ExtendedRulePage extendedRulePage, CorrelationPage correlationPage) {
		
		And("add a Correlation condition: (.*) occurences in (.*) (.*)", (String frequency, String timeValue, String timeUnit) -> {
			extendedRulePage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			correlationPage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			
			createNewFilterPage.addExtendedRule();
			extendedRulePage.selectExtendedRule(CommonConstants.EXTENDED_RULE_CORRELATION);
			correlationPage.inputFrequency(frequency);
			correlationPage.inputTimeValue(timeValue);
			correlationPage.selectTimeUnit(timeUnit);
		});
	}
}
