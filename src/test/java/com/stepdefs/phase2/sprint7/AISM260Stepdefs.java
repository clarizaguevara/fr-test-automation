package com.stepdefs.phase2.sprint7;

import com.pageobjects.CreateNewFilterPage;
import com.pageobjects.HomePage;
import com.stepdefs.ScenarioHooks;

import cucumber.api.java8.En;

public class AISM260Stepdefs implements En {
	
	public AISM260Stepdefs(ScenarioHooks hooks, CreateNewFilterPage createNewFilterPage, HomePage homePage) {
		
		And("I add category: (.*)", (String categories) -> {
			createNewFilterPage.inputCategory(categories);
		});
		
		And("category (.*) should be applied", (String categories) -> {
			createNewFilterPage.verifyCategory(categories);
		});
		
		And("I remove category: (.*)", (String categories) -> {
			createNewFilterPage.removeCategory(categories);
		});
		
		And("I browse filters with category: (.*)", (String categories) -> {
			homePage.inputCategory(categories);
		});
		
		Then("Browse Filters page should list the filters with the category: (.*)", (String categories) -> {
			homePage.clickApplyButton();
			homePage.verifyCategoryOfSearchResults(categories);
		});
		
	}

}
