@scenarios @AISM218 @Phase2 @Phase2-Sprint3 @Regression
Feature: AISM-218
  As an Tool Administrator
  I can configure so that only the necessary fields are set as mandatory on SNOW

  Background: 
    Given I am login
    And I am on Create New Filter page

  Scenario Outline: Verify Tool Administrator can configure so that only the necessary fields are set as mandatory on SNOW
    When I create a Filter with filter name <filter name> and <source> as source
    And with Filter Rule: <keyword> - <comparator> - <keyword value>
    And <filter name> has Action: Create SNOW Ticket
    Then filter should be saved successfully
    When I go back to Browse page and open filter <filter name>
    And I remove a non-mandatory field: Short Description
    Then filter should be saved successfully

    Examples: 
      | filter name                | source     | keyword     | comparator | keyword value |
      | AUT_Snow_NonRequiredFields | Nagios-Pet | Description | Contains   | warn          |
