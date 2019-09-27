@scenarios @AISM274 @Phase3 @Phase3-Sprint1 @VariableDefinition @Regression
Feature: AISM-274
  As an Operator
  I can define variables that could be used on different components

  Background: 
    Given I am login

  Scenario Outline: Verify that user can define a Variable
    When I am on Create New Filter page
    And I create a Filter with filter name <filter name> and <source> as source
    And I define a variable with name: <variable name>: after <start string> until <end string> from field <field>
    And with Filter Rule: <keyword> - <comparator> - <keyword value>
    And <filter name> has Action: Send to Slack
    Then filter should be saved successfully

    Examples: 
      | filter name         | source     | variable name    | start string | end string | field   | keyword | comparator | keyword value |
      | AUT_Variable_Single | Nagios-Pet | AUT_TestVariable | TEST         | summary    | Summary | Summary | Contains   | something     |

  Scenario Outline: Verify that user can define multiple Variables
    When I am on Create New Filter page
    And I create a Filter with filter name <filter name> and <source> as source
    And I define a variable 1 with details: <variable1>
    And I add another variable 2 with details: <variable2>
    And with Filter Rule: <keyword> - <comparator> - <keyword value>
    And <filter name> has Action: Send to Slack
    Then filter should be saved successfully

    Examples: 
      | filter name           | source     | variable1                              | variable2                                                       | keyword | comparator | keyword value |
      | AUT_Variable_Multiple | Nagios-Pet | AUT_TestVariable1-TEST-summary-Summary | AUT_TestVariable2-TEST-(end delimeter not included)-Description | Summary | Contains   | something     |

  Scenario Outline: Verify that user can edit a Variable
    When I go back to Browse page and open filter <filter name>
    And I edit the variable with name: <variable name>: after <start string> until <end string> from field <field>
    Then filter should be saved successfully

    Examples: 
      | filter name         | variable name    | start string | end string  | field       |
      | AUT_Variable_Single | AUT_TestVariable | TEST         | description | Description |

  Scenario Outline: Verify that Variable can not be deleted if is in use
    When I go back to Browse page and open filter <filter name>
    And add a Correlation condition: <frequency> occurences in <time value> <time unit>
    And with same values for <variable name>
    Then variable <variable name> can not be removed

    Examples: 
      | filter name         | frequency | time value | time unit | variable name    |
      | AUT_Variable_Single |         2 |          1 | Minutes   | AUT_TestVariable |

  Scenario Outline: Verify that user can delete a Variable
    When I go back to Browse page and open filter <filter name>
    And I delete the variable with name: <variable name>
    Then filter should be saved successfully
    And variable <variable name> should be removed

    Examples: 
      | filter name         | variable name    |
      | AUT_Variable_Single | AUT_TestVariable |

  Scenario Outline: Verify that Variables should have a unique name
    When I am on Create New Filter page
    And I create a Filter with filter name <filter name> and <source> as source
    And I define a variable 1 with details: <variable1>
    And I add another variable 2 with details: <variable2>
    And with Filter Rule: <keyword> - <comparator> - <keyword value>
    And <filter name> has Action: Send to Slack
    Then filter should not be saved

    Examples: 
      | filter name       | source     | variable1                              | variable2                                                       | keyword | comparator | keyword value |
      | AUT_Variable_Name | Nagios-Pet | AUT_TestVariable1-TEST-summary-Summary | AUT_TestVariable1-TEST-(end delimeter not included)-Description | Summary | Contains   | something     |

  Scenario Outline: Verify mandatory fields for Variables
    When I am on Create New Filter page
    And I create a Filter with filter name <filter name> and <source> as source
    And I define a variable and leave required fields blank
    And with Filter Rule: <keyword> - <comparator> - <keyword value>
    And <filter name> has Action: Send to Slack
    Then filter should not be saved
    When I fill in the variable name with value: <variable name>
    Then filter should not be saved
    When I fill in the start string with value: <start string>
    And I tick include end string checkbox
    Then filter should not be saved
    When I fill in the end string with value: <end string>
    Then filter should be saved successfully

    Examples: 
      | filter name                  | source     | variable name    | start string | end string | field   | keyword | comparator | keyword value |
      | AUT_Variable_MandatoryFields | Nagios-Pet | AUT_TestVariable | TEST         | summary    | Summary | Summary | Contains   | something     |

  Scenario Outline: Verify that user can delete a filter with variable
    When I go back to Browse page and open filter <filter name>
    And I click the Delete button to delete the filter
    Then filter <filter name> should be successfully deleted

    Examples: 
      | filter name           |
      | AUT_Variable_Multiple |
