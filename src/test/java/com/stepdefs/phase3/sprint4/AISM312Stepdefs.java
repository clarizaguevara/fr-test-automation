package com.stepdefs.phase3.sprint4;

import com.pageobjects.CreateSNOWTicketPage;
import com.stepdefs.ScenarioHooks;

import cucumber.api.java8.En;

public class AISM312Stepdefs implements En {
	
	public AISM312Stepdefs(ScenarioHooks hooks, CreateSNOWTicketPage createSNOWTicketActionPage) {

		And("I Consolidate SNow ticket into (.*)", (String consolidateType) -> {
			createSNOWTicketActionPage.selectConsolidateInto(consolidateType);
		});
		
		And("with Time component enabled: within (.*) (.*)", (String timeValue, String timeUnit) -> {
			createSNOWTicketActionPage.inputTimeValue(timeValue);
			createSNOWTicketActionPage.selectTimeUnit(timeUnit);
		});
	}

}
