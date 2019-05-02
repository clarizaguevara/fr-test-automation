@AISM22 @scenarios 
Feature: AISM - 22 
	As a Tool Administrator
	I can configure so that alert will be filtered by keyword in alert message
	
Background: 
	Given I am login 
	And I am on Create New Filter page 
	
Scenario Outline: Verify Tool Administrator can configure so that alert will be filtered by keyword in alert message (Send To Slack)
	When I create a Filter with filter name "<filter name>" and "<source>" as source 
	And with Filter Rule: "<keyword>" "<comparator>" "<keyword value>" 
	And with Action: Send To Slack "<filter name>"
	Then I should be able to save successfully 
	
	Examples: 
		| filter name            | source       | keyword      | comparator    | keyword value        |
		| AUT_TestKeywordFilter1 | Nagios-Pet   | Summary      | Contains      | TEST                 |
		| AUT_TestKeywordFilter3 | Cisco Meraki | Hostname     | Begins With   | UQ                   |
		| AUT_TestKeywordFilter5 | Cisco Meraki | Device       | Equals        | SDC-AP1-API          |
		| AUT_TestKeywordFilter7 | Cisco Meraki | Network Id   | Like          | L_60235*160806634    |
		| AUT_TestKeywordFilter9 | Cisco Meraki | Shop         | Ends With     | UQ                   |

@onescenario		
Scenario Outline: Verify Tool Administrator can configure so that alert will be filtered by keyword in alert message (Create Jira Ticket)
	When I create a Filter with filter name "<filter name>" and "<source>" as source 
	And with Filter Rule: "<keyword>" "<comparator>" "<keyword value>" 
	And with Action: Create Jira Ticket "<filter name>"
	Then I should be able to save successfully 
	
	Examples: 
		| filter name            | source       | keyword      | comparator    | keyword value        |
		| AUT_TestKeywordFilter2 | Cisco Meraki | Device       | Like          | SDC - * - API        |
		| AUT_TestKeywordFilter4 | Cisco Meraki | Country      | Ends With     | JP                   |
		| AUT_TestKeywordFilter6 | Cisco Meraki | Mac Address  | Contains      | e0:55:               |
		| AUT_TestKeywordFilter8 | Cisco Meraki | IP Address   | Begins With   | 192                  |
		| AUT_TestKeywordFilter10| Cisco Meraki | Device Serial| Equals        | Q2JD-XJGK-F8Y3       |
		
		
		
