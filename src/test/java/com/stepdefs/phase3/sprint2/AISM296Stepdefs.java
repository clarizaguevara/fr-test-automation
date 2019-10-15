package com.stepdefs.phase3.sprint2;

import com.constants.CommonConstants;
import com.pageobjects.CreateNewFilterPage;
import com.pageobjects.HomePage;
import com.stepdefs.ScenarioHooks;

import cucumber.api.java8.En;

public class AISM296Stepdefs implements En {
	
	public AISM296Stepdefs(ScenarioHooks hooks, HomePage homePage, CreateNewFilterPage createNewFilterPage) {
		
		When("I click the filter name column", () -> {
			homePage.openFilterInNewTab(CommonConstants.FILTER_NAME);
		});
		
		Then("the correct filter should open in a new tab", () -> {
			createNewFilterPage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			createNewFilterPage.verifySuccessfulNavigationToEditFilterPage();
			createNewFilterPage.checkFilterName(CommonConstants.FILTER_NAME);
		});
		
	}

}
