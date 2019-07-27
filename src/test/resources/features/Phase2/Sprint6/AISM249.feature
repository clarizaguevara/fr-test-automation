@scenarios @AISM249 @Phase2 @Phase2-Sprint6
Feature: AISM-249
  As an Operator
  I can retry actions from the event page

  Background: 
    Given I am login
    And I am on Events Browser page

  @ShoppingCart
  Scenario: Verify that Operator can select an action and put it into a shopping cart
    When I select an Event with Failed status
    And view the Retry list
    Then the selected Event should be in the Retry list

  @ShoppingCart
  Scenario: Verify that Operator can add several actions into the shopping cart
    When I select multiple Events with Failed status
    And view the Retry list
    Then the selected Events should be in the Retry list

  @ShoppingCart
  Scenario: Verify that only the selected Events are placed in the Retry list
    When I select multiple Events with Failed status
    And view the Retry list
    Then the selected Events should be in the Retry list
    When I deselect one Event
    Then the deselected Event should be removed from the Retry list

	@RetryAction
  Scenario: Verify that if retry is successful, the failed event will change status to successful after retry
  	When I select an Event with Failed status
    And view the Retry list
    Then the selected Event should be in the Retry list
    When I click the Retry button
    Then the failed Event should change its status to Success