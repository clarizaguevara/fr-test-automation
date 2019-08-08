@scenarios @AISM272 @Phase2 @Phase2-Sprint7 @Regression
Feature: AISM-272
  As an Tool Administrator
  I can configure so that EvA can get field from Whats Up Gold alerts.

  Background: 
    Given I am login
    And I am on Create New Filter page

  Scenario Outline: Verify that user can create a filter with Source: Email WUG (field: <keyword>)
    When I create a Filter with filter name <filter name> and <source> as source
    And with Filter Rule: <keyword> - <comparator> - <keyword value>
    And <filter name> has Action: <action>
    Then filter should be saved successfully

    Examples: 
      | filter name                   | source    | keyword       | comparator  | keyword value           | action             |
      | AUT_TestEmailWUG_StoreID      | Email WUG | Store ID      | Contains    |                    0569 | Send to Slack      |
      | AUT_TestEmailWUG_ComputerName | Email WUG | Computer Name | Begins With | UQ                      | Create Jira Ticket |
      | AUT_TestEmailWUG_IPAddress    | Email WUG | IP Address    | Equals      | 10.213.69.190           | Create SNOW Ticket |
      | AUT_TestEmailWUG_DeviceID     | Email WUG | Device ID     | Like        | *0569                   | Send Email         |
      | AUT_TestEmailWUG_Details      | Email WUG | Details       | Ends With   | TEST                    | Send to Slack      |
      | AUT_TestEmailWUG_State        | Email WUG | State         | Contains    |                     001 | Send to Slack      |
      | AUT_TestEmailWUG_Description  | Email WUG | Description   | Begins With | UQ                      | Create Jira Ticket |
      | AUT_TestEmailWUG_Sender       | Email WUG | Sender        | Equals      | fastretaileva@gmail.com | Create SNOW Ticket |
      | AUT_TestEmailWUG_Subject      | Email WUG | Subject       | Like        | FIRE*                   | Send Email         |
      | AUT_TestEmailWUG_Body         | Email WUG | Body          | Ends With   | TEST                    | Send to Slack      |
