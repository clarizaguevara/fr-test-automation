@scenarios @AISM146
Feature: AISM-146
  Jumping to Maintain List page, we can see the name of list, description, and edit button.

  Background: 
    Given I am login
    And I am on Home page
    When I click Maintenance tab
    And I select Keyword Lists

  Scenario: Verify successful navigation to Keyword Lists page
    Then Keyword Lists page should be loaded successfully

  Scenario: Verify operator can maintain the list of keywords (Add Keyword)
    And I add new keyword list
    Then I should be able to add keyword list successfully

  Scenario: Verify operator can maintain the list of keywords (Edit Keyword)
    And I edit existing keyword lists
    Then I should be able to edit keyword list successfully

  Scenario: Verify operator can maintain the list of keywords (Delete Keyword)
    And I delete existing keyword lists
    Then I should be able to delete keyword list successfully
 
  Scenario: Verify adding new keyword list with mandatory fields left blank is not allowed
    And I left mandatory fields blank in Add New Keyword List popup
    Then Keyword list should not be added successfully
    
