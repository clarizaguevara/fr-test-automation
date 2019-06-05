package com.stepdefs.phase2.sprint3;

import com.pageobjects.EventsBrowserPage;
import com.pageobjects.HomePage;
import com.stepdefs.ScenarioHooks;

import cucumber.api.java8.En;

public class AISM214Stepdefs implements En {
	
	public AISM214Stepdefs(ScenarioHooks hooks, HomePage homePage, EventsBrowserPage eventsBrowserPage) {
		
		And("I am on Events Browser page", () -> {
			homePage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			homePage.verifySuccessfulNavigationToHomePage();
			homePage.clickEventsTab();
			eventsBrowserPage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			eventsBrowserPage.verifySuccessfulNavigationToEventsBrowserPage();
		});
		
		When("I select (.*) as Status", (String status) -> {
			eventsBrowserPage.selectStatus(status);
		});
		
		Then("Events Browser page should list all events with (.*) actions only", (String status) -> {
			eventsBrowserPage.verifyStatusOfSearchResults(status);
		});
		
		And("with (.*) actions only", (String status) -> {
			eventsBrowserPage.verifyStatusOfSearchResults(status);
		});
		
	}

}
