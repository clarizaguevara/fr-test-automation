@scenarios @AISM136
Feature: AISM-136
  Can filter alerts by source of Slack channel

  Background: 
    Given I am login
    And I am on Create New Filter page

  Scenario Outline: Verify saving of filter with keyword: Slack Channel, comparator: <comparator>
    When I create a Filter with filter name <filter name> and <source> as source
    And with Filter Rule: <keyword> - <comparator> - <keyword value>
    And NOT button <NOT>
    And <filter name> has Action: <action>
    Then filter should be saved successfully

    Examples: 
      | filter name                     | source     | keyword       | comparator  | keyword value     | NOT      | action             |
      | AUT_TestSlackChannel_Contains   | Nagios-Pet | Slack Channel | Contains    | aism              | disabled | Send to Slack      |
      | AUT_TestSlackChannel_Like       | Nagios-Pet | Slack Channel | Like        | aism-*-test-dev   | enabled  | Create Jira Ticket |
      | AUT_TestSlackChannel_BeginsWith | Nagios-Pet | Slack Channel | Begins With | test              | disabled | Create SNOW Ticket |
      | AUT_TestSlackChannel_EndsWith   | Nagios-Pet | Slack Channel | Ends With   | dev               | enabled  | Send Email         |
      | AUT_TestSlackChannel_Equals     | Nagios-Pet | Slack Channel | Equals      | aism-eva-test-dev | disabled | Send to Slack      |
