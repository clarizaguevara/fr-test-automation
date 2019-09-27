@scenarios @AISM9 @Phase1 @Phase1-Sprint2 @ExtendedRules @Suppression @Regression
Feature: AISM-9
  As a Operator
  I can filter unnecessary alert by time 1

  Background: 
    Given I am login
    And I am on Create New Filter page

  Scenario Outline: Verify saving of filter with Suppression condition
    When I create a Filter with filter name <filter name> and <source> as source
    And with Filter Rule: <keyword> - <comparator> - <keyword value>
    And add a Suppression condition with fields: time= <timeFrom> to <timeTo>, timezone= <timezone>, days= <days>, Within these time ranges
    And <filter name> has Action: Send to Slack
    Then filter should be saved successfully

    Examples: 
      | filter name           | source | keyword | comparator | keyword value | timeFrom | timeTo | timezone | days            |
      | AUT_Suppression_Email | Email  | Subject | Contains   | TEST          | 11:00    | 20:00  | Japan    | MON,WED,FRI,SAT |
