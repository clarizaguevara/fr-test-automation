@scenarios @AdditionalTestCases @Phase1 @Phase1-Sprint2 @Regression
Feature: Additional Test Cases

  Background: 
    Given I am login

  @VoidAction
  Scenario Outline: Verify saving of filter with Void action
    When I am on Create New Filter page
    And I create a Filter with filter name <filter name> and set <action> as action
    Then filter should be saved successfully

    Examples: 
      | filter name | action |
      | AUT_Void    | Void   |

  @EditFilter
  Scenario Outline: Verify that user can Edit a filter
    When I am on Create New Filter page
    And I create a Filter with filter name <filter name>, <source> as source, and with Filter rule: <field> <comparator> <keyword>
    Then I go back to Browse page and open filter <filter name>
    And I edit the Filter Rule to: <edit field> <comparator> <edit keyword>
    Then filter <filter name> should be editted successfully with new Filter rule values: <edit field> <comparator> <edit keyword>

    Examples: 
      | filter name | source     | field   | comparator | keyword | edit field  | edit keyword |
      | AUT_Edit    | Nagios-Pet | Summary | Contains   | TEST    | Description | ERROR        |

  @DeleteFilter
  Scenario Outline: Verify that user can Delete a filter
    When I go back to Browse page and open filter <filter name>
    And I click the Delete button to delete the filter
    Then filter <filter name> should be successfully deleted

    Examples: 
      | filter name |
      | AUT_Edit    |

  @ComparatorDropdown
  Scenario: Verify Comparator dropdown values
    When I am on Create New Filter page
    Then Comparator dropdown should have the correct values

  @FieldDropdown
  Scenario: Verify Field dropdown values for all sources
    When I am on Create New Filter page
    Then Field dropdown should have the correct values for each source
