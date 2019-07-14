@AISM33
Feature: AISM-33
  As a Tool Administrator
  I can receive alerts information from Meraki

  Background: 
    Given I am login
    And I am on Create New Filter page

  Scenario Outline: Verify Operator can receive alerts information from Meraki (action: <action>)
    When I create a Filter with filter name <filter name> and <source> as source
    And with Filter Rule: <keyword> - <comparator> - <keyword value>
    And <filter name> has Action: <action>
    Then filter should be saved successfully

    Examples: 
      | filter name          | source       | keyword     | comparator | keyword value | action        |
      | AUT_TestCiscoMeraki1 | Cisco Meraki | Mac Address | Contains   | e0:55:        | Send to Slack |
      | AUT_TestCiscoMeraki2 | Cisco Meraki | Device      | Equals     | SDC-AP1-API   | Jira-KKA      |
