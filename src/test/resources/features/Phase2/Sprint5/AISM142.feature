@scenarios @AISM142 @Phase2 @Phase2-Sprint5
Feature: AISM-142
  As an Operator
  I can select sender/subject/body in the command center

  Background: 
    Given I am login
    And I am on Create New Filter page

  Scenario Outline: Verify saving of filter with Email Source (source: <source>, keyword: <keyword>)
    When I create a Filter with filter name <filter name> and <source> as source
    And with Filter Rule: <keyword> - <comparator> - <keyword value>
    And NOT button <NOT>
    And <filter name> has Action: <action>
    Then filter should be saved successfully

    Examples: 
      | filter name           | source | keyword | comparator  | keyword value | NOT      | action             |
      | AUT_TestEmail_Sender  | Email  | Sender  | Contains    | dxc           | disabled | Send to Slack      |
      | AUT_TestEmail_Subject | Email  | Subject | Like        | TEST          | disabled | Create Jira Ticket |
      | AUT_TestEmail_Body    | Email  | Body    | Begins With | TEST          | enabled  | Create SNOW Ticket |
