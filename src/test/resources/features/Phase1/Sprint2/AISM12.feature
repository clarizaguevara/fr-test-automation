@scenarios @ExtendedRules @SnowDuplicate
Feature: AISM-12
  As a Operator
  I can check SNOW ticket from the NW alert information

  Scenario Outline: Verify saving of filter with Snow Duplicate Check condition (<with> open tickets for <snow keyword>)
    Given I am to create a filter with Snow Duplicate Check condition and I am on Create New Filter page
    When I create a Filter with filter name <filter name>, <source> as source, Filter rule: <keyword> - <comparator> - <keyword value>, and add a Snow Duplicate Check condition: <with> open tickets for <snow keyword>
    Then filter with Snow Duplicate Check condition should be saved successfully

    Examples: 
      | filter name            | source       | keyword | comparator | keyword value | with    | snow keyword |
      | AUT_TestSnowDuplicate1 | Cisco Meraki | Country | Equals     | JP            | With    | IP Address   |
      | AUT_TestSnowDuplicate2 | Cisco Meraki | Shop    | Equals     | UQ            | Without | IP Address   |
