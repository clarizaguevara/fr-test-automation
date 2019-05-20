package com.stepdefs.phase1.sprint1;

import com.constants.CommonConstants;
import com.pageobjects.CreateJiraTicketActionPage;
import com.pageobjects.CreateNewFilterPage;
import com.pageobjects.CreateSNOWTicketPage;
import com.pageobjects.FilterRulePage;
import com.pageobjects.HomePage;
import com.pageobjects.SendEmailActionPage;
import com.pageobjects.SendToSlackActionPage;
import com.stepdefs.ScenarioHooks;

import cucumber.api.java8.En;

public class AISM25Stepdefs implements En {
	
	public AISM25Stepdefs(ScenarioHooks hooks, HomePage homePage, CreateNewFilterPage createNewFilterPage, FilterRulePage filterRulePage,
			SendToSlackActionPage sendToSlackActionPage, CreateJiraTicketActionPage createJiraTicketActionPage, CreateSNOWTicketPage createSNOWTicketActionPage, SendEmailActionPage sendEmailActionPage) {

		And("I am on Create New Filter page", () -> {
			homePage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			createNewFilterPage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			
			homePage.clickCreateNewFilterButton();
			createNewFilterPage.verifySuccessfulNavigationToCreateNewFilterPage();
		});
	
		When("I create a Filter with filter name (.*) and (.*) as source", (String filterName, String source) -> {
			createNewFilterPage.inputFilterName(filterName);
			createNewFilterPage.selectSource(source);
		});
	
		And("I leave Keyword Value blank in the Filter Rule: (.*) - (.*)", (String keyword, String comparator) -> {
			filterRulePage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			filterRulePage.selectKeyword(keyword);
			filterRulePage.selectComparator(comparator);
		});
		
		And("NOT button (.*)", (String btnState) -> {
			filterRulePage.clickNOTButton(btnState);
		});
	
		And("(.*) has Action: Send to Slack", (String filterName) -> {
			sendToSlackActionPage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			createNewFilterPage.selectAction(CommonConstants.ACTION_SEND_TO_SLACK);
			sendToSlackActionPage.inputSlackChannel(CommonConstants.SLACK_CHANNEL);
			sendToSlackActionPage.inputSlackMessage(filterName);
			sendToSlackActionPage.checkIncludeOriginalAlertMessage();
		});
		
		And("(.*) has Action: Create Jira Ticket", (String filterName) -> {
			createJiraTicketActionPage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			createNewFilterPage.selectAction(CommonConstants.ACTION_CREATE_JIRA_TICKET);
			createJiraTicketActionPage.inputSummary(filterName);
			createJiraTicketActionPage.inputDescription(filterName);
			createJiraTicketActionPage.setAssignee(CommonConstants.JIRA_ASSIGNEE);
			createJiraTicketActionPage.inputLabels(filterName);
			createJiraTicketActionPage.checkSendTicketToSlackIDChannel();
			createJiraTicketActionPage.inputSlackChannel(CommonConstants.JIRA_SLACK_CHANNEL);
		});
		
		And("(.*) has Action: Create SNOW Ticket", (String filterName) -> {
			createSNOWTicketActionPage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			createNewFilterPage.selectAction(CommonConstants.ACTION_CREATE_SNOW_TICKET);
			createSNOWTicketActionPage.setImpactedUsers(CommonConstants.SNOW_IMPACTED_USER);
			createSNOWTicketActionPage.setAssignmentGroup(CommonConstants.SNOW_ASSIGNMENT_GROUP);
			createSNOWTicketActionPage.setAssignedTo(CommonConstants.SNOW_ASSIGNED_TO);
			createSNOWTicketActionPage.setCategory(CommonConstants.SNOW_CATEGORY);
			createSNOWTicketActionPage.setSubCategory(CommonConstants.SNOW_SUB_CATEGORY);
			createSNOWTicketActionPage.setArea(CommonConstants.SNOW_AREA);
			createSNOWTicketActionPage.inputShortDescription(filterName);
			createSNOWTicketActionPage.inputDescription(filterName);
		});
		
		And("(.*) has Action: Send Email", (String filterName) -> {
			sendEmailActionPage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			createNewFilterPage.selectAction(CommonConstants.ACTION_SEND_EMAIL);
			sendEmailActionPage.inputTo(CommonConstants.EMAIL_TO);
			sendEmailActionPage.inputSubject(filterName);
			sendEmailActionPage.inputEmailMessage(filterName);
			sendEmailActionPage.checkIncludeOriginalAlertMessage();
		});
	
		Then("filter should be saved successfully", () -> {
			createNewFilterPage.clickSaveButton();
			createNewFilterPage.verifyFilterSuccessfullySaved();
		});
		
		
		Then("filter should not be saved", () -> {
			createNewFilterPage.clickSaveButton();
			createNewFilterPage.verifyFilterisNOTSuccessfullySaved();
		});
		
		And("I click Create New Filter after saving", () -> {
			createNewFilterPage.clickCreateNewFilterButton();
		});
		
		
		Then("\"Successfully saved!\" message should be removed", () -> {
			createNewFilterPage.verifyFilterisNOTSuccessfullySaved();
			createNewFilterPage.verifySuccessfulNavigationToCreateNewFilterPage();
		});

	
	}
}
