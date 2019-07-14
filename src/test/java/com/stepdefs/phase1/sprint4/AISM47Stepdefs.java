package com.stepdefs.phase1.sprint4;

import com.pageobjects.CreateSNOWTicketPage;
import com.stepdefs.ScenarioHooks;

import cucumber.api.java8.En;

public class AISM47Stepdefs implements En {
	
	public AISM47Stepdefs(ScenarioHooks hooks, CreateSNOWTicketPage createSNOWTicketActionPage) {

		And("I tick \"Automatically close SNOW ticket\" checkbox", () -> {
			createSNOWTicketActionPage.checkAutomaticallyClosedTicket();
		});
	}
}
