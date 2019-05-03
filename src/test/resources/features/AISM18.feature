@AISM18 @scenarios 
Feature: AISM - 18 
	As a Tool Administrator
	I can configure so that a JIRA ticket will be created automatically (KKA)
	
Background: 
	Given I am login 
	And I am on Create New Filter page 
	
Scenario Outline: Verify Tool Administrator can configure so that a JIRA ticket will be created automatically (Nagios-Pet)
	When I create a Filter with filter name "<filter name>" and "<source>" as source 
	And with Filter Rule: "<keyword>" "<comparator>" "<keyword value>" 
	And with Action: Create Jira Ticket-KKA "<filter name>"
	Then I should be able to save successfully 
	
	Examples: 
		| filter name                | source       | keyword      | comparator    | keyword value        |
		| AUT_TestCreateJiraAction1  | Nagios-Pet   | Description  | Contains      | TEST                 |
		| AUT_TestCreateJiraAction2  | Cisco Meraki | Hostname     | Begins With   | UQ                   |

Scenario Outline: Verify Filter is not saved if mandatory fields are left blank
	When I create a Filter with filter name "<filter name>" and "<source>" as source 
	And with Filter Rule: "<keyword>" "<comparator>" "<keyword value>" 
	And with Action: Create Jira Ticket-KKA but mandatory fields are left blank "<filter name>"
	Then I should not be able to save successfully
	
	Examples: 
		| filter name                | source       | keyword      | comparator    | keyword value        |
		| AUT_TestCreateJiraAction3  | Cisco Meraki | Country      | Ends With     | JP                   |
		
Scenario Outline: Verify Filter is saved if non mandatory fields are left blank
	When I create a Filter with filter name "<filter name>" and "<source>" as source 
	And with Filter Rule: "<keyword>" "<comparator>" "<keyword value>" 
	And with Action: Create Jira Ticket-KKA but non mandatory fields are left blank "<filter name>"
	Then I should be able to save successfully
	
	Examples: 
		| filter name                | source       | keyword      | comparator    | keyword value        |
		| AUT_TestCreateJiraAction4  | Cisco Meraki | Shop         | Ends With     | UQ                   |		
		
		
