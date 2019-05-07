package com.stepdefs;

import com.pageobjects.CreateJiraTicketActionPage;
import com.pageobjects.CreateNewFilterPage;
import com.pageobjects.FilterRulePage;
import com.pageobjects.LoginPage;
import com.pageobjects.SendToSlackActionPage;
import com.utils.PropertyUtil;

import cucumber.api.java8.En;

public class AISM6Stepdefs implements En {
	
	public AISM6Stepdefs(ScenarioHooks hooks, LoginPage loginPage, CreateNewFilterPage createNewFilterPage, FilterRulePage filterRulePage,
			 CreateJiraTicketActionPage createJiraTicketActionPage) {
		
		And("with Action: Create Jira Ticket-ACPF \"([^\\\"]*)\"$", (String uniqueName) -> {
			createNewFilterPage.setDriver(hooks.getDriverHelper(), hooks.getScenarioName());
			createJiraTicketActionPage.setDriver(hooks.getDriverHelper(), hooks.getScenarioName());
			createNewFilterPage.selectAction("Create Jira Ticket");
			createJiraTicketActionPage.selectProject(PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "jira.project.ACPF"));
			createJiraTicketActionPage.inputSummary(uniqueName);
			createJiraTicketActionPage.selectPlatform(PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "jira.platform"));
			createJiraTicketActionPage.selectProgress(PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "jira.progress"));
			createJiraTicketActionPage.inputDescription(uniqueName);
			createJiraTicketActionPage.selectMarkets(PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "jira.market"));
			createJiraTicketActionPage.selectPriority(PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "jira.priority.ACPF"));
			createJiraTicketActionPage.setAssignee(PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "jira.assignee"));
			createJiraTicketActionPage.inputLabels(uniqueName);
			createJiraTicketActionPage.checkSendTicketToSlackIDChannel();                                                                                                                                                                                                         
			createJiraTicketActionPage.inputSlackChannel(PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "slackChannel.dev"));
		});
		
		And("Send ticket ID to Slack channel is not ticked$", () -> {
			createJiraTicketActionPage.setDriver(hooks.getDriverHelper(), hooks.getScenarioName());
			createJiraTicketActionPage.checkSendTicketToSlackIDChannel(); 
		});
		
		And("Slack Channel field is left blank$", () -> {
			createJiraTicketActionPage.setDriver(hooks.getDriverHelper(), hooks.getScenarioName());
			createJiraTicketActionPage.inputSlackChannel(PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "AISM7.SlackChannelBlank"));
		});
	}
}
