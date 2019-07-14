package com.stepdefs.phase1.sprint2;

import com.constants.CommonConstants;
import com.pageobjects.CiscoMerakiCheckConditionPage;
import com.pageobjects.CreateNewFilterPage;
import com.pageobjects.ExtendedRulePage;
import com.stepdefs.ScenarioHooks;

import cucumber.api.java8.En;

public class AISM11Stepdefs implements En {
	
	public AISM11Stepdefs(ScenarioHooks hooks, CreateNewFilterPage createNewFilterPage,
			ExtendedRulePage extendedRulePage, CiscoMerakiCheckConditionPage ciscoMerakiCheckConditionPage) {

		And("add a Cisco Meraki Check condition: Check if device causing alert is (.*)", (String deviceStatus) -> {
			extendedRulePage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			ciscoMerakiCheckConditionPage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			
			createNewFilterPage.addExtendedRule();
			extendedRulePage.selectExtendedRule(CommonConstants.EXTENDED_RULE_CISCO_MERAKI_CHECK);
			ciscoMerakiCheckConditionPage.selectDeviceStatus(deviceStatus);
		});
	}
}
