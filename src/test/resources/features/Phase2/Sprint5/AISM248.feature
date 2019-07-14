@scenarios @AISM248 @Phase2 @Phase2-Sprint5 @EventsBrowser
Feature: AISM-248
  As an Tool Administrator
  I can configure so that hour, minute, and second is displayed in the timestamp on the event page.

  Background: 
    Given I am login
    And I am on Events Browser page

  Scenario: Verify that timestamp is displayed in MM/dd/yyyy HH:mm:ss format
    Then Timestamp should be displayed in MM/dd/yyyy HH:mm:ss format