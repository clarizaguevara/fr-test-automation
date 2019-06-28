@AISM142
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
      | filter name       | source               | keyword | comparator  | keyword value | NOT      | action             |
      | AUT_TestEmailJP11 | Email - JP1          | Sender  | Contains    | TEST          | disabled | Send to Slack      |
      | AUT_TestEmailJP12 | Email - JP1          | Subject | Like        | TEST          | disabled | Create Jira Ticket |
      | AUT_TestEmailJP13 | Email - JP1          | Body    | Begins With | TEST          | disabled | Create SNOW Ticket |
      | AUT_TestEmailNP1  | Email - Nagios-Pet   | Sender  | Ends With   | TEST          | disabled | Send Email         |
      | AUT_TestEmailNP2  | Email - Nagios-Pet   | Subject | Equals      | TEST          | enabled  | Send to Slack      |
      | AUT_TestEmailNP3  | Email - Nagios-Pet   | Body    | Contains    | TEST          | enabled  | Create Jira Ticket |
      | AUT_TestEmailWUG1 | Email - WhatsUp Gold | Sender  | Like        | TEST          | enabled  | Create SNOW Ticket |
      | AUT_TestEmailWUG2 | Email - WhatsUp Gold | Subject | Begins With | TEST          | enabled  | Send Email         |
      | AUT_TestEmailWUG3 | Email - WhatsUp Gold | Body    | Ends With   | TEST          | disabled | Send to Slack      |
