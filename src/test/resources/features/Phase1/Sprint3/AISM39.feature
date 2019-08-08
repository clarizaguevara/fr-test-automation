@scenarios @AISM39 @Phase1 @Phase1-Sprint3 @AccessManagement @Regression
Feature: AISM-39
  As an Administrator
  I can manage roles assigned to a user based on username provided by ADFS

  Background: 
    Given I am login
    And I am on Access Management page

  Scenario: Verify successful navigation to Access Management page
    Then Access Management page should be loaded successfully

  Scenario: Verify adding a new User
    When I click Add User button
    And I fill-in the fields with values: Employee Id: 12345, Name: AUT_TestUser, Role: Admin, Expiration date: From 05/01/2019 To 12/31/2019
    And I click Save
    Then User should be added successfully

  Scenario: Verify adding a new Role
    When I go to Roles section
    And I click Add Role button
    And I fill-in the fields with values: Role Name: AUT_TestRole, Roles: FILTER_CREATE,FILTER_READ,FILTER_UPDATE,FILTER_DELETE
    And I click Save
    Then Role should be added successfully

  Scenario: Verify editting a User
    When I click the user with name: AUT_TestUser
    And I edit the fields with values: Employee Id: 67890, Name: AUT_TestEdittedUser, Role: AUT_TestRole
    And I click Save
    Then User should be editted successfully with new values: Employee Id: 67890, Name: AUT_TestEdittedUser, Role: AUT_TestRole
    
  Scenario: Verify that From date cannot be greater than To date when setting Expiration date for User
    When I click the user with name: AUT_TestEdittedUser
    And I change the Expiration date to: 05/01/2019 to 04/15/2019
    And I click Save
    Then User should be editted successfully and AUT_TestEdittedUser's From date is not greater than To date

  Scenario: Verify editting a Role
    When I go to Roles section
    And I click the role with name: AUT_TestRole
    And I edit the fields with values: Role Name: AUT_TestEdittedRole, Roles: FILTER_CREATE,USER_READ,ROLE_UPDATE
    And I click Save
    Then Role should be editted successfully with new values: Role Name: AUT_TestEdittedRole, Roles: FILTER_CREATE,USER_READ,ROLE_UPDATE

  Scenario: Verify deleting a User
    When I click the delete button of user AUT_TestEdittedUser
    Then AUT_TestEdittedUser should be deleted successfully

  Scenario: Verify deleting a Role
    When I go to Roles section
    And I click the delete button of role AUT_TestEdittedRole
    Then AUT_TestEdittedRole should be deleted successfully

  Scenario: Verify adding a new User with mandatory fields (Employee Id, Name) left blank
    When I click Add User button
    And I click Save
    Then User should not be added successfully

  Scenario: Verify adding a new Role with mandatory fields (Role Name) left blank
    When I go to Roles section
    And I click Add Role button
    And I click Save
    Then Role should not be added successfully
