@scenarios @AISM153 @BrowseFilters
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
      | source               |
      | Email - JP1          |
      | Email - Nagios-Pet   |
      | Email - WhatsUp Gold |
      | Nagios-Pet           |
      | Cisco Meraki         |

  Scenario Outline: Verify browsing of Filters by Filter name and Source: <source>
    When I browse filters with source: <source>
    And with name that contains AUT
    Then Browse Filters page should list the filters with <source> as source
    And filters with AUT in name

    Examples: 
      | source               |
      | Email - JP1          |
      | Email - Nagios-Pet   |
      | Email - WhatsUp Gold |
      | Nagios-Pet           |
      | Cisco Meraki         |
