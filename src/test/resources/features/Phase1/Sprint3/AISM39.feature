@scenarios @AISM39 @Phase1 @Phase1-Sprint3 @AccessManagement @Regression
Feature: AISM-39
  As an Administrator
  I can manage roles assigned to a user based on username provided by ADFS

  Background: 
    Given I am login
    And I am on Access Management page

  Scenario: Verify successful navigation to Access Management page
    Then Access Management page should be loaded successfully

  Scenario Outline: Verify adding a new User
    When I click Add User button
    And I fill-in the fields with values: Employee Id: <employee id>, Name: <name>, Role: <role>, Expiration date: From <expiry from> To <expiry to>
    Then User should be added successfully

    Examples: 
      | employee id | name         | role  | expiry from | expiry to  |
      |       12345 | AUT_TestUser | Admin | 05/01/2019  | 12/31/2019 |

  Scenario Outline: Verify adding a new Role
    When I go to Roles section
    And I click Add Role button
    And I fill-in the fields with values: Role Name: <role name>, Roles: <roles>
    Then Role should be added successfully

    Examples: 
      | role name    | roles                                                 |
      | AUT_TestRole | FILTER_CREATE,FILTER_READ,FILTER_UPDATE,FILTER_DELETE |

  Scenario Outline: Verify editting a User
    When I click the user with name: <name>
    And I edit the fields with values: Employee Id: <employee id>, Name: <edit name>, Role: <role>
    Then User should be editted successfully with new values: Employee Id: <employee id>, Name: <edit name>, Role: <role>

    Examples: 
      | employee id | name         | role         | edit name           |
      |       67890 | AUT_TestUser | AUT_TestRole | AUT_TestEdittedUser |

  Scenario Outline: Verify that From date cannot be greater than To date when setting Expiration date for User
    When I click the user with name: <name>
    And I change the Expiration date to: <expiry from> to <expiry to>
    Then User should be editted successfully and <name>'s From date is not greater than To date

    Examples: 
      | name                | expiry from | expiry to  |
      | AUT_TestEdittedUser | 05/01/2019  | 04/15/2019 |

  Scenario Outline: Verify editting a Role
    When I go to Roles section
    And I click the role with name: <role name>
    And I edit the fields with values: Role Name: <edit name>, Roles: <roles>
    Then Role should be editted successfully with new values: Role Name: <edit name>, Roles: <roles>

    Examples: 
      | role name    | roles                               | edit name           |
      | AUT_TestRole | FILTER_CREATE,USER_READ,ROLE_UPDATE | AUT_TestEdittedRole |

  Scenario Outline: Verify deleting a User
    When I click the delete button of user <name>
    Then <name> should be deleted successfully

    Examples: 
      | name                |
      | AUT_TestEdittedUser |

  Scenario Outline: Verify deleting a Role
    When I go to Roles section
    And I click the delete button of role <name>
    Then <name> should be deleted successfully

    Examples: 
      | name                |
      | AUT_TestEdittedRole |

  Scenario: Verify adding a new User with mandatory fields (Employee Id, Name) left blank
    When I click Add User button
    Then User should not be added successfully

  Scenario: Verify adding a new Role with mandatory fields (Role Name) left blank
    When I go to Roles section
    And I click Add Role button
    Then Role should not be added successfully
