@scenarios @AISM143 @Phase2 @Phase2-Sprint1
Feature: AISM-143
  As an Tool Administrator
  I can configure so that source will be mapped with email sender

  Background: 
    Given I am login
    And I am on Create New Filter page

  Scenario Outline: Verify keyword dropdown values for Source: <source>
    When I select <source> as source
    Then Keyword dropdown should have the correct values for source: <source>

    Examples: 
      | source       |
      | Email        |
      | Nagios-Pet   |
      | Cisco Meraki |
      | Email        |
