package com.stepdefs;

import com.pageobjects.CreateNewFilterPage;
import com.pageobjects.FilterRulePage;
import com.pageobjects.LoginPage;
import com.pageobjects.SendToSlackActionPage;
import com.utils.PropertyUtil;

import cucumber.api.java8.En;

public class AISM7Stepdefs implements En {
	
	public AISM7Stepdefs(ScenarioHooks hooks, LoginPage loginPage, CreateNewFilterPage createNewFilterPage, FilterRulePage filterRulePage,
			SendToSlackActionPage sendToSlackActionPage) {
	
		Given("I am login$", () -> {
			loginPage.setDriver(hooks.getDriverHelper(), hooks.getScenarioName());
			loginPage.navigateToLoginPage();
		});
		
		And("I am on Create New Filter page$", () -> {
			createNewFilterPage.setDriver(hooks.getDriverHelper(), hooks.getScenarioName());
			createNewFilterPage.clickCreateNewFilterButton();
			createNewFilterPage.verifySuccessfulNavigationToCreateNewFilterPage();
		});
		
		When("I create Filter so that message is sent to users on Slack automatically with filter name (.*), source value Nagios-Pet$", (String filterName) -> {
			loginPage.setDriver(hooks.getDriverHelper(), hooks.getScenarioName());
			createNewFilterPage.setDriver(hooks.getDriverHelper(), hooks.getScenarioName());
			filterRulePage.setDriver(hooks.getDriverHelper(), hooks.getScenarioName());
			sendToSlackActionPage.setDriver(hooks.getDriverHelper(), hooks.getScenarioName());
			loginPage.navigateToLoginPage();
			createNewFilterPage.clickCreateNewFilterButton();
			createNewFilterPage.verifySuccessfulNavigationToCreateNewFilterPage();
			createNewFilterPage.inputFilterName(filterName);
			createNewFilterPage.selectSource("Nagios-Pet");
			createNewFilterPage.inputOwnerName(PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "AISM7.OwnerName"));
			filterRulePage.selectKeyword(PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "keyword.summary"));
			filterRulePage.selectComparator(PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "comparator.contains"));
			filterRulePage.inputKeywordValue(PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "AISM7.KeywordValue"));
			createNewFilterPage.selectAction(PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "AISM7.Action"));
			sendToSlackActionPage.inputSlackChannel(PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "slackChannel.dev"));
			sendToSlackActionPage.inputSlackMessage(PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "AISM7.SlackMessage"));
		});
		
		When("I create Filter so that message is sent to users on Slack automatically with filter name (.*), source value Cisco Meraki$", (String filterName) -> {
			loginPage.setDriver(hooks.getDriverHelper(), hooks.getScenarioName());
			createNewFilterPage.setDriver(hooks.getDriverHelper(), hooks.getScenarioName());
			filterRulePage.setDriver(hooks.getDriverHelper(), hooks.getScenarioName());
			sendToSlackActionPage.setDriver(hooks.getDriverHelper(), hooks.getScenarioName());
			loginPage.navigateToLoginPage();
			createNewFilterPage.clickCreateNewFilterButton();
			createNewFilterPage.verifySuccessfulNavigationToCreateNewFilterPage();
			createNewFilterPage.inputFilterName(filterName);
			createNewFilterPage.selectSource("Cisco Meraki");
			createNewFilterPage.inputOwnerName(PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "AISM7.OwnerName"));
			filterRulePage.selectKeyword(PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "keyword.country"));
			filterRulePage.selectComparator(PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "comparator.equals"));
			filterRulePage.inputKeywordValue(PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "keywordValue.country"));
			createNewFilterPage.selectAction(PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "AISM7.Action"));
			sendToSlackActionPage.inputSlackChannel(PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "slackChannel.dev"));
			sendToSlackActionPage.inputSlackMessage(PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "AISM7.SlackMessage"));
		});
		
		And("I ticked include original alert message$", () -> {
			sendToSlackActionPage.setDriver(hooks.getDriverHelper(), hooks.getScenarioName());
			sendToSlackActionPage.checkIncludeOriginalAlertMessage();
		});
		
		And("I add mention$", () -> {
			sendToSlackActionPage.setDriver(hooks.getDriverHelper(), hooks.getScenarioName());
			sendToSlackActionPage.inputSlackMessage(PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "AISM7.Mention"));
		});
		
		And("I left Slack Channel field blank$", () -> {
			sendToSlackActionPage.setDriver(hooks.getDriverHelper(), hooks.getScenarioName());
			sendToSlackActionPage.inputSlackMessage(PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "AISM7.SlackChannelBlank"));
		});
		
		Then("I should be able to save successfully$", () -> {
			createNewFilterPage.setDriver(hooks.getDriverHelper(), hooks.getScenarioName());
			createNewFilterPage.clickSaveButton();
			createNewFilterPage.verifyFilterSuccessfullySaved();
		});
		
		Then("I should not be able to save successfully$", () -> {
			createNewFilterPage.setDriver(hooks.getDriverHelper(), hooks.getScenarioName());
			createNewFilterPage.clickSaveButton();
			createNewFilterPage.verifyFilterisNOTSuccessfullySaved();
		});
	}
}
