@scenarios @FilterRules
Feature: AISM-25
  As a Tool Administrator
  I can configure so that alert will be filtered by field in alert

  Background: 
    Given I am login
    And I am on Create New Filter page

  Scenario Outline: Verify saving of filter with Filter Rule (filter by <keyword>)
    When I create a Filter with filter name <filter name> and <source> as source
    And with Filter Rule: <keyword> - <comparator> - <keyword value>, NOT button <NOT>
    And <filter name> has Action: <action>
    Then filter should be saved successfully

    Examples: 
      | filter name                 | source       | keyword       | comparator | keyword value        | NOT      | action             |
      | AUT_TestFieldNameAndValue1  | Cisco Meraki | Hostname      | Equals     | UQ-JP-0088-SDC       | disabled | Send to Slack      |
      | AUT_TestFieldNameAndValue2  | Cisco Meraki | Country       | Equals     | JP                   | disabled | Create Jira Ticket |
      | AUT_TestFieldNameAndValue3  | Cisco Meraki | Device        | Equals     | SDC-AP2-API          | disabled | Create SNOW Ticket |
      | AUT_TestFieldNameAndValue4  | Cisco Meraki | Mac Address   | Equals     | e0:55:3d:eb:84:b1    | disabled | Send Email         |
      | AUT_TestFieldNameAndValue5  | Cisco Meraki | Device Serial | Equals     | Q2JD-XJGK-F8Z4       | enabled  | Send to Slack      |
      | AUT_TestFieldNameAndValue6  | Cisco Meraki | Network Id    | Equals     | M_602356450160806634 | enabled  | Create Jira Ticket |
      | AUT_TestFieldNameAndValue7  | Cisco Meraki | IP Address    | Equals     | 192.168.250.23       | enabled  | Create SNOW Ticket |
      | AUT_TestFieldNameAndValue8  | Cisco Meraki | Shop          | Equals     | UQ                   | enabled  | Send Email         |
      | AUT_TestFieldNameAndValue9  | Nagios-Pet   | Summary       | Contains   | TEST                 | disabled | Create Jira Ticket |
      | AUT_TestFieldNameAndValue10 | Nagios-Pet   | Description   | Contains   | TEST                 | disabled | Create SNOW Ticket |

  Scenario Outline: Verify saving of filter with Filter Rule (filter by field) and mandatory field (keyword value) left blank
    When I create a Filter with filter name <filter name> and <source> as source
    And with Filter Rule: <keyword> - <comparator> - <keyword value>, NOT button <NOT>
    And <filter name> has Action: <action>
    Then filter should not be saved

    Examples: 
      | filter name                 | source       | keyword | comparator | keyword value | NOT      | action        |
      | AUT_TestFieldNameAndValue11 | Cisco Meraki | Country | Equals     |               | disabled | Send to Slack |
