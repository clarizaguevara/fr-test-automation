@AISM7 @scenarios
Feature: AISM - 7
	As a Tool Administrator
	I can configure so that message is sent to users on Slack automatically
	
Background: 	
	Given I am login 
	And I am on Create New Filter page

@onescenario
Scenario Outline: Verify Tool Administrator can configure so that message is sent to users on Slack automatically
	When I create a Filter with filter name <filter name> and <source> as source 
	And with Filter Rule: <keyword> - <comparator> - <keyword value> 
	And with Action: Send To Slack "<filter name>"
	Then I should be able to save successfully 
	
		Examples: 
		| filter name                | source       | keyword      | comparator    | keyword value        |
		| AUT_TestSlackActionFilter1 | Nagios-Pet   | Summary      | Contains      | TEST                 |
		| AUT_TestSlackActionFilter2 | Cisco Meraki | Hostname     | Begins With   | UQ                   |
		
Scenario Outline: Verify EvA bot can include original alert message to the message posted with quotation
	When I create a Filter with filter name <filter name> and <source> as source 
	And with Filter Rule: <keyword> - <comparator> - <keyword value> 
	And with Action: Send To Slack "<filter name>"
	And I ticked include original alert message
	Then I should be able to save successfully 
	
		Examples: 
		| filter name                | source       | keyword      | comparator    | keyword value        |
		| AUT_TestSlackActionFilter3 | Nagios-Pet   | Description  | Contains      | TEST                 |
		
Scenario Outline: Verify EvA can send mention
	When I create a Filter with filter name <filter name> and <source> as source 
	And with Filter Rule: <keyword> - <comparator> - <keyword value> 
	And with Action: Send To Slack "<filter name>"
	And I add mention
	Then I should be able to save successfully 
	
		Examples: 
		| filter name                | source       | keyword      | comparator    | keyword value        |
		| AUT_TestSlackActionFilter4 | Cisco Meraki | Country      | Equals        | JP                   |

Scenario Outline: Verify filter is not saved when Slack Channel field is blank
	When I create a Filter with filter name <filter name> and <source> as source 
	And with Filter Rule: <keyword> - <comparator> - <keyword value> 
	And with Action: Send To Slack "<filter name>"
	And I left Slack Channel field blank
	Then I should be able to save successfully 
	
		Examples: 
		| filter name                | source       | keyword      | comparator    | keyword value        |
		| AUT_TestSlackActionFilter5 | Cisco Meraki | Mac Address  | Contains      | e0:55:               |
			
	
