package com.stepdefs;

import com.pageobjects.CreateJiraTicketActionPage;
import com.pageobjects.CreateNewFilterPage;
import com.pageobjects.FilterRulePage;
import com.pageobjects.LoginPage;
import com.pageobjects.SendToSlackActionPage;
import com.utils.PropertyUtil;

import cucumber.api.java8.En;

public class AISM22Stepdefs implements En {
	
	public AISM22Stepdefs(ScenarioHooks hooks, LoginPage loginPage, CreateNewFilterPage createNewFilterPage, FilterRulePage filterRulePage,
			SendToSlackActionPage sendToSlackActionPage, CreateJiraTicketActionPage createJiraTicketActionPage) {
		
		When("^I create a Filter with filter name \"([^\"]*)\" and \"([^\"]*)\" as source$", (String filterName, String source) -> {
			loginPage.setDriver(hooks.getDriverHelper(), hooks.getScenarioName());
			createNewFilterPage.setDriver(hooks.getDriverHelper(), hooks.getScenarioName());
			sendToSlackActionPage.setDriver(hooks.getDriverHelper(), hooks.getScenarioName());
			loginPage.navigateToLoginPage();
			createNewFilterPage.clickCreateNewFilterButton();
			createNewFilterPage.verifySuccessfulNavigationToCreateNewFilterPage();
			createNewFilterPage.inputFilterName(filterName);
			createNewFilterPage.selectSource(source);
		});
		
		And("with Filter Rule: \"([^\\\"]*)\" \"([^\\\"]*)\" \"([^\\\"]*)\"$", (String keyword, String comparator, String keywordValue) -> {
			filterRulePage.setDriver(hooks.getDriverHelper(), hooks.getScenarioName());
			filterRulePage.selectKeyword(keyword);
			filterRulePage.selectComparator(comparator);
			filterRulePage.inputKeywordValue(keywordValue);
		});
		
		And("with Action: Send To Slack \"([^\\\"]*)\"$", (String uniqueName) -> {
			createNewFilterPage.setDriver(hooks.getDriverHelper(), hooks.getScenarioName());
			sendToSlackActionPage.setDriver(hooks.getDriverHelper(), hooks.getScenarioName());
			createNewFilterPage.selectAction("Send To Slack");
			sendToSlackActionPage.inputSlackChannel(PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "slackChannel.dev"));
			sendToSlackActionPage.inputSlackMessage(uniqueName);
		});
		
		And("with Action: Create Jira Ticket-KKA \"([^\\\"]*)\"$", (String uniqueName) -> {
			createNewFilterPage.setDriver(hooks.getDriverHelper(), hooks.getScenarioName());
			createJiraTicketActionPage.setDriver(hooks.getDriverHelper(), hooks.getScenarioName());
			createNewFilterPage.selectAction("Create Jira Ticket");
			createJiraTicketActionPage.inputSummary(uniqueName);
			createJiraTicketActionPage.inputDescription(uniqueName);
			createJiraTicketActionPage.selectBrand(PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "jira.brand.gu"));
			createJiraTicketActionPage.inputClosingCondition(uniqueName);
			createJiraTicketActionPage.selectPriority(PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "jira.priority.KKA"));
			createJiraTicketActionPage.setAssignee(PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "jira.assignee"));
			createJiraTicketActionPage.inputLabels(uniqueName);
			createJiraTicketActionPage.checkSendTicketToSlackIDChannel();
			createJiraTicketActionPage.inputSlackChannel(PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "slackChannel.dev"));
		});
	}
}
