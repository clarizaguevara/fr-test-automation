@scenarios @AISM21 @Phase1 @Phase1-Sprint3
Feature: AISM-21
  Tool Administrator
  I can configure so that an email will be sent automatically

  Background: 
    Given I am login
    And I am on Create New Filter page

  Scenario Outline: Verify Tool Administrator can configure so that an email will be sent automatically (source: <source>)
    When I create a Filter with filter name <filter name> and <source> as source
    And with Filter Rule: <keyword> - <comparator> - <keyword value>
    And <filter name> has Action: Send Email
    Then filter should be saved successfully

    Examples: 
      | filter name        | source       | keyword     | comparator  | keyword value |
      | AUT_TestSendEmail1 | Nagios-Pet   | Description | Contains    | TEST          |
      | AUT_TestSendEmail2 | Cisco Meraki | IP Address  | Begins With |           192 |

  Scenario Outline: Verify original alert message is included in Email if include original alert message checkbox is ticked
    When I create a Filter with filter name <filter name> and <source> as source
    And with Filter Rule: <keyword> - <comparator> - <keyword value>
    And <filter name> has Action: Send Email
    And I ticked include original alert message
    Then filter should be saved successfully

    Examples: 
      | filter name        | source     | keyword | comparator | keyword value |
      | AUT_TestSendEmail3 | Nagios-Pet | Summary | Contains   | TEST          |

  Scenario Outline: Verify filter is not saved if required fields are left blank
    When I create a Filter with filter name <filter name> and <source> as source
    And with Filter Rule: <keyword> - <comparator> - <keyword value>
    And <filter name> has Action: Email but mandatory fields are left blank
    Then filter should not be saved

    Examples: 
      | filter name        | source       | keyword       | comparator | keyword value  |
      | AUT_TestSendEmail4 | Cisco Meraki | Device Serial | Equals     | Q2JD-XJGK-F8Y3 |

  Scenario Outline: Verify Tool Administrator can configure so that an email with sub-domain will be sent automatically
    When I create a Filter with filter name <filter name> and <source> as source
    And with Filter Rule: <keyword> - <comparator> - <keyword value>
    And <filter name> has Action: Email with sub-domain
    Then filter should be saved successfully

    Examples: 
      | filter name        | source       | keyword | comparator | keyword value |
      | AUT_TestSendEmail5 | Cisco Meraki | Country | Equals     | JP            |
