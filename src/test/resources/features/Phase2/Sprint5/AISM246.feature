@scenarios @AISM246 @Phase2 @Phase2-Sprint5 @EventsBrowser @Regression
Feature: AISM-246
  As an Operator
  I can filter events by event id

  Background: 
    Given I am login
    And I am on Events Browser page

  Scenario: Verify that user can filter events by Event Id
    When I input an Event Id
    And I click Apply
    Then Events Browser page should only show the event with the selected Event Id