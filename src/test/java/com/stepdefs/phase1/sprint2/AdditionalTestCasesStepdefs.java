package com.stepdefs.phase1.sprint2;

import java.util.Arrays;
import java.util.List;

import com.constants.CommonConstants;
import com.pageobjects.CreateNewFilterPage;
import com.pageobjects.DeleteFilterPage;
import com.pageobjects.FilterRulePage;
import com.pageobjects.HomePage;
import com.pageobjects.SendToSlackActionPage;
import com.stepdefs.ScenarioHooks;
import com.utils.DataHelper;

import cucumber.api.java8.En;

public class AdditionalTestCasesStepdefs implements En {
	
	public AdditionalTestCasesStepdefs(ScenarioHooks hooks, CreateNewFilterPage createNewFilterPage, FilterRulePage filterRulePage,
			SendToSlackActionPage sendToSlackActionPage, HomePage homePage, DeleteFilterPage deletePage) {

		/*VOID ACTION scenario*/
		
		When("I create a Filter with filter name (.*) and set Void as action", (String filterName) -> {
			createNewFilterPage.inputFilterName(filterName);
			createNewFilterPage.inputCategory("automation,regression");
			createNewFilterPage.enableOrDisableFilter("disabled");
			filterRulePage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			filterRulePage.selectComparator("Contains");
			filterRulePage.inputKeywordValue("TEST");
		});
	
		/*EDIT scenario*/
		
		When("I create a Filter with filter name (.*), (.*) as source, and with Filter rule: (.*) (.*) (.*)", (String filterName, String source, String keyword, String comparator, String keywordValue) -> {
			createNewFilterPage.inputFilterName(filterName);
			createNewFilterPage.selectSource(source);
			createNewFilterPage.inputCategory("automation,regression");
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
			createNewFilterPage.verifyFilterSuccessfullySaved(true);
		});
		
		Then("I go back to Browse page and open filter (.*)", (String filterName) -> {
			createNewFilterPage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			createNewFilterPage.clickHomeButton();
			homePage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			homePage.verifySuccessfulNavigationToHomePage();
			homePage.selectFilterInList(filterName);
			createNewFilterPage.verifySuccessfulNavigationToEditFilterPage();
			createNewFilterPage.checkFilterName(filterName);
		});
		
		And("I edit the Filter Rule to: (.*) (.*) (.*)", (String keyword, String comparator, String keywordValue) -> {
			filterRulePage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			filterRulePage.selectKeyword(keyword);
			//filterRulePage.selectComparator(comparator);
			filterRulePage.inputKeywordValue(keywordValue);
			createNewFilterPage.clickSaveButton();
			createNewFilterPage.verifyFilterSuccessfullySaved(true);
		});
		
		Then("filter (.*) should be editted successfully with new Filter rule values: (.*) (.*) (.*)", (String filterName, String keyword, String comparator, String keywordValue) -> {
			createNewFilterPage.clickHomeButton();
			homePage.verifySuccessfulNavigationToHomePage();
			homePage.selectFilterInList(filterName);
			createNewFilterPage.verifySuccessfulNavigationToEditFilterPage();
			createNewFilterPage.checkFilterName(filterName);
			filterRulePage.checkKeywordValue(keywordValue);
		});
		
		/*DELETE scenario*/
		
		And("I click the Delete button to delete the filter", () -> {
			createNewFilterPage.clickDeleteButton();
			deletePage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			deletePage.verifyDeletePopUp();
			deletePage.clickDeleteYesButton();
		});
		
		Then("filter (.*) should be successfully deleted", (String filterName) -> {
			homePage.verifySuccessfulNavigationToHomePage();
			homePage.verifyIfFilterIsPresent(filterName, false);
		});
		
		/*COMPARATOR dropdown*/
		
		Then("Comparator dropdown should have the correct values", () -> {
			filterRulePage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			filterRulePage.verifyComparatorDropdownValues(CommonConstants.LOV_COMPARATORS);
		});
		
		/*FIELD dropdown*/
		
		Then("Field dropdown should have the correct values for each source", () -> {
			filterRulePage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			String all_sources = CommonConstants.LOV_SOURCES.replaceAll("\\[|\\]|\\s", "");
			List<String> list_sources = Arrays.asList(all_sources.split(","));
			
			for (String source : list_sources) {
				source = source.replace("_", " ");
				createNewFilterPage.selectSource(source);
				filterRulePage.verifyFieldDropdownValues(DataHelper.getLOV(source));
			}
		});

	
	}

}
