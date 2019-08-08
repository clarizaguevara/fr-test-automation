@scenarios @AISM244 @Phase2 @Phase2-Sprint5 @CreateSNOWTicket @SNOWConsolidateTicket @Regression
Feature: AISM-244
  As an Operator
  I can select if the same alert happens repeatedly in a short time range, ticket will be consolidated into one.

  Background: 
    Given I am login
    And I am on Create New Filter page

  Scenario Outline: Verify saving of filter with SNOW action and ticket is consolidated
    When I create a Filter with filter name <filter name> and <source> as source
    And with Filter Rule: <keyword> - <comparator> - <keyword value>
    And <filter name> has Action: Create SNOW Ticket
    And I tick "Consolidate SNOW ticket" checkbox
    Then filter should be saved successfully

    Examples: 
      | filter name                   | source     | keyword | comparator | keyword value |
      | AUT_TestSNOWConsolidateTicket | Nagios-Pet | Summary | Contains   | TEST          |
