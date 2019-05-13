package com.stepdefs.phase1.sprint2;

import com.constants.CommonConstants;
import com.pageobjects.CreateNewFilterPage;
import com.pageobjects.ExtendedRulePage;
import com.pageobjects.FilterRulePage;
import com.pageobjects.SendToSlackActionPage;
import com.pageobjects.SuppressionPage;
import com.stepdefs.ScenarioHooks;

import cucumber.api.java8.En;

public class AISM9Stepdefs implements En {
	
	public AISM9Stepdefs(ScenarioHooks hooks, CreateNewFilterPage createNewFilterPage, FilterRulePage filterRulePage,
			ExtendedRulePage extendedRulePage, SuppressionPage suppressionPage, SendToSlackActionPage sendToSlackActionPage) {

		When("I create a Filter with filter name (.*), Filter rule: (.*) - (.*) - (.*), and add a Suppression condition with fields: time= (.*) to (.*), timezone= (.*), days= (.*), (.*) these time ranges", (String filterName, String keyword, String comparator, String keywordValue, String timeFrom, String timeTo, String timezone, String days, String timeRange) -> {
			filterRulePage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			extendedRulePage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			suppressionPage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			sendToSlackActionPage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			
			//filter
			createNewFilterPage.inputFilterName(filterName);
			createNewFilterPage.selectSource(CommonConstants.SOURCE_CISCO_MERAKI);
			filterRulePage.selectKeyword(keyword);
			filterRulePage.selectComparator(comparator);
			filterRulePage.inputKeywordValue(keywordValue);
			
			//suppression
			createNewFilterPage.addExtendedRule();
			extendedRulePage.selectExtendedRule(CommonConstants.EXTENDED_RULE_SUPPRESSION);
			suppressionPage.selectTimeFrom(timeFrom);
			suppressionPage.selectTimeTo(timeTo);
			suppressionPage.setTimezone(timezone);
			suppressionPage.selectDays(days);
			suppressionPage.selectTimeRange(timeRange);
			
			//action
			createNewFilterPage.selectAction(CommonConstants.ACTION_SEND_TO_SLACK);
			sendToSlackActionPage.inputSlackChannel(CommonConstants.SLACK_CHANNEL);
			sendToSlackActionPage.inputSlackMessage(filterName);
			sendToSlackActionPage.checkIncludeOriginalAlertMessage();
		});
		
		Then("filter with Suppression condition should be saved successfully", () -> {
			createNewFilterPage.clickSaveButton();
			createNewFilterPage.verifyFilterSuccessfullySaved();
		});

	
	}

}
