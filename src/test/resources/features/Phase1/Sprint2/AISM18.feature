@scenarios @AISM18 @Phase1 @Phase1-Sprint2
Feature: AISM-18
  As a Tool Administrator
  I can configure so that a JIRA ticket will be created automatically (KKA)

  Background: 
    Given I am login
    And I am on Create New Filter page

  Scenario Outline: Verify Tool Administrator can configure so that a JIRA ticket will be created automatically (source: <source>)
    When I create a Filter with filter name <filter name> and <source> as source
    And with Filter Rule: <keyword> - <comparator> - <keyword value>
    And <filter name> has Action: Jira-KKA
    Then filter should be saved successfully

    Examples: 
      | filter name               | source       | keyword     | comparator  | keyword value |
      | AUT_TestCreateJiraAction1 | Nagios-Pet   | Description | Contains    | TEST          |
      | AUT_TestCreateJiraAction2 | Cisco Meraki | Hostname    | Begins With | UQ            |

  @Regression
  Scenario Outline: Verify Filter is not saved if mandatory fields are left blank
    When I create a Filter with filter name <filter name> and <source> as source
    And with Filter Rule: <keyword> - <comparator> - <keyword value>
    And <filter name> has Action: Jira Project Issue type but mandatory fields are left blank
    Then filter should not be saved

    Examples: 
      | filter name               | source       | keyword | comparator | keyword value |
      | AUT_TestCreateJiraAction3 | Cisco Meraki | Country | Ends With  | JP            |

  Scenario Outline: Verify Filter is saved if non mandatory fields are left blank
    When I create a Filter with filter name <filter name> and <source> as source
    And with Filter Rule: <keyword> - <comparator> - <keyword value>
    And <filter name> has Action: Jira Project Issue type but non mandatory fields are left blank
    Then filter should be saved successfully

    Examples: 
      | filter name               | source       | keyword | comparator | keyword value |
      | AUT_TestCreateJiraAction4 | Cisco Meraki | Shop    | Ends With  | UQ            |

  @Regression
  Scenario: Verify that Slack channel disappears if "Send ticket ID to Slack channel" checkbox is unchecked
    When I go back to Browse page and open filter AUT_TestCreateJiraAction4
    And I untick "Send ticket ID to Slack channel" checkbox
    Then Slack channel field should be blank
    When I tick "Send ticket ID to Slack channel" checkbox and input Slack channel
    Then Slack channel should be filled up
