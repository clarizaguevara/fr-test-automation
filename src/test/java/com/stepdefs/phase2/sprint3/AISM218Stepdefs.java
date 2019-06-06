package com.stepdefs.phase2.sprint3;

import com.constants.CommonConstants;
import com.pageobjects.CreateNewFilterPage;
import com.pageobjects.CreateSNOWTicketPage;
import com.pageobjects.FilterRulePage;
import com.pageobjects.LoginPage;
import com.stepdefs.ScenarioHooks;

import cucumber.api.java8.En;

public class AISM218Stepdefs implements En {
	
	public AISM218Stepdefs(ScenarioHooks hooks, LoginPage loginPage, CreateNewFilterPage createNewFilterPage, FilterRulePage filterRulePage,
			CreateSNOWTicketPage createSNOWTicket) {
		
		And("with Action: Create SNOW Ticket with correct mandatory fields \"([^\\\"]*)\"$", (String uniqueName) -> {
			createNewFilterPage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			createSNOWTicket.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			createNewFilterPage.selectAction(CommonConstants.ACTION_CREATE_SNOW_TICKET);
			createSNOWTicket.setImpactedUsers(CommonConstants.SNOW_IMPACTED_USER);
			createSNOWTicket.setCategory(CommonConstants.SNOW_CATEGORY);
			createSNOWTicket.setAssignmentGroup(CommonConstants.SNOW_ASSIGNMENT_GROUP);
			createSNOWTicket.setSubCategory(CommonConstants.SNOW_SUB_CATEGORY);
			createSNOWTicket.setArea(CommonConstants.SNOW_AREA);
			createSNOWTicket.selectLanguage(CommonConstants.SNOW_LANGUAGE);
		});
	}

}
