@scenarios @AISM214 @EventsBrowser
Feature: AISM-214
  As an Operator
  I can filter by status of events in event page

  Background: 
    Given I am login
    And I am on Events Browser page

  Scenario Outline: Verify filtering of Events by Status: <status>
    When I select <status> as Status
    And I click Apply
    Then Events Browser page should list all events with Status: <status>

    Examples: 
      | status               |
      | Success              |
      | Partially Successful |
      | Failed               |
      | No Action            |

  Scenario Outline: Verify filtering of Events by Status: <status> and can combine with Source: <source> and Timestamp
    When I select <source> as Source
    And I select <status> as Status
    And I select Date Range: From 06/01/2019 00:00 To 07/01/2019 00:00
    And I click Apply
    Then Events Browser page should list the events received from 06/01/2019 00:00 to 07/01/2019 00:00 and with <source> as source
    And with Status: <status> only

    Examples: 
      | source       | status               |
      | Nagios-Pet   | Success              |
      | Nagios-Pet   | Partially Successful |
      | Nagios-Pet   | Failed               |
      | Nagios-Pet   | No Action            |
      | Cisco Meraki | Success              |
      | Cisco Meraki | Partially Successful |
      | Cisco Meraki | Failed               |
      | Cisco Meraki | No Action            |
