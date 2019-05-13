package com.stepdefs.phase1.sprint2;

import com.constants.CommonConstants;
import com.pageobjects.CreateNewFilterPage;
import com.pageobjects.CreateSNOWTicketPage;
import com.pageobjects.ExtendedRulePage;
import com.pageobjects.FilterRulePage;
import com.pageobjects.SNOWDuplicateConditionPage;
import com.stepdefs.ScenarioHooks;

import cucumber.api.java8.En;

public class AISM12Stepdefs implements En {
	
	public AISM12Stepdefs(ScenarioHooks hooks, CreateNewFilterPage createNewFilterPage, FilterRulePage filterRulePage,
			ExtendedRulePage extendedRulePage, SNOWDuplicateConditionPage snowDuplicateConditionPage, CreateSNOWTicketPage createSNOWTicketActionPage) {

		When("I create a Filter with filter name (.*), (.*) as source, Filter rule: (.*) - (.*) - (.*), and add a Snow Duplicate Check condition: (.*) open tickets for (.*)", (String filterName, String source, String keyword, String comparator, String keywordValue, String with, String snowKeyword) -> {
			filterRulePage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			extendedRulePage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			snowDuplicateConditionPage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			createSNOWTicketActionPage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			
			//filter
			createNewFilterPage.inputFilterName(filterName);
			createNewFilterPage.selectSource(source);
			filterRulePage.selectKeyword(keyword);
			filterRulePage.selectComparator(comparator);
			filterRulePage.inputKeywordValue(keywordValue);
			
			//snow duplicate
			createNewFilterPage.addExtendedRule();
			extendedRulePage.selectExtendedRule(CommonConstants.EXTENDED_RULE_SNOW_DUPLICATE);
			snowDuplicateConditionPage.selectWithOrWithout(with);
			snowDuplicateConditionPage.selectKeyword(snowKeyword);
			
			//action
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
		
		Then("filter with Snow Duplicate Check condition should be saved successfully", () -> {
			createNewFilterPage.clickSaveButton();
			createNewFilterPage.verifyFilterSuccessfullySaved();
		});

	
	}

}
