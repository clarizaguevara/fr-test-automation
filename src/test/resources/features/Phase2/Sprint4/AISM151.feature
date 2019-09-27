@scenarios @AISM151 @AISM150 @AISM156 @Phase2 @Phase2-Sprint4 @Templates @Regression
Feature: Templates
  As an Operator
  I can apply the template when creating a filter (AISM-151)
  I can propagate the template (AISM-150)
  I can see the preview of the filter in the propagate filter page (AISM-156)

  Background: 
    Given I am login

  Scenario Outline: Create Templates
    When I am on Templates Management page
    And I create a Template with template name <template name>, template type <template type> and <source> as source
    And with Filter Rule: <keyword> - <comparator> - <keyword value>
    And <template name> has Action: <action>
    Then template should be saved successfully

    Examples: 
      | template name   | template type | source       | keyword | comparator | keyword value | action        |
      | AUT_Template_NP | Master        | Nagios-Pet   | Summary | Equals     | TEST          | Send to Slack |
      | AUT_Template_CM | Master        | Cisco Meraki | Country | Equals     | JP            | Send to Slack |

  Scenario Outline: Create Filters
    When I am on Create New Filter page
    And I create a Filter with filter name <filter name> and <source> as source
    And with Filter Rule: <keyword> - <comparator> - <keyword value>
    And <filter name> has Action: <action>
    Then filter should be saved successfully

    Examples: 
      | filter name          | source     | keyword     | comparator  | keyword value | action             |
      | AUT_Template_Filter1 | Nagios-Pet | Summary     | Begins With | warning       | Create Jira Ticket |
      | AUT_Template_Filter2 | Nagios-Pet | Description | Ends With   | error         | Send Email         |

  @ApplyTemplate
  Scenario Outline: [AISM-151] Verify that when a template is selected, the filter conditions & actions in the template will be automatically applied
    When I go back to Browse page and open filter <filter name>
    And I apply template <template name>
    Then filter should be saved successfully
    And filter conditions and actions of <template name> <version> should be applied

    Examples: 
      | filter name          | template name   | version |
      | AUT_Template_Filter1 | AUT_Template_NP | v1      |

  @ApplyTemplate
  Scenario Outline: [AISM-151] Verify that filter and template should have the same Source
    When I go back to Browse page and open filter <filter name>
    Then I should not be able to apply <template name>
    When I apply template <template name2>
    Then filter should be saved successfully
    And filter conditions and actions of <template name2> <version> should be applied

    Examples: 
      | filter name          | template name   | template name2  | version |
      | AUT_Template_Filter2 | AUT_Template_CM | AUT_Template_NP | v1      |

  @Propagate
  Scenario Outline: [AISM-150] Verify that pressing the Apply changes button will show the list of filters that uses the old version of the template
    When I go back to Template Browse page and open template <template name>
    And I edit the Filter Rule to: <keyword> <comparator> <keyword value>
    Then template <template name> should be editted successfully with new Filter rule values: <keyword> <comparator> <keyword value>
    When I go back to Templates Management page
    Then version number of template <template name> should be <new version>
    When I open template <template name>
    And click Apply Changes
    Then it should list all filters that uses the template with version older than <new version>

    Examples: 
      | template name   | keyword     | comparator | keyword value | new version |
      | AUT_Template_NP | Description | Contains   | TEST          | v2          |

  @Propagate
  Scenario Outline: [AISM-150] Verify that the changes in Template should only be applied to the selected Filter
    When I go back to Template Browse page and open template <template name>
    And click Apply Changes
    Then it should list all filters that uses the template with version older than <version>
    When I propagate the template changes to <filter name>
    When I go back to Browse page and open filter <filter name>
    Then filter conditions and actions of <template name> <version> should be applied
    When I go back to Browse page and open filter <filter name2>
    Then filter conditions and actions of <template name> <old version> should be applied

    Examples: 
      | template name   | version | filter name          | filter name2         | old version |
      | AUT_Template_NP | v2      | AUT_Template_Filter1 | AUT_Template_Filter2 | v1          |

  @PreviewFilter
  Scenario Outline: [AISM-156] Verify that user can see the preview of a Filter
    When I go back to Template Browse page and open template <template name>
    And click Apply Changes
    Then it should list all filters that uses the template with version older than <version>
    When I click the preview button of <filter name>
    Then it should show the contents of <filter name> and <template name> <old version> should be applied

    Examples: 
      | template name   | version | filter name          | old version |
      | AUT_Template_NP | v2      | AUT_Template_Filter2 | v1          |
