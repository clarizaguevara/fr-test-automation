@scenarios @AISM215 @Phase2 @Phase2-Sprint2 @Regression
Feature: AISM-215
  As an Tool Administrator
  I can configure so that SNOW URL is sent to Slack

  Background: 
    Given I am login
    And I am on Create New Filter page

  Scenario Outline: Verify that Slack channel disappears if "Send ticket URL to Slack channel" checkbox is unchecked
    When I create a Filter with filter name <filter name> and <source> as source
    And with Filter Rule: <keyword> - <comparator> - <keyword value>
    And <filter name> has Action: Create SNOW Ticket
    Then filter should be saved successfully
    When I go back to Browse page and open filter <filter name>
    And I untick "Send ticket URL to Slack channel" checkbox
    Then Slack channel field of SNOW action should be blank
    When I tick "Send ticket URL to Slack channel" checkbox and input Slack channel
    Then Slack channel field of SNOW action should be filled up

    Examples: 
      | filter name           | source     | keyword     | comparator | keyword value |
      | AUT_TestSNOWTicketURL | Nagios-Pet | Description | Contains   | warn          |
