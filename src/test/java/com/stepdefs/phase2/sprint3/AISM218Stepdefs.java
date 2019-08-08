package com.stepdefs.phase2.sprint3;

import com.pageobjects.CreateSNOWTicketPage;
import com.pageobjects.LoginPage;
import com.stepdefs.ScenarioHooks;

import cucumber.api.java8.En;

public class AISM218Stepdefs implements En {
	
	public AISM218Stepdefs(ScenarioHooks hooks, LoginPage loginPage, CreateSNOWTicketPage createSNOWTicket) {
		
		And("I remove a non-mandatory field: Short Description", () -> {
			createSNOWTicket.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			createSNOWTicket.clearShortDescription();
		});
	}

}
