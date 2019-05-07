@scenarios @ExtendedRules @CiscoMerakiCheck
Feature: AISM-11
  As a Operator
  I can check network status from the alert information

  Scenario Outline: Verify saving of filter with Cisco Meraki Check condition (device status = <device status>)
    Given I am to create a filter with Cisco Meraki Check condition and I am on Create New Filter page
    When I create a Filter with filter name <filter name>, <source> as source, Filter rule: <keyword> - <comparator> - <keyword value>, and add a Cisco Meraki Check condition: Check if device causing alert is <device status>
    Then filter with Cisco Meraki Check condition should be saved successfully

    Examples: 
      | filter name          | source       | keyword       | comparator  | keyword value | device status |
      | AUT_TestMerakiCheck1 | Cisco Meraki | Mac Address   | Begins With | e0            | Active        |
      | AUT_TestMerakiCheck2 | Cisco Meraki | Device Serial | Ends With   | F8Y3          | Inactive      |
