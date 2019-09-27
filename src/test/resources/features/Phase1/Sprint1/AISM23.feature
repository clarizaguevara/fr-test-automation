@scenarios @AISM23 @Phase1 @Phase1-Sprint1 @ExtendedRules @Correlation @Regression
Feature: AISM-23
  As a Tool Administrator
  I can configure so that alert can be filtered by correlation

  Background: 
    Given I am login
    And I am on Create New Filter page

  Scenario Outline: Verify saving of filter with Correlation condition
    When I create a Filter with filter name <filter name> and <source> as source
    And with Filter Rule: <keyword> - <comparator> - <keyword value>
    And add a Correlation condition: <frequency> occurences in <time value> <time unit>
    And <filter name> has Action: Send to Slack
    Then filter should be saved successfully

    Examples: 
      | filter name        | source     | keyword | comparator | keyword value | frequency | time value | time unit |
      | AUT_Correlation_NP | Nagios-Pet | Summary | Contains   | TEST          |         2 |         10 | Minutes   |
