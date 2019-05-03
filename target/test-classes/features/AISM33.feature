@AISM33 @scenarios 
Feature: AISM - 33
	As a Tool Administrator
	I can receive alerts information from Meraki
	
Background: 
	Given I am login 
	And I am on Create New Filter page 
	
Scenario Outline: Verify Operator can receive alerts information from Meraki (Send To Slack)
	When I create a Filter with filter name "<filter name>" and "<source>" as source 
	And with Filter Rule: "<keyword>" "<comparator>" "<keyword value>" 
	And with Action: Send To Slack "<filter name>"
	Then I should be able to save successfully 
	
	Examples: 
		| filter name            | source       | keyword      | comparator    | keyword value        |
		| AUT_TestCiscoMeraki1   | Cisco Meraki | Mac Address  | Contains      | e0:55:               |
	
Scenario Outline: Verify Operator can receive alerts information from Meraki (Create Jira Ticket)
	When I create a Filter with filter name "<filter name>" and "<source>" as source 
	And with Filter Rule: "<keyword>" "<comparator>" "<keyword value>" 
	And with Action: Create Jira Ticket-KKA "<filter name>"
	Then I should be able to save successfully 
	
	Examples: 
		| filter name            | source       | keyword      | comparator    | keyword value        |
		| AUT_TestCiscoMeraki2   | Cisco Meraki | Device       | Equals        | SDC-AP1-API          |

		
		
		
