package com.stepdefs;

import com.pageobjects.CreateNewFilterPage;
import com.pageobjects.FilterRulePage;
import com.pageobjects.LoginPage;
import com.pageobjects.SendEmailActionPage;

import cucumber.api.java8.En;

public class AISM21Stepdefs implements En {
	
	public AISM21Stepdefs(ScenarioHooks hooks, LoginPage loginPage, CreateNewFilterPage createNewFilterPage, FilterRulePage filterRulePage,
			SendEmailActionPage sendEmailActionPage) {
		
		And("with Action: Send Email \"([^\\\"]*)\"$", (String uniqueName) -> {
			createNewFilterPage.setDriver(hooks.getDriverHelper(), hooks.getScenarioName());
			sendEmailActionPage.setDriver(hooks.getDriverHelper(), hooks.getScenarioName());
			createNewFilterPage.selectAction("Send Email");
			sendEmailActionPage.inputTo("sarah-jane.par.clavio@dxc.com");
			sendEmailActionPage.inputCC("cguevara6@dxc.com");
			sendEmailActionPage.inputSubject(uniqueName);
			sendEmailActionPage.inputEmailMessage(uniqueName);
		});
		
		And("with Action: Send Email but mandatory fields are left blank \"([^\\\"]*)\"$", (String uniqueName) -> {
			createNewFilterPage.setDriver(hooks.getDriverHelper(), hooks.getScenarioName());
			sendEmailActionPage.setDriver(hooks.getDriverHelper(), hooks.getScenarioName());
			createNewFilterPage.selectAction("Send Email");
			sendEmailActionPage.inputTo(" ");
			sendEmailActionPage.inputCC("cguevara6@dxc.com");
			sendEmailActionPage.inputSubject(" ");
			sendEmailActionPage.inputEmailMessage(uniqueName);
		});
	}
}
