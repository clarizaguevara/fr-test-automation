@scenarios @AISM146 @Phase2 @Phase2-Sprint1
Feature: AISM-146
  As an Operator
  I can maintain the list of keywords

  Background: 
    Given I am login
    And I am on Keyword Lists page

  Scenario: Verify successful navigation to Keyword Lists page
    Then Keyword Lists page should be loaded successfully

  Scenario: Verify operator can maintain the list of keywords (Add Keyword)
    When I add new keyword list
    Then I should be able to add keyword list successfully

  Scenario: Verify operator can maintain the list of keywords (Edit Keyword)
    When I edit existing keyword lists
    Then I should be able to edit keyword list successfully

  Scenario: Verify operator can maintain the list of keywords (Delete Keyword)
    When I delete existing keyword lists
    Then I should be able to delete keyword list successfully

  Scenario: Verify adding new keyword list with mandatory fields left blank is not allowed
    When I left mandatory fields blank in Add New Keyword List popup
    Then Keyword list should not be added successfully
