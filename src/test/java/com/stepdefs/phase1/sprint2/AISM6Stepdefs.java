package com.stepdefs.phase1.sprint2;

import com.constants.CommonConstants;
import com.pageobjects.CreateJiraTicketActionPage;
import com.pageobjects.CreateNewFilterPage;
import com.pageobjects.FilterRulePage;
import com.pageobjects.LoginPage;
import com.pageobjects.SendToSlackActionPage;
import com.stepdefs.ScenarioHooks;
import com.utils.PropertyUtil;

import cucumber.api.java8.En;

public class AISM6Stepdefs implements En {
	
	public AISM6Stepdefs(ScenarioHooks hooks, LoginPage loginPage, CreateNewFilterPage createNewFilterPage, FilterRulePage filterRulePage,
			 CreateJiraTicketActionPage createJiraTicketActionPage) {
		
		And("with Action: Create Jira Ticket-ACPF \"([^\\\"]*)\"$", (String uniqueName) -> {
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
			createJiraTicketActionPage.setAssignee(CommonConstants.JIRA_ASSIGNEE);
			createJiraTicketActionPage.inputLabels(uniqueName);
			createJiraTicketActionPage.checkSendTicketToSlackIDChannel();                                                                                                                                                                                                         
			createJiraTicketActionPage.inputSlackChannel(CommonConstants.JIRA_SLACK_CHANNEL);
		});
		
		And("Send ticket ID to Slack channel is not ticked$", () -> {
			createJiraTicketActionPage.setDriver(hooks.getDriverHelper(), hooks.getScenarioName());
			createJiraTicketActionPage.checkSendTicketToSlackIDChannel(); 
		});
		
		And("Slack Channel field is left blank$", () -> {
			createJiraTicketActionPage.setDriver(hooks.getDriverHelper(), hooks.getScenarioName());
			createJiraTicketActionPage.inputSlackChannel(CommonConstants.JIRA_SLACK_CHANNEL);
		});
	}
}
