@scenarios @AISM145 @Phase2 @Phase2-Sprint1 @Regression
Feature: AISM-145
  As an Operator, 
  I can select contains keyword as an operator.

  Background: 
    Given I am login

  Scenario Outline: Create a Keyword List
    When I am on Keyword Lists page
    And I create a new Keyword List with name: <name>
    And with Keyword values: <keywords>
    Then Keyword List with name: <name> should be created successfully

    Examples: 
      | name             | keywords |
      | AUT_Keyword Test | TEST,JP  |

  Scenario Outline: Verify user can select contains keyword as an operator (source: <source>)
    When I am on Create New Filter page
    And I create a Filter with filter name <filter name> and <source> as source
    And with Filter Rule: <keyword> - <comparator> - <keyword value>
    And <filter name> has Action: <action>
    Then filter should be saved successfully

    Examples: 
      | filter name              | source       | keyword | comparator        | keyword value    | action             |
      | AUT_TestContainsKeyword1 | Nagios-Pet   | Summary | Contains Keywords | AUT_Keyword Test | Send to Slack      |
      | AUT_TestContainsKeyword2 | Cisco Meraki | Country | Contains Keywords | AUT_Keyword Test | Create Jira Ticket |
