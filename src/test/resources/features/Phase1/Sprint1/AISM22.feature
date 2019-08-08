@scenarios @AISM22 @Phase1 @Phase1-Sprint1 @Regression
Feature: AISM-22
  As a Tool Administrator
  I can configure so that alert will be filtered by keyword in alert message

  Background: 
    Given I am login
    And I am on Create New Filter page

  Scenario Outline: Verify Tool Administrator can configure so that alert will be filtered by keyword in alert message (source: <source>, comparator: <comparator>)
    When I create a Filter with filter name <filter name> and <source> as source
    And with Filter Rule: <keyword> - <comparator> - <keyword value>
    And <filter name> has Action: <action>
    Then filter should be saved successfully

    Examples: 
      | filter name             | source       | keyword     | comparator  | keyword value     | action             |
      | AUT_TestKeywordFilter1  | Nagios-Pet   | Summary     | Contains    | TEST              | Send to Slack      |
      | AUT_TestKeywordFilter2  | Nagios-Pet   | Description | Begins With | TEST              | Create Jira Ticket |
      | AUT_TestKeywordFilter3  | Nagios-Pet   | Summary     | Equals      | Testing           | Create SNOW Ticket |
      | AUT_TestKeywordFilter4  | Nagios-Pet   | Description | Like        | warn*             | Send Email         |
      | AUT_TestKeywordFilter5  | Nagios-Pet   | Summary     | Ends With   | TEST              | Send to Slack      |
      | AUT_TestKeywordFilter6  | Cisco Meraki | Hostname    | Contains    | PH                | Send to Slack      |
      | AUT_TestKeywordFilter7  | Cisco Meraki | Country     | Begins With | UQ                | Create Jira Ticket |
      | AUT_TestKeywordFilter8  | Cisco Meraki | Device      | Equals      | SDC-AP1-API       | Create SNOW Ticket |
      | AUT_TestKeywordFilter9  | Cisco Meraki | Network Id  | Like        | L_60235*160806634 | Send Email         |
      | AUT_TestKeywordFilter10 | Cisco Meraki | Shop        | Ends With   | GU                | Send to Slack      |
