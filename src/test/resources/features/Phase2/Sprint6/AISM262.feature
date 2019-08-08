@scenarios @AISM262 @Phase2 @Phase2-Sprint6 @Regression
Feature: AISM-262
  As an Tool Administrator
  I can configure so that EvA can handle alerts from Prometheus (Ariake SCM) - via EMAIL

  Background: 
    Given I am login
    And I am on Create New Filter page

  Scenario Outline: Verify saving of filter with source: Email for Ariake SCM
    When I create a Filter with filter name <filter name> and <source> as source
    And with Filter Rule: <keyword> - <comparator> - <keyword value>
    And NOT button <NOT>
    And <filter name> has Action: <action>
    Then filter should be saved successfully

    Examples: 
      | filter name          | source | keyword | comparator | keyword value               | NOT      | action             |
      | AUT_TestEmailAriake1 | Email  | Body    | Contains   | RDS_PosgresSQL_BurstBalance | disabled | Send to Slack      |
      | AUT_TestEmailAriake2 | Email  | Body    | Contains   | RDS_PosgresSQL_BurstBalance | enabled  | Create Jira Ticket |
