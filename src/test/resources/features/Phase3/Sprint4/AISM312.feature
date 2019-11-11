@scenarios @AISM312 @Phase3 @Phase3-Sprint4 @CreateSNOWTicket @SNOWConsolidateTicket
Feature: AISM-312
  As an Operator
  I would like to have an option to group duplicate tickets, as configured by time component,
  will be added to the work note of the active ticket instead of having a child ticket.

  Background: 
    Given I am login
    And I am on Create New Filter page

  Scenario Outline: Verify saving of filter with SNOW action and ticket is consolidated into <consolidate type> with time component
    When I create a Filter with filter name <filter name> and <source> as source
    And with Filter Rule: <keyword> - <comparator> - <keyword value>
    And <filter name> has Action: Create SNOW Ticket
    And I Consolidate SNow ticket into <consolidate type>
    And with Time component enabled: within <time value> <time unit>
    Then filter should be saved successfully

    Examples: 
      | filter name                           | source     | keyword     | comparator | keyword value | consolidate type | time value | time unit |
      | AUT_SNOWConsolidateTicket_WorkNote    | Nagios-Pet | Summary     | Contains   | TEST          | Work Note        |          2 | Minutes   |
      | AUT_SNOWConsolidateTicket_ChildTicket | Nagios-Pet | Description | Contains   | TEST          | Child Ticket     |          2 | Minutes   |
