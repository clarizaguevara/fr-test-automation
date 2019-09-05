package com.stepdefs.phase3.sprint1;

import com.pageobjects.CreateNewFilterPage;
import com.pageobjects.VariableDefinitionPage;
import com.stepdefs.ScenarioHooks;

import cucumber.api.java8.En;

public class AISM274Stepdefs implements En {
	
	public AISM274Stepdefs(ScenarioHooks hooks, CreateNewFilterPage createNewFilterPage, VariableDefinitionPage variableDefinitionPage) {
		
		And("I define a variable with name: (.*): after (.*) until (.*) from field (.*)", (String variableName, String startString, String endDelimeter, String field) -> {
			createNewFilterPage.clickAddVariableButton();
			variableDefinitionPage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			variableDefinitionPage.inputVariableName(variableName);
			variableDefinitionPage.inputStartString(startString);
			if(!endDelimeter.equals("(end delimeter not included)")) {
				variableDefinitionPage.includeEndDelimeter(endDelimeter);
				variableDefinitionPage.inputEndDelimeter(endDelimeter);
			}
			variableDefinitionPage.selectField(field);
		});
		
		And("I edit the variable with name: (.*): after (.*) until (.*) from field (.*)", (String variableName, String startString, String endDelimeter, String field) -> {
			variableDefinitionPage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			variableDefinitionPage.inputVariableName(variableName);
			variableDefinitionPage.inputStartString(startString);
			if(!endDelimeter.equals("(end delimeter not included)")) {
				variableDefinitionPage.includeEndDelimeter(endDelimeter);
				variableDefinitionPage.inputEndDelimeter(endDelimeter);
			}
			variableDefinitionPage.selectField(field);
		});
		
		And("I delete the variable with name: (.*)", (String variableName) -> {
			variableDefinitionPage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			variableDefinitionPage.deleteVariable(variableName);
		});
		
		And("variable (.*) should be removed", (String variableName) -> {
			variableDefinitionPage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			variableDefinitionPage.verifyIfVariableIsRemoved(variableName);
		});
		
		And("I define a variable (.*) with details: (.*)", (String rowNumber, String variable) -> {
			variableDefinitionPage.setDriver(hooks.getDriverHelper(), ScenarioHooks.getScenarioName());
			createNewFilterPage.clickAddVariableButton();
			variableDefinitionPage.createVariableByRow(variable, rowNumber);
		});
		
		And("I add another variable (.*) with details: (.*)", (String rowNumber, String variable) -> {
			createNewFilterPage.clickAddVariableButton();
			variableDefinitionPage.createVariableByRow(variable, rowNumber);
		});
		
	}
	
}
