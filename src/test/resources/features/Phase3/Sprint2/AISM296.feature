@scenarios @AISM296 @Phase3 @Phase3-Sprint2 @BrowseFilters @Regression
Feature: AISM-296
  As an operator
  I can open a filter in a new tab, so that I can keep settings of the filter browse page while navigating to multiple filters

  Background: 
    Given I am login
    And I am on Home page

  Scenario: Verify that filter can be opened in a new tab
    When I click the filter name column
    Then the correct filter should open in a new tab
