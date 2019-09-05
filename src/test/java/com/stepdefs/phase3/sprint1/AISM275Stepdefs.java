package com.stepdefs.phase3.sprint1;

import com.pageobjects.CorrelationPage;
import com.stepdefs.ScenarioHooks;

import cucumber.api.java8.En;

public class AISM275Stepdefs implements En {
	
	public AISM275Stepdefs(ScenarioHooks hooks, CorrelationPage correlationPage) {
		
		And("with same values for (.*)", (String variableName) -> {
			correlationPage.selectVariable(variableName);
		});
		
	}

}
