$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("C:/Users/cguevara6/OneDrive - DXC Production/Documents/GitHub/FR-Test-Automation/src/test/resources/features/Phase1/Sprint1/AISM23.feature");
formatter.feature({
  "line": 2,
  "name": "AISM-23",
  "description": "As a Tool Administrator\nI can configure so that alert can be filtered by correlation",
  "id": "aism-23",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@scenarios"
    },
    {
      "line": 1,
      "name": "@ExtendedRules"
    },
    {
      "line": 1,
      "name": "@Correlation"
    },
    {
      "line": 1,
      "name": "@testing"
    }
  ]
});
formatter.scenarioOutline({
  "line": 6,
  "name": "Verify saving of filter with Correlation condition (time unit \u003d \u003ctime unit\u003e)",
  "description": "",
  "id": "aism-23;verify-saving-of-filter-with-correlation-condition-(time-unit-\u003d-\u003ctime-unit\u003e)",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 7,
  "name": "I am to create a filter with Correlation condition and I am on Create New Filter page",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "I create a Filter with filter name \u003cfilter name\u003e, \u003csource\u003e as source, Filter rule: \u003ckeyword\u003e - \u003ccomparator\u003e - \u003ckeyword value\u003e, and add a Correlation condition: \u003cfrequency\u003e occurences in \u003ctime value\u003e \u003ctime unit\u003e",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "filter with Correlation condition should be saved successfully",
  "keyword": "Then "
});
formatter.examples({
  "line": 11,
  "name": "",
  "description": "",
  "id": "aism-23;verify-saving-of-filter-with-correlation-condition-(time-unit-\u003d-\u003ctime-unit\u003e);",
  "rows": [
    {
      "cells": [
        "filter name",
        "source",
        "keyword",
        "comparator",
        "keyword value",
        "frequency",
        "time value",
        "time unit"
      ],
      "line": 12,
      "id": "aism-23;verify-saving-of-filter-with-correlation-condition-(time-unit-\u003d-\u003ctime-unit\u003e);;1"
    },
    {
      "cells": [
        "AUT_TestCorrelation1",
        "Nagios-Pet",
        "Summary",
        "Contains",
        "TEST",
        "2",
        "10",
        "Seconds"
      ],
      "line": 13,
      "id": "aism-23;verify-saving-of-filter-with-correlation-condition-(time-unit-\u003d-\u003ctime-unit\u003e);;2"
    },
    {
      "cells": [
        "AUT_TestCorrelation2",
        "Nagios-Pet",
        "Description",
        "Begins With",
        "TEST",
        "2",
        "3",
        "Minutes"
      ],
      "line": 14,
      "id": "aism-23;verify-saving-of-filter-with-correlation-condition-(time-unit-\u003d-\u003ctime-unit\u003e);;3"
    },
    {
      "cells": [
        "AUT_TestCorrelation3",
        "Nagios-Pet",
        "Summary",
        "Ends With",
        "TEST",
        "2",
        "2",
        "Hours"
      ],
      "line": 15,
      "id": "aism-23;verify-saving-of-filter-with-correlation-condition-(time-unit-\u003d-\u003ctime-unit\u003e);;4"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 6494222769,
  "status": "passed"
});
formatter.scenario({
  "line": 13,
  "name": "Verify saving of filter with Correlation condition (time unit \u003d Seconds)",
  "description": "",
  "id": "aism-23;verify-saving-of-filter-with-correlation-condition-(time-unit-\u003d-\u003ctime-unit\u003e);;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@testing"
    },
    {
      "line": 1,
      "name": "@scenarios"
    },
    {
      "line": 1,
      "name": "@ExtendedRules"
    },
    {
      "line": 1,
      "name": "@Correlation"
    }
  ]
});
formatter.step({
  "line": 7,
  "name": "I am to create a filter with Correlation condition and I am on Create New Filter page",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "I create a Filter with filter name AUT_TestCorrelation1, Nagios-Pet as source, Filter rule: Summary - Contains - TEST, and add a Correlation condition: 2 occurences in 10 Seconds",
  "matchedColumns": [
    0,
    1,
    2,
    3,
    4,
    5,
    6,
    7
  ],
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "filter with Correlation condition should be saved successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "AISM23Stepdefs.java:19"
});
formatter.result({
  "duration": 10494546447,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "AUT_TestCorrelation1",
      "offset": 35
    },
    {
      "val": "Nagios-Pet",
      "offset": 57
    },
    {
      "val": "Summary",
      "offset": 92
    },
    {
      "val": "Contains",
      "offset": 102
    },
    {
      "val": "TEST",
      "offset": 113
    },
    {
      "val": "2",
      "offset": 152
    },
    {
      "val": "10",
      "offset": 168
    },
    {
      "val": "Seconds",
      "offset": 171
    }
  ],
  "location": "AISM23Stepdefs.java:28"
});
formatter.result({
  "duration": 21780385675,
  "status": "passed"
});
formatter.match({
  "location": "AISM23Stepdefs.java:55"
});
formatter.result({
  "duration": 2104971985,
  "status": "passed"
});
formatter.after({
  "duration": 1230859472,
  "status": "passed"
});
formatter.before({
  "duration": 4008321779,
  "status": "passed"
});
formatter.scenario({
  "line": 14,
  "name": "Verify saving of filter with Correlation condition (time unit \u003d Minutes)",
  "description": "",
  "id": "aism-23;verify-saving-of-filter-with-correlation-condition-(time-unit-\u003d-\u003ctime-unit\u003e);;3",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@testing"
    },
    {
      "line": 1,
      "name": "@scenarios"
    },
    {
      "line": 1,
      "name": "@ExtendedRules"
    },
    {
      "line": 1,
      "name": "@Correlation"
    }
  ]
});
formatter.step({
  "line": 7,
  "name": "I am to create a filter with Correlation condition and I am on Create New Filter page",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "I create a Filter with filter name AUT_TestCorrelation2, Nagios-Pet as source, Filter rule: Description - Begins With - TEST, and add a Correlation condition: 2 occurences in 3 Minutes",
  "matchedColumns": [
    0,
    1,
    2,
    3,
    4,
    5,
    6,
    7
  ],
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "filter with Correlation condition should be saved successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "AISM23Stepdefs.java:19"
});
formatter.result({
  "duration": 9197626218,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "AUT_TestCorrelation2",
      "offset": 35
    },
    {
      "val": "Nagios-Pet",
      "offset": 57
    },
    {
      "val": "Description",
      "offset": 92
    },
    {
      "val": "Begins With",
      "offset": 106
    },
    {
      "val": "TEST",
      "offset": 120
    },
    {
      "val": "2",
      "offset": 159
    },
    {
      "val": "3",
      "offset": 175
    },
    {
      "val": "Minutes",
      "offset": 177
    }
  ],
  "location": "AISM23Stepdefs.java:28"
});
formatter.result({
  "duration": 21172345410,
  "status": "passed"
});
formatter.match({
  "location": "AISM23Stepdefs.java:55"
});
formatter.result({
  "duration": 2109611724,
  "status": "passed"
});
formatter.after({
  "duration": 932912807,
  "status": "passed"
});
formatter.before({
  "duration": 3796540381,
  "status": "passed"
});
formatter.scenario({
  "line": 15,
  "name": "Verify saving of filter with Correlation condition (time unit \u003d Hours)",
  "description": "",
  "id": "aism-23;verify-saving-of-filter-with-correlation-condition-(time-unit-\u003d-\u003ctime-unit\u003e);;4",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@testing"
    },
    {
      "line": 1,
      "name": "@scenarios"
    },
    {
      "line": 1,
      "name": "@ExtendedRules"
    },
    {
      "line": 1,
      "name": "@Correlation"
    }
  ]
});
formatter.step({
  "line": 7,
  "name": "I am to create a filter with Correlation condition and I am on Create New Filter page",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "I create a Filter with filter name AUT_TestCorrelation3, Nagios-Pet as source, Filter rule: Summary - Ends With - TEST, and add a Correlation condition: 2 occurences in 2 Hours",
  "matchedColumns": [
    0,
    1,
    2,
    3,
    4,
    5,
    6,
    7
  ],
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "filter with Correlation condition should be saved successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "AISM23Stepdefs.java:19"
});
formatter.result({
  "duration": 7902694229,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "AUT_TestCorrelation3",
      "offset": 35
    },
    {
      "val": "Nagios-Pet",
      "offset": 57
    },
    {
      "val": "Summary",
      "offset": 92
    },
    {
      "val": "Ends With",
      "offset": 102
    },
    {
      "val": "TEST",
      "offset": 114
    },
    {
      "val": "2",
      "offset": 153
    },
    {
      "val": "2",
      "offset": 169
    },
    {
      "val": "Hours",
      "offset": 171
    }
  ],
  "location": "AISM23Stepdefs.java:28"
});
formatter.result({
  "duration": 21839902066,
  "status": "passed"
});
formatter.match({
  "location": "AISM23Stepdefs.java:55"
});
formatter.result({
  "duration": 2255059983,
  "status": "passed"
});
formatter.after({
  "duration": 1039604240,
  "status": "passed"
});
});