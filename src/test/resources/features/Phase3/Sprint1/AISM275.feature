@scenarios @AISM275 @Phase3 @Phase3-Sprint1 @VariableDefinition @Correlation @Regression
Feature: AISM-275
  As an Operator
  I can use an alert field, or a defined variable as a parameter in the Correlation condition

  Background: 
    Given I am login
    And I am on Create New Filter page

  Scenario Outline: Verify saving of filter with a defined variable as a parameter in the Correlation condition (source: <source>)
    When I create a Filter with filter name <filter name> and <source> as source
    And I define a variable with name: <variable name>: after <start string> until <end string> from field <field>
    And with Filter Rule: <keyword> - <comparator> - <keyword value>
    And add a Correlation condition: <frequency> occurences in <time value> <time unit>
    And with same values for <variable name>
    And <filter name> has Action: Send to Slack
    Then filter should be saved successfully

    Examples: 
      | filter name              | source    | variable name         | start string | end string | field | keyword | comparator | keyword value | frequency | time value | time unit |
      | AUT_Variable_Correlation | Email WUG | AUT_TestVariable_EWUG | FRCN         | min        | State | State   | Contains   | Firewall      |         2 |          2 | Minutes   |
