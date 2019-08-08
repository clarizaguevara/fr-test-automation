@scenarios @AISM153 @Phase2 @Phase2-Sprint1 @BrowseFilters @Regression
Feature: AISM-153
  As an Operator
  I can filter by email source on filter browse page

  Background: 
    Given I am login
    And I am on Home page

  Scenario Outline: Verify browsing of Filters by Source: <source>
    When I browse filters with source: <source>
    Then Browse Filters page should list the filters with <source> as source

    Examples: 
      | source       |
      | Email        |
      | Nagios-Pet   |
      | Cisco Meraki |
      | Email        |
      | Email WUG    |

  Scenario Outline: Verify browsing of Filters by Filter name and Source: <source>
    When I browse filters with source: <source>
    And with name that contains AUT
    Then Browse Filters page should list the filters with <source> as source
    And filters with AUT in name

    Examples: 
      | source       |
      | Email        |
      | Nagios-Pet   |
      | Cisco Meraki |
      | Email        |
      | Email WUG    |
