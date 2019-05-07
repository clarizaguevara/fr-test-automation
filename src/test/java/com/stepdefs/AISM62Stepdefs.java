package com.stepdefs;

import com.pageobjects.CreateJiraTicketActionPage;
import com.pageobjects.CreateNewFilterPage;
import com.pageobjects.FilterRulePage;
import com.pageobjects.LoginPage;
import com.pageobjects.SendToSlackActionPage;
import com.utils.PropertyUtil;

import cucumber.api.java8.En;

public class AISM62Stepdefs implements En {
	
	public AISM62Stepdefs(ScenarioHooks hooks, LoginPage loginPage, CreateNewFilterPage createNewFilterPage, FilterRulePage filterRulePage,
			CreateJiraTicketActionPage createJiraTicketActionPage) {
		
		And("with Action: Create Jira Ticket-ACPF but mandatory fields are left blank \"([^\\\"]*)\"$", (String uniqueName) -> {
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
			createJiraTicketActionPage.checkSendTicketToSlackIDChannel();
			createJiraTicketActionPage.inputSlackChannel(PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "slackChannel.dev"));
			createJiraTicketActionPage.setAssignee(PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "jira.assignee.notExisting"));
		});
		
		And("with Action: Create Jira Ticket-ACPF but non mandatory fields are left blank \"([^\\\"]*)\"$", (String uniqueName) -> {
			createNewFilterPage.setDriver(hooks.getDriverHelper(), hooks.getScenarioName());
			createJiraTicketActionPage.setDriver(hooks.getDriverHelper(), hooks.getScenarioName());
			createNewFilterPage.selectAction("Create Jira Ticket");
			createJiraTicketActionPage.selectProject(PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "jira.project.ACPF"));
			createJiraTicketActionPage.inputSummary(" ");
			createJiraTicketActionPage.selectPlatform(PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "jira.platform"));
			createJiraTicketActionPage.selectProgress(PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "jira.progress"));
			createJiraTicketActionPage.inputDescription(" ");
			createJiraTicketActionPage.selectMarkets(PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "jira.market"));
			createJiraTicketActionPage.selectPriority(PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "jira.priority.ACPF"));
			createJiraTicketActionPage.setAssignee(PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "jira.assignee"));
			createJiraTicketActionPage.inputLabels(" ");
			createJiraTicketActionPage.checkSendTicketToSlackIDChannel();
			createJiraTicketActionPage.inputSlackChannel(PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "slackChannel.dev"));
		});
		
		And("I add multiple watchers$", () -> {
			createJiraTicketActionPage.setDriver(hooks.getDriverHelper(), hooks.getScenarioName());
			createJiraTicketActionPage.setWatchers(PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "jira.watchers"));
			createJiraTicketActionPage.setWatchers(PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "jira.watchers.another"));
		});
		
		And("I add multiple labels$", () -> {
			createJiraTicketActionPage.setDriver(hooks.getDriverHelper(), hooks.getScenarioName());
			createJiraTicketActionPage.inputLabels(PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "jira.label.multiple"));
		});
	}
}
