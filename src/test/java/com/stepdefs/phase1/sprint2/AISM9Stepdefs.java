package com.stepdefs.phase1.sprint2;

import com.constants.CommonConstants;
import com.pageobjects.CreateNewFilterPage;
import com.pageobjects.ExtendedRulePage;
import com.pageobjects.FilterRulePage;
import com.pageobjects.LoginPage;
import com.pageobjects.SendToSlackActionPage;
import com.pageobjects.SuppressionPage;
import com.stepdefs.ScenarioHooks;
import com.utils.SuppressionUtil;

import cucumber.api.java8.En;

public class AISM9Stepdefs implements En {
	
	public AISM9Stepdefs(ScenarioHooks hooks, LoginPage loginPage, CreateNewFilterPage createNewFilterPage, FilterRulePage filterRulePage,
			ExtendedRulePage extendedRulePage, SuppressionPage suppressionPage, SuppressionUtil suppressionUtil, SendToSlackActionPage sendToSlackActionPage) {

		Given("I am to create a filter with Suppression condition and I am on Create New Filter page", () -> {
			loginPage.setDriver(hooks.getDriverHelper(), hooks.getScenarioName());
			createNewFilterPage.setDriver(hooks.getDriverHelper(), hooks.getScenarioName());
			
			loginPage.navigateToLoginPage();
			createNewFilterPage.clickCreateNewFilterButton();
			createNewFilterPage.verifySuccessfulNavigationToCreateNewFilterPage();
		});

		When("I create a Filter with filter name (.*), Filter rule: (.*) - (.*) - (.*), and add a Suppression condition with fields: time= (.*) to (.*), timezone= (.*), days= (.*), (.*) these time ranges", (String filterName, String keyword, String comparator, String keywordValue, String timeFrom, String timeTo, String timezone, String days, String timeRange) -> {
			filterRulePage.setDriver(hooks.getDriverHelper(), hooks.getScenarioName());
			extendedRulePage.setDriver(hooks.getDriverHelper(), hooks.getScenarioName());
			suppressionPage.setDriver(hooks.getDriverHelper(), hooks.getScenarioName());
			sendToSlackActionPage.setDriver(hooks.getDriverHelper(), hooks.getScenarioName());
			
			//filter
			createNewFilterPage.inputFilterName(filterName);
			createNewFilterPage.selectSource(CommonConstants.SOURCE_CISCO_MERAKI);
			filterRulePage.selectKeyword(keyword);
			filterRulePage.selectComparator(comparator);
			filterRulePage.inputKeywordValue(keywordValue);
			
			//suppression
			createNewFilterPage.addExtendedRule();
			extendedRulePage.selectExtendedRule(CommonConstants.EXTENDED_RULE_SUPPRESSION);
			suppressionUtil.selectTime(timeFrom, timeTo, suppressionPage);
			suppressionPage.setTimezone(timezone);
			suppressionUtil.selectDays(days,suppressionPage);
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
