package com.stepdefs.phase1.sprint1;

import com.constants.CommonConstants;
import com.pageobjects.CreateNewFilterPage;
import com.pageobjects.FilterRulePage;
import com.pageobjects.LoginPage;
import com.pageobjects.SendToSlackActionPage;
import com.stepdefs.ScenarioHooks;

import cucumber.api.java8.En;

public class AISM7Stepdefs implements En {
	
	public AISM7Stepdefs(ScenarioHooks hooks, LoginPage loginPage, CreateNewFilterPage createNewFilterPage, FilterRulePage filterRulePage,
			SendToSlackActionPage sendToSlackActionPage) {
	
		Given("I am login$", () -> {
			loginPage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			loginPage.navigateToLoginPage();
		});
		
		And("I ticked include original alert message$", () -> {
			sendToSlackActionPage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			sendToSlackActionPage.checkIncludeOriginalAlertMessage();
		});
		
		And("I add mention$", () -> {
			sendToSlackActionPage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			sendToSlackActionPage.inputSlackMessage(CommonConstants.SLACK_MENTION);
		});
		
		And("I left Slack Channel field blank$", () -> {
			sendToSlackActionPage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			sendToSlackActionPage.inputSlackChannel("");
		});
		
		Then("I should be able to save successfully$", () -> {
			createNewFilterPage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			createNewFilterPage.clickSaveButton();
			createNewFilterPage.verifyFilterSuccessfullySaved();
		});
		
		Then("I should not be able to save successfully$", () -> {
			createNewFilterPage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			createNewFilterPage.clickSaveButton();
			createNewFilterPage.verifyFilterisNOTSuccessfullySaved();
		});
	}
}
