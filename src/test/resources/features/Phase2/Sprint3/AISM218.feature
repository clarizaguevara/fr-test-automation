@scenarios @AISM218
Feature: AISM-218
  As an Tool Administrator
  I can configure so that only the necessary fields are set as mandatory on SNOW

  Background: 
    Given I am login
    And I am on Create New Filter page 

Scenario Outline: Verify Tool Administrator can configure so that only the necessary fields are set as mandatory on SNOW
	When I create a Filter with filter name <filter name> and <source> as source 
	And with Filter Rule: <keyword> - <comparator> - <keyword value> 
	And with Action: Create SNOW Ticket with correct mandatory fields "<filter name>"
	Then I should be able to save successfully 
	
	Examples: 
		| filter name             | source       | keyword      | comparator    | keyword value        |
		| AUT_TestSNOWMandatory1  | Nagios-Pet   | Description  | Contains      | TEST                 |
		| AUT_TestSNOWMandatory2  | Cisco Meraki | IP Address   | Begins With   | 192                  |
