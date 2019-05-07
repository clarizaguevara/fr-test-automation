package com.stepdefs.phase1.sprint2;

import com.constants.CommonConstants;
import com.pageobjects.CreateNewFilterPage;
import com.pageobjects.ExtendedRulePage;
import com.pageobjects.FilterRulePage;
import com.pageobjects.LoginPage;
import com.pageobjects.SNOWDuplicateConditionPage;
import com.pageobjects.SendToSlackActionPage;
import com.stepdefs.ScenarioHooks;

import cucumber.api.java8.En;

public class AISM12Stepdefs implements En {
	
	public AISM12Stepdefs(ScenarioHooks hooks, LoginPage loginPage, CreateNewFilterPage createNewFilterPage, FilterRulePage filterRulePage,
			ExtendedRulePage extendedRulePage, SNOWDuplicateConditionPage snowDuplicateConditionPage, SendToSlackActionPage sendToSlackActionPage) {

		Given("I am to create a filter with Snow Duplicate Check condition and I am on Create New Filter page", () -> {
			loginPage.setDriver(hooks.getDriverHelper(), hooks.getScenarioName());
			createNewFilterPage.setDriver(hooks.getDriverHelper(), hooks.getScenarioName());
			
			loginPage.navigateToLoginPage();
			createNewFilterPage.clickCreateNewFilterButton();
			createNewFilterPage.verifySuccessfulNavigationToCreateNewFilterPage();
		});

		When("I create a Filter with filter name (.*), (.*) as source, Filter rule: (.*) - (.*) - (.*), and add a Snow Duplicate Check condition: (.*) open tickets for (.*)", (String filterName, String source, String keyword, String comparator, String keywordValue, String with, String snowKeyword) -> {
			filterRulePage.setDriver(hooks.getDriverHelper(), hooks.getScenarioName());
			extendedRulePage.setDriver(hooks.getDriverHelper(), hooks.getScenarioName());
			snowDuplicateConditionPage.setDriver(hooks.getDriverHelper(), hooks.getScenarioName());
			sendToSlackActionPage.setDriver(hooks.getDriverHelper(), hooks.getScenarioName());
			
			//filter
			createNewFilterPage.inputFilterName(filterName);
			createNewFilterPage.selectSource(source);
			filterRulePage.selectKeyword(keyword);
			filterRulePage.selectComparator(comparator);
			filterRulePage.inputKeywordValue(keywordValue);
			
			//snow duplicate
			createNewFilterPage.addExtendedRule();
			extendedRulePage.selectExtendedRule(CommonConstants.EXTENDED_RULE_SNOW_DUPLICATE);
			snowDuplicateConditionPage.selectWithOrWithout(with);
			snowDuplicateConditionPage.selectKeyword(snowKeyword);
			
			//action
			createNewFilterPage.selectAction(CommonConstants.ACTION_SEND_TO_SLACK);
			sendToSlackActionPage.inputSlackChannel(CommonConstants.SLACK_CHANNEL);
			sendToSlackActionPage.inputSlackMessage(filterName);
			sendToSlackActionPage.checkIncludeOriginalAlertMessage();
		});
		
		Then("filter with Snow Duplicate Check condition should be saved successfully", () -> {
			createNewFilterPage.clickSaveButton();
			createNewFilterPage.verifyFilterSuccessfullySaved();
		});

	
	}

}
