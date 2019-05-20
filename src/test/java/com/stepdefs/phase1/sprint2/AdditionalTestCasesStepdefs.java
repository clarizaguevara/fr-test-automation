package com.stepdefs.phase1.sprint2;

import com.constants.CommonConstants;
import com.pageobjects.CreateNewFilterPage;
import com.pageobjects.DeleteFilterPage;
import com.pageobjects.FilterRulePage;
import com.pageobjects.HomePage;
import com.pageobjects.SendToSlackActionPage;
import com.stepdefs.ScenarioHooks;

import cucumber.api.java8.En;

public class AdditionalTestCasesStepdefs implements En {
	
	public AdditionalTestCasesStepdefs(ScenarioHooks hooks, CreateNewFilterPage createNewFilterPage, FilterRulePage filterRulePage,
			SendToSlackActionPage sendToSlackActionPage, HomePage homePage, DeleteFilterPage deletePage) {

		/*VOID ACTION scenario*/
		
		When("I create a Filter with filter name (.*) and set Void as action", (String filterName) -> {
			createNewFilterPage.inputFilterName(filterName);
			createNewFilterPage.enableOrDisableFilter("disabled");
			filterRulePage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			filterRulePage.selectComparator("Contains");
			filterRulePage.inputKeywordValue("TEST");
		});
	
		Then("filter with Void action should be saved successfully", () -> {
			createNewFilterPage.clickSaveButton();
			createNewFilterPage.verifyFilterSuccessfullySaved();
		});
	
		/*EDIT scenario*/
		
		When("I create a Filter with filter name (.*), (.*) as source, and with Filter rule: (.*) (.*) (.*)", (String filterName, String source, String keyword, String comparator, String keywordValue) -> {
			createNewFilterPage.inputFilterName(filterName);
			createNewFilterPage.selectSource(source);
			createNewFilterPage.enableOrDisableFilter("disabled");
			filterRulePage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			filterRulePage.selectKeyword(keyword);
			filterRulePage.selectComparator(comparator);
			filterRulePage.inputKeywordValue(keywordValue);
			sendToSlackActionPage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			createNewFilterPage.selectAction(CommonConstants.ACTION_SEND_TO_SLACK);
			sendToSlackActionPage.inputSlackChannel(CommonConstants.SLACK_CHANNEL);
			sendToSlackActionPage.inputSlackMessage(filterName);
			sendToSlackActionPage.checkIncludeOriginalAlertMessage();
			createNewFilterPage.clickSaveButton();
			createNewFilterPage.verifyFilterSuccessfullySaved();
		});
		
		Then("I go back to Browse page and open filter (.*)", (String filterName) -> {
			createNewFilterPage.clickHomeButton();
			homePage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			homePage.verifySuccessfulNavigationToHomePage();
			homePage.inputFilterTitle(filterName);
			homePage.clickApplyButton();
			homePage.selectFilterInList(filterName);
			createNewFilterPage.verifySuccessfulNavigationToEditFilterPage();
			createNewFilterPage.checkFilterName(filterName);
		});
		
		And("I edit the Filter Rule to: (.*) (.*) (.*)", (String keyword, String comparator, String keywordValue) -> {
			filterRulePage.selectKeyword(keyword);
			//filterRulePage.selectComparator(comparator);
			filterRulePage.inputKeywordValue(keywordValue);
			createNewFilterPage.clickSaveButton();
			createNewFilterPage.verifyFilterSuccessfullySaved();
		});
	
		Then("filter (.*) should be editted successfully with new Filter rule values: (.*) (.*) (.*)", (String filterName, String keyword, String comparator, String keywordValue) -> {
			createNewFilterPage.clickHomeButton();
			homePage.verifySuccessfulNavigationToHomePage();
			homePage.inputFilterTitle(filterName);
			homePage.clickApplyButton();
			homePage.selectFilterInList(filterName);
			createNewFilterPage.verifySuccessfulNavigationToEditFilterPage();
			createNewFilterPage.checkFilterName(filterName);
			filterRulePage.checkKeywordValue(keywordValue);
		});
		
		/*DELETE scenario*/
		
		When("I create a Filter with filter name: (.*) and (.*) as source", (String filterName, String source) -> {
			createNewFilterPage.inputFilterName(filterName);
			createNewFilterPage.selectSource(source);
			createNewFilterPage.enableOrDisableFilter("disabled");
			filterRulePage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			filterRulePage.selectComparator("Contains");
			filterRulePage.inputKeywordValue("TEST");
			sendToSlackActionPage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			createNewFilterPage.selectAction(CommonConstants.ACTION_SEND_TO_SLACK);
			sendToSlackActionPage.inputSlackChannel(CommonConstants.SLACK_CHANNEL);
			sendToSlackActionPage.inputSlackMessage(filterName);
			sendToSlackActionPage.checkIncludeOriginalAlertMessage();
			createNewFilterPage.clickSaveButton();
			createNewFilterPage.verifyFilterSuccessfullySaved();
		});
		
		And("I click the Delete button to delete the filter", () -> {
			createNewFilterPage.clickDeleteButton();
			deletePage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			deletePage.verifyDeletePopUp();
			deletePage.clickDeleteYesButton();
		});
	
		Then("filter (.*) should be successfully deleted", (String filterName) -> {
			homePage.verifySuccessfulNavigationToHomePage();
			homePage.inputFilterTitle(filterName);
			homePage.clickApplyButton();
			homePage.verifyFilterNotFound(filterName);
		});

	
	}

}
