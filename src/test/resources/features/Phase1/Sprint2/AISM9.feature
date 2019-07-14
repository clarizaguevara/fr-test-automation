@scenarios @AISM9 @Phase1 @Phase1-Sprint2 @ExtendedRules @Suppression
Feature: AISM-9
  As a Operator
  I can filter unnecessary alert by time 1

  Background: 
    Given I am login
    And I am on Create New Filter page

  Scenario Outline: Verify saving of filter with Suppression condition (Within selected time/days/timezone)
    When I create a Filter with filter name <filter name> and <source> as source
    And with Filter Rule: <keyword> - <comparator> - <keyword value>
    And add a Suppression condition with fields: time= <timeFrom> to <timeTo>, timezone= <timezone>, days= <days>, Within these time ranges
    And <filter name> has Action: Send to Slack
    Then filter should be saved successfully

    Examples: 
      | filter name          | source       | keyword  | comparator | keyword value  | timeFrom | timeTo | timezone | days                |
      | AUT_TestSuppression1 | Cisco Meraki | Hostname | Contains   | UQ             | 11:00    | 20:00  | Japan    | MON,TUE,WED,THU,FRI |
      | AUT_TestSuppression2 | Cisco Meraki | Hostname | Ends With  | SDC            | 02:00    | 11:00  | GMT      | MON,TUE,WED,THU,FRI |
      | AUT_TestSuppression3 | Cisco Meraki | Hostname | Equals     | UQ-JP-0088-SDC | 10:00    | 19:00  | Japan    | MON,WED,FRI         |
