package com.stepdefs.phase1.sprint3;

import com.constants.CommonConstants;
import com.pageobjects.CreateJiraTicketActionPage;
import com.pageobjects.CreateNewFilterPage;
import com.pageobjects.FilterRulePage;
import com.pageobjects.LoginPage;
import com.stepdefs.ScenarioHooks;

import cucumber.api.java8.En;

public class AISM62Stepdefs implements En {
	
	public AISM62Stepdefs(ScenarioHooks hooks, LoginPage loginPage, CreateNewFilterPage createNewFilterPage, FilterRulePage filterRulePage,
			CreateJiraTicketActionPage createJiraTicketActionPage) {
		
		And("with Action: Create Jira Ticket-ACPF but mandatory fields are left blank \"([^\\\"]*)\"$", (String uniqueName) -> {
			createNewFilterPage.setDriver(hooks.getDriverHelper(), hooks.getScenarioName());
			createJiraTicketActionPage.setDriver(hooks.getDriverHelper(), hooks.getScenarioName());
			createNewFilterPage.selectAction(CommonConstants.ACTION_CREATE_JIRA_TICKET);
			createJiraTicketActionPage.selectProject(CommonConstants.JIRA_PROJECT_TYPE_ACPF);
			createJiraTicketActionPage.inputSummary(uniqueName);
			createJiraTicketActionPage.selectPlatform(CommonConstants.JIRA_PLATFORM);
			createJiraTicketActionPage.selectProgress(CommonConstants.JIRA_PROGRESS);
			createJiraTicketActionPage.inputDescription(uniqueName);
			createJiraTicketActionPage.selectMarkets(CommonConstants.JIRA_MARKET);
			createJiraTicketActionPage.selectPriority(CommonConstants.JIRA_PRIORITY_ACPF);
			createJiraTicketActionPage.checkSendTicketToSlackIDChannel();
			createJiraTicketActionPage.inputSlackChannel(CommonConstants.JIRA_SLACK_CHANNEL);
			createJiraTicketActionPage.setAssignee(CommonConstants.JIRA_ASSIGNEE_NOT_EXISTING);
		});
		
		And("with Action: Create Jira Ticket-ACPF but non mandatory fields are left blank \"([^\\\"]*)\"$", (String uniqueName) -> {
			createNewFilterPage.setDriver(hooks.getDriverHelper(), hooks.getScenarioName());
			createJiraTicketActionPage.setDriver(hooks.getDriverHelper(), hooks.getScenarioName());
			createNewFilterPage.selectAction(CommonConstants.ACTION_CREATE_JIRA_TICKET);
			createJiraTicketActionPage.selectProject(CommonConstants.JIRA_PROJECT_TYPE_ACPF);
			createJiraTicketActionPage.inputSummary(" ");
			createJiraTicketActionPage.selectPlatform(CommonConstants.JIRA_PLATFORM);
			createJiraTicketActionPage.selectProgress(CommonConstants.JIRA_PROGRESS);
			createJiraTicketActionPage.inputDescription(" ");
			createJiraTicketActionPage.selectMarkets(CommonConstants.JIRA_MARKET);
			createJiraTicketActionPage.selectPriority(CommonConstants.JIRA_PRIORITY_ACPF);
			createJiraTicketActionPage.setAssignee(CommonConstants.JIRA_ASSIGNEE);
			createJiraTicketActionPage.inputLabels(" ");
			createJiraTicketActionPage.checkSendTicketToSlackIDChannel();
			createJiraTicketActionPage.inputSlackChannel(CommonConstants.JIRA_SLACK_CHANNEL);
		});
		
		And("I add multiple watchers$", () -> {
			createJiraTicketActionPage.setDriver(hooks.getDriverHelper(), hooks.getScenarioName());
			createJiraTicketActionPage.setWatchers(CommonConstants.JIRA_WATCHERS);
			createJiraTicketActionPage.setWatchers(CommonConstants.JIRA_WATCHERS_ANOTHER);
		});
		
		And("I add multiple labels$", () -> {
			createJiraTicketActionPage.setDriver(hooks.getDriverHelper(), hooks.getScenarioName());
			createJiraTicketActionPage.inputLabels(CommonConstants.JIRA_LABEL_ANOTHER);
		});
	}
}
