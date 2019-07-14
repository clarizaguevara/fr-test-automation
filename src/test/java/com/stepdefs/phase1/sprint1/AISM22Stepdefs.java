package com.stepdefs.phase1.sprint1;

import com.constants.CommonConstants;
import com.pageobjects.CreateJiraTicketActionPage;
import com.pageobjects.CreateNewFilterPage;
import com.pageobjects.FilterRulePage;
import com.pageobjects.LoginPage;
import com.pageobjects.SendToSlackActionPage;
import com.stepdefs.ScenarioHooks;

import cucumber.api.java8.En;

public class AISM22Stepdefs implements En {
	
	public AISM22Stepdefs(ScenarioHooks hooks, LoginPage loginPage, CreateNewFilterPage createNewFilterPage, FilterRulePage filterRulePage,
			SendToSlackActionPage sendToSlackActionPage, CreateJiraTicketActionPage createJiraTicketActionPage) {
		
		And("with Filter Rule: (.*) - (.*) - (.*)$", (String keyword, String comparator, String keywordValue) -> {
			filterRulePage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			filterRulePage.selectKeyword(keyword);
			filterRulePage.selectComparator(comparator);
			filterRulePage.inputKeywordValue(keywordValue);
		});
		
		And("(.*) has Action: Jira-KKA", (String uniqueName) -> {
			createNewFilterPage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			createJiraTicketActionPage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			createNewFilterPage.selectAction(CommonConstants.ACTION_CREATE_JIRA_TICKET);
			createJiraTicketActionPage.inputSummary(uniqueName);
			createJiraTicketActionPage.inputDescription(uniqueName);
			createJiraTicketActionPage.selectBrand(CommonConstants.JIRA_BRAND);
			createJiraTicketActionPage.inputClosingCondition(uniqueName);
			createJiraTicketActionPage.selectPriority(CommonConstants.JIRA_PRIORITY_KKA);
			createJiraTicketActionPage.setAssignee(CommonConstants.JIRA_ASSIGNEE);
			createJiraTicketActionPage.inputLabels(uniqueName);
			createJiraTicketActionPage.checkSendTicketToSlackIDChannel();
			createJiraTicketActionPage.inputSlackChannel(CommonConstants.SLACK_CHANNEL);
		});
	}
}
