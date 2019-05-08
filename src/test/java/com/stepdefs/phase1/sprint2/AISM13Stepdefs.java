package com.stepdefs.phase1.sprint2;

import com.constants.CommonConstants;
import com.pageobjects.CreateNewFilterPage;
import com.pageobjects.CreateSNOWTicket;
import com.pageobjects.FilterRulePage;
import com.pageobjects.LoginPage;
import com.stepdefs.ScenarioHooks;

import cucumber.api.java8.En;

public class AISM13Stepdefs implements En {
	
	public AISM13Stepdefs(ScenarioHooks hooks, LoginPage loginPage, CreateNewFilterPage createNewFilterPage, FilterRulePage filterRulePage,
			CreateSNOWTicket createSNOWTicket) {
		
		And("with Action: Create SNOW Ticket \"([^\\\"]*)\"$", (String uniqueName) -> {
			createNewFilterPage.setDriver(hooks.getDriverHelper(), hooks.getScenarioName());
			createSNOWTicket.setDriver(hooks.getDriverHelper(), hooks.getScenarioName());
			createNewFilterPage.selectAction(CommonConstants.ACTION_CREATE_SNOW_TICKET);
			createSNOWTicket.setImpactedUsers(CommonConstants.SNOW_IMPACTED_USER);
			createSNOWTicket.setCategory(CommonConstants.SNOW_CATEGORY);
			createSNOWTicket.setAssignmentGroup(CommonConstants.SNOW_ASSIGNMENT_GROUP);
			createSNOWTicket.setSubCategory(CommonConstants.SNOW_SUB_CATEGORY);
			createSNOWTicket.setArea(CommonConstants.SNOW_AREA);
			createSNOWTicket.setAssignedTo(CommonConstants.SNOW_ASSIGNED_TO);
			createSNOWTicket.selectLanguage(CommonConstants.SNOW_LANGUAGE);
			createSNOWTicket.selectContactType(CommonConstants.SNOW_CONTACT_TYPE);
			createSNOWTicket.selectImpact(CommonConstants.SNOW_IMPACT);
			createSNOWTicket.selectUrgency(CommonConstants.SNOW_URGENCY);
			createSNOWTicket.selectPriority(CommonConstants.SNOW_PRIORITY);
			createSNOWTicket.inputShortDescription(uniqueName);
			createSNOWTicket.inputDescription(uniqueName);
		});
		
		And("with Action: Create SNOW Ticket but mandatory fields are left blank \"([^\\\"]*)\"$", (String uniqueName) -> {
			createNewFilterPage.setDriver(hooks.getDriverHelper(), hooks.getScenarioName());
			createSNOWTicket.setDriver(hooks.getDriverHelper(), hooks.getScenarioName());
			createNewFilterPage.selectAction(CommonConstants.ACTION_CREATE_SNOW_TICKET);
			createSNOWTicket.selectLanguage(CommonConstants.SNOW_LANGUAGE);
			createSNOWTicket.selectContactType(CommonConstants.SNOW_CONTACT_TYPE);
			createSNOWTicket.selectImpact(CommonConstants.SNOW_IMPACT);
			createSNOWTicket.selectUrgency(CommonConstants.SNOW_URGENCY);
			createSNOWTicket.selectPriority(CommonConstants.SNOW_PRIORITY);
			createSNOWTicket.inputShortDescription(uniqueName);
			createSNOWTicket.inputDescription(uniqueName);
		});
	}
}
