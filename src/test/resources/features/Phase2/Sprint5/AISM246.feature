@scenarios @AISM246 @EventsBrowser
Feature: AISM-246
  As an Operator
  I can filter events by event id

  Background: 
    Given I am login
    And I am on Events Browser page

  Scenario: Verify that there is a field to input Event Id
    Then Event Id field should be present
    
  Scenario: Verify that user can filter events by Event Id
    When I input an Event Id
    And I click Apply
    Then Events Browser page should only show the event with the selected Event Id