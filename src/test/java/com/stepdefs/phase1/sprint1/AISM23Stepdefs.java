package com.stepdefs.phase1.sprint1;

import com.constants.CommonConstants;
import com.pageobjects.CorrelationPage;
import com.pageobjects.CreateNewFilterPage;
import com.pageobjects.ExtendedRulePage;
import com.pageobjects.FilterRulePage;
import com.pageobjects.LoginPage;
import com.pageobjects.SendToSlackActionPage;
import com.stepdefs.ScenarioHooks;

import cucumber.api.java8.En;

public class AISM23Stepdefs implements En {

	public AISM23Stepdefs(ScenarioHooks hooks, LoginPage loginPage, CreateNewFilterPage createNewFilterPage, FilterRulePage filterRulePage,
			ExtendedRulePage extendedRulePage, CorrelationPage correlationPage, SendToSlackActionPage sendToSlackActionPage) {
		
		Given("I am to create a filter with Correlation condition and I am on Create New Filter page", () -> {
			loginPage.setDriver(hooks.getDriverHelper(), hooks.getScenarioName());
			createNewFilterPage.setDriver(hooks.getDriverHelper(), hooks.getScenarioName());
			
			loginPage.navigateToLoginPage();
			createNewFilterPage.clickCreateNewFilterButton();
			createNewFilterPage.verifySuccessfulNavigationToCreateNewFilterPage();
		});
	
		When("I create a Filter with filter name (.*), (.*) as source, Filter rule: (.*) - (.*) - (.*), and add a Correlation condition: (.*) occurences in (.*) (.*)", (String filterName, String source, String keyword, String comparator, String keywordValue, String frequency, String timeValue, String timeUnit) -> {
			filterRulePage.setDriver(hooks.getDriverHelper(), hooks.getScenarioName());
			extendedRulePage.setDriver(hooks.getDriverHelper(), hooks.getScenarioName());
			correlationPage.setDriver(hooks.getDriverHelper(), hooks.getScenarioName());
			sendToSlackActionPage.setDriver(hooks.getDriverHelper(), hooks.getScenarioName());
			
			//filter
			createNewFilterPage.inputFilterName(filterName);
			createNewFilterPage.selectSource(source);
			filterRulePage.selectKeyword(keyword);
			filterRulePage.selectComparator(comparator);
			filterRulePage.inputKeywordValue(keywordValue);
			
			//correlation
			createNewFilterPage.addExtendedRule();
			extendedRulePage.selectExtendedRule(CommonConstants.EXTENDED_RULE_CORRELATION);
			correlationPage.inputFrequency(frequency);
			correlationPage.inputTimeValue(timeValue);
			correlationPage.selectTimeUnit(timeUnit);
			
			//action
			createNewFilterPage.selectAction(CommonConstants.ACTION_SEND_TO_SLACK);
			sendToSlackActionPage.inputSlackChannel(CommonConstants.SLACK_CHANNEL);
			sendToSlackActionPage.inputSlackMessage(filterName);
			sendToSlackActionPage.checkIncludeOriginalAlertMessage();
		});

		Then("filter with Correlation condition should be saved successfully", () -> {
			createNewFilterPage.clickSaveButton();
			createNewFilterPage.verifyFilterSuccessfullySaved();
		});

	
	}
}
