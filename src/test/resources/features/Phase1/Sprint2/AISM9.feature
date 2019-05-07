@scenarios @ExtendedRules @Suppression
Feature: AISM-9
  As a Operator
  I can filter unnecessary alert by time 1

  Scenario Outline: Verify saving of filter with Suppression condition (Within selected time/days/timezone)
    Given I am to create a filter with Suppression condition and I am on Create New Filter page
    When I create a Filter with filter name <filter name>, Filter rule: <keyword> - <comparator> - <keyword value>, and add a Suppression condition with fields: time= <timeFrom> to <timeTo>, timezone= <timezone>, days= <days>, Within these time ranges
    Then filter with Suppression condition should be saved successfully

    Examples: 
      | filter name          | keyword  | comparator | keyword value  | timeFrom | timeTo | timezone | days                |
      | AUT_TestSuppression1 | Hostname | Contains   | UQ             | 11:00    | 20:00  | Japan    | MON,TUE,WED,THU,FRI |
      | AUT_TestSuppression2 | Hostname | Ends With  | SDC            | 02:00    | 11:00  | GMT      | MON,TUE,WED,THU,FRI |
      | AUT_TestSuppression3 | Hostname | Equals     | UQ-JP-0088-SDC | 10:00    | 19:00  | Japan    | MON,WED,FRI         |
