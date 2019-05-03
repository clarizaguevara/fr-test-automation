package com.stepdefs;

import com.pageobjects.CreateNewFilterPage;
import com.pageobjects.CreateSNOWTicket;
import com.pageobjects.FilterRulePage;
import com.pageobjects.LoginPage;
import com.utils.PropertyUtil;

import cucumber.api.java8.En;

public class AISM13Stepdefs implements En {
	
	public AISM13Stepdefs(ScenarioHooks hooks, LoginPage loginPage, CreateNewFilterPage createNewFilterPage, FilterRulePage filterRulePage,
			CreateSNOWTicket createSNOWTicket) {
		
		And("with Action: Create SNOW Ticket \"([^\\\"]*)\"$", (String uniqueName) -> {
			createNewFilterPage.setDriver(hooks.getDriverHelper(), hooks.getScenarioName());
			createSNOWTicket.setDriver(hooks.getDriverHelper(), hooks.getScenarioName());
			createNewFilterPage.selectAction("Create SNOW Ticket");
			createSNOWTicket.setImpactedUsers(PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "snow.impactedUser"));
			createSNOWTicket.setCategory(PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "snow.category"));
			createSNOWTicket.setAssignmentGroup(PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "snow.assignmentGroup"));
			createSNOWTicket.setSubCategory(PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "snow.subCategory"));
			createSNOWTicket.setArea(PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "snow.area"));
			createSNOWTicket.setAssignedTo(PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "snow.assignedTo"));
			createSNOWTicket.selectLanguage(PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "snow.language"));
			createSNOWTicket.selectContactType(PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "snow.contactType"));
			createSNOWTicket.selectImpact(PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "snow.impact"));
			createSNOWTicket.selectUrgency(PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "snow.urgency"));
			createSNOWTicket.selectPriority(PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "snow.priority"));
			createSNOWTicket.inputShortDescription(uniqueName);
			createSNOWTicket.inputDescription(uniqueName);
		});
		
		And("with Action: Create SNOW Ticket but mandatory fields are left blank \"([^\\\"]*)\"$", (String uniqueName) -> {
			createNewFilterPage.setDriver(hooks.getDriverHelper(), hooks.getScenarioName());
			createSNOWTicket.setDriver(hooks.getDriverHelper(), hooks.getScenarioName());
			createNewFilterPage.selectAction("Create SNOW Ticket");
			createSNOWTicket.selectLanguage(PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "snow.language"));
			createSNOWTicket.selectContactType(PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "snow.contactType"));
			createSNOWTicket.selectImpact(PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "snow.impact"));
			createSNOWTicket.selectUrgency(PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "snow.urgency"));
			createSNOWTicket.selectPriority(PropertyUtil.getProp("src/test/resources/properties/test-data.properties", "snow.priority"));
			createSNOWTicket.inputShortDescription(uniqueName);
			createSNOWTicket.inputDescription(uniqueName);
		});
	}
}
