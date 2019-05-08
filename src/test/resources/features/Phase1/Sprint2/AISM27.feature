@AISM27 @scenarios 
Feature: AISM - 27
	As a Tool Administrator
	I can configure so that alerts from Slack channel that comes from Nagios in PET environment can be handled
	
Background: 
	Given I am login 
	And I am on Create New Filter page 
	
Scenario Outline: Verify Tool Administrator can configure so that alerts from Slack channel that comes from Nagios in PET environment can be handled (Send To Slack)
	When I create a Filter with filter name <filter name> and <source> as source 
	And with Filter Rule: <keyword> - <comparator> - <keyword value> 
	And with Action: Send To Slack "<filter name>"
	Then I should be able to save successfully 
	
	Examples: 
		| filter name            | source       | keyword      | comparator    | keyword value        |
		| AUT_TestSourceNagios1  | Nagios-Pet   | Summary      | Contains      | TEST                 |
	
Scenario Outline: Verify Tool Administrator can configure so that alerts from Slack channel that comes from Nagios in PET environment can be handled (Create Jira Ticket)
	When I create a Filter with filter name <filter name> and <source> as source 
	And with Filter Rule: <keyword> - <comparator> - <keyword value> 
	And with Action: Create Jira Ticket-KKA "<filter name>"
	Then I should be able to save successfully 
	
	Examples: 
		| filter name            | source       | keyword      | comparator    | keyword value        |
		| AUT_TestSourceNagios2  | Nagios-Pet   | Description  | Contains      | TEST                 |

		
		
		
