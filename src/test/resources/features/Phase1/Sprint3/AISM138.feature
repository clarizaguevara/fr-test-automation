@scenarios @EventsBrowser @testing
Feature: AISM-138
  As an Operator
  I can see the status of the Filters and the Actions Triggered.  (EvA Event Browser)

  Background: 
    Given I am login
    And I am on Home page

  Scenario: Verify successful navigation to Events Browser page
    When I click Events tab
    Then Events Browser page should be loaded successfully

  Scenario Outline: Verify filtering of Events by Timestamp and Source: <source>
    When I click Events tab
    And I select <source> as Source
    And I select Date Range: From 05/01/2019 00:00 To 06/01/2019 00:00
    And I click Apply
    Then Events Browser page should list the events received from 05/01/2019 00:00 to 06/01/2019 00:00 and with <source> as source

    Examples: 
      | source       |
      | Nagios-Pet   |
      | Cisco Meraki |

  Scenario: Verify Payload Info of an event
    When I click Events tab
    And I click the Payload button of each event
    Then Payload info of the event is shown

  Scenario: Verify Filter details of an event
    When I click Events tab
    And I select an event in the list
    Then Filter details of the event is shown
    When I click the Back button
    Then Events Browser page should be loaded successfully

  Scenario: Verify Action details of a filter
    When I click Events tab
    And I select an event in the list
    Then Filter details of the event is shown
    When I select a filter in the filter list
    Then Action details of the filter is shown
    When I click the Back button
    Then Filter details of the event is shown

  Scenario: Verify Payload details of an action
    When I click Events tab
    And I select an event in the list
    Then Filter details of the event is shown
    When I select a filter in the filter list
    Then Action details of the filter is shown
    When I select an action in the action list
    Then Payload of the action is shown
    When I click the Back button
    Then Action details of the filter is shown
