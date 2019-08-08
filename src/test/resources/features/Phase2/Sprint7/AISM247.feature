@scenarios @AISM247 @Phase2 @Phase2-Sprint7 @EventsBrowser @Regression
Feature: AISM-247
  As an Operator
  I can filter events by status (multiple selection)

  Background: 
    Given I am login
    And I am on Events Browser page

  Scenario Outline: Verify filtering of Events by Status: <status>
    When I select <status> as Status
    And I click Apply
    Then Events Browser page should list all events with Status: <status>

    Examples: 
      | status                       |
      | Success,Partially Successful |

  Scenario Outline: Verify filtering of Events by Status: <status> and can combine with Source: <source> and Timestamp
    When I select <source> as Source
    And I select <status> as Status
    And I select Date Range: From 08/01/2019 00:00 To 07/01/2099 00:00
    And I click Apply
    Then Events Browser page should list the events received from 08/01/2019 00:00 to 07/01/2099 00:00 and with <source> as source
    And with Status: <status> only

    Examples: 
      | source    | status           |
      | Email WUG | Failed,No Action |
