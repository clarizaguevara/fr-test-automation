@AISM7 @scenarios
Feature: AISM - 7
	As a Tool Administrator
	I can configure so that message is sent to users on Slack automatically
	
Background: 	
	Given I am login 
	And I am on Create New Filter page

Scenario: Verify Tool Administrator can configure so that message is sent to users on Slack automatically_Nagios
	When I create Filter so that message is sent to users on Slack automatically with filter name AUT_TestSlackActionFilter1, source value Nagios-Pet
	Then I should be able to save successfully
	
Scenario: Verify EvA bot can include original alert message to the message posted with quotation
	When I create Filter so that message is sent to users on Slack automatically with filter name AUT_TestSlackActionFilter2, source value Nagios-Pet
	And I ticked include original alert message
	Then I should be able to save successfully

Scenario: Verify EvA can send mention
	When I create Filter so that message is sent to users on Slack automatically with filter name AUT_TestSlackActionFilter3, source value Nagios-Pet
	And I add mention
	Then I should be able to save successfully
	
Scenario: Verify filter is not saved when Slack Channel field is blank
	When I create Filter so that message is sent to users on Slack automatically with filter name AUT_TestSlackActionFilter4, source value Nagios-Pet
	And I left Slack Channel field blank
	Then I should not be able to save successfully

Scenario: Verify Tool Administrator can configure so that message is sent to users on Slack automatically_Meraki
	When I create Filter so that message is sent to users on Slack automatically with filter name AUT_TestSlackActionFilter5, source value Cisco Meraki
	Then I should be able to save successfully	

	
