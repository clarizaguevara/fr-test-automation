package com.stepdefs.phase2.sprint5;

import com.pageobjects.EventsBrowserPage;
import com.stepdefs.ScenarioHooks;

import cucumber.api.java8.En;

public class AISM248Stepdefs implements En {
	
	public AISM248Stepdefs(ScenarioHooks hooks, EventsBrowserPage eventsBrowserPage) {
		
		Then("Timestamp should be displayed in (.*) format", (String format) -> {
			eventsBrowserPage.verifyTimestampFormat(format);
		});
		
	}

}
