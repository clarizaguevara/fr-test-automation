@AISM6 @scenarios 
Feature: AISM - 6 
	As a Tool Administrator
	I can configure so that JIRA ticket URL can be sent to Slack automatically as an action
	
Background: 
	Given I am login 
	And I am on Create New Filter page 

Scenario Outline: Verify Tool Administrator can configure so that JIRA ticket URL can be sent to Slack automatically as an action (KKA)
	When I create a Filter with filter name <filter name> and <source> as source 
	And with Filter Rule: <keyword> - <comparator> - <keyword value> 
	And with Action: Create Jira Ticket-KKA "<filter name>"
	Then I should be able to save successfully 
	
	Examples: 
		| filter name                    | source       | keyword      | comparator    | keyword value        |
		| AUT_TestCreateJiraSendToSlack1 | Nagios-Pet   | Summary      | Contains      | TEST                 |

Scenario Outline: Verify Tool Administrator can configure so that JIRA ticket URL can be sent to Slack automatically as an action (ACPF)
	When I create a Filter with filter name <filter name> and <source> as source 
	And with Filter Rule: <keyword> - <comparator> - <keyword value> 
	And with Action: Create Jira Ticket-ACPF "<filter name>"
	Then I should be able to save successfully 
	
	Examples: 
		| filter name                    | source       | keyword      | comparator    | keyword value        |
		| AUT_TestCreateJiraSendToSlack2 | Cisco Meraki | Country      | Equals        | JP                   |

Scenario Outline: Verify JIRA ticket URL is not sent to Slack if Send ticket ID to Slack Channel checkbox is not ticked
	When I create a Filter with filter name <filter name> and <source> as source 
	And with Filter Rule: <keyword> - <comparator> - <keyword value> 
	And with Action: Create Jira Ticket-ACPF "<filter name>"
	And Send ticket ID to Slack channel is not ticked
	Then I should be able to save successfully 
	
	Examples: 
		| filter name                    | source       | keyword      | comparator    | keyword value        |
		| AUT_TestCreateJiraSendToSlack3 | Cisco Meraki | Device       | Equals        | SDC-AP1-API          |		
		
Scenario Outline: Verify slack channel field should not be left blank if Send ticket ID to Slack channel check box is ticked
	When I create a Filter with filter name <filter name> and <source> as source 
	And with Filter Rule: <keyword> - <comparator> - <keyword value> 
	And with Action: Create Jira Ticket-KKA "<filter name>"
	And Slack Channel field is left blank 
	Then I should not be able to save successfully 
	
	Examples: 
		| filter name                    | source       | keyword      | comparator    | keyword value        |
		| AUT_TestCreateJiraSendToSlack4 | Cisco Meraki | Mac Address  | Contains      | e0:55:               |				
