@scenarios @ExtendedRules @Suppression
Feature: AISM-10
  As a Operator
  I can filter unnecessary alert by time 2

  Background: 
    Given I am login
    And I am on Create New Filter page

  Scenario Outline: Verify saving of filter with Suppression condition (Beyond selected time/days/timezone)
    When I create a Filter with filter name <filter name>, Filter rule: <keyword> - <comparator> - <keyword value>, and add a Suppression condition with fields: time= <timeFrom> to <timeTo>, timezone= <timezone>, days= <days>, Beyond these time ranges
    Then filter with Suppression condition should be saved successfully

    Examples: 
      | filter name          | keyword | comparator | keyword value | timeFrom | timeTo | timezone | days                |
      | AUT_TestSuppression4 | Shop    | Equals     | UQ            | 11:00    | 20:00  | Japan    | MON,TUE,WED,THU,FRI |
      | AUT_TestSuppression5 | Country | Equals     | JP            | 02:00    | 11:00  | GMT      | MON,TUE,WED,THU,FRI |
      | AUT_TestSuppression6 | Device  | Contains   | SDC           | 10:00    | 19:00  | Japan    | MON,WED,FRI         |
