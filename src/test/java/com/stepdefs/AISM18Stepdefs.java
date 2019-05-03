package com.stepdefs;

import com.pageobjects.CreateJiraTicketActionPage;
import com.pageobjects.CreateNewFilterPage;
import com.pageobjects.FilterRulePage;
import com.pageobjects.LoginPage;
import com.pageobjects.SendToSlackActionPage;
import com.utils.PropertyUtil;

import cucumber.api.java8.En;

public class AISM18Stepdefs implements En {
	
	public AISM18Stepdefs(ScenarioHooks hooks, LoginPage loginPage, CreateNewFilterPage createNewFilterPage, FilterRulePage filterRulePage,
			SendToSlackActionPage sendToSlackActionPage, CreateJiraTicketActionPage createJiraTicketActionPage) {
		
		And("with Action: Create Jira Ticket-KKA but mandatory fields are left blank \"([^\\\"]*)\"$", (String uniqueName) -> {
			createNewFilterPage.setDriver(hooks.getDriverHelper(), hooks.getScenarioName());
			createJiraTicketActionPage.setDriver(hooks.getDriverHelper(), hooks.getScenarioName());
			createNewFilterPage.selectAction("Create Jira Ticket");
			createJiraTicketActionPage.inputSummary(uniqueName);
			createJiraTicketActionPage.inputDescription(uniqueName);
			createJiraTicketActionPage.selectBrand(PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "jira.brand.gu"));
			createJiraTicketActionPage.inputClosingCondition(uniqueName);
			createJiraTicketActionPage.selectPriority(PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "jira.priority.KKA"));
			createJiraTicketActionPage.setWatchers(PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "jira.watchers"));
			createJiraTicketActionPage.inputLabels(uniqueName);
			createJiraTicketActionPage.checkSendTicketToSlackIDChannel();
			createJiraTicketActionPage.inputSlackChannel(PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "slackChannel.dev"));
			createJiraTicketActionPage.setAssignee(PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "jira.assignee.notExisting"));
		});
		
		And("with Action: Create Jira Ticket-KKA but non mandatory fields are left blank \"([^\\\"]*)\"$", (String uniqueName) -> {
			createNewFilterPage.setDriver(hooks.getDriverHelper(), hooks.getScenarioName());
			createJiraTicketActionPage.setDriver(hooks.getDriverHelper(), hooks.getScenarioName());
			createNewFilterPage.selectAction("Create Jira Ticket");
			createJiraTicketActionPage.inputSummary(" ");
			createJiraTicketActionPage.inputDescription(" ");
			createJiraTicketActionPage.selectBrand(PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "jira.brand.gu"));
			createJiraTicketActionPage.inputClosingCondition(uniqueName);
			createJiraTicketActionPage.selectPriority(PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "jira.priority.KKA"));
			createJiraTicketActionPage.setAssignee(PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "jira.assignee"));
			createJiraTicketActionPage.setWatchers(PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "jira.watchers"));
			createJiraTicketActionPage.inputLabels(" ");
			createJiraTicketActionPage.checkSendTicketToSlackIDChannel();
			createJiraTicketActionPage.inputSlackChannel(PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "slackChannel.dev"));
		});
		
		And("with Action: Create Jira Ticket-KKA but incorrect text format is entered in fields \"([^\\\"]*)\"$", (String uniqueName) -> {
			createNewFilterPage.setDriver(hooks.getDriverHelper(), hooks.getScenarioName());
			createJiraTicketActionPage.setDriver(hooks.getDriverHelper(), hooks.getScenarioName());
			createNewFilterPage.selectAction("Create Jira Ticket");
			createJiraTicketActionPage.inputSummary(uniqueName);
			createJiraTicketActionPage.inputDescription(uniqueName);
			createJiraTicketActionPage.selectBrand(PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "jira.brand.gu"));
			createJiraTicketActionPage.inputClosingCondition(PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "jira.closingCondition.incorrectFormat"));
			createJiraTicketActionPage.selectPriority(PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "jira.priority.KKA"));
			createJiraTicketActionPage.setAssignee(PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "jira.assignee"));
			createJiraTicketActionPage.setWatchers(PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "jira.watchers"));
			createJiraTicketActionPage.inputLabels(PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "jira.label.incorrectFormat"));
			createJiraTicketActionPage.checkSendTicketToSlackIDChannel();
			createJiraTicketActionPage.inputSlackChannel(PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "slackChannel.dev"));
		});
	}
}
