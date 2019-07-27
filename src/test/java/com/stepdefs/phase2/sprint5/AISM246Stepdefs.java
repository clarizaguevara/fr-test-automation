package com.stepdefs.phase2.sprint5;

import com.constants.CommonConstants;
import com.pageobjects.EventsBrowserPage;
import com.stepdefs.ScenarioHooks;

import cucumber.api.java8.En;

public class AISM246Stepdefs implements En {
	
	public AISM246Stepdefs(ScenarioHooks hooks, EventsBrowserPage eventsBrowserPage) {
		
		When("I input an Event Id", () -> {
			eventsBrowserPage.inputEventId(CommonConstants.EVENT_ID);
		});
		
		Then("Events Browser page should only show the event with the selected Event Id", () -> {
			eventsBrowserPage.verifyEventIdOfSearchResults(CommonConstants.EVENT_ID);
		});
		
	}

}
