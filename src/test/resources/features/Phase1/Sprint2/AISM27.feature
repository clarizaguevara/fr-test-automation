@AISM27
Feature: AISM-27
  As a Tool Administrator
  I can configure so that alerts from Slack channel that comes from Nagios in PET environment can be handled

  Background: 
    Given I am login
    And I am on Create New Filter page

  Scenario Outline: Verify Tool Administrator can configure so that alerts from Slack channel that comes from Nagios in PET environment can be handled (action: <action>)
    When I create a Filter with filter name <filter name> and <source> as source
    And with Filter Rule: <keyword> - <comparator> - <keyword value>
    And <filter name> has Action: <action>
    Then filter should be saved successfully

    Examples: 
      | filter name           | source     | keyword     | comparator | keyword value | action        |
      | AUT_TestSourceNagios1 | Nagios-Pet | Summary     | Contains   | TEST          | Send to Slack |
      | AUT_TestSourceNagios2 | Nagios-Pet | Description | Contains   | TEST          | Jira-KKA      |
