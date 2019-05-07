@scenarios @AdditionalTestCases
Feature: Additional Test Cases
  

  @VoidAction
  Scenario: Verify saving of filter with Void action
    Given I am to create a filter with Void action and I am on Create New Filter page
    When I create a Filter with filter name AUT_TestVoid and set Void as action
    Then filter with Void action should be saved successfully
  
  @EditFilter
  Scenario: Verify that user can Edit a filter
    Given I am to create a filter to edit and I am on Create New Filter page
    When I create a Filter with filter name AUT_TestEdit, Nagios-Pet as source, and with Filter rule: Summary Contains TEST
		Then I go back to Browse page and open filter AUT_TestEdit
		And I edit the Filter Rule to: Description Contains ERROR
    Then filter AUT_TestEdit should be editted successfully with new Filter rule values: Description Contains ERROR
  
  @DeleteFilter
  Scenario: Verify that user can Delete a filter
    Given I am to create a filter to delete and I am on Create New Filter page
    When I create a Filter with filter name: AUT_TestDelete and Nagios-Pet as source
		Then I go back to Browse page and open filter AUT_TestDelete
		And I click the Delete button to delete the filter
    Then filter AUT_TestDelete should be deleted successfully