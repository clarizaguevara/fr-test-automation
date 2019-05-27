@scenarios @AISM147
Feature: AISM-147
  As an Operator
  I can use OR in filter conditions

  Background: 
    Given I am login
    And I am on Create New Filter page

  Scenario Outline: Verify saving of filter with AND/OR conditions (source: <source>)
    When I create a Filter with filter name <filter name> and <source> as source
    And 1st group has conditions: <group1 conditions>
    And I add another group - <andor> 1
    And 2nd group has conditions: <group2 conditions>
    And <filter name> has Action: Send to Slack
    Then filter should be saved successfully

    Examples: 
      | filter name             | source       | group1 conditions                                                     | andor | group2 conditions                                                                   |
      | AUT_TestAND/OR_CM_TRUE  | Cisco Meraki | Device-Contains-TEST OR Network_Id-NOT-Equals-TEST AND Shop-Equals-GU | OR    | Hostname-Begins_With-e0 AND Country-Ends_With-JP OR Device_Serial-Contains-Q2JD     |
      | AUT_TestAND/OR_CM_FALSE | Cisco Meraki | Hostname-Contains-TEST OR Country-NOT-Equals-PH AND Shop-Equals-GU    | OR    | Mac_Address-Begins_With-e0 AND Device-Ends_With-TEST OR Device_Serial-Contains-Q1JD |
	  | AUT_TestAND/OR_NP_TRUE  | Nagois-Pet   | Summary-Contains-TEST AND Summary-Contains-cif                        | OR    | Description-Contains-CRITICAL OR Description-Contains-TEST AND Description-Contains-WARNING |
 
@onescenario 
Scenario Outline: Verify saving of filter with AND/OR conditions (source: <source>)
    When I create a Filter with filter name <filter name> and <source> as source
    And 1st group has conditions: <group1 conditions>
    And I add another group - <andor> 1
    And 2nd group has conditions: <group2 conditions>
    And I add another group - <andor2> 2
    And 3rd group has conditions: <group3 conditions>
    And <filter name> has Action: Send to Slack
    Then filter should be saved successfully    
    
    Examples:  
      | filter name              | source       | group1 conditions                               | andor | group2 conditions                                                                           | andor2 | group3 conditions             |
	  | AUT_TestAND/OR_NP_TRUE   | Nagois-Pet   | Summary-Contains-TEST AND Summary-Contains-cif  | OR    | Description-Contains-CRITICAL OR Description-Contains-TEST AND Description-Contains-WARNING | AND    | Summary-NOT-Contains-CRITICAL |
	  | AUT_TestAND/OR_NP_FALSE  | Nagois-Pet   | Summary-Contains-TEST AND Summary-Contains-cif  | OR    | Description-Contains-CRITICAL OR Description-Contains-TEST AND Description-Contains-WARNING | AND    | Summary-Contains-CRITICAL     |