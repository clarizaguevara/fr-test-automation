package com.stepdefs.phase1.sprint4;

import com.constants.CommonConstants;
import com.pageobjects.CreateNewFilterPage;
import com.pageobjects.CreateSNOWTicket;
import com.pageobjects.FilterRulePage;
import com.pageobjects.LoginPage;
import com.stepdefs.ScenarioHooks;

import cucumber.api.java8.En;

public class AISM47Stepdefs implements En {
	
	public AISM47Stepdefs(ScenarioHooks hooks, LoginPage loginPage, CreateNewFilterPage createNewFilterPage, FilterRulePage filterRulePage,
			CreateSNOWTicket createSNOWTicketActionPage) {

		Given("I am to create a filter with SNOW action and I am on Create New Filter page", () -> {
			loginPage.setDriver(hooks.getDriverHelper(), hooks.getScenarioName());
			createNewFilterPage.setDriver(hooks.getDriverHelper(), hooks.getScenarioName());
			
			loginPage.navigateToLoginPage();
			createNewFilterPage.clickCreateNewFilterButton();
			createNewFilterPage.verifySuccessfulNavigationToCreateNewFilterPage();
		});

		When("I create a Filter with filter name (.*), (.*) as source, Filter rule: (.*) - (.*) - (.*), action as Create SNOW Ticket", (String filterName, String source, String keyword, String comparator, String keywordValue) -> {
			filterRulePage.setDriver(hooks.getDriverHelper(), hooks.getScenarioName());
			createSNOWTicketActionPage.setDriver(hooks.getDriverHelper(), hooks.getScenarioName());
			
			//filter
			createNewFilterPage.inputFilterName(filterName);
			createNewFilterPage.selectSource(source);
			filterRulePage.selectKeyword(keyword);
			filterRulePage.selectComparator(comparator);
			filterRulePage.inputKeywordValue(keywordValue);
			
			//action
			createSNOWTicketActionPage.setDriver(hooks.getDriverHelper(), hooks.getScenarioName());
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
		
		And("I tick \"Automatically close SNOW ticket\" checkbox", () -> {
			createSNOWTicketActionPage.checkAutomaticallyClosedTicket();
		});
		
		Then("filter with SNOW action should be saved successfully", () -> {
			createNewFilterPage.clickSaveButton();
			createNewFilterPage.verifyFilterSuccessfullySaved();
		});

	
	}

}
