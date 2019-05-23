@scenarios @AISM143
Feature: AISM-143
  As an Tool Administrator
  I can configure so that source will be mapped with email sender

  Background: 
    Given I am login
    And I am on Create New Filter page

  Scenario Outline: Verify keyword dropdown values if Source: <source> is selected
    When I select <source> as source
    Then Keyword dropdown values should be: <dropdown values>

    Examples: 
      | source               | dropdown values                                                                                            |
      | Email - JP1          | Sender,Subject,Body                                                                                        |
      | Email - Nagios-Pet   | Sender,Subject,Body                                                                                        |
      | Email - WhatsUp Gold | Sender,Subject,Body                                                                                        |
      | Nagios-Pet           | Summary,Description                                                                                        |
      | Cisco Meraki         | Hostname,Country,Device,Mac Address,Timestamp,Network Id,IP Address,Shop,Device Serial,Description,Summary |
