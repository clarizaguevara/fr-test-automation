@scenarios @AISM259 @Phase2 @Phase2-Sprint6 @BrowseFilters @Regression
Feature: AISM-259
  As an Operator
  I can filter filters by status

  Background: 
    Given I am login
    And I am on Home page

  Scenario Outline: Verify browsing of Filters by Status: <status>
    When I browse filters with status: <status>
    Then Browse Filters page should list the filters with <status> as status

    Examples: 
      | status   |
      | Active   |
      | Inactive |

  Scenario Outline: Verify browsing of Filters by Filter name and Status: <status>
    When I browse filters with status: <status>
    And with name that contains AUT
    Then Browse Filters page should list the filters with <status> as status
    And filters with AUT in name

    Examples: 
      | status   |
      | Active   |
      | Inactive |

  Scenario Outline: Verify browsing of Filters by Source: <source> and Status: <status>
    When I browse filters with status: <status>
    And with source: <source>
    Then Browse Filters page should list the filters with <status> as status
    And filters with <source> as source

    Examples: 
      | status   | source       |
      | Active   | Nagios-Pet   |
      | Active   | Cisco Meraki |
      | Active   | Email        |
      | Active   | Email WUG    |
      | Inactive | Nagios-Pet   |
      | Inactive | Cisco Meraki |
      | Inactive | Email        |
      | Inactive | Email WUG    |

  Scenario Outline: Verify browsing of Filters by Filter name, Source: <source> and Status: <status>
    When I browse filters with status: <status>
    And with source: <source>
    And with name that contains AUT
    Then Browse Filters page should list the filters with <status> as status
    And filters with <source> as source
    And filters with AUT in name

    Examples: 
      | status   | source       |
      | Active   | Nagios-Pet   |
      | Active   | Cisco Meraki |
      | Active   | Email        |
      | Active   | Email WUG    |
      | Inactive | Nagios-Pet   |
      | Inactive | Cisco Meraki |
      | Inactive | Email        |
      | Inactive | Email WUG    |
