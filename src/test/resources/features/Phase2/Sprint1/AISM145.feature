@AISM145 @scenarios
Feature: AISM - 145
  As an Operator, 
  I can select contains keyword as an operator.

  Background: 
    Given I am login
    And I am on Create New Filter page

  Scenario: Verify that user can create a Keyword List to be used in filter creation
    When I click Maintenance tab
    And I select Keyword Lists
    And I create a new Keyword List with name: Keyword Test
    And with Keyword values: TEST,JP
    Then Keyword List with name: Keyword Test should be created successfully

  Scenario Outline: Verify user can select contains keyword as an operator (Send To Slack)
    When I create a Filter with filter name <filter name> and <source> as source
    And with Filter Rule: <keyword> - <comparator> - <keyword value>
    And with comparator: Contains Keywords <keyword value>
    And with Action: Send To Slack "<filter name>"
    Then I should be able to save successfully

    Examples: 
      | filter name              | source     | keyword | comparator        | keyword value |
      | AUT_TestContainsKeyword1 | Nagios-Pet | Summary | Contains Keywords | Keyword Test  |

  Scenario Outline: Verify user can select contains keyword as an operator (Create Jira Ticket)
    When I create a Filter with filter name <filter name> and <source> as source
    And with Filter Rule: <keyword> - <comparator> - <keyword value>
    And with comparator: Contains Keywords <keyword value>
    And with Action: Create Jira Ticket-KKA "<filter name>"
    Then I should be able to save successfully

    Examples: 
      | filter name              | source       | keyword | comparator        | keyword value |
      | AUT_TestContainsKeyword2 | Cisco Meraki | Country | Contains Keywords | Keyword Test  |
