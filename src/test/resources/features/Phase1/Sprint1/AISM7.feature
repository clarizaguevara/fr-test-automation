@scenarios @AISM7 @Phase1 @Phase1-Sprint1
Feature: AISM-7
  As a Tool Administrator
  I can configure so that message is sent to users on Slack automatically

  Background: 
    Given I am login
    And I am on Create New Filter page

  Scenario Outline: Verify Tool Administrator can configure so that message is sent to users on Slack automatically (source: <source>)
    When I create a Filter with filter name <filter name> and <source> as source
    And with Filter Rule: <keyword> - <comparator> - <keyword value>
    And <filter name> has Action: Send to Slack
    Then filter should be saved successfully

    Examples: 
      | filter name                | source       | keyword  | comparator  | keyword value |
      | AUT_TestSlackActionFilter1 | Nagios-Pet   | Summary  | Contains    | TEST          |
      | AUT_TestSlackActionFilter2 | Cisco Meraki | Hostname | Begins With | UQ            |

  @Regression
  Scenario Outline: Verify EvA bot can include original alert message to the message posted with quotation
    When I create a Filter with filter name <filter name> and <source> as source
    And with Filter Rule: <keyword> - <comparator> - <keyword value>
    And <filter name> has Action: Send to Slack
    And I ticked include original alert message
    Then filter should be saved successfully

    Examples: 
      | filter name                | source     | keyword     | comparator | keyword value |
      | AUT_TestSlackActionFilter3 | Nagios-Pet | Description | Contains   | TEST          |

  @Regression
  Scenario Outline: Verify EvA can send mention
    When I create a Filter with filter name <filter name> and <source> as source
    And with Filter Rule: <keyword> - <comparator> - <keyword value>
    And <filter name> has Action: Send to Slack
    And I add mention
    Then filter should be saved successfully

    Examples: 
      | filter name                | source       | keyword | comparator | keyword value |
      | AUT_TestSlackActionFilter4 | Cisco Meraki | Country | Equals     | JP            |

  @Regression
  Scenario Outline: Verify filter is not saved when Slack Channel field is blank
    When I create a Filter with filter name <filter name> and <source> as source
    And with Filter Rule: <keyword> - <comparator> - <keyword value>
    And <filter name> has Action: Send to Slack
    And I left Slack Channel field blank
    Then filter should not be saved

    Examples: 
      | filter name                | source       | keyword     | comparator | keyword value |
      | AUT_TestSlackActionFilter5 | Cisco Meraki | Mac Address | Contains   | e0:55:        |
