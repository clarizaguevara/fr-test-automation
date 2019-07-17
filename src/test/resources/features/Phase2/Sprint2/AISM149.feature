@scenarios @AISM149 @Phase2 @Phase2-Sprint2 @Templates
Feature: AISM-149
  As an Operator
  I can create a template

  Background: 
    Given I am login
    And I am on Templates Management page

  Scenario: Verify successful navigation to Templates Management page
    Then Templates Management page should be loaded successfully

  Scenario Outline: Verify that user can Create a Template
    When I create a Template with template name <template name>, template type <template type> and <source> as source
    And with Filter Rule: <keyword> - <comparator> - <keyword value>
    And <template name> has Action: <action>
    Then template should be saved successfully

    Examples: 
      | template name    | template type | source       | keyword  | comparator | keyword value  | action        |
      | AUT_TestTemplate | Master        | Cisco Meraki | Hostname | Equals     | UQ-JP-0088-SDC | Send to Slack |

  Scenario Outline: Verify saving of template and mandatory field (keyword value) left blank
    When I create a Template with template name <template name>, template type <template type> and <source> as source
    And I leave Keyword Value blank in the Filter Rule: <keyword> - <comparator>
    And <template name> has Action: <action>
    Then template should not be saved

    Examples: 
      | template name     | template type | source       | keyword  | comparator | action        |
      | AUT_TestTemplate2 | Master        | Cisco Meraki | Hostname | Equals     | Send to Slack |

  Scenario Outline: Verify that user can Edit a template
    When I go back to Template Browse page and open template <template name>
    And I edit the Filter Rule to: <keyword> <comparator> <keyword value>
    Then template <template name> should be editted successfully with new Filter rule values: <keyword> <comparator> <keyword value>

    Examples: 
      | template name    | template type | source       | keyword | comparator | keyword value |
      | AUT_TestTemplate | Master        | Cisco Meraki | Shop    | Contains   | UQ            |

  Scenario Outline: Verify that version number increments when a Template is editted
    Then version number of template <template name> should be v2

    Examples: 
      | template name    |
      | AUT_TestTemplate |
