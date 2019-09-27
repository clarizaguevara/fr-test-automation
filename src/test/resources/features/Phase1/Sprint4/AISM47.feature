@scenarios @AISM47 @Phase1 @Phase1-Sprint4 @CreateSNOWTicket @SNOWAutoCloseTicket
Feature: AISM-47
  As a Tool Administrator
  I can configure so that a SNOW ticket can be closed automatically after creation

  Background: 
    Given I am login
    And I am on Create New Filter page

  Scenario Outline: Verify saving of filter with SNOW action and ticket is automatically closed after creation
    When I create a Filter with filter name <filter name> and <source> as source
    And with Filter Rule: <keyword> - <comparator> - <keyword value>
    And <filter name> has Action: Create SNOW Ticket
    And I tick "Automatically close SNOW ticket" checkbox
    Then filter should be saved successfully

    Examples: 
      | filter name                 | source       | keyword     | comparator | keyword value |
      | AUT_TestSNOWAutoCloseTicket | Cisco Meraki | Mac Address | Contains   | e0            |
