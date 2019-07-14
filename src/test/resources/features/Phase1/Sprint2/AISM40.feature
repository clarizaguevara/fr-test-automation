@scenarios @AISM40 @Phase1 @Phase1-Sprint2 @ExtendedRules @SnowDuplicate
Feature: AISM-40
  As a Tool Administrator
  I can configure so that a new ticket will not be created for duplicate alert.

  Background: 
    Given I am login
    And I am on Create New Filter page

  Scenario Outline: Verify saving of filter with Snow Duplicate Check condition (<with> open tickets for <snow keyword>)
  	When I create a Filter with filter name <filter name> and <source> as source
    And with Filter Rule: <keyword> - <comparator> - <keyword value>
    And add a Snow Duplicate Check condition: <with> open tickets for <snow keyword>
    And <filter name> has Action: Create SNOW Ticket
    Then filter should be saved successfully

    Examples: 
      | filter name            | source       | keyword    | comparator | keyword value | with    | snow keyword |
      | AUT_TestSnowDuplicate3 | Cisco Meraki | Network Id | Contains   |           634 | With    | Summary      |
      | AUT_TestSnowDuplicate4 | Cisco Meraki | Hostname   | Contains   |          0088 | Without | Summary      |
      | AUT_TestSnowDuplicate5 | Cisco Meraki | IP Address | Contains   |           192 | With    | Filter ID    |
      | AUT_TestSnowDuplicate6 | Cisco Meraki | Device     | Contains   | SDC           | Without | Filter ID    |
