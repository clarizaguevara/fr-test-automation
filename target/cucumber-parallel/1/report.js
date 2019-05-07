$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("C:/Users/sclavio/Documents/Git/FR-Test-Automation/src/test/resources/features/AISM62.feature");
formatter.feature({
  "line": 2,
  "name": "AISM - 62",
  "description": "As an Operator\r\nI can configure so that a JIRA ticket will be created automatically (ACPF)",
  "id": "aism---62",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@AISM62"
    },
    {
      "line": 1,
      "name": "@scenarios"
    }
  ]
});
formatter.scenarioOutline({
  "line": 32,
  "name": "Verify Filter is saved if non mandatory fields are left blank",
  "description": "",
  "id": "aism---62;verify-filter-is-saved-if-non-mandatory-fields-are-left-blank",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 31,
      "name": "@onescenario"
    }
  ]
});
formatter.step({
  "line": 33,
  "name": "I create a Filter with filter name \"\u003cfilter name\u003e\" and \"\u003csource\u003e\" as source",
  "keyword": "When "
});
formatter.step({
  "line": 34,
  "name": "with Filter Rule: \"\u003ckeyword\u003e\" \"\u003ccomparator\u003e\" \"\u003ckeyword value\u003e\"",
  "keyword": "And "
});
formatter.step({
  "line": 35,
  "name": "with Action: Create Jira Ticket-ACPF but non mandatory fields are left blank \"\u003cfilter name\u003e\"",
  "keyword": "And "
});
formatter.step({
  "line": 36,
  "name": "I should be able to save successfully",
  "keyword": "Then "
});
formatter.examples({
  "line": 38,
  "name": "",
  "description": "",
  "id": "aism---62;verify-filter-is-saved-if-non-mandatory-fields-are-left-blank;",
  "rows": [
    {
      "cells": [
        "filter name",
        "source",
        "keyword",
        "comparator",
        "keyword value"
      ],
      "line": 39,
      "id": "aism---62;verify-filter-is-saved-if-non-mandatory-fields-are-left-blank;;1"
    },
    {
      "cells": [
        "AUT_TestCreateJiraActionIssueTask4",
        "Cisco Meraki",
        "Shop",
        "Ends With",
        "UQ"
      ],
      "line": 40,
      "id": "aism---62;verify-filter-is-saved-if-non-mandatory-fields-are-left-blank;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 9353156570,
  "status": "passed"
});
formatter.background({
  "line": 6,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 7,
  "name": "I am login",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "I am on Create New Filter page",
  "keyword": "And "
});
formatter.match({
  "location": "AISM7Stepdefs.java:16"
});
formatter.result({
  "duration": 8235188785,
  "status": "passed"
});
formatter.match({
  "location": "AISM7Stepdefs.java:21"
});
formatter.result({
  "duration": 1623340838,
  "status": "passed"
});
formatter.scenario({
  "line": 40,
  "name": "Verify Filter is saved if non mandatory fields are left blank",
  "description": "",
  "id": "aism---62;verify-filter-is-saved-if-non-mandatory-fields-are-left-blank;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 31,
      "name": "@onescenario"
    },
    {
      "line": 1,
      "name": "@scenarios"
    },
    {
      "line": 1,
      "name": "@AISM62"
    }
  ]
});
formatter.step({
  "line": 33,
  "name": "I create a Filter with filter name \"AUT_TestCreateJiraActionIssueTask4\" and \"Cisco Meraki\" as source",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 34,
  "name": "with Filter Rule: \"Shop\" \"Ends With\" \"UQ\"",
  "matchedColumns": [
    2,
    3,
    4
  ],
  "keyword": "And "
});
formatter.step({
  "line": 35,
  "name": "with Action: Create Jira Ticket-ACPF but non mandatory fields are left blank \"AUT_TestCreateJiraActionIssueTask4\"",
  "matchedColumns": [
    0
  ],
  "keyword": "And "
});
formatter.step({
  "line": 36,
  "name": "I should be able to save successfully",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "AUT_TestCreateJiraActionIssueTask4",
      "offset": 36
    },
    {
      "val": "Cisco Meraki",
      "offset": 77
    }
  ],
  "location": "AISM22Stepdefs.java:17"
});
formatter.result({
  "duration": 5692348631,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Shop",
      "offset": 19
    },
    {
      "val": "Ends With",
      "offset": 26
    },
    {
      "val": "UQ",
      "offset": 38
    }
  ],
  "location": "AISM22Stepdefs.java:28"
});
formatter.result({
  "duration": 3681434957,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "AUT_TestCreateJiraActionIssueTask4",
      "offset": 78
    }
  ],
  "location": "AISM62Stepdefs.java:33"
});
formatter.result({
  "duration": 30791505707,
  "status": "passed"
});
formatter.match({
  "location": "AISM7Stepdefs.java:80"
});
formatter.result({
  "duration": 1668911014,
  "status": "passed"
});
formatter.after({
  "duration": 2127389169,
  "status": "passed"
});
});