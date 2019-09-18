@scenarios @AISM12 @Phase1 @Phase1-Sprint2 @ExtendedRules @SnowDuplicate @Regression
Feature: AISM-12
  As a Operator
  I can check SNOW ticket from the NW alert information

  Background: 
    Given I am login
    And I am on Create New Filter page

  Scenario Outline: Verify saving of filter with Snow Duplicate Check condition (<with> open tickets for <snow keyword>)
    When I create a Filter with filter name <filter name> and <source> as source
    And with Filter Rule: <keyword> - <comparator> - <keyword value>
    And add a Snow Duplicate Check condition: <with> open tickets where <snow keyword> contains <field>
    And <filter name> has Action: Create SNOW Ticket
    Then filter should be saved successfully

    Examples: 
      | filter name                                           | source       | keyword | comparator | keyword value | with    | snow keyword      | field         |
      | AUT_TestSnowDuplicate_With_ShortDescription_IPAddress | Cisco Meraki | Country | Equals     | JP            | With    | Short Description | ${Ip address} |
      | AUT_TestSnowDuplicate_Without_Description_IPAddress   | Cisco Meraki | Shop    | Equals     | UQ            | Without | Description       | IP Address    |
