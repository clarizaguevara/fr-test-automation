@scenarios @AdditionalTestCases @Phase1 @Phase1-Sprint2
Feature: Additional Test Cases

  Background: 
    Given I am login
    And I am on Create New Filter page

  @VoidAction
  Scenario: Verify saving of filter with Void action
    When I create a Filter with filter name AUT_TestVoid and set Void as action
    Then filter should be saved successfully

  @EditFilter
  Scenario: Verify that user can Edit a filter
    When I create a Filter with filter name AUT_TestEdit, Nagios-Pet as source, and with Filter rule: Summary Contains TEST
    Then I go back to Browse page and open filter AUT_TestEdit
    And I edit the Filter Rule to: Description Contains ERROR
    Then filter AUT_TestEdit should be editted successfully with new Filter rule values: Description Contains ERROR

  @DeleteFilter
  Scenario: Verify that user can Delete a filter
    When I create a Filter with filter name: AUT_TestDelete and Nagios-Pet as source
    Then I go back to Browse page and open filter AUT_TestDelete
    And I click the Delete button to delete the filter
    Then filter AUT_TestDelete should be successfully deleted

  @ComparatorDropdown
  Scenario: Verify Comparator dropdown values
    Then Comparator dropdown should have the correct values
