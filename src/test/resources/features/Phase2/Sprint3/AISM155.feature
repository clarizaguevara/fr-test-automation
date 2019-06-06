@scenarios @AISM155
Feature: AISM-155
  As an Operator
   I can have one page for maintaining components

  Background: 
    Given I am login
    And I am on Home page
    When I click Maintenance tab

  Scenario: Verify clicking on the item in Maintenance tab leads to each maintenance page (Templates Management)
    And I select Templates Management
    Then Templates Management page should be loaded successfully

  Scenario: Verify clicking on the item in Maintenance tab leads to each maintenance page (Keyword Lists)
    And I select Keyword Lists
    Then Keyword Lists page should be loaded successfully
    
   Scenario: Verify clicking on the item in Maintenance tab leads to each maintenance page (Access Management)
    And I select Access Management
    Then Access Management page should be loaded successfully