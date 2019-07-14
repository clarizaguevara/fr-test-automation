package com.stepdefs.phase1.sprint2;

import com.constants.CommonConstants;
import com.pageobjects.CreateNewFilterPage;
import com.pageobjects.ExtendedRulePage;
import com.pageobjects.SuppressionPage;
import com.stepdefs.ScenarioHooks;

import cucumber.api.java8.En;

public class AISM9Stepdefs implements En {
	
	public AISM9Stepdefs(ScenarioHooks hooks, CreateNewFilterPage createNewFilterPage,
			ExtendedRulePage extendedRulePage, SuppressionPage suppressionPage) {

		And("add a Suppression condition with fields: time= (.*) to (.*), timezone= (.*), days= (.*), (.*) these time ranges", (String timeFrom, String timeTo, String timezone, String days, String timeRange) -> {
			extendedRulePage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			suppressionPage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			
			createNewFilterPage.addExtendedRule();
			extendedRulePage.selectExtendedRule(CommonConstants.EXTENDED_RULE_SUPPRESSION);
			suppressionPage.selectTimeFrom(timeFrom);
			suppressionPage.selectTimeTo(timeTo);
			suppressionPage.setTimezone(timezone);
			suppressionPage.selectDays(days);
			suppressionPage.selectTimeRange(timeRange);
		});
	}
}
