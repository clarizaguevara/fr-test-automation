package com.stepdefs.phase1.sprint2;

import com.constants.CommonConstants;
import com.pageobjects.CreateNewFilterPage;
import com.pageobjects.CreateSNOWTicketPage;
import com.pageobjects.FilterRulePage;
import com.pageobjects.LoginPage;
import com.stepdefs.ScenarioHooks;

import cucumber.api.java8.En;

public class AISM13Stepdefs implements En {
	
	public AISM13Stepdefs(ScenarioHooks hooks, LoginPage loginPage, CreateNewFilterPage createNewFilterPage, FilterRulePage filterRulePage,
			CreateSNOWTicketPage createSNOWTicket) {
		
		And("(.*) has Action: Create SNOW but mandatory fields are left blank", (String uniqueName) -> {
			createNewFilterPage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			createSNOWTicket.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			createNewFilterPage.selectAction(CommonConstants.ACTION_CREATE_SNOW_TICKET);
			createSNOWTicket.selectLanguage(CommonConstants.SNOW_LANGUAGE);
			createSNOWTicket.selectContactType(CommonConstants.SNOW_CONTACT_TYPE);
			createSNOWTicket.selectImpact(CommonConstants.SNOW_IMPACT);
			createSNOWTicket.selectUrgency(CommonConstants.SNOW_URGENCY);
			createSNOWTicket.selectPriority(CommonConstants.SNOW_PRIORITY);
			createSNOWTicket.inputShortDescription(uniqueName);
			createSNOWTicket.inputDescription(uniqueName);
			createSNOWTicket.setAssignedTo(CommonConstants.SNOW_ASSIGNED_TO);
		});
	}
}
