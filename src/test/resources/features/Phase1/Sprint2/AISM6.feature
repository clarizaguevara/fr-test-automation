@scenarios @AISM6 @Phase1 @Phase1-Sprint2
Feature: AISM-6
  As a Tool Administrator
  I can configure so that JIRA ticket URL can be sent to Slack automatically as an action

  Background: 
    Given I am login
    And I am on Create New Filter page

  Scenario Outline: Verify Tool Administrator can configure so that JIRA ticket URL can be sent to Slack automatically as an action (<action>)
    When I create a Filter with filter name <filter name> and <source> as source
    And with Filter Rule: <keyword> - <comparator> - <keyword value>
    And <filter name> has Action: <action>
    Then filter should be saved successfully

    Examples: 
      | filter name                    | source       | keyword | comparator | keyword value | action    |
      | AUT_TestCreateJiraSendToSlack1 | Nagios-Pet   | Summary | Contains   | TEST          | Jira-KKA  |
      | AUT_TestCreateJiraSendToSlack2 | Cisco Meraki | Country | Equals     | JP            | Jira-ACPF |

  @Regression
  Scenario Outline: Verify JIRA ticket URL is not sent to Slack if Send ticket ID to Slack Channel checkbox is not ticked
    When I create a Filter with filter name <filter name> and <source> as source
    And with Filter Rule: <keyword> - <comparator> - <keyword value>
    And <filter name> has Action: Jira-ACPF
    And Send ticket ID to Slack channel is not ticked
    Then filter should be saved successfully

    Examples: 
      | filter name                    | source       | keyword | comparator | keyword value |
      | AUT_TestCreateJiraSendToSlack3 | Cisco Meraki | Device  | Equals     | SDC-AP1-API   |

  @Regression
  Scenario Outline: Verify slack channel field should not be left blank if Send ticket ID to Slack channel check box is ticked
    When I create a Filter with filter name <filter name> and <source> as source
    And with Filter Rule: <keyword> - <comparator> - <keyword value>
    And <filter name> has Action: Jira-KKA
    And Slack Channel field is left blank
    Then filter should not be saved

    Examples: 
      | filter name                    | source       | keyword     | comparator | keyword value |
      | AUT_TestCreateJiraSendToSlack4 | Cisco Meraki | Mac Address | Contains   | e0:55:        |
