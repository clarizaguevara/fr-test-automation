@scenarios @AISM13 @Phase1 @Phase1-Sprint2
Feature: AISM-13
  As an Operator
  I can make a SNOW incident ticket from alert

  Background: 
    Given I am login
    And I am on Create New Filter page

  Scenario Outline: Verify Operator can make a SNOW incident ticket from alert (source: <source>)
    When I create a Filter with filter name <filter name> and <source> as source
    And with Filter Rule: <keyword> - <comparator> - <keyword value>
    And <filter name> has Action: Create SNOW Ticket
    Then filter should be saved successfully

    Examples: 
      | filter name               | source       | keyword     | comparator  | keyword value |
      | AUT_TestSnowTicketAction1 | Nagios-Pet   | Description | Contains    | TEST          |
      | AUT_TestSnowTicketAction2 | Cisco Meraki | IP Address  | Begins With |           192 |

  @Regression
  Scenario Outline: Verify no SNOW Ticket is created if mandatory fields are left blank
    When I create a Filter with filter name <filter name> and <source> as source
    And with Filter Rule: <keyword> - <comparator> - <keyword value>
    And <filter name> has Action: Create SNOW but mandatory fields are left blank
    Then filter should not be saved

    Examples: 
      | filter name               | source     | keyword | comparator | keyword value |
      | AUT_TestSnowTicketAction3 | Nagios-Pet | Summary | Contains   | TEST          |
