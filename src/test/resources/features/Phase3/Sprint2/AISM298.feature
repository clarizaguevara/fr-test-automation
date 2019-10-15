@scenarios @AISM298 @Phase3 @Phase3-Sprint2 @BrowseFilters @Regression
Feature: AISM-298
  As an operator
  I could search a filter by it's ID, so that I can navigate through filters easier and faster

  Background: 
    Given I am login
    And I am on Home page

  Scenario: Verify search by Filter ID
    When I input a Filter Id
    Then Browse Filters page should only show the filter with the selected Filter Id
