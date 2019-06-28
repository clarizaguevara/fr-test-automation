@AISM62 @scenarios
Feature: AISM - 62
  As an Operator
  I can configure so that a JIRA ticket will be created automatically (ACPF)

  Background: 
    Given I am login
    And I am on Create New Filter page

  Scenario Outline: Verify Tool Administrator can configure so that a JIRA ticket will be created automatically
    When I create a Filter with filter name <filter name> and <source> as source
    And with Filter Rule: <keyword> - <comparator> - <keyword value>
    And with Action: Create Jira Ticket-ACPF "<filter name>"
    Then I should be able to save successfully

    Examples: 
      | filter name                        | source       | keyword    | comparator | keyword value |
      | AUT_TestCreateJiraActionIssueTask1 | Nagios-Pet   | Summary    | Contains   | TEST          |
      | AUT_TestCreateJiraActionIssueTask2 | Cisco Meraki | IP Address | Contains   |           250 |

  Scenario Outline: Verify Filter is not saved if mandatory fields are left blank
    When I create a Filter with filter name <filter name> and <source> as source
    And with Filter Rule: <keyword> - <comparator> - <keyword value>
    And with Action: Create Jira Ticket-ACPF but mandatory fields are left blank "<filter name>"
    Then I should not be able to save successfully

    Examples: 
      | filter name                        | source       | keyword | comparator | keyword value |
      | AUT_TestCreateJiraActionIssueTask3 | Cisco Meraki | Country | Ends With  | JP            |

  Scenario Outline: Verify Filter is saved if non mandatory fields are left blank
    When I create a Filter with filter name <filter name> and <source> as source
    And with Filter Rule: <keyword> - <comparator> - <keyword value>
    And with Action: Create Jira Ticket-ACPF but non mandatory fields are left blank "<filter name>"
    Then I should be able to save successfully

    Examples: 
      | filter name                        | source       | keyword | comparator | keyword value |
      | AUT_TestCreateJiraActionIssueTask4 | Cisco Meraki | Shop    | Ends With  | UQ            |

  Scenario Outline: Verify Multiple watchers can be added
    When I create a Filter with filter name <filter name> and <source> as source
    And with Filter Rule: <keyword> - <comparator> - <keyword value>
    And with Action: Create Jira Ticket-ACPF "<filter name>"
    And I add multiple watchers
    Then I should be able to save successfully

    Examples: 
      | filter name                        | source     | keyword     | comparator | keyword value |
      | AUT_TestCreateJiraActionIssueTask5 | Nagios-Pet | Description | Contains   | TEST          |

  Scenario Outline: Verify Multiple labels can be added
    When I create a Filter with filter name <filter name> and <source> as source
    And with Filter Rule: <keyword> - <comparator> - <keyword value>
    And with Action: Create Jira Ticket-ACPF "<filter name>"
    And I add multiple labels
    Then I should be able to save successfully

    Examples: 
      | filter name                        | source     | keyword | comparator | keyword value |
      | AUT_TestCreateJiraActionIssueTask6 | Nagios-Pet | Summary | Contains   | TEST          |
