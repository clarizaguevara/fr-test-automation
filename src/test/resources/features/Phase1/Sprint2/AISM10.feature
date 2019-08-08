@scenarios @AISM10 @Phase1 @Phase1-Sprint2 @ExtendedRules @Suppression @Regression
Feature: AISM-10
  As a Operator
  I can filter unnecessary alert by time 2

  Background: 
    Given I am login
    And I am on Create New Filter page

  Scenario Outline: Verify saving of filter with Suppression condition (Beyond selected time/days/timezone)
    When I create a Filter with filter name <filter name> and <source> as source
    And with Filter Rule: <keyword> - <comparator> - <keyword value>
    And add a Suppression condition with fields: time= <timeFrom> to <timeTo>, timezone= <timezone>, days= <days>, Beyond these time ranges
    And <filter name> has Action: Send to Slack
    Then filter should be saved successfully

    Examples: 
      | filter name          | source       | keyword | comparator | keyword value | timeFrom | timeTo | timezone | days                |
      | AUT_TestSuppression4 | Cisco Meraki | Shop    | Equals     | UQ            | 11:00    | 18:00  | Japan    | MON,TUE,WED,THU,FRI |
      | AUT_TestSuppression5 | Cisco Meraki | Country | Equals     | JP            | 02:00    | 11:00  | GMT      | MON,TUE,WED,THU,FRI |
      | AUT_TestSuppression6 | Cisco Meraki | Device  | Contains   | SDC           | 10:00    | 19:00  | Japan    | TUE,THU,SAT         |
