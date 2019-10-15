package com.stepdefs.phase3.sprint2;

import com.constants.CommonConstants;
import com.pageobjects.HomePage;
import com.stepdefs.ScenarioHooks;

import cucumber.api.java8.En;

public class AISM298Stepdefs implements En {
	
	public AISM298Stepdefs(ScenarioHooks hooks, HomePage homePage) {
		
		When("I input a Filter Id", () -> {
			homePage.inputFilterId(CommonConstants.FILTER_ID);
		});
		
		Then("Browse Filters page should only show the filter with the selected Filter Id", () -> {
			homePage.clickApplyButton();
			homePage.verifyFilterIdOfSearchResults(CommonConstants.FILTER_ID);
		});
		
	}

}
