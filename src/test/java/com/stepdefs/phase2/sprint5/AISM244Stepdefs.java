package com.stepdefs.phase2.sprint5;

import com.pageobjects.CreateSNOWTicketPage;
import com.stepdefs.ScenarioHooks;

import cucumber.api.java8.En;

public class AISM244Stepdefs implements En {
	
	public AISM244Stepdefs(ScenarioHooks hooks, CreateSNOWTicketPage createSNOWTicketActionPage) {

		And("I tick \"Consolidate SNOW ticket\" checkbox", () -> {
			createSNOWTicketActionPage.checkConsolidateTicket();
		});
	}

}
