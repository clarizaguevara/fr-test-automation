@scenarios @AISM276 @Phase3 @Phase3-Sprint1 @VariableDefinition @SnowDuplicate @Regression
Feature: AISM-276
  As an Operator
  I can use an alert field, or a defined variable to extend logic to determine open duplicate tickets for a filter

  Background: 
    Given I am login
    And I am on Create New Filter page

  Scenario Outline: Verify saving of filter with a defined variable as a parameter in Snow Duplicate Check condition (source: <source>)
    When I create a Filter with filter name <filter name> and <source> as source
    And I define a variable with name: <variable name>: after <start string> until <end string> from field <field>
    And with Filter Rule: <keyword> - <comparator> - <keyword value>
    And add a Snow Duplicate Check condition: <with> open tickets where <snow keyword> contains <snow field>
    And <filter name> has Action: Create SNOW Ticket
    Then filter should be saved successfully

    Examples: 
      | filter name                | source | variable name          | start string | end string                   | field   | keyword | comparator | keyword value | with | snow keyword      | snow field                |
      | AUT_Variable_SnowDuplicate | Email  | AUT_TestVariable_Email | [FIRING:1]   | (end delimeter not included) | Subject | Subject | Contains   | RDS           | With | Short Description | ${AUT_TestVariable_Email} |
