package com.stepdefs.phase1.sprint2;

import com.constants.CommonConstants;
import com.pageobjects.CiscoMerakiCheckConditionPage;
import com.pageobjects.CreateNewFilterPage;
import com.pageobjects.ExtendedRulePage;
import com.pageobjects.FilterRulePage;
import com.pageobjects.LoginPage;
import com.pageobjects.SendToSlackActionPage;
import com.stepdefs.ScenarioHooks;

import cucumber.api.java8.En;

public class AISM11Stepdefs implements En {
	
	public AISM11Stepdefs(ScenarioHooks hooks, LoginPage loginPage, CreateNewFilterPage createNewFilterPage, FilterRulePage filterRulePage,
			ExtendedRulePage extendedRulePage, CiscoMerakiCheckConditionPage ciscoMerakiCheckConditionPage, SendToSlackActionPage sendToSlackActionPage) {

		Given("I am to create a filter with Cisco Meraki Check condition and I am on Create New Filter page", () -> {
			loginPage.setDriver(hooks.getDriverHelper(), hooks.getScenarioName());
			createNewFilterPage.setDriver(hooks.getDriverHelper(), hooks.getScenarioName());
			
			loginPage.navigateToLoginPage();
			createNewFilterPage.clickCreateNewFilterButton();
			createNewFilterPage.verifySuccessfulNavigationToCreateNewFilterPage();
		});

		When("I create a Filter with filter name (.*), (.*) as source, Filter rule: (.*) - (.*) - (.*), and add a Cisco Meraki Check condition: Check if device causing alert is (.*)", (String filterName, String source, String keyword, String comparator, String keywordValue, String deviceStatus) -> {
			filterRulePage.setDriver(hooks.getDriverHelper(), hooks.getScenarioName());
			extendedRulePage.setDriver(hooks.getDriverHelper(), hooks.getScenarioName());
			ciscoMerakiCheckConditionPage.setDriver(hooks.getDriverHelper(), hooks.getScenarioName());
			sendToSlackActionPage.setDriver(hooks.getDriverHelper(), hooks.getScenarioName());
			
			//filter
			createNewFilterPage.inputFilterName(filterName);
			createNewFilterPage.selectSource(source);
			filterRulePage.selectKeyword(keyword);
			filterRulePage.selectComparator(comparator);
			filterRulePage.inputKeywordValue(keywordValue);
			
			//cisco meraki check
			createNewFilterPage.addExtendedRule();
			extendedRulePage.selectExtendedRule(CommonConstants.EXTENDED_RULE_CISCO_MERAKI_CHECK);
			ciscoMerakiCheckConditionPage.selectDeviceStatus(deviceStatus);
			
			//action
			createNewFilterPage.selectAction(CommonConstants.ACTION_SEND_TO_SLACK);
			sendToSlackActionPage.inputSlackChannel(CommonConstants.SLACK_CHANNEL);
			sendToSlackActionPage.inputSlackMessage(filterName);
			sendToSlackActionPage.checkIncludeOriginalAlertMessage();
		});
		
		Then("filter with Cisco Meraki Check condition should be saved successfully", () -> {
			createNewFilterPage.clickSaveButton();
			createNewFilterPage.verifyFilterSuccessfullySaved();
		});

	
	}

}
