package com.stepdefs.phase1.sprint3;

import com.pageobjects.EventsBrowserPage;
import com.pageobjects.HomePage;
import com.stepdefs.ScenarioHooks;
import cucumber.api.java8.En;

public class AISM138Stepdefs implements En {
	
	public AISM138Stepdefs(ScenarioHooks hooks, HomePage homePage, EventsBrowserPage eventsBrowserPage) {
		
		And("I am on Home page", () -> {
			homePage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			homePage.verifySuccessfulNavigationToHomePage();
		});
		
		When("I click Events tab", () -> {
			homePage.clickEventsTab();
			eventsBrowserPage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
		});
		
		Then("Events Browser page should be loaded successfully", () -> {
			eventsBrowserPage.verifySuccessfulNavigationToEventsBrowserPage();
		});
		
		/*-----------------------------*/
		
		And("I select (.*) as Source", (String source) -> {
			eventsBrowserPage.selectSource(source);
		});
		
		And("I select Date Range: From (.*) To (.*)", (String timestampFrom, String timestampTo) -> {
			eventsBrowserPage.inputTimestampFrom(timestampFrom);
			eventsBrowserPage.inputTimestampTo(timestampTo);
		});
		
		And("I click Apply", () -> {
			eventsBrowserPage.clickApplyButton();
		});
		
		Then("Events Browser page should list the events received from (.*) to (.*) and with (.*) as source", (String timestampFrom, String timestampTo, String source) -> {
			eventsBrowserPage.verifySourceOfSearchResults(source);
			eventsBrowserPage.verifyDateOfSearchResults(timestampFrom, timestampTo);
		});
		
		/*-----------------------------*/
		
		Then("From date should not be greater than To date when selecting Date Range", () -> {
			eventsBrowserPage.verifyFromAndToTimestamps();
		});
		
		/*-----------------------------*/
		
		And("I click the Payload button of each event", () -> {
			
		});
		
		Then("Payload info of the event is shown", () -> {
			eventsBrowserPage.verifyPayloadInfo();
		});
		
		/*-----------------------------*/
		
		And("I select an event in the list", () -> {
			eventsBrowserPage.clickEventId();
		});
		
		Then("Filter details of the event is shown", () -> {
			eventsBrowserPage.verifyFilterDetails();
		});
		
		When("I click the Back button", () -> {
			eventsBrowserPage.clickBackButton();
		});
		
		/*-----------------------------*/
		
		And("I select a filter in the filter list", () -> {
			eventsBrowserPage.clickFilterName();
		});
		
		Then("Action details of the filter is shown", () -> {
			eventsBrowserPage.verifyActionDetails();
		});
		
		/*-----------------------------*/
		
		And("I select an action in the action list", () -> {
			eventsBrowserPage.clickAction();
		});
		
		Then("Payload of the action is shown", () -> {
			eventsBrowserPage.verifyPayloadDetails();
		});
		
	}

}
