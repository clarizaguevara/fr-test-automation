package com.stepdefs.phase2.sprint1;

import com.pageobjects.HomePage;
import com.stepdefs.ScenarioHooks;

import cucumber.api.java8.En;

public class AISM153Stepdefs implements En {
	
	public AISM153Stepdefs(ScenarioHooks hooks, HomePage homePage) {
		
		When("I browse filters with source: (.*)", (String source) -> {
			homePage.selectSource(source);
			homePage.clickApplyButton();
		});
		
		Then("Browse Filters page should list the filters with (.*) as source", (String source) -> {
			homePage.verifySourceOfSearchResults(source);
		});
		
	}

}
