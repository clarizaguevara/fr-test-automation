@AISM149 @Templates
Feature: AISM-149
  As an Operator
  I can create a template

  Background: 
    Given I am login
    And I am on Home page

  Scenario: Verify successful navigation to Templates Management page
    When I click Maintenance tab
    And I select Templates Management
    Then Templates Management page should be loaded successfully

  Scenario Outline: Verify saving of template with Template type: <template type>
    When I click Maintenance tab
    And I select Templates Management
    And I create a Template with template name <template name>, template type <template type> and <source> as source
    And with Filter Rule: <keyword> - <comparator> - <keyword value>
    And <template name> has Action: <action>
    Then template should be saved successfully

    Examples: 
      | template name          | template type | source       | keyword  | comparator | keyword value  | action             |
      | AUT_TestTemplateMaster | Master        | Cisco Meraki | Hostname | Equals     | UQ-JP-0088-SDC | Send to Slack      |

  Scenario Outline: Verify saving of template and mandatory field (keyword value) left blank
    When I click Maintenance tab
    And I select Templates Management
    And I create a Template with template name <template name>, template type <template type> and <source> as source
    And I leave Keyword Value blank in the Filter Rule: <keyword> - <comparator>
    And <template name> has Action: <action>
    Then template should not be saved

    Examples: 
      | template name           | template type | source       | keyword  | comparator | action        |
      | AUT_TestTemplateMaster2 | Master        | Cisco Meraki | Hostname | Equals     | Send to Slack |

  Scenario Outline: Verify that user can Edit a template
    When I click Maintenance tab
    And I select Templates Management
    And I create a Template with template name <template name>, template type <template type> and <source> as source
    And with Filter Rule: <keyword> - <comparator> - <keyword value>
    And <template name> has Action: <action>
    Then template should be saved successfully
    When I go back to Template Browse page and open template AUT_TestEditTemplate
    And I edit the Filter Rule to: Shop Contains UQ
    Then template AUT_TestEditTemplate should be editted successfully with new Filter rule values: Shop Contains UQ

    Examples: 
      | template name        | template type | source       | keyword  | comparator | keyword value  | action        |
      | AUT_TestEditTemplate | Master        | Cisco Meraki | Hostname | Equals     | UQ-JP-0088-SDC | Send to Slack |
