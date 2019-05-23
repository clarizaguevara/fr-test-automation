@scenarios @AISM215
Feature: AISM-215
  As an Tool Administrator
  I can configure so that SNOW URL is sent to Slack

  Background: 
    Given I am login
    And I am on Create New Filter page

  Scenario: Verify saving of filter with SNOW ticket URL to be sent to Slack
    When I create a Filter with filter name AUT_TestSNOWTicketURL and Nagios-Pet as source
    And with Filter Rule: Description - Begins With - TEST
    And AUT_TestSNOWTicketURL has Action: Create SNOW Ticket
    And I tick "Send ticket URL to Slack channel" checkbox and input Slack channel
    Then filter should be saved successfully

  Scenario: Verify that Slack channel disappears if "Send ticket URL to Slack channel" checkbox is unchecked
    When I go back to Browse page and open filter AUT_TestSNOWTicketURL
    And I untick "Send ticket URL to Slack channel" checkbox
    Then Slack channel field of SNOW action should be blank
    When I tick "Send ticket URL to Slack channel" checkbox and input Slack channel
    Then Slack channel field of SNOW action should be filled up
