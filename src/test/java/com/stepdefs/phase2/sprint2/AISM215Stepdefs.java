package com.stepdefs.phase2.sprint2;

import com.constants.CommonConstants;
import com.pageobjects.CreateNewFilterPage;
import com.pageobjects.CreateSNOWTicketPage;
import com.stepdefs.ScenarioHooks;

import cucumber.api.java8.En;

public class AISM215Stepdefs implements En {
	
	public AISM215Stepdefs(ScenarioHooks hooks, CreateNewFilterPage createNewFilterPage, CreateSNOWTicketPage createSNOWTicketPage) {
		
		And("I untick \"Send ticket URL to Slack channel\" checkbox", () -> {
			createSNOWTicketPage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			createSNOWTicketPage.checkSendTicketToSlackIDChannel();
		});
		
		Then("Slack channel field of SNOW action should be blank", () -> {
			createNewFilterPage.clickSaveButton();
			createNewFilterPage.verifyFilterSuccessfullySaved(true);
			createSNOWTicketPage.checkSlackChannelValue("");
		});
		
		When("I tick \"Send ticket URL to Slack channel\" checkbox and input Slack channel", () -> {
			createSNOWTicketPage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			createSNOWTicketPage.checkSendTicketToSlackIDChannel();
			createSNOWTicketPage.inputSlackChannel(CommonConstants.SLACK_CHANNEL);
		});
		
		Then("Slack channel field of SNOW action should be filled up", () -> {
			createNewFilterPage.clickSaveButton();
			createNewFilterPage.verifyFilterSuccessfullySaved(true);
			createSNOWTicketPage.checkSlackChannelValue(CommonConstants.SLACK_CHANNEL);
		});
	}

}
