package com.stepdefs.phase1.sprint2;

import com.constants.CommonConstants;
import com.pageobjects.CreateJiraTicketActionPage;
import com.pageobjects.CreateNewFilterPage;
import com.pageobjects.FilterRulePage;
import com.pageobjects.LoginPage;
import com.pageobjects.SendToSlackActionPage;
import com.stepdefs.ScenarioHooks;

import cucumber.api.java8.En;

public class AISM18Stepdefs implements En {
	
	public AISM18Stepdefs(ScenarioHooks hooks, LoginPage loginPage, CreateNewFilterPage createNewFilterPage, FilterRulePage filterRulePage,
			SendToSlackActionPage sendToSlackActionPage, CreateJiraTicketActionPage createJiraTicketActionPage) {
		
		And("with Action: Create Jira Ticket-KKA but mandatory fields are left blank \"([^\\\"]*)\"$", (String uniqueName) -> {
			createNewFilterPage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			createJiraTicketActionPage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			createNewFilterPage.selectAction(CommonConstants.ACTION_CREATE_JIRA_TICKET);
			createJiraTicketActionPage.inputSummary(uniqueName);
			createJiraTicketActionPage.inputDescription(uniqueName);
			createJiraTicketActionPage.selectBrand(CommonConstants.JIRA_BRAND);
			createJiraTicketActionPage.inputClosingCondition(uniqueName);
			createJiraTicketActionPage.selectPriority(CommonConstants.JIRA_PRIORITY_KKA);
			createJiraTicketActionPage.setWatchers(CommonConstants.JIRA_WATCHERS);
			createJiraTicketActionPage.inputLabels(uniqueName);
			createJiraTicketActionPage.checkSendTicketToSlackIDChannel();
			createJiraTicketActionPage.inputSlackChannel(CommonConstants.SLACK_CHANNEL);
			createJiraTicketActionPage.setAssignee(CommonConstants.JIRA_ASSIGNEE_NOT_EXISTING);
		});
		
		And("with Action: Create Jira Ticket-KKA but non mandatory fields are left blank \"([^\\\"]*)\"$", (String uniqueName) -> {
			createNewFilterPage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			createJiraTicketActionPage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			createNewFilterPage.selectAction(CommonConstants.ACTION_CREATE_JIRA_TICKET);
			createJiraTicketActionPage.inputSummary(" ");
			createJiraTicketActionPage.inputDescription(" ");
			createJiraTicketActionPage.selectBrand(CommonConstants.JIRA_BRAND);
			createJiraTicketActionPage.inputClosingCondition(uniqueName);
			createJiraTicketActionPage.selectPriority(CommonConstants.JIRA_PRIORITY_KKA);
			createJiraTicketActionPage.setAssignee(CommonConstants.JIRA_ASSIGNEE);
			createJiraTicketActionPage.inputLabels(" ");
			createJiraTicketActionPage.checkSendTicketToSlackIDChannel();
			createJiraTicketActionPage.inputSlackChannel(CommonConstants.SLACK_CHANNEL);
		});
		
		And("I untick \"Send ticket ID to Slack channel\" checkbox", () -> {
			createJiraTicketActionPage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			createJiraTicketActionPage.checkSendTicketToSlackIDChannel();
		});
		
		Then("Slack channel field should be blank", () -> {
			createNewFilterPage.clickSaveButton();
			createNewFilterPage.verifyFilterSuccessfullySaved();
			createJiraTicketActionPage.checkSlackChannelValue("");
		});
		
		When("I tick \"Send ticket ID to Slack channel\" checkbox and input Slack channel", () -> {
			createJiraTicketActionPage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			createJiraTicketActionPage.checkSendTicketToSlackIDChannel();
			createJiraTicketActionPage.inputSlackChannel(CommonConstants.SLACK_CHANNEL);
		});
		
		Then("Slack channel should be filled up", () -> {
			createNewFilterPage.clickSaveButton();
			createNewFilterPage.verifyFilterSuccessfullySaved();
			createJiraTicketActionPage.checkSlackChannelValue(CommonConstants.SLACK_CHANNEL);
		});
	}
}
