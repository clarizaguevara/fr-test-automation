@scenarios @AISM260 @AISM261 @Phase2 @Phase2-Sprint7 @Category @Regression
Feature: Category
  As an Operator
  I can set a category to a filter (AISM-260)
  I can filter filters by category (AISM-261)

  Background: 
    Given I am login

  @SetCategory
  Scenario Outline: [AISM-260] Verify that Operator can set a Category to a filter
    When I am on Create New Filter page
    And I create a Filter with filter name <filter name> and <source> as source
    And I add category: <category>
    And with Filter Rule: <keyword> - <comparator> - <keyword value>
    And <filter name> has Action: <action>
    Then filter should be saved successfully
    And category <category> should be applied

    Examples: 
      | filter name           | source     | category                     | keyword | comparator  | keyword value | action             |
      | AUT_Category_Single   | Nagios-Pet | test-category                | Summary | Begins With | warning       | Create Jira Ticket |
      | AUT_Category_Multiple | Email      | test-category,email,category | Subject | Ends With   | error         | Send Email         |

  @SetCategory
  Scenario Outline: [AISM-260] Verify that Operator can remove a Category
    When I go back to Browse page and open filter <filter name>
    And I remove category: <category>
    Then filter should be saved successfully
    And category <updated category> should be applied

    Examples: 
      | filter name           | category | updated category    |
      | AUT_Category_Multiple | category | test-category,email |

  @FilterByCategory
  Scenario Outline: [AISM-261] Verify that Operator can filter Filters by Category
    When I am on Home page
    And I browse filters with category: <category>
    Then Browse Filters page should list the filters with the category: <category>

    Examples: 
      | category            |
      | test-category       |
      | test-category,email |
      | email               |

  @FilterByCategory
  Scenario Outline: [AISM-261] Verify that filtering of Filters by Category can be combined with Source/Status/Title
    When I am on Home page
    And I browse filters with category: <category>
    And with source: <source>
    Then Browse Filters page should list the filters with the category: <category>
    And filters with <source> as source

    Examples: 
      | category            | source     |
      | test-category       | Nagios-Pet |
      | test-category,email | Nagios-Pet |
      | email               | Email      |
