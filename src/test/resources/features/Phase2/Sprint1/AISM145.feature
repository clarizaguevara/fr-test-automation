@scenarios @AISM145 @Phase2 @Phase2-Sprint1
Feature: AISM-145
  As an Operator, 
  I can select contains keyword as an operator.

  Background: 
    Given I am login
    And I am on Create New Filter page

  Scenario: Create a Keyword List
    When I click Maintenance tab
    And I select Keyword Lists
    And I create a new Keyword List with name: AUT_Keyword Test
    And with Keyword values: TEST,JP
    Then Keyword List with name: AUT_Keyword Test should be created successfully

  Scenario Outline: Verify user can select contains keyword as an operator (source: <source>)
    When I create a Filter with filter name <filter name> and <source> as source
    And with Filter Rule: <keyword> - <comparator> - <keyword value>
    And <filter name> has Action: <action>
    Then filter should be saved successfully

    Examples: 
      | filter name              | source       | keyword | comparator        | keyword value    | action             |
      | AUT_TestContainsKeyword1 | Nagios-Pet   | Summary | Contains Keywords | AUT_Keyword Test | Send to Slack      |
      | AUT_TestContainsKeyword2 | Cisco Meraki | Country | Contains Keywords | AUT_Keyword Test | Create Jira Ticket |
