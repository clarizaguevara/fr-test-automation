package com.stepdefs.phase1.sprint2;

import org.junit.Assert;

import com.constants.CommonConstants;
import com.pageobjects.CreateNewFilterPage;
import com.pageobjects.DeleteFilterPage;
import com.pageobjects.FilterRulePage;
import com.pageobjects.HomePage;
import com.pageobjects.LoginPage;
import com.pageobjects.SendToSlackActionPage;
import com.stepdefs.ScenarioHooks;

import cucumber.api.java8.En;

public class AdditionalTestCasesStepdefs implements En {
	
	public AdditionalTestCasesStepdefs(ScenarioHooks hooks, LoginPage loginPage, CreateNewFilterPage createNewFilterPage, FilterRulePage filterRulePage,
			SendToSlackActionPage sendToSlackActionPage, HomePage homePage, DeleteFilterPage deletePage) {

		/*VOID ACTION scenario*/
		
		Given("I am to create a filter with Void action and I am on Create New Filter page", () -> {
			loginPage.setDriver(hooks.getDriverHelper(), hooks.getScenarioName());
			createNewFilterPage.setDriver(hooks.getDriverHelper(), hooks.getScenarioName());
			
			loginPage.navigateToLoginPage();
			createNewFilterPage.clickCreateNewFilterButton();
			createNewFilterPage.verifySuccessfulNavigationToCreateNewFilterPage();
		});
	
		When("I create a Filter with filter name (.*) and set Void as action", (String filterName) -> {
			createNewFilterPage.inputFilterName(filterName);
			filterRulePage.setDriver(hooks.getDriverHelper(), hooks.getScenarioName());
			filterRulePage.selectComparator("Contains");
			filterRulePage.inputKeywordValue("TEST");
		});
	
		Then("filter with Void action should be saved successfully", () -> {
			createNewFilterPage.clickSaveButton();
			createNewFilterPage.verifyFilterSuccessfullySaved();
		});
	
		/*EDIT scenario*/
		
		Given("I am to create a filter to edit and I am on Create New Filter page", () -> {
			loginPage.setDriver(hooks.getDriverHelper(), hooks.getScenarioName());
			createNewFilterPage.setDriver(hooks.getDriverHelper(), hooks.getScenarioName());
			
			loginPage.navigateToLoginPage();
			createNewFilterPage.clickCreateNewFilterButton();
			createNewFilterPage.verifySuccessfulNavigationToCreateNewFilterPage();
		});
		
		When("I create a Filter with filter name (.*), (.*) as source, and with Filter rule: (.*) (.*) (.*)", (String filterName, String source, String keyword, String comparator, String keywordValue) -> {
			createNewFilterPage.inputFilterName(filterName);
			createNewFilterPage.selectSource(source);
			filterRulePage.setDriver(hooks.getDriverHelper(), hooks.getScenarioName());
			filterRulePage.selectKeyword(keyword);
			filterRulePage.selectComparator(comparator);
			filterRulePage.inputKeywordValue(keywordValue);
			sendToSlackActionPage.setDriver(hooks.getDriverHelper(), hooks.getScenarioName());
			createNewFilterPage.selectAction(CommonConstants.ACTION_SEND_TO_SLACK);
			sendToSlackActionPage.inputSlackChannel(CommonConstants.SLACK_CHANNEL);
			sendToSlackActionPage.inputSlackMessage(filterName);
			sendToSlackActionPage.checkIncludeOriginalAlertMessage();
			createNewFilterPage.clickSaveButton();
			createNewFilterPage.verifyFilterSuccessfullySaved();
		});
		
		Then("I go back to Browse page and open filter (.*)", (String filterName) -> {
			createNewFilterPage.clickHomeButton();
			homePage.setDriver(hooks.getDriverHelper(), hooks.getScenarioName());
			homePage.verifySuccessfulNavigationToHomePage();
			homePage.inputFilterTitle(filterName);
			homePage.clickApplyButton();
			homePage.clickFilterName();
			createNewFilterPage.verifySuccessfulNavigationToEditFilterPage();
			Assert.assertTrue("Values are not the same", (createNewFilterPage.getFilterName()).equals(filterName));
		});
		
		And("I edit the Filter Rule to: (.*) (.*) (.*)", (String keyword, String comparator, String keywordValue) -> {
			filterRulePage.selectKeyword(keyword);
			filterRulePage.selectComparator(comparator);
			filterRulePage.inputKeywordValue(keywordValue);
			createNewFilterPage.clickSaveButton();
			createNewFilterPage.verifyFilterSuccessfullySaved();
		});
	
		Then("filter (.*) should be editted successfully with new Filter rule values: (.*) (.*) (.*)", (String filterName, String keyword, String comparator, String keywordValue) -> {
			createNewFilterPage.clickHomeButton();
			homePage.verifySuccessfulNavigationToHomePage();
			homePage.inputFilterTitle(filterName);
			homePage.clickApplyButton();
			homePage.clickFilterName();
			createNewFilterPage.verifySuccessfulNavigationToEditFilterPage();
			Assert.assertTrue("Values are not the same", (createNewFilterPage.getFilterName()).equals(filterName));
			//Assert.assertTrue("Values are not the same", (filterRulePage.getKeyword()).equals(keyword));
			//Assert.assertTrue("Values are not the same", (filterRulePage.getComparator()).equals(comparator));
			Assert.assertTrue("Values are not the same", (filterRulePage.getKeywordValue()).equals(keywordValue));
		});
		
		/*DELETE scenario*/
		
		Given("I am to create a filter to delete and I am on Create New Filter page", () -> {
			loginPage.setDriver(hooks.getDriverHelper(), hooks.getScenarioName());
			createNewFilterPage.setDriver(hooks.getDriverHelper(), hooks.getScenarioName());
			
			loginPage.navigateToLoginPage();
			createNewFilterPage.clickCreateNewFilterButton();
			createNewFilterPage.verifySuccessfulNavigationToCreateNewFilterPage();
		});
		
		When("I create a Filter with filter name: (.*) and (.*) as source", (String filterName, String source) -> {
			createNewFilterPage.inputFilterName(filterName);
			createNewFilterPage.selectSource(source);
			filterRulePage.setDriver(hooks.getDriverHelper(), hooks.getScenarioName());
			filterRulePage.selectComparator("Contains");
			filterRulePage.inputKeywordValue("TEST");
			sendToSlackActionPage.setDriver(hooks.getDriverHelper(), hooks.getScenarioName());
			createNewFilterPage.selectAction(CommonConstants.ACTION_SEND_TO_SLACK);
			sendToSlackActionPage.inputSlackChannel(CommonConstants.SLACK_CHANNEL);
			sendToSlackActionPage.inputSlackMessage(filterName);
			sendToSlackActionPage.checkIncludeOriginalAlertMessage();
			createNewFilterPage.clickSaveButton();
			createNewFilterPage.verifyFilterSuccessfullySaved();
		});
		
		And("I click the Delete button to delete the filter", () -> {
			createNewFilterPage.clickDeleteButton();
			deletePage.setDriver(hooks.getDriverHelper(), hooks.getScenarioName());
			deletePage.verifyDeletePopUp();
			deletePage.clickDeleteYesButton();
			createNewFilterPage.verifySuccessfulNavigationToCreateNewFilterPage();
		});
	
		Then("filter (.*) should be deleted successfully", (String filterName) -> {
			createNewFilterPage.clickHomeButton();
			homePage.verifySuccessfulNavigationToHomePage();
			homePage.inputFilterTitle(filterName);
			homePage.clickApplyButton();
			homePage.verifyFilterNotFound();
		});

	
	}

}
