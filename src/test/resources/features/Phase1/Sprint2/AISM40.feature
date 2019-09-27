@scenarios @AISM40 @Phase1 @Phase1-Sprint2 @ExtendedRules @SnowDuplicate @Regression
Feature: AISM-40
  As a Tool Administrator
  I can configure so that a new ticket will not be created for duplicate alert.

  Background: 
    Given I am login
    And I am on Create New Filter page

  Scenario Outline: Verify saving of filter with Snow Duplicate Check condition
    When I create a Filter with filter name <filter name> and <source> as source
    And with Filter Rule: <keyword> - <comparator> - <keyword value>
    And add a Snow Duplicate Check condition: <with> open tickets where <snow keyword> contains <field>
    And <filter name> has Action: Create SNOW Ticket
    Then filter should be saved successfully

    Examples: 
      | filter name            | source    | keyword   | comparator | keyword value | with    | snow keyword | field   |
      | AUT_SnowDuplicate_EWUG | Email WUG | Device ID | Contains   | Firewall      | Without | Description  | Subject |
