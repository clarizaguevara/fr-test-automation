package com.stepdefs.phase2.sprint6;

import com.constants.CommonConstants;
import com.pageobjects.EventsBrowserPage;
import com.stepdefs.ScenarioHooks;

import cucumber.api.java8.En;

public class AISM249Stepdefs implements En {
	
	public AISM249Stepdefs(ScenarioHooks hooks, EventsBrowserPage eventsBrowserPage) {
		
		When("I select an Event with Failed status", () -> {
			eventsBrowserPage.clickRetryOfEventIDs(CommonConstants.EVENT_ID_FAILED_STATUS);
		});
		
		And("view the Retry list", () -> {
			eventsBrowserPage.clickEventsListButton();
		});
		
		Then("the selected Event should be in the Retry list", () -> {
			eventsBrowserPage.verifyRetryListPopUp();
			eventsBrowserPage.verifySelectedEvents(CommonConstants.EVENT_ID_FAILED_STATUS);
		});
		
		/*-----------------------------*/
		
		When("I select multiple Events with Failed status", () -> {
			eventsBrowserPage.clickRetryOfEventIDs(CommonConstants.MULTIPLE_EVENT_IDS_FAILED_STATUS);
		});
		
		Then("the selected Events should be in the Retry list", () -> {
			eventsBrowserPage.verifyRetryListPopUp();
			eventsBrowserPage.verifySelectedEvents(CommonConstants.MULTIPLE_EVENT_IDS_FAILED_STATUS);
		});
		
		/*-----------------------------*/
		
		When("I deselect one Event", () -> {
			eventsBrowserPage.clickRetryListCloseButton();
			eventsBrowserPage.clickRetryOfEventIDs(CommonConstants.EVENT_ID_DESELECT);
		});
		
		Then("the deselected Event should be removed from the Retry list", () -> {
			eventsBrowserPage.clickEventsListButton();
			eventsBrowserPage.verifyRetryListPopUp();
			eventsBrowserPage.verifySelectedEvents(CommonConstants.EVENT_ID_FAILED_STATUS);
		});
		
		/*-----------------------------*/
		
		When("I click the Retry button", () -> {
			eventsBrowserPage.selectEventsInRetryList(CommonConstants.EVENT_ID_FAILED_STATUS);
			eventsBrowserPage.clickRetryButton();
		});
		
		Then("the failed Event should change its status to (.*)", (String status) -> {
			eventsBrowserPage.verifyIfRetryIsExecuted();
			eventsBrowserPage.clickRetryListCloseButton();
			eventsBrowserPage.inputEventId(CommonConstants.EVENT_ID_FAILED_STATUS);
			eventsBrowserPage.clickApplyButton();
			eventsBrowserPage.verifyStatusOfSearchResults(status);
		});
		
	}

}
