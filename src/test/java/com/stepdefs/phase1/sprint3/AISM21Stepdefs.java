package com.stepdefs.phase1.sprint3;

import com.constants.CommonConstants;
import com.pageobjects.CreateNewFilterPage;
import com.pageobjects.FilterRulePage;
import com.pageobjects.LoginPage;
import com.pageobjects.SendEmailActionPage;
import com.stepdefs.ScenarioHooks;

import cucumber.api.java8.En;

public class AISM21Stepdefs implements En {
	
	public AISM21Stepdefs(ScenarioHooks hooks, LoginPage loginPage, CreateNewFilterPage createNewFilterPage, FilterRulePage filterRulePage,
			SendEmailActionPage sendEmailActionPage) {
		
		And("(.*) has Action: Email but mandatory fields are left blank", (String uniqueName) -> {
			createNewFilterPage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			sendEmailActionPage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			createNewFilterPage.selectAction(CommonConstants.ACTION_SEND_EMAIL);
			sendEmailActionPage.inputTo(" ");
			sendEmailActionPage.inputCC(CommonConstants.EMAIL_CC);
			sendEmailActionPage.inputSubject(" ");
			sendEmailActionPage.inputEmailMessage(uniqueName);
		});
		
		And("(.*) has Action: Email with sub-domain", (String uniqueName) -> {
			createNewFilterPage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			sendEmailActionPage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			createNewFilterPage.selectAction(CommonConstants.ACTION_SEND_EMAIL);
			sendEmailActionPage.inputTo(CommonConstants.EMAIL_TO_SUBDOMAIN);
			sendEmailActionPage.inputSubject(uniqueName);
			sendEmailActionPage.inputEmailMessage(uniqueName);
		});
	}
}
