@scenarios @AISM155 @Phase2 @Phase2-Sprint3 @Regression
Feature: AISM-155
  As an Operator
   I can have one page for maintaining components

  Background: 
    Given I am login
    And I am on Home page

  Scenario: Verify clicking on the item in Maintenance tab leads to each maintenance page (Templates Management)
    When I select Templates Management
    Then Templates Management page should be loaded successfully

  Scenario: Verify clicking on the item in Maintenance tab leads to each maintenance page (Keyword Lists)
    When I select Keyword Lists
    Then Keyword Lists page should be loaded successfully
    
   Scenario: Verify clicking on the item in Maintenance tab leads to each maintenance page (Access Management)
    When I select Access Management
    Then Access Management page should be loaded successfully