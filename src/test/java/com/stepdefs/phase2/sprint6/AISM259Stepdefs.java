package com.stepdefs.phase2.sprint6;

import com.pageobjects.HomePage;
import com.stepdefs.ScenarioHooks;

import cucumber.api.java8.En;

public class AISM259Stepdefs implements En {
	
	public AISM259Stepdefs(ScenarioHooks hooks, HomePage homePage) {
		
		When("I browse filters with status: (.*)", (String status) -> {
			homePage.selectStatus(status);
		});
		
		And("with source: (.*)", (String source) -> {
			homePage.selectSource(source);
		});
		
		Then("Browse Filters page should list the filters with (.*) as status", (String status) -> {
			homePage.clickApplyButton();
			homePage.verifyStatusOfSearchResults(status);
		});
		
		And("filters with (.*) as source", (String source) -> {
			homePage.verifySourceOfSearchResults(source);
		});
		
	}

}
