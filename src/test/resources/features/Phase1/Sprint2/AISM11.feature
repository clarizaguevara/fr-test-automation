@scenarios @AISM11 @Phase1 @Phase1-Sprint2 @ExtendedRules @CiscoMerakiCheck @Regression
Feature: AISM-11
  As a Operator
  I can check network status from the alert information

  Background: 
    Given I am login
    And I am on Create New Filter page

  Scenario Outline: Verify saving of filter with Cisco Meraki Check condition (device status = <device status>)
  	When I create a Filter with filter name <filter name> and <source> as source
    And with Filter Rule: <keyword> - <comparator> - <keyword value>
    And add a Cisco Meraki Check condition: Check if device causing alert is <device status>
    And <filter name> has Action: Send to Slack
    Then filter should be saved successfully

    Examples: 
      | filter name          | source       | keyword       | comparator  | keyword value | device status |
      | AUT_TestMerakiCheck1 | Cisco Meraki | Mac Address   | Begins With | e0            | Active        |
      | AUT_TestMerakiCheck2 | Cisco Meraki | Device Serial | Ends With   | F8Y3          | Inactive      |
